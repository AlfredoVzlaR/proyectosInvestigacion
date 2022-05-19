/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IProyectos;
import interfaces.IRepProyectos;
import interfaces.IRepPublicaciones;


/**
 *
 * @author Alfredo Valenzuela
 */
public class FabricaProyectos {
    
    public static IProyectos getInstancia()
    {
        return new FachadaProyectos();
    }
    public static IRepProyectos getInstanciaRep(){
        return new RepProyectos(ConexionBD.getConexionBD());
    }
    public static IRepPublicaciones getInstanciaRepPublicaciones(){
        return new RepPublicaciones(ConexionBD.getConexionBD());
    }
}
