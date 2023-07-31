package burlesca.escola.api.domain.professoras;

import burlesca.escola.api.domain.Modalidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ProfessoraRepository extends JpaRepository<Professora, Long> {
    Page<Professora> findAllByAtivoTrue(Pageable paginacao);
    @Query("""
            select p from Professora p
            where
            p.ativo = true
            and
            p.modalidade = :modalidade
            and
            p.id not in(
                select au.professora.id from Aula au                
                where
                au.data = :data
                )
            order by rand()
            limit 1
            """)
    Professora escolherProfAleatoriaLivreNaData(Modalidade modalidade, LocalDateTime data);
    @Query("""
            select p.ativo
            from Professora p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
