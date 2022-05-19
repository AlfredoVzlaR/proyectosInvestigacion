
package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class NoDoctor extends Profesor{

    public NoDoctor() {
    }

    public NoDoctor(String nombre, String apellido, String despacho, String telefono) {
        super(nombre, apellido, despacho, telefono);
    }

    public NoDoctor(ObjectId id, String nombre, String apellido, String despacho, String telefono) {
        super(id, nombre, apellido, despacho, telefono);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getDespacho() {
        return despacho;
    }

    @Override
    public void setDespacho(String despacho) {
        this.despacho = despacho;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
