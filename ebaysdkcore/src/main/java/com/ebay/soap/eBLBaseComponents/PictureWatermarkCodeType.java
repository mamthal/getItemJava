
package com.ebay.soap.eBLBaseComponents;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PictureWatermarkCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PictureWatermarkCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="User"/>
 *     &lt;enumeration value="Icon"/>
 *     &lt;enumeration value="CustomCode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PictureWatermarkCodeType")
@XmlEnum
public enum PictureWatermarkCodeType {


    /**
     * 
     * 						SellerId watermark option for EPS upload functionality.
     * 					
     * 
     */
    @XmlEnumValue("User")
    USER("User"),

    /**
     * 
     * 						Icon watermark option for EPS upload functionality.
     * 					
     * 
     */
    @XmlEnumValue("Icon")
    ICON("Icon"),

    /**
     * 
     * 						(out) Reserved for internal or future use
     * 					
     * 
     */
    @XmlEnumValue("CustomCode")
    CUSTOM_CODE("CustomCode");
    private final String value;

    PictureWatermarkCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PictureWatermarkCodeType fromValue(String v) {
        for (PictureWatermarkCodeType c: PictureWatermarkCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
