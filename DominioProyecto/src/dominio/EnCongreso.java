/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class EnCongreso extends Publicaciones {

    private Tipo tipo;
    private String nombreCongreso;
    private Date fechaInicio;
    private Date fechaFin;
    private String lugar;
    private String pais;
    private String editorial;

    public EnCongreso() {
    }

    public EnCongreso(Tipo tipo, String nombreCongreso, Date fechaInicio, Date fechaFin, String lugar, String pais, String editorial) {
        this.id = new ObjectId();
        this.tipo = tipo;
        this.nombreCongreso = nombreCongreso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.pais = pais;
        this.editorial = editorial;
    }
    
    public EnCongreso(Tipo tipo, String nombreCongreso, Date fechaInicio, Date fechaFin, String lugar, String pais, String editorial, int numeroSecuencia, String titulo, ObjectId tipoPublicacion) {
        super(numeroSecuencia, titulo);
        this.tipo = tipo;
        this.nombreCongreso = nombreCongreso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.pais = pais;
        this.editorial = editorial;
    }

    public EnCongreso(Tipo tipo, String nombreCongreso, Date fechaInicio, Date fechaFin, String lugar, String pais, String editorial, ObjectId id, int numeroSecuencia, String titulo, ObjectId tipoPublicacion) {
        super(id, numeroSecuencia, titulo, tipoPublicacion);
        this.tipo = tipo;
        this.nombreCongreso = nombreCongreso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lugar = lugar;
        this.pais = pais;
        this.editorial = editorial;
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNombreCongreso() {
        return nombreCongreso;
    }

    public void setNombreCongreso(String nombreCongreso) {
        this.nombreCongreso = nombreCongreso;
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "EnCongreso{" + "tipo=" + tipo + ", nombreCongreso=" + nombreCongreso + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", lugar=" + lugar + ", pais=" + pais + ", editorial=" + editorial + '}';
    }

}
