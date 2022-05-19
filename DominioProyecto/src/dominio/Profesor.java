
package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class Profesor {
    
    protected ObjectId idProfesor;
    protected String nombre;
    protected String apellido;
    protected String despacho;
    protected String telefono;

    public Profesor() {
    }

    public Profesor(String nombre, String apellido, String despacho, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.despacho = despacho;
        this.telefono = telefono;
    }

    public Profesor(ObjectId id, String nombre, String apellido, String despacho, String telefono) {
        this.idProfesor = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.despacho = despacho;
        this.telefono = telefono;
    }

    public ObjectId getId() {
        return idProfesor;
    }

    public void setId(ObjectId id) {
        this.idProfesor = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDespacho() {
        return despacho;
    }

    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idProfesor);
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
        final Profesor other = (Profesor) obj;
        return Objects.equals(this.idProfesor, other.idProfesor);
    }

    @Override
    public String toString() {
        return nombre + " "+ apellido;
    }

   
    
    
    
    
}
