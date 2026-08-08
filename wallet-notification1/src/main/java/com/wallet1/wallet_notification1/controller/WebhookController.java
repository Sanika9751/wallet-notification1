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
    private final ObjectMapper objectMapper =
            new ObjectMapper();

    public WebhookController(
            NotificationService notificationService) {

        this.notificationService =
                notificationService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<String> receiveTransaction(
            @RequestBody String payload) {

        try {

            JsonNode root =
                    objectMapper.readTree(payload);

            JsonNode activity =
                    root.path("event")
                            .path("activity")
                            .get(0);

            if (activity != null) {

                String fromAddress =
                        activity.path("fromAddress")
                                .asText();

                String toAddress =
                        activity.path("toAddress")
                                .asText();

                String from =
                        getWalletName(fromAddress);

                String to =
                        getWalletName(toAddress);

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

                notificationService
                        .addNotification(notification);

                System.out.println(
                        "Transaction Stored Successfully"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("Success");
    }

    private String getWalletName(String address) {

        if ("0x59f14b4121a99eb4e151d1748adf3fd402875a12"
                .equalsIgnoreCase(address)) {

            return "Sender Wallet";
        }

        if ("0x7c6bf83c2fd6eee36fc2df3639a0be4f9dc90225"
                .equalsIgnoreCase(address)) {

            return "Sanika Wallet";
        }

        return address;
    }
}