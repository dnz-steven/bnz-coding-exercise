package nz.co.bnz.lapworkshop.common;

import nz.co.bnz.lapworkshop.exception.UnprivilegedDataAccessException;
import nz.co.bnz.lapworkshop.exception.UpstreamApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UnprivilegedDataAccessException.class})
    public ResponseEntity<Object> handleUnprivilegedDataAccessException(UnprivilegedDataAccessException exception) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ExceptionModel(exception.getMessage()));
    }

    @ExceptionHandler({UpstreamApiException.class})
    public ResponseEntity<Object> handleUpstreamApiException(UpstreamApiException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionModel(exception.getMessage()));
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public ResponseEntity<Object> handleOtherException() {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionModel("Unexpected server error."));
    }

}
