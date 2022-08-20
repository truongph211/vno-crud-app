package com.example.phuong.vno.response;

public class VnoResponse {

    private boolean status;
    private String message;

    public VnoResponse() {
    }

    public VnoResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void buildSuccess(String message) {
        this.status = true;
        this.message = message;
    }

    public void buildFailure(String message) {
        this.status = false;
        this.message = message;
    }
}
