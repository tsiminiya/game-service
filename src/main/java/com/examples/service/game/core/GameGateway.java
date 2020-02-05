package com.examples.service.game.core;

import java.util.Optional;

public interface GameGateway {

    Optional<Game> getGame(Long id);

}
