package com.hotel.models;

public class Room {
    private int roomId;
    private String category;
    private double price;
    private boolean isAvailable;

    // Constructors
    public Room(int roomId, String category, double price, boolean isAvailable) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
