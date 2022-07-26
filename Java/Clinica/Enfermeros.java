import java.util.ArrayList;
import java.util.Date;

/**
 * Enfermeros es la clase donde vamos a almacenar toda la información de cada enfermero.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Enfermeros extends DatosPersonales{
    public ArrayList<PacientesAsignados> listPacAsignados;
    public int pruebasRealizadas;
    public PacientesAsignados pacientesAsignados;
    
    public Enfermeros(String ID, Date fecha, String nombre, String apellidos,int edad, String sexo, String usuario){
        super(ID, fecha, nombre, apellidos, edad, sexo, usuario);
        this.listPacAsignados = listPacAsignados;
        listPacAsignados = new ArrayList<>();
    }
    
    public void addPacientes(PacientesAsignados pacAsig){
            listPacAsignados.add(pacAsig);
            pruebasRealizadas++;
    } 
}
