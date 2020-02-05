package com.examples.service.game.core;

import com.examples.service.game.core.exception.AccountGatewayException;

import java.math.BigDecimal;

public interface AccountGateway {

    void credit(Long gameId, Long playerId, BigDecimal amount) throws AccountGatewayException;

    void debit(Long gameId, Long playerId, BigDecimal amount) throws AccountGatewayException;

}
