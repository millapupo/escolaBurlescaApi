package burlesca.escola.api.alunas;

import burlesca.escola.api.professoras.Modalidade;

public record AlunaDTO(String nome, String email, String telefone, Modalidade modalidade) {
}
