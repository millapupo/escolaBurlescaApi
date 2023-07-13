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

    //@ElementCollection
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Modalidade.class)
    @CollectionTable(name = "modalidade", joinColumns = @JoinColumn(name = "id"))
    private List<Modalidade> modalidades;

    public Professora(ProfessoraDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.modalidades = dados.modalidades();
    }
}
