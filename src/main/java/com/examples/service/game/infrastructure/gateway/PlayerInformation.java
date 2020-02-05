package com.examples.service.game.infrastructure.gateway;

public class PlayerInformation {

    private Long id;
    private String username;
    private Boolean active;

    public PlayerInformation(Long id, String username, Boolean active) {
        this.id = id;
        this.username = username;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Boolean getActive() {
        return active;
    }

}
