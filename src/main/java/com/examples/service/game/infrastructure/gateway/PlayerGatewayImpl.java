package com.examples.service.game.infrastructure.gateway;

import com.examples.service.game.core.Player;
import com.examples.service.game.core.PlayerGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PlayerGatewayImpl implements PlayerGateway {

    private final RestTemplate restTemplate;

    public PlayerGatewayImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Player> getPlayer(String token) {
        return Optional.ofNullable(restTemplate.getForObject("/player", PlayerInformation.class, "access_token", token))
                .map(this::toPlayer);
    }

    private Player toPlayer(PlayerInformation playerInformation) {
        return new Player(playerInformation.getId(), playerInformation.getUsername(), playerInformation.getActive());
    }
}
