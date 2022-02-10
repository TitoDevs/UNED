import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class floyd {

    public void Floyd(int[][] a, int n, int[][] m)
    {
        System.out.println("Floyd");
        int i, j, k;

        for (i = 1;i < n; i++)
        {
            for (j = 1;j < n; j++)
            {
                m[i][j] = a[i][j];
                System.out.println("Primer bucle: " + m[i][j]);
            }
        }
        for (k = 1; k < n; k++)
        {
            for (i = 1; i < n; i++)
            {
                for (j = 1; j < n; j++)
                {
                    m[i][j] = Math.min(m[i][j], m[i][k] + m[k][j]);
                    System.out.println("Segundo bucle: " + m[i][j]);
                }
            }
        }
    }

    public void Floyd2(int[][] a, int n, int[][] m, int[][] ruta)
    {
        System.out.println("Floyd2");
        int i, j, k, tmp;

        for (i = 1;i < n; i++)
        {
            for (j = 1;j < n; j++)
            {
                m[i][j] = a[i][j];
                ruta[i][j] = 0;
                System.out.println("Primer bucle: " + m[i][j]);
            }
        }
        for (k = 1; k < n; k++){

            for (i = 1; i < n; i++)
            {
                for (j = 1; j < n; j++)
                {
                    tmp = m[i][k] + m[k][j];
                    if (tmp < m[i][j])
                    {
                        m[i][j] = tmp;
                        ruta[i][j] = k;
                        System.out.println("Segundo bucle1: " + tmp);
                        System.out.println("Segundo bucle2: " + k);
                    }
                }
            }
        }
    }

    public void VerRutas(int n, int[][] m, int[][] ruta)
    {
        int i, j;

        for (i = 1; i < n; i++)
        {
            for (j = 1; j < n; j++)
            {
                if (m[i][j] != -1)
                {
                    System.out.print("Ruta de " + i + " a" + j);
                    System.out.print(i);
                    ImprimeRutasRec(ruta,i,j);
                    System.out.println(j);
                }
            }
        }
    }

    public void ImprimeRutasRec(int [][] ruta, int i, int j)
    {
        int k;
        k = ruta[i][j];
        if (k != 0)
        {
            ImprimeRutasRec(ruta, i, j);
            System.out.print(k);
            ImprimeRutasRec(ruta, k, j);
        }
    }

    public static void ayuda(){
        System.out.println();
        System.out.println(" SINTAXIS: floyd [-t] [-h]  [fichero entrada]  [fichero salida]");
        System.out.println("      -t          Traza el algoritmo");
        System.out.println("      -h          Muestra esta ayuda");
        System.out.println("      [fichero entrada]   Matriz de adyacencia que representa el grafo");
        System.out.println("      [ficharo salida]    Para cada par de nodos: la lista de nodos del camino más corto y su valor o longitud");
        System.out.println();
    }

    public static void programa(String t, String h, String entrada, String salida){

        try
        {
            String br = "C:\\floyd\\" + entrada + ".txt";
            String bw = "C:\\floyd\\" + salida + ".txt";

            String prueba;

            File fentrada = new File(br);
            File fsalida = new File(bw);

            if (h.equals("-h") && t.equals("-t"))
            {
                if (fentrada.exists())
                {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(br));
                    while ((prueba = bufferedReader.readLine()) != null)
                    {

                    }
                }
                else
                {
                    System.out.println(" El fichero de entrada no existe");
                }
            }
            else
            {
                System.out.println(" Comprueba el orden o nombres de los parámetros");
            }
        }
        catch (IOException e)
        {
            System.out.println(" Error E/S: " + e);
        }
    }

    public static void main(String[]args)
    {
        floyd floyd = new floyd();
        int[][] a = {{1,2},{5,4},{1,2},{5,4}};
        int n = 4;
        int[][] m = {{4,6,2},{1,2,3},{4,6,2},{1,2,3}};
        floyd.Floyd(a, n, m);
    }
}
