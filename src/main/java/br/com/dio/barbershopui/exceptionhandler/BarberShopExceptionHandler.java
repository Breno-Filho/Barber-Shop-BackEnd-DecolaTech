package br.com.dio.barbershopui.exceptionhandler;
import br.com.dio.barbershopui.controller.response.ProblemResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class BarberShopExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BarberShopExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaught(final Exception ex, final WebRequest request){
        log.error("handleUncaught: ", ex);
        var status = INTERNAL_SERVER_ERROR;
        var response = ProblemResponse.builder()
                .status(status.value())
                .timestamp(OffsetDateTime.now())
                .message(ex.getMessage())
                .build();
        return handleExceptionInternal(ex, response, new HttpHeaders(), status, request);
    }

}
