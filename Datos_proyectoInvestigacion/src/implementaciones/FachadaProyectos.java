/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;
import dominio.LineaInvestigacion;
import dominio.Profesor;
import interfaces.IProyectos;
import dominio.Proyectos;
import interfaces.IConexionBD;
import interfaces.IRepProyectos;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Alfredo Valenzuela
 */
public class FachadaProyectos implements IProyectos
{
    public FachadaProyectos() {
    }
    
    @Override
    public Proyectos ConsultarProyectos(String codigo,int index) {
        if(index==0){
            return FabricaProyectos.getInstanciaRep().consultarProyecto(codigo, index);
        }
        else if(index==1){
            return FabricaProyectos.getInstanciaRep().consultarProyecto(codigo, index);
        }
        else if(index==2){
            return FabricaProyectos.getInstanciaRep().consultarProyecto(codigo, index);
        }
        else if(index==3){
           return FabricaProyectos.getInstanciaRep().consultarProyecto(codigo, index);
        }
        else if(index==4){
           return FabricaProyectos.getInstanciaRep().consultarProyecto(codigo, index);
        }
        return null;
    }

    @Override
    public boolean actualizarProyecto(Proyectos proyecto) {
        return FabricaProyectos.getInstanciaRep().actualizarProyecto(proyecto);
    }

    @Override
    public List<Proyectos> consultarProyectosPeriodo(Date inicio, Date fin) {
        return FabricaProyectos.getInstanciaRep().consultarProyectosPeriodo(inicio,fin);
    }

    @Override
    public List<Proyectos> consultarProyectos() {
       return FabricaProyectos.getInstanciaRep().consultarProyectos();
    }
}
