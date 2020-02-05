package com.examples.service.game.infrastructure.gateway;

import com.examples.service.game.core.AccountGateway;
import com.examples.service.game.core.exception.AccountGatewayException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class AccountGatewayImpl implements AccountGateway {

    private final RestTemplate restTemplate;
    private final String accountServiceUrl;
    private final String accountGatewayToken;

    public AccountGatewayImpl(RestTemplate restTemplate, String accountServiceUrl, String accountGatewayToken) {
        this.restTemplate = restTemplate;
        this.accountServiceUrl = accountServiceUrl;
        this.accountGatewayToken = accountGatewayToken;
    }

    @Override
    public void credit(Long gameId, Long playerId, BigDecimal amount) throws AccountGatewayException {
        updateAccount(new AccountUpdateRequest(gameId, playerId, amount, Operation.CREDIT.name()));
    }

    @Override
    public void debit(Long gameId, Long playerId, BigDecimal amount) throws AccountGatewayException {
        updateAccount(new AccountUpdateRequest(gameId, playerId, amount, Operation.DEBIT.name()));
    }

    private void updateAccount(AccountUpdateRequest accountUpdateRequest) throws AccountGatewayException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-TOKEN", accountGatewayToken);
        HttpEntity<AccountUpdateRequest> requestEntity = new HttpEntity<>(accountUpdateRequest, httpHeaders);
        try {
            restTemplate.exchange(accountServiceUrl, HttpMethod.POST, requestEntity, Object.class);
        } catch (RestClientException e) {
            throw new AccountGatewayException();
        }
    }

    private static class AccountUpdateRequest {
        private Long gameId;
        private Long playerId;
        private BigDecimal amount;
        private String operation;

        public AccountUpdateRequest(Long gameId, Long playerId, BigDecimal amount, String operation) {
            this.gameId = gameId;
            this.playerId = playerId;
            this.amount = amount;
            this.operation = operation;
        }

        public Long getGameId() {
            return gameId;
        }

        public Long getPlayerId() {
            return playerId;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public String getOperation() {
            return operation;
        }
    }

    private static enum Operation {
        DEBIT, CREDIT
    }

}
