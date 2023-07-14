package burlesca.escola.api.professoras;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "professoras")
@Entity(name = "Professora")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Professora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @ElementCollection
    @CollectionTable(name = "professoras_modalidades")
    @Enumerated(EnumType.STRING)
    private List<Modalidade> modalidade;

    public Professora(ProfessoraDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.modalidade = dados.modalidade();
    }
    public void atualizarInformacoes(AtualizacaoProfDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.modalidade()!= null){
            this.modalidade = dados.modalidade();
        }
    }
}
