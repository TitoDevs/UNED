import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ActivarVehiculo {
    public int idVehiculo;
    public int idCliente;
    public int ubicacionClienteRadio;
    public double ubicacionClienteAngulo;
    public int ubicacionVehiculoRadio;
    public double ubicacionVehiculoAngulo;
    public int tiempoUso;
    public Date fechaActivacion;
    public Date horaActivacion;
    public String tipoVehiculo;
    public ArrayList<ActivarVehiculo> listInfo = new ArrayList<>();

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getUbicacionClienteRadio() {
        return ubicacionClienteRadio;
    }

    public void setUbicacionClienteRadio(int ubicacionClienteRadio) {
        this.ubicacionClienteRadio = ubicacionClienteRadio;
    }

    public double getUbicacionClienteAngulo() {
        return ubicacionClienteAngulo;
    }

    public void setUbicacionClienteAngulo(double ubicacionClienteAngulo) {
        this.ubicacionClienteAngulo = ubicacionClienteAngulo;
    }

    public int getUbicacionVehiculoRadio() {
        return ubicacionVehiculoRadio;
    }

    public void setUbicacionVehiculoRadio(int ubicacionVehiculoRadio) {
        this.ubicacionVehiculoRadio = ubicacionVehiculoRadio;
    }

    public double getUbicacionVehiculoAngulo() {
        return ubicacionVehiculoAngulo;
    }

    public void setUbicacionVehiculoAngulo(double ubicacionVehiculoAngulo) {
        this.ubicacionVehiculoAngulo = ubicacionVehiculoAngulo;
    }

    public int getTiempoUso() {
        return tiempoUso;
    }

    public void setTiempoUso(int tiempoUso) {
        this.tiempoUso = tiempoUso;
    }

    public Date getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(Date fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    public Date getHoraActivacion() {
        return horaActivacion;
    }

    public void setHoraActivacion(Date horaActivacion) {
        this.horaActivacion = horaActivacion;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void activarVehiculo(ArrayList<Cliente> listClientes, ArrayList<Vehiculo> listVehiculos){
        boolean tecla = false;
        boolean tecla2 = false;
        boolean tecla3 = false;
        boolean tecla4 = false;
        boolean tecla5 = false;
        boolean tecla6 = false;
        int idVehiculo;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat formato1 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat formatday = new SimpleDateFormat("dd");

        while (!tecla){
            ActivarVehiculo info = new ActivarVehiculo();
            Scanner myOjb = new Scanner(System.in);
            System.out.println("\nActivar vehículo:");
            while(!tecla2){
                System.out.print("     Identificador cliente? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    int id = Integer.parseInt(num);
                    if (listClientes.size() != 0){
                        for (Cliente listCliente : listClientes) {
                            if (id == listCliente.getId()) {
                                info.setIdCliente(id);
                                tecla2 = true;
                                break;
                            } else {
                                System.out.println("     El número de identificador que has introducido no existe. Elija otro.\n");
                            }
                        }
                    }else {
                        tecla2 = true;
                    }
                }else{
                    System.out.println("\n     Introduzca un valor numérico\n");
                }
            }
            tecla2 = false;

            while(!tecla3){
                System.out.print("     Ubicación cliente: Radio? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    int num2 = Integer.parseInt(num);
                    if (num2 < 10000){
                        info.setUbicacionClienteRadio(Integer.parseInt(num));
                        tecla3 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (10000 metros)\n");
                    }
                }else{
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla3 = false;

            while (!tecla4){
                System.out.print("     Ubicación cliente: Ángulo? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    double num2 = Double.parseDouble(num);
                    if (num2 < 360.00){
                        info.setUbicacionClienteAngulo(num2);
                        tecla4 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (360.00 grados)\n");
                    }
                }else{
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla4 = false;

            while(!tecla5){
                System.out.print("     Tipo de vehículo (C/B/P/T)? ");
                info.setTipoVehiculo(myOjb.nextLine());
                if (info.getTipoVehiculo().equalsIgnoreCase("C") || info.getTipoVehiculo().equalsIgnoreCase("B") || info.getTipoVehiculo().equalsIgnoreCase("P") || info.getTipoVehiculo().equalsIgnoreCase("T")){
                    tecla5 = true;
                }else {
                    System.out.println("\n     Introduce un tipo de vehículo correcto (C/B/P/T)\n");
                }
            }
            tecla5 = false;

            System.out.print("     Fecha de activación (DD/MM/AA)? ");
            Date fecha = null;
            try {
                fecha = formato.parse(myOjb.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            info.setFechaActivacion(fecha);
            System.out.print("     Hora de activación (HH:MM)? ");

            Date hora = null;
            try {
                hora = formato1.parse(myOjb.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            info.setHoraActivacion(hora);

            System.out.println("                 Vehículos disponibles\n");
            System.out.println("Ref\tIdentificador\tTipo\tDistancia\tRumbo\n");
            ArrayList<Integer> arrayId = new ArrayList<>();
            for (Vehiculo listVehiculo : listVehiculos) {
                if (listVehiculo.getTipoDeVehiculo().equals(info.getTipoVehiculo())) {
                    arrayId.add(listVehiculo.getId());
                    info.setIdVehiculo(listVehiculo.getId());
                    System.out.println(arrayId.size() + "\t" + listVehiculo.getId() + "\t" + listVehiculo.getTipoDeVehiculo() + "\t   " + (info.getUbicacionClienteRadio()) + "\t  " + (info.getUbicacionClienteAngulo()));
                }
            }
            for (int h = 0; h < listVehiculos.size(); h++){
                if (arrayId.size() != 0){
                    System.out.print("\nRef. Vehiculo seleccionado? ");
                    idVehiculo = Integer.parseInt(myOjb.nextLine());
                    for (Vehiculo listVehiculo : listVehiculos) {
                        if (arrayId.size() >= idVehiculo) {
                            if (arrayId.get(idVehiculo - 1) == listVehiculo.getId()) {
                                System.out.println("\n          Datos del vehículo seleccionado\n");
                                System.out.println("Identificador: " + listVehiculo.getId() + "     Tipo: " + listVehiculo.getTipoDeVehiculo());
                                System.out.println("Descripción: " + listVehiculo.getDescripcion());
                                System.out.println("Distancia desde cliente: " + (listVehiculo.getRadio()));
                                System.out.println("Rumbo desde cliente: " + (listVehiculo.getAngulo()) + "\n");
                                System.out.print("Datos correctos (S/N)? ");
                                String opcion = myOjb.nextLine();
                                while (!tecla6) {
                                    if (opcion.equalsIgnoreCase("S")) {
                                        if (listInfo.size() == 0) {
                                            ActivarVehiculo activarVehiculo = new ActivarVehiculo();
                                            for (int k = 0; k < 31; k++) {
                                                listInfo.add(activarVehiculo);
                                            }
                                        }

                                        if (listInfo.size() != 0) {
                                            String dia = formatday.format(fecha);
                                            int day = Integer.parseInt(dia);
                                            listInfo.add(day, info);
                                        }
                                        listInfo.add(info);
                                        tecla = true;
                                        System.out.println("\nEl vehículo con Identificador: " + listVehiculo.getId() + ", ha sido ACTIVADO");
                                        System.out.println("Desde las " + formato1.format(info.getHoraActivacion()) + " horas del día " + formato.format(info.getFechaActivacion()) + "\n");
                                        tecla6 = true;
                                    }
                                    if (opcion.equalsIgnoreCase("N")) {
                                        System.out.println("\t");
                                        tecla6 = true;
                                    }
                                }
                                tecla6 = false;
                            } else {
                                System.out.println("\nLa Ref. seleccionada no existe\n");
                            }
                        } else {
                            System.out.println("\nLa Ref. seleccionada no existe\n");
                        }
                    }
                break;
                }else{
                    System.out.println("\n      No hay disponibles vehículos de tipo " + info.getTipoVehiculo() + ". Por favor, elija otro");
                }
            }
        }
    }

    public void devolverVehiculo(ArrayList<Vehiculo> listVehiculos){
        boolean tecla = false;
        boolean tecla2 = false;
        boolean tecla3 = false;
        boolean tecla4 = false;
        boolean tecla5 = false;
        int idVehiculo = 0;
        int idVehiculoArray = 0;

        while (!tecla){
            Scanner myOjb = new Scanner(System.in);
            System.out.println("\nDevolver vehículo:");
            while(!tecla2){
                System.out.print("     Identificador vehículo? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    int id = Integer.parseInt(num);
                    if (listInfo.size() != 0){
                        for (ActivarVehiculo activarVehiculo : listInfo) {
                            if (id == activarVehiculo.getIdVehiculo()) {
                                idVehiculo = id;
                                idVehiculoArray = idVehiculoArray + 1;
                                tecla2 = true;
                                break;
                            } else {
                                System.out.println("     El número de identificador que has introducido no existe. Elija otro.\n");
                            }
                        }
                    }
                }else{
                    System.out.println("\n     Introduzca un valor numérico\n");
                }
            }
            tecla2 = false;

            while(!tecla3){
                System.out.print("     Nueva Ubicación vehículo: Radio? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    int num2 = Integer.parseInt(num);
                    if (num2 < 10000){
                        listInfo.get(idVehiculoArray-1).setUbicacionVehiculoRadio(Integer.parseInt(num));
                        tecla3 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (10000 metros)\n");
                    }
                }else{
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla3 = false;

            while (!tecla4){
                System.out.print("     Nueva Ubicación vehículo: Ángulo? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    double num2 = Double.parseDouble(num);
                    if (num2 < 360.00){
                        listInfo.get(idVehiculoArray-1).setUbicacionVehiculoAngulo(num2);
                        tecla4 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (360.00 grados)\n");
                    }
                }else{
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla4 = false;

            while(!tecla5){
                System.out.print("     Tiempo de uso (en minutos)? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    listInfo.get(idVehiculoArray-1).setTiempoUso(Integer.parseInt(num));
                    tecla5 = true;
                } else{
                    System.out.println("\n     Por favor, introduce un dígito\n");
                }
            }
            tecla5 = false;
            for (Vehiculo listVehiculo : listVehiculos) {
                if (listVehiculo.id == idVehiculo) {
                    System.out.println("\n              Datos del Vehículo\n");
                    System.out.println("Identificador: " + listVehiculo.getId() + "     Tipo: " + listVehiculo.getTipoDeVehiculo());
                    System.out.println("Descripción: " + listVehiculo.getDescripcion());
                    System.out.println("Nueva Ubicación: Radio " + listInfo.get(idVehiculoArray - 1).getUbicacionVehiculoRadio());
                    System.out.println("Rumbo desde cliente: " + listInfo.get(idVehiculoArray - 1).getUbicacionVehiculoAngulo() + "\n");
                    break;
                }
            }

            System.out.print("Datos correctos (S/N)? ");
            String opcion = myOjb.nextLine();
            if (opcion.equalsIgnoreCase("S")){
                tecla = true;
                System.out.println("\nEl vehículo con Identificador: " + listInfo.get(idVehiculoArray-1).getIdVehiculo() + ", ha sido DEVUETO");
                System.out.println("Después de haber sido utilizado durante " + listInfo.get(idVehiculoArray-1).getTiempoUso() + " minutos" + "\n");
            }
            if (opcion.equalsIgnoreCase("N")){
                System.out.println("\t");
            }
        }
    }

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

    public ArrayList<ActivarVehiculo> mostrarInfo() {
        return listInfo;
    }
}
