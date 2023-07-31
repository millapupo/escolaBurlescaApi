package burlesca.escola.api.domain.aulas.validacoes.agendamento;

import burlesca.escola.api.domain.aulas.DadosAgendaAulaDTO;

public interface ValidadorAgendamentoDeAula {

    void validar(DadosAgendaAulaDTO dados);
}
