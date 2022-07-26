import java.util.ArrayList;
import java.util.Date; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * Datos personales es una clase herencia que sirve para no duplicar contenido en otras clases
 * básicamente.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class DatosPersonales
{
   public String ID, nombre, apellidos, sexo, usuario;
    public int edad;
    public Date fecha;
    
    public DatosPersonales(String ID, Date fecha, String nombre, String apellidos,int edad, String sexo, String usuario){
        this.ID = ID;
        this.fecha = fecha;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
        this.usuario = usuario;
    }
    
    public String getID(){
        return ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

}
