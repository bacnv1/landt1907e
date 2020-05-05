package com.t3h.chatt3h.model;

public class Event {
    private boolean isLoading;
    private boolean isSuccess;
    private boolean isFail;

    public Event(boolean isLoading, boolean isSuccess, boolean isFail) {
        this.isLoading = isLoading;
        this.isSuccess = isSuccess;
        this.isFail = isFail;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public boolean isFail() {
        return isFail;
    }
}
