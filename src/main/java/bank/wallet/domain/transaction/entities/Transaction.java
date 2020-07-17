package bank.wallet.domain.transaction.entities;

import bank.wallet.domain.transaction.entities.enumerator.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime occurred;
    @OneToOne
    @JoinColumn(name = "to_user_id", referencedColumnName = "id")
    private Long toUser;
    @OneToOne
    @JoinColumn(name = "from_user_id", referencedColumnName = "id")
    private Long fromUser;
    private BigDecimal value;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private LocalDateTime startedAt;
}
