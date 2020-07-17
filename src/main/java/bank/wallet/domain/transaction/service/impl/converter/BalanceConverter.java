package bank.wallet.domain.transaction.service.impl.converter;

import bank.wallet.domain.transaction.api.v1.controller.response.BalanceResponse;
import bank.wallet.domain.transaction.entities.Balance;

public class BalanceConverter {

    public static BalanceResponse returnBalanceResponse(Balance balance) {
        return BalanceResponse.builder()
                .balance(balance.getBalance())
                .lastUpdateAt(balance.getLastUpdateAt())
                .userId(balance.getUserId())
                .build();
    }
}
