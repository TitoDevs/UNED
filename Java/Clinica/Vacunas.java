 
/**
 * Vacunas es la clase donde vamos a almacenar los tipos que existen. En este caso es Pfizer,
 * moderna, y Jonhson & Jonhson.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Vacunas{
    private int Pfizer = 20;
    private int Moderna = 20;
    private int JJ = 20;
    
    public Vacunas(){
        this.Pfizer = Pfizer;
        this.Moderna = Moderna;
        this.JJ = JJ;
    }
    
    public void setPfizer(int Pfizer){
        this.Pfizer = Pfizer;
    }
    
    public int getPfizer(){
        return Pfizer;
    }
    
    public void setModerna(int Moderna){
        this.Moderna = Moderna;
    }
    
    public int getModerna(){
        return Moderna;
    }
    
    public void setJJ(int JJ){
        this.JJ = JJ;
    }
    
    public int getJJ(){
        return JJ;
    }
}
