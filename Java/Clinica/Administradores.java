import java.util.Date;

/**
 * Administradores es la clase donde vamos a almacenar toda la información de todos los
 * administradores.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Administradores extends DatosPersonales{

    public Administradores(String ID, Date fecha, String nombre, String apellidos,int edad, String sexo, String usuario){
        super(ID,fecha,nombre,apellidos,edad,sexo,usuario);
        
    }
}
