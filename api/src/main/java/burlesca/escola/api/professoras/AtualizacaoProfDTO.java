package burlesca.escola.api.professoras;

import java.util.List;

public record AtualizacaoProfDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {

}
