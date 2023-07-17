package burlesca.escola.api.domain.professoras;

import burlesca.escola.api.domain.Modalidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProfessoraDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotNull
        List<Modalidade> modalidade){}





