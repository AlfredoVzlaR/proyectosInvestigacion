/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Doctor;
import dominio.LineaInvestigacion;
import dominio.NoDoctor;
import dominio.Profesor;
import dominio.Proyectos;
import implementaciones.FabricaProyectos;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Valenzuela
 */
public class CtrlRegistrar {

    public List<Doctor> consultarDoctores() {
        return FabricaProyectos.getInstanciaRep().consultarDoctores();
    }

    public List<NoDoctor> consultarNoDoctores() {
        return FabricaProyectos.getInstanciaRep().consultarNoDoctores();
    }

    public List<LineaInvestigacion> consultarLineasInvestigacion() {
        return FabricaProyectos.getInstanciaRep().consultarLineasInvestigacion();
    }

    public boolean verificarInformacionRegistrar(String programa, String linea, String nombre, String acronimo, Date fechaInicio, Date fechaFinal, float presupuesto, String descripcion, int index, List<Profesor> profesoresParticipantes) {
        if (programa.isEmpty() || linea.isEmpty() || nombre.isEmpty() || acronimo.isEmpty() || fechaInicio == null || fechaFinal == null || presupuesto <= 0 || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    public boolean verificaElementosSeleccionados(int index, List<Profesor> profesoresParticipantes){
        if (index == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un doctor", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (profesoresParticipantes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione profesores/doctores", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public boolean registrarProyecto(Proyectos proyecto) {
        if (FabricaProyectos.getInstanciaRep().RegistrarProyecto(proyecto)) {
            JOptionPane.showMessageDialog(null, "El proyecto se ha agregado con éxito", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "No fue posible agregar el proyecto", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    public boolean verificarRegistrarProyecto(Proyectos proyecto){
        List<Proyectos> proyectos = FabricaProyectos.getInstancia().consultarProyectos();
        
        for(Proyectos proyectoVerificar:proyectos){
            if(proyectoVerificar.getCodigo().equals(proyecto.getCodigo())
                    ||proyectoVerificar.getNombre().equalsIgnoreCase(proyecto.getNombre())
                    ||proyectoVerificar.getAcronimo().equalsIgnoreCase(proyecto.getAcronimo())){
                JOptionPane.showMessageDialog(null,"Ya existe un proyecto con ese código,nombre,acrónimo.","Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else{
                return true;
            }
        }
        return true;
    }

}
