package bank.wallet.domain.transaction.service.impl.converter;

import bank.wallet.domain.transaction.api.v1.controller.request.CreateTransactionDto;
import bank.wallet.domain.transaction.entities.Transaction;
import bank.wallet.domain.transaction.entities.enumerator.TransactionStatus;

import java.time.LocalDateTime;

public class TransactionConverter {

    public static Transaction transactionDtoToEntity(CreateTransactionDto request) {
        return Transaction.builder()
                .value(request.getValue())
                .fromUser(request.getFromUser())
                .toUser(request.getToUser())
                .startedAt(LocalDateTime.now())
                .status(TransactionStatus.Started)
                .build();
    }
}
