package burlesca.escola.api.domain.professoras;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessoraRepository extends JpaRepository<Professora, Long> {
    Page<Professora> findAllByAtivoTrue(Pageable paginacao);
}
