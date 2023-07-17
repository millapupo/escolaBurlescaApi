package burlesca.escola.api.domain.professoras;

import java.util.List;

public record DetalhamentoProfDTO(Long id, String nome, String email, String telefone, List Modalidade) {

    public DetalhamentoProfDTO(Professora professora){
        this(professora.getId(),professora.getNome(), professora.getEmail(), professora.getTelefone(), professora.getModalidade());
    }
}
