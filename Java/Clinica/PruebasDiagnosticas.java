import java.util.ArrayList;

/**
 * Pruebas diagnósticas es la clase donde vamos a almacenar los tres tipos de pruebas, que son:
 * las pruebas de antígenos, los PCRs y los análisis serológicos.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class PruebasDiagnosticas{
    private int pruebasAntigenos = 20;
    private int PCR = 20;
    private int analisisSerologicos = 20;
    
    public PruebasDiagnosticas(){
        this.pruebasAntigenos = pruebasAntigenos;
        this.PCR = PCR;
        this.analisisSerologicos = analisisSerologicos;
    }
    
    public void setPruebasAntigenos(){
        this.pruebasAntigenos = pruebasAntigenos;
    }
    
    public int getPruebasAntigenos(){
        return pruebasAntigenos;
    }
    
    public void setPCR(){
        this.PCR = PCR;
    }
    
    public int getPCR(){
        return PCR;
    }
    
    public void setAnalisisSerologicos(){
        this.analisisSerologicos = analisisSerologicos;
    }
    
    public int getAnalisisSerologicos(){
        return analisisSerologicos;
    }
}
