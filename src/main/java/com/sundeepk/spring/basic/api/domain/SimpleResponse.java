package com.sundeepk.spring.basic.api.domain;

import java.util.Objects;

public class SimpleResponse {

    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleResponse that = (SimpleResponse) o;
        return Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "message='" + message + '\'' +
                '}';
    }

}
