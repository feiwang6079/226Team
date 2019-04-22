package com.cmpe226.cafe.models;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Message {
    int code;
    String message;
    String data;

    public Message(int code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            return "";
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}