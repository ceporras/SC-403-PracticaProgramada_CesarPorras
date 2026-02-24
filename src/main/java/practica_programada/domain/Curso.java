package practica_programada.domain;

import com.google.firebase.database.annotations.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = true)
    public Integer idCurso;

    @Column(nullable = false, length = 50)
    @NotNull
    @Size(max = 45)
    public String nombre;

    @Column(name = "creditos")
    public Integer creditos;

    @Column(nullable = false, length = 50, name = "estado")
    @NotNull
    @Size(max = 50)
    public String estado;

    @Column(length = 1024, name = "ruta_imagen")
    @Size(max = 1024)
    public String rutaImagen;

    @Column(name = "activo", nullable = false)
    @NotNull
    public Boolean activo;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Estudiante> estudiantes;
}
