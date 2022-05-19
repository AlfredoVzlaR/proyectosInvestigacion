package dominio;

import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class EnRevista extends Publicaciones {
    
    private String nombreRevista;
    private String editorial;
    private int volumen;
    private int numeroRev;
    private int pagInicio;
    private int pagFin;

    public EnRevista() {
    }

    public EnRevista(String nombreRevista, String editorial, int volumen,int numero, int pagInicio, int pagFin) {
        this.id = new ObjectId();
        this.nombreRevista = nombreRevista;
        this.editorial = editorial;
        this.volumen = volumen;
        this.pagInicio = pagInicio;
        this.pagFin = pagFin;
        this.numeroRev = numero;
    }

    public EnRevista(String nombreRevista, String editorial, int volumen, int numero, int pagInicio, int pagFin, int numeroSecuencia, String titulo, ObjectId tipoPublicacion) {
        super(numeroSecuencia, titulo);
        this.nombreRevista = nombreRevista;
        this.editorial = editorial;
        this.volumen = volumen;
        this.numeroRev= numero;
        this.pagInicio = pagInicio;
        this.pagFin = pagFin;
    }

    public EnRevista(String nombreRevista, String editorial, int volumen, int numero, int pagInicio, int pagFin, ObjectId id, int numeroSecuencia, String titulo, ObjectId tipo) {
        super(id, numeroSecuencia, titulo, tipo);
        this.nombreRevista = nombreRevista;
        this.editorial = editorial;
        this.volumen = volumen;
        this.numeroRev = numero;
        this.pagInicio = pagInicio;
        this.pagFin = pagFin;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getNumeroRev() {
        return numeroRev;
    }

    public void setNumeroRev(int numeroRev) {
        this.numeroRev = numeroRev;
    }
   
    public int getPagInicio() {
        return pagInicio;
    }

    public void setPagInicio(int pagInicio) {
        this.pagInicio = pagInicio;
    }

    public int getPagFin() {
        return pagFin;
    }

    public void setPagFin(int pagFin) {
        this.pagFin = pagFin;
    }

}
