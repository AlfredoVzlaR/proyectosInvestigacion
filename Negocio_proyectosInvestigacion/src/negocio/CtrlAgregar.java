/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.EnCongreso;
import dominio.EnRevista;
import dominio.Profesor;
import dominio.Proyectos;
import dominio.Publicaciones;
import implementaciones.FabricaProyectos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class CtrlAgregar {
    public List<Proyectos> consultarProyectos() {
        return FabricaProyectos.getInstanciaRep().consultarProyectos();
    }
    
    public boolean verificarElementoSeleccionado(JTable tabla){
        if (tabla.getSelectedRowCount() >= 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarInformacionAgregar(String noSecuencia, String titulo, List<Profesor> profesores,String nombre, String editorial, String volumen, String pagInicio, String pagFin) {
        if (noSecuencia.equalsIgnoreCase("") || titulo.equalsIgnoreCase("") || profesores.isEmpty()|| nombre.equalsIgnoreCase("") || editorial.equalsIgnoreCase("") || volumen.equalsIgnoreCase("") ||
                pagInicio.equalsIgnoreCase("") || pagFin.equalsIgnoreCase("")){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean verificarInformacionAgregar(String noSecuencia, boolean tipo, String volumen, String numero, String pagInicio, String pagFin, String editorial) {
        if (tipo) {
            if (!isNumeric(noSecuencia) || !isNumeric(volumen) || !isNumeric(numero) || !isNumeric(pagInicio) || !isNumeric(pagFin) || editorial.equalsIgnoreCase("")) {
                return false;
            } else {
                return true;

            }
        } 
        return true;
    }
    
    public boolean verificarInformacionAgregar(boolean tipo, String noSecuencia) {
        if (tipo) {
            if (!isNumeric(noSecuencia)) {
                return false;
            }

            return true;
        }

        return true;
    }
    
    private static boolean isNumeric(String cadena) {
        try {
            Integer numero = Integer.parseInt(cadena);
            if (numero >= 0){
            return true;
            } else {return false;}
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    boolean verificarPublicacion(String titulo) {
        List<Publicaciones> publicaciones = FabricaProyectos.getInstanciaRepPublicaciones().consultarPublicaciones();

        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return false;
            }
            return true;
        }
        return true;
    }

    boolean guardarPublicacion(Publicaciones publicaciones, EnRevista r) {
        if (FabricaProyectos.getInstanciaRepPublicaciones().agregarPublicacion(publicaciones, r)) {
            JOptionPane.showMessageDialog(null, "La publicación se ha agregado con éxito", "Publicación", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "No fue posible agregar la publicación", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    boolean guardarPublicacion(Publicaciones publicaciones, EnCongreso congreso) {
       if (FabricaProyectos.getInstanciaRepPublicaciones().agregarPublicacion(publicaciones, congreso)) {
            JOptionPane.showMessageDialog(null, "La publicación se ha agregado con éxito", "Congreso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "No fue posible agregar la publicación", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}
