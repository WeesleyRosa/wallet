package bank.wallet.domain.transaction.repository;


import bank.wallet.domain.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
