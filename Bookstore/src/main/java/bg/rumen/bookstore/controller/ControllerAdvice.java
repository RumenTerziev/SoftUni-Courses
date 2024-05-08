package bg.rumen.bookstore.controller;

import bg.rumen.bookstore.exceptions.NoSuchBookWithIdException;
import bg.rumen.bookstore.exceptions.NoSuchCommentWithIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NoSuchBookWithIdException.class)
    public ResponseEntity<Object> handleNoSuchBookWithIdException(NoSuchBookWithIdException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", String.format("%s", ex.getMessage()));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchCommentWithIdException.class)
    public ResponseEntity<Object> handleNoSuchCommentWithIdException(NoSuchCommentWithIdException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", String.format("%s", ex.getMessage()));
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
