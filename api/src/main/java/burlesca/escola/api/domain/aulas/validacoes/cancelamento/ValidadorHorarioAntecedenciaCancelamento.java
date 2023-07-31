package burlesca.escola.api.domain.aulas.validacoes.cancelamento;

import burlesca.escola.api.domain.ValidacaoException;
import burlesca.escola.api.domain.aulas.Aula;
import burlesca.escola.api.domain.aulas.AulaRepository;
import burlesca.escola.api.domain.aulas.DadosCancelamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedenciaCancelamento implements ValidadorCancelamentoDeAula {

    @Autowired
    private AulaRepository repository;

    @Override
    public void validar(DadosCancelamentoDTO dados) {
        var aula = repository.getReferenceById(dados.idAula());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, aula.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Aula somente pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
