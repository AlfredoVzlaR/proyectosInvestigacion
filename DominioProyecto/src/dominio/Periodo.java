package dominio;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class Periodo {

    private ObjectId id;
    private Date fechaInicio;
    private Date fechaFin;
    private Proyectos proyecto;
    private List<Profesor> profesores;

    public Periodo() {
    }

    public Periodo(Date fechaInicio, Date fechaFin, Proyectos proyecto, List<Profesor> profesores) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proyecto = proyecto;
        this.profesores = profesores;
    }

    public Periodo(ObjectId id, Date fechaInicio, Date fechaFin, Proyectos proyecto, List<Profesor> profesores) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.proyecto = proyecto;
        this.profesores = profesores;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Proyectos getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    @Override
    public String toString() {
        return "Periodo{" + "id=" + id + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", proyecto=" + proyecto + ", profesores=" + profesores + '}';
    }

}
