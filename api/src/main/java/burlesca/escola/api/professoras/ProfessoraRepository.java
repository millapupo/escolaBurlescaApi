package burlesca.escola.api.professoras;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public interface ProfessoraRepository extends JpaRepository<Professora, Long> {
    Page<Professora> findAllByAtivoTrue(Pageable paginacao);
}
