import java.util.Scanner;

public class Menu {

    Cliente cliente = new Cliente();
    Vehiculo vehiculo = new Vehiculo();
    ActivarVehiculo info = new ActivarVehiculo();

    public void menu(){
        boolean tecla = false;
        while (!tecla){
            //Scanner para leer la entrada del usuario.
            Scanner myOjb = new Scanner(System.in);
            System.out.println("VehiCom: Gestión de Vehículos Compartidos");
            System.out.println("      Alta nuevo cliente               (Pulsar C)");
            System.out.println("      Alta nuevo vehículo              (Pulsar V)");
            System.out.println("      Activar vehículo                 (Pulsar A)");
            System.out.println("      Devolver vehículo                (Pulsar D)");
            System.out.println("      Resumen mensual                  (Pulsar R)");
            System.out.println("      Salir                            (Pulsar S)");
            System.out.print("Teclear una opción válida (C|V|A|D|R|S)? ");

            //Leemos la entrada se la asignamos al string.
            String letra = myOjb.nextLine();

            //Opciones del menú.
            switch (letra.toUpperCase()) {
                case "C" -> nuevoCliente();
                case "V" -> nuevoVehiculo();
                case "A" -> activarVehiculo();
                case "D" -> devolverVehiculo();
                case "R" -> resumenMensual();
                case "S" -> tecla = true;
                default -> System.out.println("La letra introducida no esta asignada en este menú");
            }
        }
    }
    public void nuevoCliente(){
        cliente.nuevoCliente();
    }

    public void nuevoVehiculo(){
        vehiculo.nuevoVehiculo();
    }

    public void activarVehiculo(){
        info.activarVehiculo(cliente.mostrarCliente(), vehiculo.mostrarVehiculo());
    }

    public void devolverVehiculo(){
        info.devolverVehiculo(vehiculo.mostrarVehiculo());
    }

    public void resumenMensual(){
        cliente.resumenMensual(cliente.mostrarCliente(), info.mostrarInfo());
    }

    public static void main(String[] args){
        Menu menu = new Menu();
        menu.menu();
    }
}