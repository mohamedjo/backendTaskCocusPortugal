package com.cocus.backendTask.exception.custom;

public class APIRateLimitExceededException extends RuntimeException {
    public APIRateLimitExceededException(String message) {
        super(message);

    }
}
