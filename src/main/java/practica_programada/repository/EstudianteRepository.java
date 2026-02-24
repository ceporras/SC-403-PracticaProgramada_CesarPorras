package practica_programada.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import practica_programada.domain.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
    public List<Estudiante> findByActivoTrue();
    
}
