package negocio;

/**
 *
 * @author germa
 */
public class FabricaLogica{

    public static ILogica getInstancia(){
        return new FachadaProyectos();
    }
}
