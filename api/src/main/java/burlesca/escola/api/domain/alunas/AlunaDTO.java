package burlesca.escola.api.domain.alunas;

import burlesca.escola.api.domain.Modalidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record AlunaDTO(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        List<Modalidade> modalidade){}
