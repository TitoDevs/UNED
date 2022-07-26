import java.io.*;
import java.util.*;

public class skyline {

    public static String resumen;
    public static Boolean activar = false;
    public static int num = 1;

    // Divide y Vencerás
    public List<int[]> dyv(int[][] problema) {                                      // O(1)
        resumen = "\n\n =========== DYV ===========\n";                             // 1
        resumen += " Se detecta " + problema.length + " edificios\n";               // 1

        if (problema.length == 0)                                                   // 1
            return new ArrayList<>();
        activar = true;

        return edificios(problema, 0, problema.length - 1);                    // 1
    }


    // Edificios
    private ArrayList<int[]> edificios(int[][] C, int i, int j) {                   // O(1)
        int m, n;                                                                   // 1
        m = (i + j - 1) / 2;                                                        // 1
        n = j - i + 1;                                                              // 1

        if (n == 1) {                                                               // 1
            ArrayList<int[]> s = new ArrayList<>();
            s.add(new int[]{C[i][0], C[i][2]});
            s.add(new int[]{C[i][1], 0});
            activar = false;
            resumen += "    Skyline " + (i + 1) + ": " + "(" + C[i][0] + "," + C[i][2] + "," + C[i][1] + "," + 0 + ")\n";
            return s;
        } else {                                                                    // 1
            if (activar && num == 1) {
                resumen += " Pasamos al método edificios\n";
                resumen += "\n =========== EDIFICIOS ===========\n";
            }

            resumen += " Se divide el array de edificios entre dos hasta obtener dos edificios: Obtenemos " + n + " edificios\n";
            ArrayList<int[]> sa = edificios(C, i, m);
            ArrayList<int[]> sb = edificios(C, m + 1, j);
            activar = false;
            num++;
            return combinar(sa, sb);
        }
    }


    // Combinar
    private ArrayList<int[]> combinar(ArrayList<int[]> sa, ArrayList<int[]> sb) {   // O(n)
        resumen += " Pasamos al método combinar\n";                                 // 1
        resumen += "\n =========== COMBINAR ===========\n";                         // 1
        ArrayList<int[]> s = new ArrayList<>();                                     // 1
        int ha = 0, hb = 0, uh = 0;                                                 // 1
        int[] a, b;                                                                 // 1
        int ia, ib, nx, nh;                                                         // 1

        ia = 0;                                                                     // 1
        ib = 0;                                                                     // 1

        resumen += " Combinamos los " + sa.size() + " skylines\n";                  // 1

        while (ia < sa.size() && ib < sb.size()) {                                  // n
            a = sa.get(ia);
            b = sb.get(ib);

            if (a[0] == b[0]) {
                nx = a[0];
                nh = Math.max(a[1], b[1]);
                ha = a[1];
                hb = b[1];
                ia = ia + 1;
                ib = ib + 1;
            } else {
                if (a[0] < b[0]) {
                    nx = a[0];
                    nh = Math.max(a[1], hb);
                    ha = a[1];
                    ia = ia + 1;
                } else {
                    nx = b[0];
                    nh = Math.max(b[1], ha);
                    hb = b[1];
                    ib = ib + 1;
                }
            }
            if (uh != nh) {
                s.add(new int[]{nx, nh});
                uh = nh;
            }
        }
        while (ia < sa.size()) {                                                    // n
            s.add(sa.get(ia++));
        }
        while (ib < sb.size()) {                                                    // n
            s.add(sb.get(ib++));
        }
        return s;                                                                   // 1
    }

    // Menú de ayuda
    public static void ayuda() {                                                    // O(1)
        System.out.println();
        System.out.println(" SINTAXIS: skyline [-t] [-h]  [fichero entrada]  [fichero salida]");
        System.out.println("      -t          Traza cada llamada recursiva y sus parámetros");
        System.out.println("      -h          Muestra esta ayuda");
        System.out.println("      [fichero entrada]   Conjunto de edificios de la ciudad");
        System.out.println("      [ficharo salida]   Secuencia que representan el skyline de la ciudad");
        System.out.println();
    }

