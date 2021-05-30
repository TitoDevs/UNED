import java.util.ArrayList;
import java.util.Date;

/**
 * Pacientes es la clase donde vamos a almacenar toda la información de los pacientes.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Paciente extends DatosPersonales{
    private boolean resultadoCovid;
    Date inicioConf, finConf, fechaPrueba;
    String enfAsignado, tecAsignado, enfAsignado1, tecAsignado1, proxPrueba, prueba, vacuna;
    
    public Paciente(String ID, Date fecha, String nombre, String apellidos,int edad, String sexo, String usuario, boolean resultadoCovid){
        super(ID, fecha, nombre, apellidos, edad, sexo, usuario);
        this.resultadoCovid = resultadoCovid;
        this.enfAsignado = enfAsignado;
        this.tecAsignado = tecAsignado;
        this.inicioConf = inicioConf;
        this.finConf = finConf;
        this.proxPrueba = proxPrueba;
        this.fechaPrueba = fechaPrueba;
        this.prueba = prueba;
        this.vacuna = vacuna;
    }
    
    public void setResultadoCovid(boolean resulado){
        this.resultadoCovid = resultadoCovid;
    }
    
    public boolean getResultadoCovid(){
        return resultadoCovid;
    }
    
    public void setInicioConf(Date inicioConf){
        this.inicioConf = inicioConf;
    }
    
    public Date getInicioConf(){
        return inicioConf;
    }
    
    public void setFinConf(Date finConf){
        this.finConf = finConf;
    }
    
    public Date getFinConf(){
        return finConf;
    }
    
    public void setEnfAsignado(String enfAsignado){
        this.enfAsignado = enfAsignado;
    }
    
    public String getEnfAsignado(){
        return enfAsignado;
    }
    
    public void setTecAsignado(String tecAsignado){
        this.tecAsignado = tecAsignado;
    }
    
    public String getTecAsignado(){
        return tecAsignado;
    }
    
    public void setProxPrueba(String proxPrueba){
        this.proxPrueba = proxPrueba;
    }
    
    public String getProxPrueba(){
        return proxPrueba;
    }
    
    public void setFechaPrueba(Date fechaPrueba){
        this.fechaPrueba = fechaPrueba;
    }
    
    public Date getFechaPrueba(){
        return fechaPrueba;
    }
    
    public void setPrueba(String prueba){
        this.prueba = prueba;
    }
    
    public String getPrueba(){
        return prueba;
    }
    
     public void setVacuna(String vacuna){
        this.vacuna = vacuna;
    }
    
    public String getVacuna(){
        return vacuna;
    }
}
