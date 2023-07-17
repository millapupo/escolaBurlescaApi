package burlesca.escola.api.domain.alunas;

import burlesca.escola.api.domain.Modalidade;
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
    private Boolean ativo;
    @ElementCollection
    @CollectionTable(name = "alunas_modalidades")
    @Enumerated(EnumType.STRING)
    private List<Modalidade> modalidade;

    public Aluna(AlunaDTO dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.modalidade = dados.modalidade();
    }
    public void atualizarInformacoes(AtualizacaoAlunDTO dados) {
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
    public void excluir() {
        this.ativo = false;
    }
}
