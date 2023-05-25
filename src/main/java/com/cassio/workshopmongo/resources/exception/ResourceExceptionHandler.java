package com.cassio.workshopmongo.resources.exception;

import com.cassio.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        // Instanciando o objeto StandardError de acordo com seus atributos.

        Instant instant = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Not found";
        String msg = e.getMessage();
        String path = request.getRequestURI();

        return ResponseEntity.status(status).body(new StandardError(instant, status.value(), error, msg, path));
    }

}
