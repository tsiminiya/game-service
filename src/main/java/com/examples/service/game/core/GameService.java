package com.examples.service.game.core;

public class GameService {

    private final GameGateway gameGateway;
    private final PlayerGateway playerGateway;

    public GameService(GameGateway gameGateway, PlayerGateway playerGateway) {
        this.gameGateway = gameGateway;
        this.playerGateway = playerGateway;
    }



}
