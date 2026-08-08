package com.wallet1.wallet_notification1.service;

import com.wallet1.wallet_notification1.model.Notification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final List<Notification> notifications =
            new ArrayList<>();

    public void addNotification(
            Notification notification) {

        notifications.add(notification);
    }

    public List<Notification> getNotifications() {
        return notifications;
    }
}