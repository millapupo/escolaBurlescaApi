package burlesca.escola.api.domain.professoras;

import burlesca.escola.api.domain.Modalidade;

import java.util.List;

public record AtualizacaoProfDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {

}
