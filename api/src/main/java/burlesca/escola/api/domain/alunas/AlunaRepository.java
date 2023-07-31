package burlesca.escola.api.domain.alunas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunaRepository extends JpaRepository <Aluna, Long>{
    Page<Aluna> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select a.ativo
            from Aluna a
            where
            a.id = :id
            """)
    Boolean findAtivoById(Long id);

}
