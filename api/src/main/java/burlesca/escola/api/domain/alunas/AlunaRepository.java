package burlesca.escola.api.domain.alunas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunaRepository extends JpaRepository <Aluna, Long>{
    Page<Aluna> findAllByAtivoTrue(Pageable paginacao);
}
