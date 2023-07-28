package burlesca.escola.api.domain.aulas;

import java.time.LocalDateTime;

public record DadosDetalheAulaDTO(Long id,Long idProfessora,Long idAluna,LocalDateTime data) {
    public DadosDetalheAulaDTO(Aula aula){
        this(aula.getId(), aula.getProfessora().getId(), aula.getAluna().getId(), aula.getData());
    }

}


