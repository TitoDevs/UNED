import java.util.ArrayList;

/**
 * Pacientes es donde vamos guardar todos los pacientes.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Pacientes
{
    // instance variables - replace the example below with your own
    public ArrayList<Paciente> listPacientes;
    int numeroPacientes;
    
    public Pacientes()
    {
       listPacientes = new ArrayList<>();
    }
    
    public void addPacientes(Paciente paciente)
    {
        listPacientes.add(paciente);
        numeroPacientes++;
    }
    
    public void listaPacientes(){
        int lista = listPacientes.size();
        System.out.println(lista);
    }
}
