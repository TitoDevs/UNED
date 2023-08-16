import java.util.Date;

/**
 * Pacientes Asignados es una clase donde guardaremos los pacientes asignados a enfermeros y a tecnicos.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
 public class PacientesAsignados{
        public String idPaciente;
        public Date date;
        
        public PacientesAsignados(Date date, String idPaciente){
            this.idPaciente = idPaciente;
            this.date = date;
        }
        
        public Date getDate(){
            return date;
        }
        
        public String getIdPaciente(){
            return idPaciente;
        }
        
        public void setDate(Date date){
            this.date = date;
        }
        
        public void setIdPaciente(String idPaciente){
            this.idPaciente = idPaciente;
        }
        
    }
