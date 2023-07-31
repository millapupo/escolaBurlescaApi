package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import burlesca.escola.api.domain.professoras.ProfessoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorProfessoraAtiva implements ValidadorAgendamentoDeAula {

    @Autowired
    private ProfessoraRepository repository;

    public void validar(DadosAgendaAulaDTO dados) {

        if(dados.idProfessora() ==null){
            return;
        }
        var professoraEstaAtiva = repository.findAtivoById(dados.idProfessora());
        if(!professoraEstaAtiva){
            throw new ValidacaoException("Aula não pode ser agendada com professora excluída");
        }

    }

}
