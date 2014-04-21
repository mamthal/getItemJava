
package com.ebay.soap.eBLBaseComponents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelReasonCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CancelReasonCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="OutOfStock"/>
 *     &lt;enumeration value="BuyerNoShow"/>
 *     &lt;enumeration value="BuyerRefused"/>
 *     &lt;enumeration value="BuyerNotSchedule"/>
 *     &lt;enumeration value="BuyerCancelOrder"/>
 *     &lt;enumeration value="ValetDeliveryIssues"/>
 *     &lt;enumeration value="ValetUnavailable"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CancelReasonCodeType")
@XmlEnum
public enum CancelReasonCodeType {


    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that one or more order line items were out of stock at the store where the order was supposed to be picked up.
     * 					
     * 
     */
    @XmlEnumValue("OutOfStock")
    OUT_OF_STOCK("OutOfStock"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that the buyer was not at the expected delivery location to receive the order.
     * 					
     * 
     */
    @XmlEnumValue("BuyerNoShow")
    BUYER_NO_SHOW("BuyerNoShow"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that the buyer refused to accept the order.
     * 					
     * 
     */
    @XmlEnumValue("BuyerRefused")
    BUYER_REFUSED("BuyerRefused"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that the buyer did not successfully schedule the delivery of the order.
     * 					
     * 
     */
    @XmlEnumValue("BuyerNotSchedule")
    BUYER_NOT_SCHEDULE("BuyerNotSchedule"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that the buyer cancelled the order.
     * 					
     * 
     */
    @XmlEnumValue("BuyerCancelOrder")
    BUYER_CANCEL_ORDER("BuyerCancelOrder"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that the eBay Now valet had an issue delivering the order to the buyer.
     * 					
     * 
     */
    @XmlEnumValue("ValetDeliveryIssues")
    VALET_DELIVERY_ISSUES("ValetDeliveryIssues"),

    /**
     * 
     * 						This value indicates that the eBay Now order was cancelled due to the fact that no eBay Now valet was available to deliver the order to the buyer.
     * 					
     * 
     */
    @XmlEnumValue("ValetUnavailable")
    VALET_UNAVAILABLE("ValetUnavailable"),

    /**
     * 
     * 						Reserved for internal or future use.
     * 					
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    CancelReasonCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CancelReasonCodeType fromValue(String v) {
        for (CancelReasonCodeType c: CancelReasonCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
