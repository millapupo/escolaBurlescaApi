package burlesca.escola.api.alunas;

import burlesca.escola.api.professoras.Modalidade;

import java.util.List;

public record AtualizacaoAlunDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {
}
