package com.example.urlshortener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class URLShortener {
    private Map<String, URLInfo> urlMap = new HashMap<>();
    private static final String BASE_URL = "http://short.url/";

    public String shortenURL(String longURL, String userId, int limit, long expiryTime) {
        String shortURL = BASE_URL + UUID.randomUUID().toString().substring(0, 8);
        urlMap.put(shortURL, new URLInfo(longURL, userId, limit, expiryTime));
        return shortURL;
    }

    public String redirect(String shortURL) {
        URLInfo urlInfo = urlMap.get(shortURL);
        if (urlInfo == null || urlInfo.isExpired() || urlInfo.isLimitReached()) {
            return "Link is not available.";
        }
        urlInfo.incrementClickCount();
        return urlInfo.getLongURL();
    }

    public void cleanUpExpiredLinks() {
        urlMap.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }

    public List<String> getAllShortenedURLs() {
        return new ArrayList<>(urlMap.keySet());
    }

    public boolean deleteShortenedURL(String shortURL) {
        if (urlMap.containsKey(shortURL)) {
            urlMap.remove(shortURL);
            return true; // Успешно удалено
        }
        return false; // Ссылка не найдена
    }

    public boolean updateShortenedURL(String shortURL, int newLimit, long newExpiryTime) {
        URLInfo urlInfo = urlMap.get(shortURL);
        if (urlInfo != null) {
            urlInfo.setLimit(newLimit);
            urlInfo.setExpiryTime(newExpiryTime);
            return true; // Успешно обновлено
        }
        return false; // Ссылка не найдена
    }
}