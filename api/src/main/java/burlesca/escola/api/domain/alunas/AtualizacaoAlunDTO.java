package burlesca.escola.api.domain.alunas;

import burlesca.escola.api.domain.Modalidade;

import java.util.List;

public record AtualizacaoAlunDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {
}
