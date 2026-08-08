package com.wallet1.wallet_notification1.model;

public class Notification {

    private String from;
    private String to;
    private String asset;
    private double amount;

    public Notification() {
    }

    public Notification(
            String from,
            String to,
            String asset,
            double amount) {

        this.from = from;
        this.to = to;
        this.asset = asset;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}