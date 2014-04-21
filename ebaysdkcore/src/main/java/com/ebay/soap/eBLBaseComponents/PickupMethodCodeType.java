
package com.ebay.soap.eBLBaseComponents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PickupMethodCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PickupMethodCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="InStorePickup"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PickupMethodCodeType")
@XmlEnum
public enum PickupMethodCodeType {


    /**
     * 	
     * 						This value indicates that the buyer will pick up the In-Store Pickup item at the merchant's physical store.
     * 						<br/><br/>
     * 						<span class="tablenote">
     * 						<strong>Note:</strong> A seller must be eligible for the In-Store Pickup feature to list an item that is eligible for In-Store Pickup. At this time, the In-Store Pickup feature is generally only available to large retail merchants, and can only be applied to multi-quantity, fixed-price listings. Sellers who are eligible for the In-Store Pickup feature can start listing items in Production with the In-Store Pickup option beginning in late September 2013. However, in the meantime, merchants/developers can test In-Store Pickup functionality in the Sandbox environment, including listing items enabled with the In-Store Pickup feature,  creating store locations and adding inventory to these stores using the Inventory Management API, and informing eBay of In-Store Pickup status changes using the Inbound Notifications API.
     * 						</span>
     * 					
     * 
     */
    @XmlEnumValue("InStorePickup")
    IN_STORE_PICKUP("InStorePickup"),

    /**
     * 
     * 						Reserved for internal or future use.
     * 					
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    PickupMethodCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PickupMethodCodeType fromValue(String v) {
        for (PickupMethodCodeType c: PickupMethodCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
