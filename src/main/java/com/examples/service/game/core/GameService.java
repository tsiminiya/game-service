package com.examples.service.game.core;

import com.examples.service.game.core.exception.GameNotFoundException;
import com.examples.service.game.core.exception.GameServiceException;
import com.examples.service.game.core.exception.PlayerNotFoundException;

public class GameService {

    private final GameGateway gameGateway;
    private final PlayerGateway playerGateway;
    private final AccountGateway accountGateway;

    public GameService(GameGateway gameGateway, PlayerGateway playerGateway, AccountGateway accountGateway) {
        this.gameGateway = gameGateway;
        this.playerGateway = playerGateway;
        this.accountGateway = accountGateway;
    }

    public void sendBet(GameTransaction gameTransaction) throws GameServiceException {
        Game game = gameGateway.getGame(gameTransaction.getGameId()).orElseThrow(GameNotFoundException::new);
        Player player = playerGateway.getPlayer(gameTransaction.getToken()).orElseThrow(PlayerNotFoundException::new);

        accountGateway.debit(game.getId(), player.getId(), gameTransaction.getAmount());
    }

    public void claimWinnings(GameTransaction gameTransaction) throws GameServiceException {
        Game game = gameGateway.getGame(gameTransaction.getGameId()).orElseThrow(GameNotFoundException::new);
        Player player = playerGateway.getPlayer(gameTransaction.getToken()).orElseThrow(PlayerNotFoundException::new);

        accountGateway.credit(game.getId(), player.getId(), gameTransaction.getAmount());
    }

}
