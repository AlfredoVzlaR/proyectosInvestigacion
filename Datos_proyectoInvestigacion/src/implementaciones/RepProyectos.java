/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import dominio.Doctor;
import dominio.LineaInvestigacion;
import dominio.NoDoctor;
import dominio.Proyectos;
import interfaces.IConexionBD;
import interfaces.IRepProyectos;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Alfredo Valenzuela
 */
public class RepProyectos implements IRepProyectos {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public RepProyectos(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    private MongoCollection getCollection() {
        return this.baseDatos.getCollection("proyectos", Proyectos.class);
    }

//    private MongoCollection <Profesor>getCollectionProfesores() {
//        return this.baseDatos.getCollection("profesores", Profesor.class);
//    }
    private MongoCollection<LineaInvestigacion> getCollectionLineasInvestigacion() {
        return this.baseDatos.getCollection("lineasInvestigacion", LineaInvestigacion.class);
    }

    private MongoCollection<Doctor> getCollectionDoctores() {
        return this.baseDatos.getCollection("doctor", Doctor.class);
    }

    private MongoCollection<NoDoctor> getCollectionNoDoctores() {
        return this.baseDatos.getCollection("nodoctor", NoDoctor.class);
    }

//    @Override
//    public List<Profesor> consultarTodosProfesores(){
//        MongoCollection <Profesor> coleccion = this.getCollectionProfesores();
//        List<Profesor> listProfesores = new LinkedList();
//        coleccion.find().into(listProfesores);
//        return listProfesores;
//    }
    @Override
    public List<Doctor> consultarDoctores() {
        MongoCollection<Doctor> coleccion = this.getCollectionDoctores();
        List<Doctor> listDoctores = new LinkedList();
        coleccion.find().into(listDoctores);
        return listDoctores;
    }

    @Override
    public Proyectos consultarProyecto(String parametro, int index) {
        try {
            MongoCollection<Proyectos> coleccion = this.getCollection();
            List<Proyectos> lista = new LinkedList<>();
            if (index == 0) {
                coleccion.find(new Document().append("codigo", new Document().append("$eq", parametro))).into(lista);
                return lista.get(0);
            } else if (index == 1) {
                coleccion.find(new Document().append("nombre", new Document().append("$eq", parametro))).into(lista);
                return lista.get(0);
            } else if (index == 2) {
                coleccion.find(new Document().append("acronimo", new Document().append("$eq", parametro))).into(lista);
                return lista.get(0);
            } else if (index == 3) {
                coleccion.find(new Document().append("programaInvestigacion", new Document().append("$eq", parametro))).into(lista);
                return lista.get(0);
            } else if (index == 4) {
                coleccion.find(new Document().append("desarrolloFinancia", new Document().append("$eq", parametro))).into(lista);
                return lista.get(0);
            }
        } catch (Exception e) {
            System.err.print(e);
        }
        return null;
    }

    @Override
    public boolean RegistrarProyecto(Proyectos proyecto) {
        MongoCollection<Proyectos> coleccion = this.getCollection();
        coleccion.insertOne(proyecto);
        return true;
    }

    @Override
    public List<LineaInvestigacion> consultarLineasInvestigacion() {
        MongoCollection<LineaInvestigacion> coleccion = this.getCollectionLineasInvestigacion();
        List<LineaInvestigacion> listLineas = new LinkedList();
        coleccion.find().into(listLineas);
        return listLineas;
    }

    @Override
    public List<NoDoctor> consultarNoDoctores() {
        MongoCollection<NoDoctor> coleccion = this.getCollectionNoDoctores();
        List<NoDoctor> listNoDoctores = new LinkedList();
        coleccion.find().into(listNoDoctores);
        return listNoDoctores;
    }

    @Override
    public boolean actualizarProyecto(Proyectos proyecto) {
        MongoCollection<Proyectos> coleccion = this.getCollection();
        coleccion.updateOne(Filters.eq("codigo", proyecto.getCodigo()), new Document().append("$set", new Document().append("nombre", proyecto.getNombre())
                .append("acronimo", proyecto.getAcronimo()).append("programaInvestigacion", proyecto.getProgramaInvestigacion()).append("lineaInvestigacion", proyecto.getLineaInvestigacion())
                .append("investigadorPrincipal", proyecto.getInvestigadorPrincipal()).append("presupuesto", proyecto.getPresupuesto()).append("descripcionObjetivos", proyecto.getDescripcionObjetivos())
                .append("profesores", proyecto.getProfesores()).append("fechaInicio", proyecto.getFechaInicio()).append("fechaFinalizacion", proyecto.getFechaFinalizacion())));
        return true;
    }
    
    @Override
    public List<Proyectos> consultarProyectosPeriodo(Date inicio,Date fin){
        MongoCollection<Proyectos> coleccion = this.getCollection();
        Document etapa = new Document().append("fechaInicio",new Document().append("$gte",inicio)).append("fechaFinalizacion",new Document().append("$lte",fin));
        List<Proyectos> proyectos = new ArrayList<>();
        coleccion.find(etapa).into(proyectos);
        if(proyectos.isEmpty()){return null;}
        return proyectos;
    }
    @Override
    public List<Proyectos> consultarProyectos() {
        MongoCollection <Proyectos> coleccion = this.getCollection();
        List<Proyectos> listaProyectos = new LinkedList();
        coleccion.find(new Document().append("fechaFinalizacion", new Document().append("$gt", new Date()))).into(listaProyectos);
        return listaProyectos;
    }
}
