package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamentoDeAula {

    public void validar(DadosAgendaAulaDTO dados) {

        var dataAula = dados.data();
        var domingo = dataAula.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var sabado = dataAula.getDayOfWeek().equals(DayOfWeek.SATURDAY);
        var antesDaAula = dataAula.getHour() < 10;
        var depoisDaAula = dataAula.getHour() > 18;
        if( domingo || sabado || antesDaAula || depoisDaAula){
            throw new ValidacaoException("Aula fora do horário permitido!");
        }

    }
}