/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dominio.EnCongreso;
import dominio.EnRevista;
import dominio.Publicaciones;
import interfaces.IConexionBD;
import interfaces.IRepPublicaciones;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class RepPublicaciones implements IRepPublicaciones {
    private IConexionBD conexion;
    private MongoDatabase baseDatos;
    
    public RepPublicaciones(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
     private MongoCollection <Publicaciones> getCollectionPublicaciones() {
        return this.baseDatos.getCollection("publicaciones", Publicaciones.class);
    }
     
     private MongoCollection <EnRevista> getCollectionRevista() {
        return this.baseDatos.getCollection("EnRevista",EnRevista.class);
    }
     
     private MongoCollection <EnCongreso> getCollectionCongreso() {
        return this.baseDatos.getCollection("EnCongreso",EnCongreso.class);
    }

    @Override
    public List<Publicaciones> consultarPublicaciones() {
        MongoCollection <Publicaciones> coleccion = this.getCollectionPublicaciones();
        List<Publicaciones> listPublicaciones = new LinkedList();
        coleccion.find().into(listPublicaciones);
        return listPublicaciones;
    }

    @Override
    public boolean agregarPublicacion(Publicaciones publicaciones, EnRevista revista) {

        MongoCollection<Publicaciones> publicacion = this.getCollectionPublicaciones();
        MongoCollection<EnRevista> revistas = this.getCollectionRevista();

        publicacion.insertOne(publicaciones);

        revistas.insertOne(revista);
        return true;
    }

    @Override
    public boolean agregarPublicacion(Publicaciones publicaciones, EnCongreso congreso) {
       MongoCollection<Publicaciones> publicacion = this.getCollectionPublicaciones();
       MongoCollection<EnCongreso> congresos = this.getCollectionCongreso();
       
       publicacion.insertOne(publicaciones);
       congresos.insertOne(congreso);
       
       return true;
    }
}
