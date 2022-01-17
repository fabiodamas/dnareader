package br.com.fabio.dnareader.config.validacao;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorValidationHandler {
	
	@ResponseStatus(code = HttpStatus.CONFLICT)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ErrorMessage handleConflict(DataIntegrityViolationException e) {
      ErrorMessage dto = new ErrorMessage("DNA", "DNA já cadastrado na base de dados");

      return dto;
  }  

}