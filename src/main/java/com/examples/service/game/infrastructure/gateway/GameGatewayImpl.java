package com.examples.service.game.infrastructure.gateway;

import com.examples.service.game.core.Game;
import com.examples.service.game.core.GameGateway;
import com.examples.service.game.infrastructure.repository.GameEntity;
import com.examples.service.game.infrastructure.repository.GameEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GameGatewayImpl implements GameGateway {

    private final GameEntityRepository gameEntityRepository;

    public GameGatewayImpl(GameEntityRepository gameEntityRepository) {
        this.gameEntityRepository = gameEntityRepository;
    }

    @Override
    public Optional<Game> getGame(Long id) {
        return gameEntityRepository.findById(id).map(this::toGame);
    }

    private Game toGame(GameEntity gameEntity) {
        return new Game(gameEntity.getId(), gameEntity.getName(), gameEntity.getDescription(), gameEntity.getEnabled());
    }

}
