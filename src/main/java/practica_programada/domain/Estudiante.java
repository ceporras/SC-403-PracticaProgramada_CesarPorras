package practica_programada.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    //pending to see if these are needed or not
    public Estudiante() {
    }

    public Estudiante(Integer idEstudiante, String nombreEstudiante, String correo, Integer edad, boolean activo, Curso curso) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.correo = correo;
        this.edad = edad;
        this.activo = activo;
        this.curso = curso;
    }

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
    private Integer idEstudiante;

    @Column(nullable = true, length = 50, name = "nombre")
    //@NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    //@NotNull
    @Size(max = 50, message = "El nombre del estudiante no puede tener más de 50 caracteres.")
    private String nombreEstudiante;

    @Column(name = "correo")
    private String correo;

    @NotNull(message = "El campo de edad no puede estar vacío.")
    @Min(value = 1, message = "La edad debe ser un número mayor o igual a 1.")
    @Column(name = "edad")
    private Integer edad;

    @Column(name = "activo")
    public boolean activo;//noticed suggestion on boolean rather than Boolean to avoid nulls

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
}
