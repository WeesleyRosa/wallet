package bank.wallet.domain.transaction.service;

import bank.wallet.domain.transaction.api.v1.controller.request.CreateTransactionDto;
import bank.wallet.domain.transaction.api.v1.controller.response.BalanceResponse;
import bank.wallet.domain.transaction.entities.Transaction;

public interface TransactionService {

    Transaction createTransaction(CreateTransactionDto request);
    BalanceResponse getUserBalance(Long userIdentifier);
}
