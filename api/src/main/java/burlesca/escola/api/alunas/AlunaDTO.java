package burlesca.escola.api.alunas;

import burlesca.escola.api.professoras.Modalidade;
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
