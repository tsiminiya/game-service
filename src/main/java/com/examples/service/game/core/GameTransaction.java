package com.examples.service.game.core;

import java.math.BigDecimal;

public class GameTransaction {

    private Long gameId;
    private String token;
    private BigDecimal amount;

    public GameTransaction(Long gameId, String token, BigDecimal amount) {
        this.gameId = gameId;
        this.token = token;
        this.amount = amount;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getToken() {
        return token;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
