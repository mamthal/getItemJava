import httplib
from xml.dom.minidom import parse, parseString, Node
from bottle import run,get,request
import requests
devKey = '9a40dfae-70c2-42c4-bf71-a4c96fff165e'
appKey =  'MamthaLa-96d3-412e-8e87-b33fb9e0ff2d'
certKey = '018d46b9-605f-4feb-95cd-a1f645fb42b2'
userToken = 'AgAAAA**AQAAAA**aAAAAA**ZL9SUw**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AElIKhDJCHoA+dj6x9nY+seQ**kzMCAA**AAMAAA**XfuXzsApsLxfPcgdWueHnnEp818r2yydz4g7wdPerNJZbxY4d8HxMUT4HG7RCxVF1pdVlEft9TbZlkxhJ4OywoCH00Fr0R7etw7AGYVxGLwNNjXCSZUpdwQB8Qz6Tw02xGmYxjAXdPFb6XMrQ39qFR3aHk2G1+LrN2S/4vYFdUpEwrj6XddH7dtBH+HQJRN3Vs3HLcmol7evJdDNxOrQP9GiVQMoOCAS8oW052UgzU+12BJn2wF2YpA6Nfc87XTx/rcZZiHU7gs0qd1zVOKgAeHFePD9lhcurhroekaDcsj/hvBVCeS8xh+WEQGfMnZWv4fOS6uGtrJxIWkZgBymBp+xtfL3bFZ45gVncJBxmXD0APjBlFHE6NmF27nCIvUG65PLxUNjGc9GVeH6rQ3Y4zvO6Te0BaOiY7I4bvMPgVtwPn1uDUMwddCv6nfzck6OpVqL2lW5TlQJnnuqi+3kv/hoaRGhEG1Hmab47u4z8pnOLav16Qb8JUZuqlG42yNyggOfje4LAe9bjkWUAXoxQi7ydP8htObudCrXfnZcLyIytHYfZZvrDtshkD/jgsEnbl2+I99AXnTrwjxh50sD2u77+999uYRG9GIOAQnRo8miwCKBi/tC4l5uq9jOl6nRdZ83+B1DIrekDSpQ3CcV4hKKe9zGt7gQGmUruzg+r4YcxjDFJVMsfz5nsFNYbIOyztiB0E7whE3pnY4JvyqEmkX5E2R3WtmLyYrzOz/G0mlglwjfViYL3KaUsIKrI8sR'
serverUrl = 'api.ebay.com'
def getHeaders(apicall,siteID="0",compatabilityLevel = "433"):
    headers = {"X-EBAY-API-COMPATIBILITY-LEVEL": compatabilityLevel,
               "X-EBAY-API-DEV-NAME": devKey,
               "X-EBAY-API-APP-NAME": appKey,
               "X-EBAY-API-CERT-NAME": certKey,
               "X-EBAY-API-CALL-NAME": apicall,
               "X-EBAY-API-SITEID": siteID,
               "Content-Type": "text/xml"}
    return headers

def sendRequest(apicall,xmlparameters):
    connection = httplib.HTTPSConnection(serverUrl)
    connection.request("POST", '/ws/api.dll', xmlparameters, getHeaders(apicall))
    response = connection.getresponse()
    print response.status
    if response.status != 200:
        print "Error sending request:" + response.reason
    else:
        data = response.read()
        connection.close()
    return data

def getSingleValue(node,tag):
    nl=node.getElementsByTagName(tag)
    if len(nl)>0:
        tagNode=nl[0]
        if tagNode.hasChildNodes(  ):
            return tagNode.firstChild.nodeValue
    return '-1'

def getItem(itemID):
    xml = "<?xml version='1.0' encoding='utf-8'?>"+\
        "<GetItemRequest xmlns=\"urn:ebay:apis:eBLBaseComponents\">"+\
        "<RequesterCredentials><eBayAuthToken>" +\
        userToken +\
        "</eBayAuthToken></RequesterCredentials>" + \
        "<ItemID>" + str(itemID) + "</ItemID>"+\
        "<DetailLevel>ItemReturnAttributes</DetailLevel>"+\
        "</GetItemRequest>"
    data=sendRequest('GetItem',xml)
    result={}
    response=parseString(data)
    result['title']=getSingleValue(response,'Title')
    sellingStatusNode = response.getElementsByTagName('SellingStatus')[0];
    result['price']=getSingleValue(sellingStatusNode,'CurrentPrice')
    result['bids']=getSingleValue(sellingStatusNode,'BidCount')
    seller = response.getElementsByTagName('Seller')
    result['feedback'] = getSingleValue(seller[0],'FeedbackScore')
    attributeSet=response.getElementsByTagName('Attribute');
    attributes={}
    for att in attributeSet:
        attID=att.attributes.getNamedItem('attributeID').nodeValue
        attValue=getSingleValue(att,'ValueLiteral')
        attributes[attID]=attValue
    result['attributes']=attributes
    return result

@get('/searchform')
def getit():
    
    itemID = request.GET.get('searchid','').strip()   
    result = getItem(itemID)
    res = "<html>" + "Item Name:" + result['title'] + "<br>" + "Price:" + result['price'] + "<b>" + "Bid Count:" + result['bids'] + "</html>"  

run(host = 'localhost', port = 8080 , debug = True)
