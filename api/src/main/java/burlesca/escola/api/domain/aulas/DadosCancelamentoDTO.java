package burlesca.escola.api.domain.aulas;

import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoDTO(
        @NotNull
        Long idAula,
        @NotNull
        MotivosCancelamento motivosCancelamento) {
}
