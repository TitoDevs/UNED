import java.util.ArrayList;

/**
 * Personas es la clase donde vamos a almacenar los tipos de personas que en este caso son los
 * pacientes de la clínica y sus empleados.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Personas{
    private Pacientes pacientes;
    private Empleados empleados;
    
    public void acceder(Empleados empleado){
        empleado.listaEnfermeros();
    }
    
}
