package com.wallet1.wallet_notification1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wallet1.wallet_notification1.model.Notification;
import com.wallet1.wallet_notification1.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private final NotificationService notificationService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public WebhookController(
            NotificationService notificationService) {

        this.notificationService = notificationService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> receiveTransaction(
            @RequestBody String payload) {

        try {

            JsonNode root = objectMapper.readTree(payload);

            JsonNode activity =
                    root.path("event")
                            .path("activity")
                            .get(0);

            if (activity != null) {

                String from =
                        activity.path("fromAddress")
                                .asText();

                String to =
                        activity.path("toAddress")
                                .asText();

                String asset =
                        activity.path("asset")
                                .asText();

                double amount =
                        activity.path("value")
                                .asDouble();

                Notification notification =
                        new Notification(
                                from,
                                to,
                                asset,
                                amount
                        );

                notificationService.addNotification(
                        notification
                );

                System.out.println(
                        "Latest Transaction Stored"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Success");
    }
}