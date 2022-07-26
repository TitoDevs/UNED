import java.util.ArrayList;
import java.util.Date;

/**
 * Tecnicos es la clase donde vamos a almacenar toda la información de todos los técnicos.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Tecnicos extends DatosPersonales{
    public ArrayList<PacientesAsignados> listPacAsignados;
    int pruebasRealizadas;
    
    public Tecnicos(String ID, Date fecha, String nombre, String apellidos,int edad, String sexo, String usuario){
        super(ID,fecha,nombre,apellidos,edad,sexo,usuario); 
        listPacAsignados = new ArrayList<>();
    }
    
    public void addPacientes(PacientesAsignados pacAsig){
            listPacAsignados.add(pacAsig);
            pruebasRealizadas++;
    }
}
