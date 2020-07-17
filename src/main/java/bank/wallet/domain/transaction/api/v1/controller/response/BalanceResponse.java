package bank.wallet.domain.transaction.api.v1.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceResponse {

    private Long userId;
    private BigDecimal balance;
    private LocalDateTime lastUpdateAt;
}
