package bank.wallet.domain.transaction.api.v1.controller.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTransactionDto {

    @NotNull
    private Long toUser;
    @NotNull
    private Long fromUser;
    @NotNull
    private BigDecimal value;
}
