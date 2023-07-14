package burlesca.escola.api.alunas;

import burlesca.escola.api.professoras.Modalidade;
import java.util.List;

public record ListagemAlunDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {

    public ListagemAlunDTO(Aluna aluna){
        this(aluna.getId(), aluna.getNome(), aluna.getEmail(), aluna.getTelefone(), aluna.getModalidade());
    }
}
