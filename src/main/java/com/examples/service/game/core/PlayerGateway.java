package com.examples.service.game.core;

import java.util.Optional;

public interface PlayerGateway {

    Optional<Player> getPlayer(String token);

}
