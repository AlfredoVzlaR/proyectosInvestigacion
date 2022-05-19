package dominio;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author germa
 */
public class LineaInvestigacion {
    
    private ObjectId idProfesor;
    private String codigo;
    private String nombre;
    private String conjuntoDesc;
    
    public LineaInvestigacion(){        
    }
    
    public LineaInvestigacion(ObjectId idProfesor, String codigo, String nombre, String conjuntoDesc) {
        this.idProfesor = idProfesor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.conjuntoDesc = conjuntoDesc;
    }    
        
    public LineaInvestigacion(String codigo, String nombre, String conjuntoDesc){
        this.codigo = codigo;
        this.nombre = nombre;
        this.conjuntoDesc = conjuntoDesc;
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

    public String getConjuntoDesc() {
        return conjuntoDesc;
    }

    public void setConjuntoDesc(String conjuntoDesc) {
        this.conjuntoDesc = conjuntoDesc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final LineaInvestigacion other = (LineaInvestigacion) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.conjuntoDesc, other.conjuntoDesc)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "LI: "+nombre;
    }
    
}
