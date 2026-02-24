package practica_programada.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import practica_programada.domain.Estudiante;
import practica_programada.repository.EstudianteRepository;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Transactional(readOnly = true)
    public List<Estudiante> getEstudiantes(boolean activo) {
        if (activo) { //solo activos
            return estudianteRepository.findByActivoTrue();
        }
        return estudianteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Estudiante> getEstudiante(Integer idEstudiante) {
        return estudianteRepository.findById(idEstudiante);
    }

    @Transactional
    public void save(Estudiante estudiante) {
        estudiante = estudianteRepository.save(estudiante);

        try {
            estudianteRepository.save(estudiante);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional
    public void delete(Integer idEstudiante) {
        //fue necesario cambiar esto porque sino fallaba la relacion del DB de hibernate sobre curso al borrar estudiante
        Estudiante estudiante = estudianteRepository.findById(idEstudiante)
        .orElseThrow(() -> new IllegalArgumentException(
            "La estudiante con ID " + idEstudiante + " no existe."
        ));
        try {
            estudianteRepository.deleteById(idEstudiante);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar el estudiante. Tiene datos asociados.", e);
        }
    }
}
