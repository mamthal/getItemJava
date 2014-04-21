import static spark.Spark.*;
import spark.*;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.*;
import com.ebay.soap.eBLBaseComponents.ItemType;

public class Searcher 
{
	private static ApiContext getApiContext() {

		   String input;
		   ApiContext apiContext = new ApiContext();

		   //set Api Token to access eBay Api Server
		   ApiCredential cred = apiContext.getApiCredential();
		   input =  "AgAAAA**AQAAAA**aAAAAA**ZL9SUw**nY+sHZ2PrBmdj6wVnY+sEZ2PrA2dj6AElIKhDJCHoA+dj6x9nY+seQ**kzMCAA**AAMAAA**XfuXzsApsLxfPcgdWueHnnEp818r2yydz4g7wdPerNJZbxY4d8HxMUT4HG7RCxVF1pdVlEft9TbZlkxhJ4OywoCH00Fr0R7etw7AGYVxGLwNNjXCSZUpdwQB8Qz6Tw02xGmYxjAXdPFb6XMrQ39qFR3aHk2G1+LrN2S/4vYFdUpEwrj6XddH7dtBH+HQJRN3Vs3HLcmol7evJdDNxOrQP9GiVQMoOCAS8oW052UgzU+12BJn2wF2YpA6Nfc87XTx/rcZZiHU7gs0qd1zVOKgAeHFePD9lhcurhroekaDcsj/hvBVCeS8xh+WEQGfMnZWv4fOS6uGtrJxIWkZgBymBp+xtfL3bFZ45gVncJBxmXD0APjBlFHE6NmF27nCIvUG65PLxUNjGc9GVeH6rQ3Y4zvO6Te0BaOiY7I4bvMPgVtwPn1uDUMwddCv6nfzck6OpVqL2lW5TlQJnnuqi+3kv/hoaRGhEG1Hmab47u4z8pnOLav16Qb8JUZuqlG42yNyggOfje4LAe9bjkWUAXoxQi7ydP8htObudCrXfnZcLyIytHYfZZvrDtshkD/jgsEnbl2+I99AXnTrwjxh50sD2u77+999uYRG9GIOAQnRo8miwCKBi/tC4l5uq9jOl6nRdZ83+B1DIrekDSpQ3CcV4hKKe9zGt7gQGmUruzg+r4YcxjDFJVMsfz5nsFNYbIOyztiB0E7whE3pnY4JvyqEmkX5E2R3WtmLyYrzOz/G0mlglwjfViYL3KaUsIKrI8sR";
		   cred.seteBayToken(input);

		   //set Api Server Url
		   input = "https://api.ebay.com/wsapi";
		   apiContext.setApiServerUrl(input);

		   return apiContext;
		}
	
	public static void main(String[] args) throws ApiException, SdkException, Exception{
			Spark.get(new Route("/searchform") {
	            @Override
	            public Object handle(final Request request, final Response response) 
	            {
	            	ItemType item = null;
	            	String itemId = request.queryParams("searchid");
	            	ApiContext apiContext = getApiContext();
	            	GetItemCall apiCall = new GetItemCall(apiContext);
	            	try {
	            		item = apiCall.getItem(itemId);
					} catch (ApiException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SdkException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	if (item != null)
	            	{
	            		String returnString = "<html> <h1> " + item.getTitle() + "<h1><br>";
	            		returnString = returnString + "<i>" + item.getDescription() + "</i> <br>";
	            		returnString = returnString + item.getPayPalEmailAddress() + "<br>" + item.getItemID()+ "</html>";
	            		return returnString;
	            	}
	            	return null;
	            }
	        });
	    }
}