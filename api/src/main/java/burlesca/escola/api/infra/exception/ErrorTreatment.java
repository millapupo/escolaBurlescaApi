package burlesca.escola.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorTreatment {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error400(MethodArgumentNotValidException ex) {
        var erro = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(DadosErroValidacaoDTO::new).toList());
    }
    private record DadosErroValidacaoDTO(String campo, String mensagem) {
        public DadosErroValidacaoDTO(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}