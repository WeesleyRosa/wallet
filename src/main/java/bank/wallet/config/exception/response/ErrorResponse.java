package bank.wallet.config.exception.response;

import bank.wallet.config.exception.enumerator.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private ErrorCodeEnum code;
    private String message;

}
