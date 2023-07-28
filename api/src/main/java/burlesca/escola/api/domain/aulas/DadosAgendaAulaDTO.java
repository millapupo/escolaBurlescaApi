package burlesca.escola.api.domain.aulas;

import burlesca.escola.api.domain.Modalidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendaAulaDTO(
        Long idProfessora,
        @NotNull
        Long idAluna,

        @Future
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,

        Modalidade modalidade
) {}