    // En esta función lo que se hace básicamente es obtener los edificios del txt
    public static void programa(String t, String h, String entrada, String salida) {// O(n3)
        try {                                                                       // 1
            String prueba;  // Es la entrada formateada para que nuestro programa pueda leerla.
            File fentrada = new File(entrada);
            File fsalida = new File(salida);

            if (fentrada.exists()) {                                                // 1
                BufferedReader bufferedReader = new BufferedReader(new FileReader(fentrada));
                // El formato de entrada es {(x,x),(x,x)} así como nos lo indica el libro.
                while ((prueba = bufferedReader.readLine()) != null) {              // n
                    prueba = prueba.replace("}", "");
                    prueba = prueba.replace('{', ' ');
                    prueba = prueba.replaceAll("\\(", "");
                    prueba = prueba.replaceAll("\\),", "&");
                    prueba = prueba.replaceAll("\\)", "");
                    prueba = prueba.trim();

                    String[] row = prueba.split("&");
                    int[][] matrix = new int[row.length][];
                    for (int i = 0; i < row.length; i++) {                          // n^2
                        String currentline = row[i].trim();
                        int[] temp = new int[currentline.length() - 2];
                        int cont = 0;
                        for (int j = 0; j < currentline.length(); j = j + 2) {      // n^3
                            temp[cont] = Character.getNumericValue(currentline.charAt(j));
                            cont++;
                        }
                        matrix[i] = temp;
                    }

                    StringBuilder cadena;  // Contiene la salida del skyline
                    skyline ejemplo = new skyline();
                    cadena = new StringBuilder("(");

                    for (int[] p : ejemplo.dyv(matrix)) {                           // n^2
                        for (int j : p) {                                           // n^3
                            if (j != 0) {
                                cadena.append(j).append(",");
                            } else {
                                cadena.append(j);
                            }
                        }
                    }

                    // Esto es un miniprograma que consiste en comprobar si es necesario crear una salida.txt o imprimirla por pantalla.
                    if (salida.equals("0")) {                                       // n
                        System.out.println();
                        System.out.print(cadena + ")");
                    } else {                                                        // n
                        if (fsalida.exists()) {
                            System.out.println();
                            System.out.println(cadena + ")");
                        } else {
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fsalida));
                            bufferedWriter.write(cadena + ")");
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                        }
                    }
                }
            } else {
                System.out.println(" El fichero de entrada no existe");
            }
        } catch (IOException e) {
            System.out.println(" Error E/S: " + e);
        }
    }

    public static void main(String[] args) {                                        // O(1)

        String h = "h";                                                             // 1
        String t = "t";                                                             // 1

        // Argumentos
        switch (args.length) {                                                      // 1
            case 1 : {
                File entrada = new File(args[0]);
                if (args[0].equals(h)) {                         // Si el argumento 0 es igual a "h", que salga el menú de ayuda.
                    ayuda();
                } else if (args[0].equals(t)) {                  // Si el argumento 0 es igual a "t", nos salta un error indicándonos que tenemos que introducir una entrada.
                    System.out.println(" Debe introducir una entrada\n");
                } else if (entrada.exists()) {                   // Si el argumento 0 contiene una entrada, que nos muestre la salida por consola.
                    String txtEntrada = entrada.toString();
                    programa(h, t, txtEntrada, "0");
                } else {                                         // Si el argumento 0 contiene otro tipo que no sea los anteriores indicados, que nos lance un error.
                    System.out.println(" Los parámetros introducidos son erróneos.\n");
                }
                break;
            }
            case 2: {                                                               // 1
                File entrada2 = new File(args[0]);
                File salida2 = new File(args[1]);
                File entrada2_ = new File(args[1]);
                if (args[0].equals(t) && args[1].equals(h) || args[0].equals(h) && args[1].equals(t)) {  // Si los argumentos 0 y 1 es igual a h y t o viceversa, muestra el menú de ayuda y lanza un error.
                    ayuda();
                    System.out.println(" Para que muestre la traza debe introducir una entrada.\n");
                } else if (args[0].equals(t) && entrada2_.exists()) {        // Si el argumento 0 contiene t y el segundo contiene una entrada, que nos muestre la salida y su traza.
                    String txtEntrada = entrada2_.toString();
                    programa(t, h, txtEntrada, "0");
                    System.out.println(resumen);
                } else if (args[0].equals(h) && entrada2_.exists()) {        // Si el argumento 0 contiene h y el segundo contiene una entrada, que nos muestre la salida y el menú de ayuda.
                    String txtEntrada = entrada2_.toString();
                    ayuda();
                    programa(t, h, txtEntrada, "0");
                } else if (entrada2.exists() && !salida2.exists()) {         // Si el argumento 0 contiene una entrada y el segundo una salida.txt no creada, que nos cree la salida.txt
                    String txtEntrada = entrada2.toString();
                    String txtSalida = salida2.toString();
                    programa(t, h, txtEntrada, txtSalida);
                    System.out.println(" Archivo de salida creada. Si no se ha creado es porque has introducido mal la ubicación o el formato de salida (txt)");
                } else if (entrada2.exists() && salida2.exists()) {          // Si el argumento 0 contiene una entrada y el segundo una salida.txt creada, que nos lance un error.
                    System.out.println(" El archivo de salida ya existe.\n");
                }
                break;
            }
            case 3: {                                                               // 1
                File entrada3 = new File(args[1]);
                File salida3 = new File(args[2]);
                if (args[0].equals(t) && entrada3.exists() && !salida3.exists()) {  // Si el argumento 0 contiene "t", argumento 1 contiene una entrada y argumento 2 contiene una salida.txt no creada, que nos muestre su traza y nos cree una salida.txt
                    String txtEntrada2 = entrada3.toString();
                    String txtSalida2 = salida3.toString();
                    programa(t, h, txtEntrada2, txtSalida2);
                    System.out.println(resumen);
                    System.out.println(" Archivo de salida creada. Si no se ha creado es porque has introducido mal la ubicación o el formato de salida (txt)");
                } else if (args[0].equals(h) && entrada3.exists() && !salida3.exists()) {  // Si el argumento 0 contiene "h", arguemento 1 contiene una entrada y argumento 2 contiene una salida.txt no creada, que nos muestre el menú de ayuda y nos cree una salida.txt
                    String txtEntrada2 = entrada3.toString();
                    String txtSalida2 = salida3.toString();
                    ayuda();
                    programa(t, h, txtEntrada2, txtSalida2);
                    System.out.println(" Archivo de salida creada. Si no se ha creado es porque has introducido mal la ubicación o el formato de salida (txt)");
                }  else if (args[0].equals(t) && entrada3.exists() && salida3.exists()) {  // Si el argumento 0 contiene "t", arguemento 1 contiene una entrada y argumento 2 contiene una salida.txtcreada, que nos muestre error de salida.
                    System.out.println(" El archivo de salida ya existe.\n");
                }
                else {    // Si los argumentos contiene algún dato no especificado anteriormente, nos lanzará un error.
                    System.out.println(" Los parámetros introducidos son erróneos.\n");
                }
                break;
            }
            case 4: {                                                               // 1
                File entrada4 = new File(args[2]);
                File salida4 = new File(args[3]);  // Si el argumento 0 contiene t, argumento 1 contiene h, argumento 2 contiene una entrada y argumento 3 contiene una salida.txt no creada, que nos muestre su trazado y nos cree una salida.txt
                if (args[0].equals(t) && args[1].equals(h) && entrada4.exists() && !salida4.exists() || args[0].equals(h) && args[1].equals(t) && entrada4.exists() && !salida4.exists()) {
                    String txtEntrada3 = entrada4.toString();
                    String txtSalida3 = salida4.toString();
                    ayuda();
                    programa(t, h, txtEntrada3, txtSalida3);
                }
                break;
            }
        }
    }
}