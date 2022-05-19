package negocio;

import dominio.Doctor;
import dominio.EnCongreso;
import dominio.EnRevista;
import dominio.LineaInvestigacion;
import dominio.NoDoctor;
import dominio.Profesor;
import dominio.Proyectos;
import dominio.Publicaciones;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author germa
 */
public class FachadaProyectos implements ILogica{

    CtrlBuscar ctrl = new CtrlBuscar();
    CtrlRegistrar ctrlRegistrar = new CtrlRegistrar();
    CtrlEditar ctrlEditar = new CtrlEditar();
    CtrlAgregar ctrlAgregar = new CtrlAgregar();
    
    @Override
    public boolean verificarInformacionBuscar(String campoTexto) {
        return ctrl.verificarInformacionBuscar(campoTexto) != false;
    }

    @Override
    public Proyectos consultarProyectos(String campoTexto,int index) {
        if(index==0){
            return ctrl.consultarProyectos(campoTexto, index);
        }
        else if(index==1){
            return ctrl.consultarProyectos(campoTexto, index);
        }
        else if(index==2){
            return ctrl.consultarProyectos(campoTexto, index);
        }
        else if(index==3){
            return ctrl.consultarProyectos(campoTexto, index);
        }
        else if(index==4){
            return ctrl.consultarProyectos(campoTexto, index);
        }
        return null;
    }

    @Override
    public boolean verificarInformacionRegistrar(String programa, String linea, String nombre, String acronimo, Date fechaInicio, Date fechaFinal, float presupuesto, String descripcion, int index, List<Profesor> profesoresParticipantes) {
        return ctrlRegistrar.verificarInformacionRegistrar(programa, linea, nombre, acronimo, fechaInicio, fechaFinal, presupuesto, descripcion, index, profesoresParticipantes);
    }

    @Override
    public boolean registrarProyecto(Proyectos proyecto) {
        return ctrlRegistrar.registrarProyecto(proyecto);
    }

//    @Override
//    public List<Profesor> consultarTodosProfesores() {
//        return ctrl.consultarTodosProfesores();
//    }
    
    @Override
    public List<Doctor> consultarDoctores() {
        return ctrlEditar.consultarDoctores();
    }   
    

    @Override
    public List<LineaInvestigacion> consultarLineasInvestigacion() {
        return ctrlRegistrar.consultarLineasInvestigacion();
    }

    @Override
    public List<NoDoctor> consultarNoDoctores() {
        return ctrlEditar.consultarNoDoctores();
    }

    @Override
    public boolean actualizarProyecto(Proyectos proyecto) {
        return ctrlEditar.actualizarProyecto(proyecto);
    }

    @Override
    public List<Proyectos> consultarProyectosPeriodo(Date inicio, Date fin) {
        return ctrl.consultarProyectosPeriodo(inicio, fin);
    }

    @Override
    public boolean verificaElementosSeleccionados(JTable tabla) {
       return ctrlAgregar.verificaElementoSeleccionado(tabla);
    }
    
    @Override
    public boolean verificarInformacionAgregar(String noSecuencia, String titulo, List<Profesor> profesores, String nombreRevista, String editorial, String volumen, String pagInicio, String pagFin) {
       return ctrlAgregar.verificarInformacionAgregar(noSecuencia, titulo, profesores, nombreRevista, editorial, volumen, pagInicio, pagFin);
    }

    @Override
    public boolean verificarInformacionAgregar(String noSecuencia, boolean tipo, String volumen, String numero,String pagInicio, String pagFin, String editorial) {
        return ctrlAgregar.verificarInformacionAgregar(noSecuencia, tipo, volumen,numero, pagInicio, pagFin, editorial);
    }

    @Override
    public boolean verificarInformacionAgregar(boolean tipo, String noSecuencia) {
        return ctrlAgregar.verificarInformacionAgregar(tipo, noSecuencia);
    }

    @Override
    public boolean verificarPublicacion(String titulo) {
         return ctrlAgregar.verificarPublicacion(titulo);
    }

    @Override
    public boolean registrarPublicacion(Publicaciones publicaciones, EnRevista revista) {
        return ctrlAgregar.guardarPublicacion(publicaciones,revista);
    }

    @Override
    public boolean registrarPublicacion(Publicaciones publicaciones, EnCongreso congreso) {
        return ctrlAgregar.guardarPublicacion(publicaciones, congreso);
    }
    @Override
    public List<Proyectos> consultarProyectos() {
        return ctrlEditar.consultarProyectos();
    }

    @Override
    public boolean verificaElementosSeleccionados(List list) {
        return ctrlEditar.verificaElementoSeleccionado(list);
    }

    @Override
    public boolean verificarActualizar(Proyectos proyecto) {
       return ctrlEditar.verificarActualizar(proyecto);
    }
}
