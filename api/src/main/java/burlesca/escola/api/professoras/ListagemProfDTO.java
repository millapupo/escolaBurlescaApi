package burlesca.escola.api.professoras;

import java.util.List;

public record ListagemProfDTO(String nome, String email, String telefone, List<Modalidade> modalidade) {

    public ListagemProfDTO(Professora professora){
        this(professora.getNome(), professora.getEmail(), professora.getTelefone(), professora.getModalidade());
    }
}
