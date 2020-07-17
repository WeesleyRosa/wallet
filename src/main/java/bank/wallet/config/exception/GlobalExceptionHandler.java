package bank.wallet.config.exception;


import bank.wallet.config.exception.enumerator.ErrorCodeEnum;
import bank.wallet.config.exception.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        log.error("Exception - Unhandled exception: {}", ex.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(ErrorCodeEnum.SERVICE_UNHANDLED_ERROR, "Unhandled service exception");
        return ResponseEntity.status(500).body(errorResponse);
    }
}
