package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.AulaRepository;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProfessoraComOutraAulaNoMesmoHorario implements ValidadorAgendamentoDeAula {

    @Autowired
    private AulaRepository repository;

    public void validar(DadosAgendaAulaDTO dados){
        var profPossuiOutraAulaNoMesmoHorario = repository.existsByProfessoraIdAndDataAndMotivoIsNull(dados.idProfessora(),dados.data());
        if(profPossuiOutraAulaNoMesmoHorario){
            throw new ValidacaoException("Professora já possui outra aula agendada neste mesmo horário");
        }
    }
}
