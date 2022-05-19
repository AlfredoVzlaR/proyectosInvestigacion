/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Doctor;
import dominio.NoDoctor;
import dominio.Proyectos;
import implementaciones.FabricaProyectos;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfredo Valenzuela
 */
public class CtrlEditar {
    public boolean actualizarProyecto(Proyectos proyecto){
        return FabricaProyectos.getInstancia().actualizarProyecto(proyecto);
    }
    public List<Proyectos> consultarProyectos(){
        return FabricaProyectos.getInstancia().consultarProyectos();
    }
    public List<Doctor> consultarDoctores() {
        return FabricaProyectos.getInstanciaRep().consultarDoctores();
    }

    public List<NoDoctor> consultarNoDoctores() {
        return FabricaProyectos.getInstanciaRep().consultarNoDoctores();
    }
    public boolean verificaElementoSeleccionado(List lista){
        if (lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un profesor", "Error!",JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    public boolean verificarActualizar(Proyectos proyecto){
        List<Proyectos> proyectos = FabricaProyectos.getInstancia().consultarProyectos();
        
        for(Proyectos proyectosVerificar:proyectos){
            if((proyectosVerificar.getNombre().equalsIgnoreCase(proyecto.getNombre())||proyectosVerificar.getAcronimo().equalsIgnoreCase(proyecto.getAcronimo()))){
                if(proyectosVerificar.getCodigo().equalsIgnoreCase(proyecto.getCodigo())){
                    FabricaProyectos.getInstanciaRep().actualizarProyecto(proyecto);
                    return true;
                }      
                JOptionPane.showMessageDialog(null,"Ya existe un proyecto con este nombre o acrónimo.","Error.",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
