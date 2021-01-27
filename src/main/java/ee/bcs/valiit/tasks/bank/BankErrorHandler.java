package ee.bcs.valiit.tasks.bank;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class BankErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BankException.class)
    public ResponseEntity<Object>  handleBankException(BankException e) {
        ResponseError error = new ResponseError();
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
