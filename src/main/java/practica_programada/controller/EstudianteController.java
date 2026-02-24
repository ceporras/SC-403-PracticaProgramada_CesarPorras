package practica_programada.controller;

import jakarta.validation.Valid;
import java.util.Locale;
import java.util.Optional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import practica_programada.service.CursoService;
import practica_programada.service.EstudianteService;
import practica_programada.domain.Estudiante;
import practica_programada.domain.Curso;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final CursoService cursoService;
    private final MessageSource messageSource;

    public EstudianteController(EstudianteService estudianteService, CursoService cursoService, MessageSource messageSource) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
        this.messageSource = messageSource;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        var estudiantes = estudianteService.getEstudiantes(false);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("totalEstudiantes", estudiantes.size());
        model.addAttribute("estudiante", new Estudiante()); // this was added to allow th:field="*{activo}" in agregar form to avoid unchecked box from passing a null
        var cursos = cursoService.getCursos(true);
        model.addAttribute("cursos", cursos);
        return "/estudiante/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Estudiante estudiante, RedirectAttributes redirectAttributes) {
        estudianteService.save(estudiante);
        redirectAttributes.addFlashAttribute("todoOk", messageSource.getMessage("mensaje.actualizado", null, Locale.getDefault()));

        return "redirect:/estudiante/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idEstudiante, RedirectAttributes redirectAttributes) {
        String titulo = "todoOk";
        String detalle = "mensaje.eliminado";
        try {
            estudianteService.delete(idEstudiante);
        } catch (IllegalArgumentException e) {
            titulo = "error";//captura e de argumento invalido para el mensaje de "no existe"
            detalle = "estudiante.error01";
        } catch (IllegalStateException e) {
            titulo = "error";//captura e de estado ilegarl para mensaje de "datos asociados"
            detalle = "estudiante.error02";
        } catch (Exception e) {
            titulo = "error";//captura el resto de e
            detalle = "estudiante.error03";
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(detalle, null, Locale.getDefault()));
        return "redirect:/estudiante/listado";
    }

    @GetMapping("/modificar/{idEstudiante}")
    public String modificar(@PathVariable("idEstudiante") Integer idEstudiante, Model model, RedirectAttributes redirectAttributes) {
        Optional<Estudiante> estudianteOpt = estudianteService.getEstudiante(idEstudiante);
        if (estudianteOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage("estudiante.error01", null, Locale.getDefault()));
            return "redirect:/estudiante/listado";
        }
        model.addAttribute("estudiante", estudianteOpt.get());
        var cursos = cursoService.getCursos(true);
        model.addAttribute("cursos", cursos);
        return "/estudiante/modifica";
    }

}
