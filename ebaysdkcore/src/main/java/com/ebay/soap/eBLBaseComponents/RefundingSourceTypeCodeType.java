
package com.ebay.soap.eBLBaseComponents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundingSourceTypeCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RefundingSourceTypeCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ScheduledPayout"/>
 *     &lt;enumeration value="Paypal"/>
 *     &lt;enumeration value="BankAccount"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RefundingSourceTypeCodeType")
@XmlEnum
public enum RefundingSourceTypeCodeType {


    /**
     * 
     * 					 The seller's scheduled payout account with eBay. When a buyer pays for an item the purchase amount goes into this account. This value indicates that the refund has been issued from the seller's scheduled payout account.<br/><br/>
     * 					 <span class="tablenote">
     * 					 <strong>Note:</strong> The introduction of the new eBay payment process for the Germany and
     * 						Austria eBay sites has been delayed until further notice. 
     * 					 </span>
     * 					
     * 
     */
    @XmlEnumValue("ScheduledPayout")
    SCHEDULED_PAYOUT("ScheduledPayout"),

    /**
     * 
     * 					 The seller's PayPal account associated with the transaction.<br/><br/>
     * 					 <span class="tablenote">
     * 					 <strong>Note:</strong> The introduction of the new eBay payment process for the Germany and
     * 						Austria eBay sites has been delayed until further notice. 
     * 					 </span>
     * 					
     * 
     */
    @XmlEnumValue("Paypal")
    PAYPAL("Paypal"),

    /**
     * 
     * 					 The seller's bank account associated with the transaction.<br/><br/>
     * 					 <span class="tablenote">
     * 					 <strong>Note:</strong> The introduction of the new eBay payment process for the Germany and
     * 						Austria eBay sites has been delayed until further notice. 
     * 					 </span>
     * 					
     * 
     */
    @XmlEnumValue("BankAccount")
    BANK_ACCOUNT("BankAccount"),

    /**
     * 
     * 						(out) Reserved for internal or future use.
     * 					
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    RefundingSourceTypeCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RefundingSourceTypeCodeType fromValue(String v) {
        for (RefundingSourceTypeCodeType c: RefundingSourceTypeCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
