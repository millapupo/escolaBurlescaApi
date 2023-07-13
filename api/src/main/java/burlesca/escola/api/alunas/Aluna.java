package burlesca.escola.api.alunas;

import burlesca.escola.api.professoras.Modalidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "alunas")
@Entity(name = "Aluna")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @ElementCollection
    @CollectionTable(name = "alunas_modalidades")
    @Enumerated(EnumType.STRING)
    private List<Modalidade> modalidade;

    public Aluna(AlunaDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.modalidade = dados.modalidade();
    }
}
