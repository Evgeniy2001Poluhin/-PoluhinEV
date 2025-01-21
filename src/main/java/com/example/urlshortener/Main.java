package com.example.urlshortener;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern URL_PATTERN = Pattern.compile(
            "^(https?://)?(www\\.)?[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+(/.*)?$"
    );

    public static void main(String[] args) {
        ConfigLoader configLoader = new ConfigLoader("C:\\Users\\poluh\\-PoluhinEV\\src\\main\\resources\\config.properties");
        long expiryTime = configLoader.getDefaultExpiryTime();
        int defaultClickLimit = configLoader.getDefaultClickLimit();

        URLShortener urlShortener = new URLShortener();
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Short URL");
            System.out.println("2. View Shortened URLs");
            System.out.println("3. Delete Short URL");
            System.out.println("4. Update Short URL");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter a long URL:");
                String longURL = scanner.next();

                // Проверка валидности URL
                if (!isValidURL(longURL)) {
                    System.out.println("Invalid URL format. Please enter a valid URL.");
                    continue; // Возврат к началу цикла
                }

                System.out.println("Enter the limit of clicks (default is " + defaultClickLimit + "):");
                int limit = 0;
                try {
                    limit = scanner.nextInt();
                    if (limit <= 0) {
                        limit = defaultClickLimit; // Use default if invalid
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Using default click limit.");
                    limit = defaultClickLimit; // Use default if invalid input
                    scanner.next(); // Clear the invalid input
                }

                long finalExpiryTime = System.currentTimeMillis() + expiryTime;

                String shortURL = urlShortener.shortenURL(longURL, user.getUserId(), limit, finalExpiryTime);
                System.out.println("Shortened URL: " + shortURL);
            } else if (choice == 2) {
                System.out.println("Shortened URLs:");
                for (String shortURL : urlShortener.getAllShortenedURLs()) {
                    System.out.println(shortURL);
                }
            } else if (choice == 3) {
                System.out.println("Enter the short URL to delete:");
                String shortURLToDelete = scanner.next();
                boolean deleted = urlShortener.deleteShortenedURL(shortURLToDelete);
                if (deleted) {
                    System.out.println("Short URL deleted successfully.");
                } else {
                    System.out.println("Short URL not found.");
                }
            } else if (choice == 4) {
                System.out.println("Enter the short URL to update:");
                String shortURLToUpdate = scanner.next();
                System.out.println("Enter the new limit of clicks:");
                int newLimit = scanner.nextInt();
                System.out.println("Enter the new expiry time in milliseconds:");
                long newExpiryTime = scanner.nextLong();
                boolean updated = urlShortener.updateShortenedURL(shortURLToUpdate, newLimit, newExpiryTime);
                if (updated) {
                    System.out.println("Short URL updated successfully.");
                } else {
                    System.out.println("Short URL not found.");
                }
            } else if (choice == 5) {
                break; // Выход из программы
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close(); // Close the scanner
    }

    // Метод для проверки валидности URL
    private static boolean isValidURL(String url) {
        return URL_PATTERN.matcher(url).matches();
    }
}