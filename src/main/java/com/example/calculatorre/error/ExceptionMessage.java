package com.example.calculatorre.error;

public enum ExceptionMessage {
    WRONG_INPUT("잘못된 입력입니다.");

    private final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.ERROR_MESSAGE_HEAD + message;
    }

}
