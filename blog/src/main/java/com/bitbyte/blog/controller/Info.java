package com.bitbyte.blog.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Info {

    public enum status { SUCCESS, ERROR }

    private status status;
    private String message;
    private String error;

    public Info() {
    }

    public Info.status getStatus() {
        return status;
    }

    public void setStatus(Info.status status) {
        this.status = status;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("status", status)
                .append("message", message)
                .append("error", error)
                .toString();
    }
}
