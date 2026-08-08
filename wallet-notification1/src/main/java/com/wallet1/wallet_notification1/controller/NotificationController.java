package com.wallet1.wallet_notification1.controller;

import com.wallet1.wallet_notification1.model.Notification;
import com.wallet1.wallet_notification1.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    @GetMapping
    public List<Notification> getNotifications() {

        return notificationService.getNotifications();
    }
}