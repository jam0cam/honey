package com.card;

/**
 * User: jitse
 * Date: 9/29/13
 * Time: 9:29 AM
 */
public enum AttachmentType {
    COUPON ("coupon"), CARD ("card");

    private String value;

    AttachmentType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static AttachmentType fromValue(String value){
        if ("coupon".equalsIgnoreCase(value)){
            return COUPON;
        } else {
            return CARD;
        }
    }
}
