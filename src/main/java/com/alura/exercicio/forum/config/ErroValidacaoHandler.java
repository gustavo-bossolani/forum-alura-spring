package com.alura.exercicio.forum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	// Recupera mensagem de erro e traduz de acordo com a localicade do cliente
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDTO> handle(MethodArgumentNotValidException exception) {

		List<ErroFormularioDTO> errosDto = new ArrayList<>();
		//Recuperando lsita de erros referente ao campo
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(e -> {
			// Recuperando erro traduzido de acordo com a localização
			String msg = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormularioDTO erro = new ErroFormularioDTO(e.getField(), msg);
			errosDto.add(erro);
		});
		return errosDto;
	}
}
