package com.examples.service.game.core;

import java.math.BigDecimal;

public interface AccountGateway {

    void credit(Long playerId, BigDecimal amount);

    void debit(Long playerId, BigDecimal amount);

}
