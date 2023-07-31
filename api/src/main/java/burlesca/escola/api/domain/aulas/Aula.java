package burlesca.escola.api.domain.aulas;

import burlesca.escola.api.domain.alunas.Aluna;
import burlesca.escola.api.domain.professoras.Professora;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "aulas")
@Entity(name = "Aula")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professora_id")
    private Professora professora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluna_id")
    private Aluna aluna;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivosCancelamento motivo;

    public void cancelar(MotivosCancelamento motivosCancelamento) {
        this.motivo = motivosCancelamento;
    }
}

