package burlesca.escola.api.domain.aulas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;



public interface AulaRepository extends JpaRepository<Aula,Long> {
    boolean existsByAlunaIdAndDataBetween(Long idAluna, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);
    boolean existsByProfessoraIdAndDataAndMotivoIsNull(Long idProfessora, LocalDateTime data);

}
