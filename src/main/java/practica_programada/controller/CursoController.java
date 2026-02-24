package practica_programada.controller;

import jakarta.validation.Valid;
import java.util.Locale;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import practica_programada.domain.Curso;
import practica_programada.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var cursos = cursoService.getCursos(false);
        model.addAttribute("cursos", cursos);
        model.addAttribute("totalCursos", cursos.size());
        model.addAttribute("curso", new Curso());
        return "/curso/listado";
    }

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/guardar")
    public String guardar(@Valid Curso curso, @RequestParam MultipartFile imagenFile, RedirectAttributes redirectAttributes) {
        cursoService.save(curso,imagenFile);
        redirectAttributes.addFlashAttribute("todoOk", messageSource.getMessage("mensaje.actualizado", null, Locale.getDefault()));

        return "redirect:/curso/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idCurso, RedirectAttributes redirectAttributes) {
        String titulo = "todoOk";
        String detalle = "mensaje.eliminado";
        try {
            System.out.println("deleting now "+idCurso+" from controller");/////remove this
            
            cursoService.delete(idCurso);
        } catch (IllegalArgumentException e) {
            titulo = "error";//captura e de argumento invalido para el mensaje de "no existe"
            e.printStackTrace();
            detalle = "curso.error01";
        } catch (IllegalStateException e) {
            titulo = "error";//captura e de estado ilegarl para mensaje de "datos asociados"
            detalle = "curso.error02";
        } catch (Exception e) {
            titulo = "error";//captura el resto de e
            detalle = "curso.error03";
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(detalle, null, Locale.getDefault()));
        return "redirect:/curso/listado";
    }

    @GetMapping("/modificar/{idCurso}")
    public String modificar(@PathVariable("idCurso") Integer idCurso, Model model, RedirectAttributes redirectAttributes) {
        Optional<Curso> cursoOpt = cursoService.getCurso(idCurso);
        if (cursoOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage("curso.error01", null, Locale.getDefault()));
            return "redirect:/curso/listado";
        }
        model.addAttribute("curso", cursoOpt.get());
        return "/curso/modifica";
    }
}
