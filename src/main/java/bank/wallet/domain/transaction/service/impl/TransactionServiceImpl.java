package bank.wallet.domain.transaction.service.impl;

import bank.wallet.domain.transaction.api.v1.controller.request.CreateTransactionDto;
import bank.wallet.domain.transaction.api.v1.controller.response.BalanceResponse;
import bank.wallet.domain.transaction.entities.Balance;
import bank.wallet.domain.transaction.entities.Transaction;
import bank.wallet.domain.transaction.entities.enumerator.TransactionStatus;
import bank.wallet.domain.transaction.repository.BalanceRepository;
import bank.wallet.domain.transaction.repository.TransactionRepository;
import bank.wallet.domain.transaction.service.TransactionService;
import bank.wallet.domain.transaction.service.impl.converter.BalanceConverter;
import bank.wallet.domain.transaction.service.impl.converter.TransactionConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

@Service
@Slf4j
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;

    @Override
    public Transaction createTransaction(CreateTransactionDto request) {
        handleTransaction(request);
        return transactionRepository.save(TransactionConverter.transactionDtoToEntity(request));
    }

    @Override
    public BalanceResponse getUserBalance(Long userIdentifier) {
        return BalanceConverter.returnBalanceResponse(balanceRepository.findByUserId(userIdentifier).orElseThrow());
    }

    private void handleTransaction(CreateTransactionDto request) {
        Balance fromBalance = balanceRepository.findByUserId(request.getFromUser()).orElseThrow();
        Balance toBalance = balanceRepository.findByUserId(request.getToUser()).orElseThrow();
        transferBalance(fromBalance, toBalance, request);

    }

    private void transferBalance(Balance fromUser, Balance toUser, CreateTransactionDto request) {
        if (fromUser.getBalance().subtract(request.getValue()).compareTo(BigDecimal.ZERO) >= 0) {
            toUser.setBalance(toUser.getBalance().add(request.getValue()));
            fromUser.setBalance(fromUser.getBalance().subtract(request.getValue()));
            updateBalanceAfterTransaction(fromUser, toUser);
        }
    }

    private void updateBalanceAfterTransaction(Balance fromUser, Balance toUser) {
        balanceRepository.saveAll(Arrays.asList(fromUser, toUser));
    }


}
