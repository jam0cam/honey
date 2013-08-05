package com.common;

/**
 * User: jitse
 * Date: 6/19/13
 * Time: 10:25 PM
 */
public class LoginCommand extends User {
    private String error;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
