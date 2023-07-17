package burlesca.escola.api.domain.alunas;

import java.util.List;

public record DetalhamentoAlunDTO(Long id, String nome, String email, String telefone, List Modalidade) {

    public DetalhamentoAlunDTO(Aluna aluna){
        this(aluna.getId(), aluna.getNome(), aluna.getEmail(), aluna.getTelefone(), aluna.getModalidade());
    }
}
