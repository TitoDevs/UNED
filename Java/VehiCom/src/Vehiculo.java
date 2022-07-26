import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculo {
    public int id;
    public String tipoDeVehiculo;
    public String descripcion;
    public int radio;
    public double angulo;
    private final ArrayList<Vehiculo> listVehiculo = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeVehiculo() {
        return tipoDeVehiculo;
    }

    public void setTipoDeVehiculo(String tipoDeVehiculo) {
        this.tipoDeVehiculo = tipoDeVehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public void nuevoVehiculo(){
        boolean tecla = false;
        boolean tecla2 = false;
        boolean tecla3 = false;
        boolean tecla4 = false;
        boolean tecla5 = false;
        boolean tecla6 = false;
        boolean tecla7 = false;
        boolean tecla8 = false;

        while (!tecla){
            Vehiculo nuevoVehiculo = new Vehiculo();
            Scanner myOjb = new Scanner(System.in);
            System.out.println("\nAlta nuevo vehiculo:");
            while(!tecla2){
                System.out.print("     Identificador (número entre 1 y 20)? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    nuevoVehiculo.setId(Integer.parseInt(num));
                    if(nuevoVehiculo.getId() <= 20 && nuevoVehiculo.getId() > 0){
                        if (listVehiculo.size() != 0){
                            for (Vehiculo listVehiculo : listVehiculo) {
                                if (nuevoVehiculo.getId() == listVehiculo.getId()) {
                                    System.out.println("     El número de identificador que has introducido ya le corresponde a otro vehículo. Elija otro.\n");
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
                        System.out.println("\n     El valor introducido no se encuentra dentro de los límites (20)\n");
                    }
                }else {
                    System.out.println("\n     Introduzca un valor numérico\n");
                }
            }
            while(!tecla3){
                System.out.print("     Tipo de vehículo (C/B/P/T)? ");
                nuevoVehiculo.setTipoDeVehiculo(myOjb.nextLine());
                if (nuevoVehiculo.getTipoDeVehiculo().toUpperCase().equals("C") || nuevoVehiculo.getTipoDeVehiculo().toUpperCase().equals("B") || nuevoVehiculo.getTipoDeVehiculo().toUpperCase().equals("P") || nuevoVehiculo.getTipoDeVehiculo().toUpperCase().equals("T")){
                    tecla3 = true;
                }else {
                    System.out.println("\n     Introduce un tipo de vehículo correcto (C/B/P)\n");
                }
            }
            tecla3 = false;

            while (!tecla4){
                System.out.print("     Descripción (entre 1 y 20 caracteres)? ");
                nuevoVehiculo.setDescripcion(myOjb.nextLine());
                if (nuevoVehiculo.getDescripcion().length() < 20){
                    tecla4 = true;
                }else{
                    System.out.println("\n     La descripción introducida supera los 20 caracteres\n");
                }
            }
            tecla4 = false;

            while (!tecla5){
                System.out.print("     Radio (hasta 10000 metros)? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    int num2 = Integer.parseInt(num);
                    if (num2 < 10000){
                        nuevoVehiculo.setRadio(num2);
                        tecla5 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (10000 metros)\n");
                    }
                }else {
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla5 = false;

            while(!tecla6){
                System.out.print("     Ángulo (entre 0.00 y 360.00 grados)? ");
                String num = myOjb.nextLine();
                if (isNumeric(num)){
                    double num2 = Double.parseDouble(num);
                    if (num2 < 360.00){
                        nuevoVehiculo.setAngulo(num2);
                        tecla6 = true;
                    }else{
                        System.out.println("\n     El número introducido supera los límites establecidos (360.00 grados)\n");
                    }
                }else{
                    System.out.println("\n     Por favor, introduce un número\n");
                }
            }
            tecla6 = false;

            while (!tecla7){
                System.out.print("Datos correctos (S/N)? ");
                String opcion = myOjb.nextLine();
                if (opcion.toUpperCase().equals("S")){
                    while (!tecla8){
                        System.out.print("Otro vehículo (S/N)? ");
                        String opcion2 = myOjb.nextLine();
                        if (opcion2.toUpperCase().equals("S")){
                            System.out.println("");
                            listVehiculo.add(nuevoVehiculo);
                            tecla7 = true;
                            tecla8 = true;
                            tecla2 = false;
                        }
                        if (opcion2.toUpperCase().equals("N")){
                            listVehiculo.add(nuevoVehiculo);
                            tecla = true;
                            tecla2 = false;
                            tecla7 = true;
                            tecla8 = true;
                            System.out.println("");
                        }
                    }
                    tecla8 = false;
                }
                if (opcion.toUpperCase().equals("N")){
                    System.out.println("");
                    tecla2 = false;
                    tecla7 = true;
                }
            }
            tecla7 = false;
        }
    }

    public ArrayList<Vehiculo> mostrarVehiculo(){
        return listVehiculo;
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
}
