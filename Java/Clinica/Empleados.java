import java.util.ArrayList;

/**
 * Empleados es la clase donde vamos a almacenar las listas de los enfermeros, técnicos y
 * administradores.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0*/
public class Empleados{
    Personas personas;
    public ArrayList<Enfermeros> enfermeros;
    public ArrayList<Tecnicos> tecnicos;
    public ArrayList<Administradores> administradores;
    public ArrayList<String> listEmpleados;
    public int numeroEmpleados;
    public int numeroEnfermeros;
    public int numeroTecnicos;
    public int numeroAdministradores;
    
    public Empleados() {
        enfermeros = new ArrayList<>();
        tecnicos = new ArrayList<>();
        administradores = new ArrayList<>();
        listEmpleados = new ArrayList<>();
    }

    public void addEnfermeros(Enfermeros enfermero)
    {
        enfermeros.add(enfermero);
        numeroEmpleados++;
        numeroEnfermeros++;
    }
    
    public void addTecnicos(Tecnicos tecnico)
    {
        tecnicos.add(tecnico);
        numeroEmpleados++;
        numeroTecnicos++;
    }
    
    public void addAdministradores(Administradores administrador)
    {
        administradores.add(administrador);
        numeroEmpleados++;
        numeroAdministradores++;
    }
    
    public void addEmpleados(String id){
        listEmpleados.add(id);
    }
    
    public int numerodeEmpleados(){
        return numeroEmpleados;
    }
    
    public void listaEnfermeros(){
        int lista = enfermeros.size();
    }
    
    public static void main(String[] args){
        Empleados empleado = new Empleados();
    }
}
