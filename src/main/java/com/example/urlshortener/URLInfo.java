package com.example.urlshortener;

public class URLInfo {
    private String longURL;
    private String userId;
    private int clickCount;
    private int limit;
    private long expiryTime;

    public URLInfo(String longURL, String userId, int limit, long expiryTime) {
        this.longURL = longURL;
        this.userId = userId;
        this.clickCount = 0;
        this.limit = limit;
        this.expiryTime = expiryTime;
    }

    // Getters and Setters
    public String getLongURL() {
        return longURL;
    }

    public String getUserId() {
        return userId;
    }

    public int getClickCount() {
        return clickCount;
    }

    public void incrementClickCount() {
        this.clickCount++;
    }

    public int getLimit() {
        return limit;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }

    public boolean isLimitReached() {
        return clickCount >= limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }
}