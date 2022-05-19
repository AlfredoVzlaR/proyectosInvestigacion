/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dominio.Proyectos;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alfredo Valenzuela
 */
public interface IProyectos {
    Proyectos ConsultarProyectos(String codigo,int index);
    boolean actualizarProyecto(Proyectos proyecto);
    List<Proyectos> consultarProyectosPeriodo(Date inicio, Date fin);
    List<Proyectos> consultarProyectos();
}
