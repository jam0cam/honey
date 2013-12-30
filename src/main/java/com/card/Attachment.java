package com.card;

/**
 * User: jitse
 * Date: 9/29/13
 * Time: 8:33 AM
 */
public class Attachment {

    private AttachmentType type;
    private String id;
    private String imageUrl;
    private String parentId;    //this is the parent card or coupon id

    public AttachmentType getType() {
        return type;
    }

    public void setType(AttachmentType type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
