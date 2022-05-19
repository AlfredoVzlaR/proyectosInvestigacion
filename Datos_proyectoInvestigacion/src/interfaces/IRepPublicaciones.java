/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;


import dominio.EnCongreso;
import dominio.EnRevista;
import dominio.Publicaciones;
import java.util.List;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public interface IRepPublicaciones {
    List<Publicaciones> consultarPublicaciones();

    public boolean agregarPublicacion(Publicaciones publicaciones, EnRevista revista);
    public boolean agregarPublicacion(Publicaciones publicaciones, EnCongreso congreso);
}
