package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.alunas.AlunaRepository;
import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunaAtiva implements ValidadorAgendamentoDeAula {

    @Autowired
    private AlunaRepository repository;

    public void validar(DadosAgendaAulaDTO dados){
        var alunaEstaAtivo = repository.findAtivoById(dados.idAluna());
        if(!alunaEstaAtivo){
            throw new ValidacaoException("Aula não pode ser agendada com aluna excluída");
        }
    }
}
