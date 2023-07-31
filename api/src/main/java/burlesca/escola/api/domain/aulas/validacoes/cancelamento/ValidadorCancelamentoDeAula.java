package burlesca.escola.api.domain.aulas.validacoes.cancelamento;

import burlesca.escola.api.domain.aulas.DadosCancelamentoDTO;


public interface ValidadorCancelamentoDeAula {

    void validar(DadosCancelamentoDTO dados);

}
