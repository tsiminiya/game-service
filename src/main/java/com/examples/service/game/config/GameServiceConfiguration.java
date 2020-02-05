package com.examples.service.game.config;

import com.examples.service.game.core.AccountGateway;
import com.examples.service.game.core.GameGateway;
import com.examples.service.game.core.GameService;
import com.examples.service.game.core.PlayerGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.examples.service.game.infrastructure.gateway")
public class GameServiceConfiguration {

    @Bean
    public GameService gameService(GameGateway gameGateway, PlayerGateway playerGateway, AccountGateway accountGateway) {
        return new GameService(gameGateway, playerGateway, accountGateway);
    }

}
