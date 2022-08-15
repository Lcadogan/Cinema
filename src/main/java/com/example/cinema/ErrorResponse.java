package com.example.cinema;

public class ErrorResponse {
    private final String error;

    public ErrorResponse(String errorMessage) {
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }
}
