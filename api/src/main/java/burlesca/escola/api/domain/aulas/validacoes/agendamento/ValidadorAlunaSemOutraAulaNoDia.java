package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.AulaRepository;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunaSemOutraAulaNoDia implements ValidadorAgendamentoDeAula {

    @Autowired
    private AulaRepository repository;

    public void validar(DadosAgendaAulaDTO dados){
        var primeiroHorario = dados.data().withHour(10);
        var ultimoHorario = dados.data().withHour(18);
        var alunaPossuiOutraAulaNoDia = repository.existsByAlunaIdAndDataBetween(dados.idAluna(), primeiroHorario, ultimoHorario);
        if(alunaPossuiOutraAulaNoDia){
            throw new ValidacaoException("Aluna já possui aula agendada neste dia");
        }
    }
}
