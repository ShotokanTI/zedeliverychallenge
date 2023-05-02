package com.zecodechallenge.zecode.exceptions;

import java.time.LocalDateTime;

public class CustomErrorResponse{
    private Integer status;
    private String message;
    private String originExceptionMessage;

    public String getOriginExceptionMessage() {
        return originExceptionMessage;
    }

    public void setOriginExceptionMessage(String originExceptionMessage) {
        this.originExceptionMessage = originExceptionMessage;
    }

    private LocalDateTime timestamp;

    public CustomErrorResponse(){

    }
    public CustomErrorResponse(Integer status, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CustomErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
