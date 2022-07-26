import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Cliente {
    public int id;
    public String nombre;
    public String apellido;
    public Date tiempoUsoBicicleta;
    public Date tiempoUsoPatinete;
    public Date tiempoUsoCoche;
    private ArrayList<Cliente> listClientes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getTiempoUsoBicicleta() {
        return tiempoUsoBicicleta;
    }

    public void setTiempoUsoBicicleta(Date tiempoUsoBicicleta) {
        this.tiempoUsoBicicleta = tiempoUsoBicicleta;
    }

    public Date getTiempoUsoPatinete() {
        return tiempoUsoPatinete;
    }

    public void setTiempoUsoPatinete(Date tiempoUsoPatinete) {
        this.tiempoUsoPatinete = tiempoUsoPatinete;
    }

    public Date getTiempoUsoCoche() {
        return tiempoUsoCoche;
    }

    public void setTiempoUsoCoche(Date tiempoUsoCoche) {
        this.tiempoUsoCoche = tiempoUsoCoche;
    }

    public void nuevoCliente(){
        boolean tecla = false;
        boolean tecla2 = false;
        boolean tecla3 = false;
        boolean tecla4 = false;
        boolean tecla5 = false;
        boolean tecla6 = false;

        while (!tecla){
            Cliente nuevoCliente = new Cliente();
            Scanner myOjb = new Scanner(System.in);
            System.out.println("\nAlta nuevo cliente:");
            while(!tecla2){
                System.out.print("     Identificador (número entre 1 y 20)? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    nuevoCliente.setId(Integer.parseInt(num));
                    if(nuevoCliente.getId() <= 20 && nuevoCliente.getId() > 0){
                        if (listClientes.size() != 0){
                            for (Cliente listCliente : listClientes) {
                                if (nuevoCliente.getId() == listCliente.getId()) {
                                    System.out.println("\n     El número de identificador que has introducido ya le corresponde a otro usuario. Elija otro.\n");
                                    tecla2 = false;
                                    break;
                                }else{
                                    tecla2 = true;
                                }
                            }
                        }else {
                            tecla2 = true;
                        }
                    }else{
                        System.out.println("\n     El valor introducido se encuentra dentro de los valores (10)\n");
                    }
                }else{
                    System.out.println("\n     Introduzca un valor numérico\n");
                }

            }
            while(!tecla5){
                System.out.print("     Nombre (entre 1 y 10 caracteres)? ");
                nuevoCliente.setNombre(myOjb.nextLine());
                if (nuevoCliente.getNombre().length() > 10){
                    System.out.println("\n     El nombre introducido supera los 10 caracteres\n");
                }else{
                    tecla5 = true;
                }
            }
            tecla5 = false;
            while(!tecla6){
                System.out.print("     Apellido (entre 1 y 10 caracteres)? ");
                nuevoCliente.setApellido(myOjb.nextLine());
                if (nuevoCliente.getApellido().length() > 10){
                    System.out.println("\n     El apellido introducido supera los 10 caracteres\n");
                }else{
                    tecla6 = true;
                }
            }
            tecla6 = false;
            tecla3 = false;

            while (!tecla3){
                System.out.print("Datos correctos (S/N)? ");
                String opcion = myOjb.nextLine();
                if (opcion.toUpperCase().equals("S")){
                    tecla4 = false;
                    while (!tecla4){
                        System.out.print("Otro cliente (S/N)? ");
                        String opcion2 = myOjb.nextLine();
                        if (opcion2.toUpperCase().equals("S")){
                            listClientes.add(nuevoCliente);
                            tecla2 = false;
                            tecla4 = true;
                        }
                        if (opcion2.toUpperCase().equals("N")){
                            listClientes.add(nuevoCliente);
                            tecla = true;
                            tecla2 = false;
                            tecla4 = true;
                            System.out.println("");
                        }
                    }
                    tecla3 = true;
                }
                if (opcion.toUpperCase().equals("N")){
                    System.out.println("");
                    tecla2 = false;
                    tecla3 = true;
                }
            }
        }
    }

    public ArrayList<Cliente> mostrarCliente(){
        return listClientes;
    }

    public void resumenMensual(ArrayList<Cliente> listClientes, ArrayList<ActivarVehiculo> listInfo){
        boolean tecla = false;
        boolean tecla1 = false;
        boolean tecla2 = false;
        boolean tecla3 = false;
        Scanner myOjb = new Scanner(System.in);
        String idCliente;
        int id = 0;
        String mes;
        String anno;
        String nombre = "";
        String apellido = "";
        int numMes = 0;
        int numAnno = 0;
        int numMonth = 0;
        int numYear = 0;
        int numDay = 0;
        SimpleDateFormat getYear = new SimpleDateFormat("yy");
        SimpleDateFormat getMonth = new SimpleDateFormat("MM");
        SimpleDateFormat getDay = new SimpleDateFormat("dd");
        LinkedList<ActivarVehiculo> lis = new LinkedList<>();

        System.out.println("\nResumen mensual de cliente: ");
        while (!tecla){
            System.out.print("Identificador cliente: ");
            idCliente = myOjb.nextLine();
            if (isNumeric(idCliente)){
                id = Integer.parseInt(idCliente);
                if (listClientes.size() != 0){
                    for (int i = 0; i<listClientes.size();i++) {
                        if (id == listClientes.get(i).getId()) {
                            nombre = listClientes.get(i).getNombre();
                            apellido = listClientes.get(i).getApellido();
                            tecla = true;
                            break;
                        }else{
                            System.out.println("\n     El número de identificador que has introducido no existe. Elija otro.\n");
                        }
                    }
                }else {
                    System.out.println("\n     No existen clientes en la base de datos\n");
                    tecla = true;
                    tecla1 = true;
                    tecla2 = true;
                }
            }else{
                System.out.println("\n     Introduzca un valor numérico\n");
            }
        }
        tecla = false;

        while (!tecla1){
            System.out.print("Selección Mes? ");
            mes = myOjb.nextLine();
            if (isNumeric(mes)){
                numMes = Integer.parseInt(mes);
                if (numMes <= 12){
                    tecla1 = true;
                }else {
                    System.out.println("\n     Introduzca un mes correcto\n");
                }
            }else{
                System.out.println("\n     Introduzca un valor numérico\n");
            }
        }
        tecla1 = false;
        while (!tecla2){
            System.out.print("Selección Año? ");
            anno = myOjb.nextLine();
            int cantidad = 2;

            if (isNumeric(anno)){
                numAnno = Integer.parseInt(anno);
                if (numAnno <= 2900 || numAnno >= 1700){
                    StringBuffer a = new StringBuffer(anno);
                    a.delete(0,2);
                    numAnno = Integer.parseInt(a.toString());
                    tecla2 = true;

                }else {
                    System.out.println("\n     Introduzca un anno entre 1700 y 2900\n");
                }
            }else{
                System.out.println("\n     Introduzca un valor numérico\n");
            }
        }
        tecla2 = false;


        while (!tecla3){
            int selectedYear = numAnno;
            int selectedMonth = numMes - 1;

            Calendar cal = new GregorianCalendar();
            int cDay = cal.get(Calendar.DATE);
            int cMonth = cal.get(Calendar.MONTH);
            int cYear = cal.get(Calendar.YEAR);

            GregorianCalendar gCal = new GregorianCalendar(selectedYear, selectedMonth,1);
            int days = gCal.getActualMaximum(Calendar.DATE);
            int startInWeek = gCal.get(Calendar.DAY_OF_WEEK);

            gCal = new GregorianCalendar(selectedYear, selectedMonth,days);
            int totalWeeks = gCal.getActualMaximum(Calendar.WEEK_OF_MONTH);

            ActivarVehiculo aVeh = new ActivarVehiculo();
            for (int i = 0; i < listInfo.size(); i++){
                if (listInfo.get(i).getIdCliente() == id){
                    String year = getYear.format(listInfo.get(i).getFechaActivacion());
                    String month = getMonth.format(listInfo.get(i).getFechaActivacion());
                    String day = getDay.format(listInfo.get(i).getFechaActivacion());
                    numYear = Integer.parseInt(year);
                    numMonth = Integer.parseInt(month);
                    numDay = Integer.parseInt(day);
                    if (numMonth == numMes && numYear == numAnno){
                        aVeh.setTipoVehiculo(listInfo.get(i).getTipoVehiculo());
                        aVeh.setFechaActivacion(listInfo.get(i).getFechaActivacion());
                    }
                }
            }

            int count = 1;
            System.out.println("Resumen uso cliente: " + nombre + " " + apellido);
            System.out.println();
            System.out.println("DO  LU  MA  MI  JU  VI  SA");
            for(int i = 1; i<=totalWeeks; i++){
                System.out.println();
                for (int j = 1; j <= 7; j++){
                    if (count < startInWeek || (count - startInWeek + 1) > 31){
                        System.out.print("__");
                        System.out.print("  ");
                    }else{
                        if(listInfo.size() !=0){
                            if (listInfo.get((count-startInWeek+1)).getFechaActivacion() != null){
                                String day = getDay.format(listInfo.get((count-startInWeek+1)).getFechaActivacion());
                                int numDay1 = Integer.parseInt(day);
                                if (numDay1 == (count-startInWeek+1)){
                                    System.out.print(listInfo.get((count-startInWeek+1)).getTipoVehiculo().toUpperCase());
                                    System.out.print("  ");
                                }else{
                                    System.out.print(getDay((count -startInWeek + 1)));
                                    System.out.print("  ");
                                }
                            }else{
                                System.out.print(getDay((count -startInWeek + 1)));
                                System.out.print("  ");
                            }

                        }else{
                            System.out.print(getDay((count -startInWeek + 1)));
                            System.out.print("  ");
                        }
                    }
                    count++;
                }
            }
            System.out.println("\n ");
            tecla3 = true;
        }
    }

    private static String getDay(int i) {
        String sDate = Integer.toString(i);
        if (sDate.length() == 1){
            sDate = "0"+sDate;
            return sDate;
        }
        return sDate;
    }

    // Función para saber si la entrada es entero o no
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
}
