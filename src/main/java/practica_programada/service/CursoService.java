package practica_programada.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import practica_programada.domain.Curso;
import practica_programada.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;


    @Transactional(readOnly = true)
    public List<Curso> getCursos(boolean activo) {
        if (activo) { //solo activos
            return cursoRepository.findByActivoTrue();
        }
        return cursoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Curso> getCurso(Integer idCurso) {
        return cursoRepository.findById(idCurso);
    }

    @Autowired
    private FirebaseStorageService firebaseStorageService;

    @Transactional
    public void save(Curso curso, MultipartFile imagenFile) {
        curso = cursoRepository.save(curso);
        if (!imagenFile.isEmpty()) { //si no esta vacio, pasaron una imagen
            try {
                String rutaImagen = firebaseStorageService.uploadImage(imagenFile, "curso", curso.getIdCurso());
                curso.setRutaImagen(rutaImagen);
                cursoRepository.save(curso);
            } catch (IOException e) {

            }
        }
    }

    @Transactional
    public void delete(Integer idCurso) {
        System.out.println("triggering delete for ID "+ idCurso+" from curso service");
        //verifica si la curso existe antes de intentar eliminarlo
        if (!cursoRepository.existsById(idCurso)) {
            //lanza exception para indicar que el usuario no fue encontrado
            throw new IllegalArgumentException("El curso con ID " + idCurso + " no existe.");
        }
        try {
            cursoRepository.deleteById(idCurso);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar el curso. Tiene datos asociados.", e);
        }
    }
}
