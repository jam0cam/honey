package com.common;

/**
 * User: jitse
 * Date: 8/21/13
 * Time: 2:05 PM
 */
public class ResponseResult {
    String value;

    public ResponseResult(){}

    public ResponseResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
