package bank.wallet.domain.transaction.api.v1.controller;

import bank.wallet.domain.transaction.api.v1.controller.request.CreateTransactionDto;
import bank.wallet.domain.transaction.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody CreateTransactionDto request) {
        log.info("TransactionController - POST - createTransaction - Start creating transaction.");
        transactionService.createTransaction(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @GetMapping("/user/balance/{userIdentifier}")
    public ResponseEntity<?> getUserBalance(@PathVariable Long userIdentifier) {
        log.info("TransactionController - GET - getUserBalance - Start getting balance by userid.");
        return ResponseEntity.ok(transactionService.getUserBalance(userIdentifier));
    }
}
