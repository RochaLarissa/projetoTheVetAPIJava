package com.gft.exceptions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.gft.dto.ApiErrorDTO;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({ClienteException.class})
	public ResponseEntity<ApiErrorDTO> handleClienteException(ClienteException ex, WebRequest request) {
		
		String error = "CPF já cadastrado na base de dados";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({VeterinarioException.class})
	public ResponseEntity<ApiErrorDTO> handleVeterinarioException(VeterinarioException ex, WebRequest request) {
		
		String error = "CRMV já cadastrado na base de dados";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({NomeClienteException.class})
	public ResponseEntity<ApiErrorDTO> handleNomeClienteException(NomeClienteException ex, WebRequest request) {
		
		String error = "Cliente não encontrado na base de dados";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({NomeCachorroException.class})
	public ResponseEntity<ApiErrorDTO> handleNomeCachorroException(NomeCachorroException ex, WebRequest request) {
		
		String error = "Cachorro não encontrado na base de dados";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({NomeVeterinarioException.class})
	public ResponseEntity<ApiErrorDTO> handleNomeVeterinarioException(NomeVeterinarioException ex, WebRequest request) {
		
		String error = "Veterinário não encontrado na base de dados";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ApiErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
		
		String error = "Recurso não encontrado";
		
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(), error, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
}
