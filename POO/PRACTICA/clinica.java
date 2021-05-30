import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Clinica es la clase principal donde se guarda toda la información del programa
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class clinica implements ActionListener{ 
    //Definimos
    private static JLabel userLabel, passwordLabel, success, image;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static ImageIcon icon;
    private static JFrame frame;
    private static Personas personas;
    private static PruebasDiagnosticas pruebasDiagnosticas;
    private static Empleados empleados;
    private static Pacientes pacientes;
    private static Vacunas vacuna;
    private static Paciente paciente1, paciente2, paciente3;
    private static Enfermeros enfermeros1, enfermeros2, enfermeros3;
    private static Tecnicos tecnicos1, tecnicos2, tecnicos3;
    private static Administradores administradores1, administradores2, administradores3;
    private static PacientesAsignados pacAsig1, pacAsig2, pacAsig3;
    
    public static void main(String[] args){
        //Incicializamos
        empleados = new Empleados();
        personas = new Personas();
        pacientes = new Pacientes();
        pruebasDiagnosticas = new PruebasDiagnosticas();
        vacuna = new Vacunas();
        
        //Creamos un panel
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        
        //Creamos el frame del panel
        frame = new JFrame();
        frame.setSize(800,500);
        frame.setTitle("Clinica 2.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        //Interfaz
        icon = new ImageIcon("src/ic_clinia.png");
        image = new JLabel(icon);
        image.setBounds(85,10,220,160);
        panel.add(image);
        
        panel.setLayout(null);
        panel.setBackground(Color.white);
        
        userLabel = new JLabel("Usuario");
        userLabel.setBounds(85,175,80,30);
        panel.add(userLabel);
        
        userText = new JTextField();
        userText.setBounds(85,200,220,35);
        panel.add(userText);
        
        passwordLabel = new JLabel("Contraseña");
        passwordLabel.setBounds(85,240,80,30);
        panel.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(85,265,220,35);
        panel.add(passwordText);
        
        button = new JButton("Iniciar sesión");
        button.setBounds(125,320,140,30);
        button.addActionListener(new clinica());
        panel.add(button);
        
        success = new JLabel("");
        success.setBounds(85,370,300,25);
        panel.add(success);
        
        panel1.setBounds(400,0,400,500);
        panel1.setBackground(new Color(249,73,73));
        
        JLabel jautor = new JLabel("Autor: Luis Daniel Guardado Garcia");
        jautor.setBounds(95, 440, 250, 10);
        panel.add(jautor);
        panel.add(panel1);
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        crearPersonas();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        //Este es el login para acceder al programa
        String user = userText.getText().toString();
        String password = passwordText.getText().toString();
       
        if(user.equals("Administrador") && password.equals("administrador")){
            success.setText("Login correcto para admin");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    AdminGUI gui = new AdminGUI(vacuna, personas, pruebasDiagnosticas, empleados, pacientes);
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
            
        }else if(user.equals("Enfermero") && password.equals("enfermero")){
            success.setText("Login correcto para enfermero");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    EnfermeroGUI gui = new EnfermeroGUI(personas, pruebasDiagnosticas, empleados, pacientes);
                    frame.setVisible(false);
                    frame.dispose();
                }
            });

        }else if(user.equals("Tecnico") && password.equals("tecnico")){
            success.setText("Login correcto para tecnico");
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    TecnicoGUI gui = new TecnicoGUI(personas, pruebasDiagnosticas, empleados, pacientes);
                    frame.setVisible(false);
                    frame.dispose();
                }
            });
        }else{
            success.setText("Error");
        }
    }
    
    private static void crearPersonas(){
        //Creamos pacientes y empleados con sus respectivas condiciones para que el programa se inicialice con ejemplos
        String id;
        String date = "20-01-2021";
        String date1 = "14-02-2021";
        String date2 = "01-03-2021";
        String date3 = "02-03-2021";
        String date4 = "04-03-2021";
        String date5 = "05-03-2021";
        String date6 = "07-03-2021";
        String date7 = "08-03-2021";
        String date8 = "21-03-2021";
        String pacEnf1 = "Enf1";
        String pacEnf2 = "Enf2";
        String pacEnf3 = "Enf3";
        String pacTec1 = "Tec1";
        String pacTec2 = "Tec2";
        String pacTec3 = "Tec3";
        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
        try
        {
            Date mydate = format.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek( Calendar.MONDAY);
            calendar.setMinimalDaysInFirstWeek( 4 );
            calendar.setTime(mydate);
            int numero = calendar.get(Calendar.WEEK_OF_MONTH);
            //Enfermeros
            enfermeros1 = new Enfermeros("Enf1", mydate, "Juan", "Garcia Sánchez", 34, "Hombre", "Enfermero/a");
            pacAsig1 = new PacientesAsignados(mydate, "Pac1");
            enfermeros1.addPacientes(pacAsig1);
            empleados.addEnfermeros(enfermeros1);
            
            Date mydate1 = format.parse(date);
            enfermeros2 = new Enfermeros("Enf2", mydate1, "Soraya", "Rodriguez López", 26, "Mujer", "Enfermero/a");
            pacAsig2 = new PacientesAsignados(mydate, "Pac2");
            enfermeros2.addPacientes(pacAsig2);
            empleados.addEnfermeros(enfermeros2);
            
            Date mydate2 = format.parse(date1);
            enfermeros3 = new Enfermeros("Enf3", mydate2, "Susana", "Cuenca Aparicio", 50, "Mujer", "Enfermero/a");
            pacAsig3 = new PacientesAsignados(mydate, "Pac3");
            enfermeros3.addPacientes(pacAsig3);
            empleados.addEnfermeros(enfermeros3);
            //Tecnicos
            Date mydate3 = format.parse(date2);
            tecnicos1 = new Tecnicos("Tec1",mydate3, "Francisco", "Gallardo Jaén", 65, "Hombre", "Técnico/a");
            tecnicos1.addPacientes(pacAsig1);
            empleados.addTecnicos(tecnicos1);
            
            Date mydate4 = format.parse(date3);
            tecnicos2 = new Tecnicos("Tec2", mydate4, "Daniel", "Guardado Garcia", 27, "Hombre", "Técnico/a");
            tecnicos2.addPacientes(pacAsig2);
            empleados.addTecnicos(tecnicos2);
            
            Date mydate5 = format.parse(date4);
            tecnicos3 = new Tecnicos("Tec3", mydate5, "Claudio", "Herrera Ruiz", 45, "Hombre", "Técnico/a");
            tecnicos3.addPacientes(pacAsig3);
            empleados.addTecnicos(tecnicos3);
            //Administradores
            Date mydate6 = format.parse(date5);
            administradores1 = new Administradores("Adm1", mydate6, "Rocio", "Romero Prieto", 36, "Mujer", "Administrador/a");
            empleados.addAdministradores(administradores1);
            
            Date mydate7 = format.parse(date6);
            administradores2 = new Administradores("Adm2", mydate7, "Rocio", "Garcia Roman", 22, "Mujer", "Administrador/a");
            empleados.addAdministradores(administradores2);
            
            Date mydate8 = format.parse(date6);
            administradores3 = new Administradores("Adm3", mydate8,  "Juan", "Romero Prieto", 35, "Hombre", "Administrador/a");
            empleados.addAdministradores(administradores3);
            //Pacientes
            Date mydate9 = format.parse(date6);
            paciente1 = new Paciente("Pac1", mydate9, "Cristina", "Sánchez Falcón", 56, "Mujer", "Paciente/a", true);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(mydate9);
            calendar1.add(Calendar.DAY_OF_YEAR, 10);
            paciente1.setInicioConf(mydate9);
            paciente1.setFinConf(calendar1.getTime());
            paciente1.setEnfAsignado(pacEnf1);
            Date datePrueba = format.parse("08-05-2021");
            paciente1.setFechaPrueba(datePrueba);
            paciente1.setTecAsignado(pacTec1);
            paciente1.setPrueba("Antígenos");
            paciente1.setProxPrueba("Antígenos");
            pacientes.addPacientes(paciente1);
            
            Date mydate10 = format.parse(date7);
            paciente2 = new Paciente("Pac2", mydate10, "Susana", "Sánchez Falcón", 56, "Mujer", "Paciente/a", true);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(mydate10);
            calendar2.add(Calendar.DAY_OF_YEAR, 10);
            paciente2.setInicioConf(mydate10);
            paciente2.setFinConf(calendar2.getTime());
            paciente2.setEnfAsignado(pacEnf2);
            Date datePrueba1 = format.parse("08-05-2021");
            paciente2.setFechaPrueba(datePrueba1);
            paciente2.setTecAsignado(pacTec2);
            paciente2.setPrueba("Antígenos");
            paciente2.setProxPrueba("Antígenos");
            pacientes.addPacientes(paciente2);
            
            Date mydate11 = format.parse(date7);
            paciente3 = new Paciente("Pac3", mydate11, "Eustaquio", "Ávila Román", 56, "Hombre", "Paciente/a", true);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(mydate11);
            calendar3.add(Calendar.DAY_OF_YEAR, 10);
            paciente3.setInicioConf(mydate11);
            paciente3.setFinConf(calendar3.getTime());
            paciente3.setEnfAsignado(pacEnf3);
            Date datePrueba2 = format.parse("08-05-2021");
            paciente3.setFechaPrueba(datePrueba2);
            paciente3.setTecAsignado(pacTec3);
            paciente3.setPrueba("Antígenos");
            paciente3.setProxPrueba("Serológicos");
            pacientes.addPacientes(paciente3);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
    }
}
