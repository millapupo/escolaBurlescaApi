package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeAula{

    public void validar(DadosAgendaAulaDTO dados) {

        var dataAula = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmDias = Duration.between(agora, dataAula).toDays();
        if(diferencaEmDias < 2){
            throw new ValidacaoException("Aula deve ser agendada com antecedência mínima de dois dias!");
        }
    }
}
