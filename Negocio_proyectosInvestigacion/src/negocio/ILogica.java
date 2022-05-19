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
public interface ILogica {
    
    boolean verificarInformacionBuscar(String campoTexto);
    boolean verificarInformacionRegistrar(String programa, String linea, String nombre, String acronimo, Date fechaInicio, Date fechaFinal, float presupuesto, String descripcion, int index, List<Profesor> profesoresParticipantes);
    Proyectos consultarProyectos(String campoTexto,int index);
    List<LineaInvestigacion> consultarLineasInvestigacion();
    List<Doctor> consultarDoctores();
    public List<NoDoctor> consultarNoDoctores();
    boolean registrarProyecto(Proyectos proyecto);
    boolean actualizarProyecto(Proyectos proyecto);
    List<Proyectos> consultarProyectosPeriodo(Date inicio, Date fin);
    boolean verificarInformacionAgregar(String noSecuencia,String titulo, List<Profesor> profesores, String nombreRevista, String editorial, String volumen, String pagInicio, String pagFin );
    boolean verificarInformacionAgregar(String noSecuencia, boolean tipo, String volumen, String numero, String pagInicio, String pagFin, String editorial);
    boolean verificarInformacionAgregar(boolean tipo, String noSecuencia);
    boolean verificarPublicacion(String titulo);
    boolean verificaElementosSeleccionados(JTable table);
    boolean verificaElementosSeleccionados(List list);
    boolean registrarPublicacion(Publicaciones publicaciones, EnRevista revista);
    boolean registrarPublicacion(Publicaciones publicaciones, EnCongreso congreso);
    List<Proyectos> consultarProyectos();
    boolean verificarActualizar(Proyectos proyecto);
}
