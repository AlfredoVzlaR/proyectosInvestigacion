
package dominio;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class Publicaciones {
    
    protected ObjectId id;
    protected int numeroSecuencia;
    protected String titulo;
    private ObjectId tipoPublicacion;
    private ObjectId idProyecto;
    private List<Profesor> profesores;
    
    public Publicaciones() {
    }
    
    public Publicaciones(int numeroSecuencia, String titulo) {
        this.numeroSecuencia = numeroSecuencia;
        this.titulo = titulo;
        
    }

    public Publicaciones(ObjectId id, int numeroSecuencia, String titulo, ObjectId tipoPublicacion) {
        this.id = id;
        this.numeroSecuencia = numeroSecuencia;
        this.titulo = titulo;
        this.tipoPublicacion = tipoPublicacion;
    }

    public Publicaciones(ObjectId id, int numeroSecuencia, String titulo, ObjectId tipoPublicacion, ObjectId idProyecto) {
        this.id = id;
        this.numeroSecuencia = numeroSecuencia;
        this.titulo = titulo;
        this.tipoPublicacion = tipoPublicacion;
        this.idProyecto = idProyecto;
    }
    

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getNumeroSecuencia() {
        return numeroSecuencia;
    }

    public void setNumeroSecuencia(int numeroSecuencia) {
        this.numeroSecuencia = numeroSecuencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ObjectId getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(ObjectId tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public ObjectId getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(ObjectId idProyecto) {
        this.idProyecto = idProyecto;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Publicaciones other = (Publicaciones) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Publicaciones{" + "id=" + id + ", numeroSecuencia=" + numeroSecuencia + ", titulo=" + titulo + ", tipo=" + tipoPublicacion + '}';
    }

   
}
