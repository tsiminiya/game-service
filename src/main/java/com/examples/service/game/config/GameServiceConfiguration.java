package com.examples.service.game.config;

import com.examples.service.game.core.GameGateway;
import com.examples.service.game.core.GameService;
import com.examples.service.game.core.PlayerGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameServiceConfiguration {

    @Bean
    public GameService gameService(GameGateway gameGateway, PlayerGateway playerGateway) {
        return new GameService(gameGateway, playerGateway);
    }

}
