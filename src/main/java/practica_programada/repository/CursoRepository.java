package practica_programada.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import practica_programada.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{
    public List<Curso> findByActivoTrue();
}
