package com.app.pbmsystem.model.enums;


public enum Role {
    BIDDER("BIDDER"),
    PREFABRICATOR("PREFABRICATOR");

    private String text;

    Role(String text) {
        this.text = text;
    }
}