package com.wallet1.wallet_notification1.controller;

import com.wallet1.wallet_notification1.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final NotificationService notificationService;

    public WebhookController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> receiveTransaction(
            @RequestBody String payload) {

        System.out.println("Webhook Received");

        System.out.println(payload);

        notificationService.sendNotification(
                "New Transaction Received"
        );

        return ResponseEntity.ok("Success");
    }
}