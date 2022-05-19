package dominio;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class Proyectos {

    private ObjectId id;
    private String codigo;
    private String nombre;
    private String acronimo;
    private double presupuesto;
    private String programaInvestigacion;
    private String desarrolloFinancia;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private String descripcionObjetivos;
    private String lineaInvestigacion;
    private Doctor investigadorPrincipal;
    private List<Profesor> profesores;

    public Proyectos() {
    }

    public Proyectos(String codigo, String nombre, String acronimo, double presupuesto, String programaInvestigacion, String desarrolloFinancia, Date fechaInicio, Date fechaFinalizacion, String descripcionObjetivos, List<Profesor> profesores, String lineaInvestigacion, Doctor investigadorPrincipal) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.acronimo = acronimo;
        this.presupuesto = presupuesto;
        this.programaInvestigacion = programaInvestigacion;
        this.desarrolloFinancia = desarrolloFinancia;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.descripcionObjetivos = descripcionObjetivos;
        this.profesores = profesores;
        this.lineaInvestigacion = lineaInvestigacion;
        this.investigadorPrincipal = investigadorPrincipal;
    }

    public Proyectos(ObjectId id, String codigo, String nombre, String acronimo, double presupuesto, String programaInvestigacion, String desarrolloFinancia, Date fechaInicio, Date fechaFinalizacion, String descripcionObjetivos, List<Profesor> profesores) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.acronimo = acronimo;
        this.presupuesto = presupuesto;
        this.programaInvestigacion = programaInvestigacion;
        this.desarrolloFinancia = desarrolloFinancia;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.descripcionObjetivos = descripcionObjetivos;
        this.profesores = profesores;
    }

    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getProgramaInvestigacion() {
        return programaInvestigacion;
    }

    public void setProgramaInvestigacion(String programaInvestigacion) {
        this.programaInvestigacion = programaInvestigacion;
    }

    public String getDesarrolloFinancia() {
        return desarrolloFinancia;
    }

    public void setDesarrolloFinancia(String desarrolloFinancia) {
        this.desarrolloFinancia = desarrolloFinancia;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getDescripcionObjetivos() {
        return descripcionObjetivos;
    }

    public void setDescripcionObjetivos(String descripcionObjetivos) {
        this.descripcionObjetivos = descripcionObjetivos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public String getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(String lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }        

    public Doctor getInvestigadorPrincipal() {
        return investigadorPrincipal;
    }

    public void setInvestigadorPrincipal(Doctor investigadorPrincipal) {
        this.investigadorPrincipal = investigadorPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proyectos other = (Proyectos) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return nombre + ", Acronimo" + acronimo;
    }

    

}
