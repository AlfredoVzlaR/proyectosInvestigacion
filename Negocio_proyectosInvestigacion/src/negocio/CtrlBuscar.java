package negocio;

import dominio.LineaInvestigacion;
import implementaciones.FabricaProyectos;
import dominio.Proyectos;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author germa
 */
public class CtrlBuscar{
    
    public boolean verificarInformacionBuscar(String campoTexto){
        if (campoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public List<LineaInvestigacion> consultarLineasInvestigacion(){
        return FabricaProyectos.getInstanciaRep().consultarLineasInvestigacion();
    }
    
    public Proyectos consultarProyectos(String campoTexto, int index) {
        if (index == 0) {
            Proyectos proyecto = FabricaProyectos.getInstancia().ConsultarProyectos(campoTexto, index);
            if (proyecto == null) {
                return null;
            }

            return proyecto;
        } else if (index == 1) {
            Proyectos proyecto = FabricaProyectos.getInstancia().ConsultarProyectos(campoTexto, index);
            if (proyecto == null) {
                return null;
            }

            return proyecto;
        } else if (index == 2) {
            Proyectos proyecto = FabricaProyectos.getInstancia().ConsultarProyectos(campoTexto, index);
            if (proyecto == null) {
                return null;
            }

            return proyecto;
        } else if (index == 3) {
            Proyectos proyecto = FabricaProyectos.getInstancia().ConsultarProyectos(campoTexto, index);
            if (proyecto == null) {
                return null;
            }

            return proyecto;
        } else if (index == 4) {
            Proyectos proyecto = FabricaProyectos.getInstancia().ConsultarProyectos(campoTexto, index);
            if (proyecto == null) {
                return null;
            }

            return proyecto;
        }
        return null;
    }
    List<Proyectos> consultarProyectosPeriodo(Date inicio, Date fin){
        return FabricaProyectos.getInstancia().consultarProyectosPeriodo(inicio,fin);
    }
}
