// src/main/java/com/example/urlshortener/ConfigLoader.java
package com.example.urlshortener;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader(String filePath) {
        try (FileInputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getDefaultExpiryTime() {
        return Long.parseLong(properties.getProperty("default.expiry.time", "86400000")); // 1 day default
    }

    public int getDefaultClickLimit() {
        return Integer.parseInt(properties.getProperty("default.click.limit", "10")); // 10 clicks default
    }
}