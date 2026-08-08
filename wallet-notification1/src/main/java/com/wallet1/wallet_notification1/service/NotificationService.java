package com.wallet1.wallet_notification1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final List<String> notifications =
            new ArrayList<>();

    public void sendNotification(String message) {

        notifications.add(message);

        System.out.println("================================");
        System.out.println("NOTIFICATION");
        System.out.println(message);
        System.out.println("================================");
    }

    public List<String> getNotifications() {
        return notifications;
    }
}