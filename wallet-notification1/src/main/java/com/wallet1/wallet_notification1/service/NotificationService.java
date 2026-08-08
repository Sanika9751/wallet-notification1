package com.wallet1.wallet_notification1.service;

import com.wallet1.wallet_notification1.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private Notification latestNotification;

    public void addNotification(Notification notification) {
        this.latestNotification = notification;
    }

    public Notification getLatestNotification() {

        if (latestNotification == null) {
            return null;
        }

        Notification notification = latestNotification;

        // Clear after sending once
        latestNotification = null;

        return notification;
    }
}