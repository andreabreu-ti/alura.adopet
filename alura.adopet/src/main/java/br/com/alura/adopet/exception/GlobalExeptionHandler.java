package br.com.alura.adopet.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {

	@ExceptionHandler(AdocaoException.class)
	public ResponseEntity<ResponseError> adocaoException(AdocaoException ex) {

		ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
}
