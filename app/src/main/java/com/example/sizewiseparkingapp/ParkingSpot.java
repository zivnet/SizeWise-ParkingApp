package com.example.sizewiseparkingapp;

public class ParkingSpot {
    private final int id;
    private final String street;
    private final String time;
    private final String imageUrl;
    private final String description;
    private boolean isExpanded;

    public ParkingSpot(int id, String street, String time, String imageUrl, String description) {
        this.id = id;
        this.street = street;
        this.time = time;
        this.imageUrl = imageUrl;
        this.description = description;
        this.isExpanded = false;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getTime() {
        return time;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
