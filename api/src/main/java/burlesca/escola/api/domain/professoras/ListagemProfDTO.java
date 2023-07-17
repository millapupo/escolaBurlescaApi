package burlesca.escola.api.domain.professoras;

import burlesca.escola.api.domain.Modalidade;

import java.util.List;

public record ListagemProfDTO(Long id, String nome, String email, String telefone, List<Modalidade> modalidade) {
    public ListagemProfDTO(Professora professora){
        this(professora.getId(), professora.getNome(), professora.getEmail(), professora.getTelefone(), professora.getModalidade());
    }
}
