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
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;

/**
 * Alta Usuario es la clase que utilizaremos para hacer los usuarios.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class AltaUsuario {
    //Definimos
    public int numeroUsuarios;
    public JLabel fecha, nombre, apellidos, edad, titulo, sex, usuario;
    public JTextField tfnombre, tfapellidos, tfedad;
    public JFormattedTextField tffecha;
    public JFrame frame;
    public Enfermeros enfermero;
    public Tecnicos tecnico;
    public Calendar calendar;
    public Administradores administrador;
    public Paciente paciente;
    public Personas persona;
    public JComboBox listaUsuario, listaSexo;
    
    public AltaUsuario(Empleados empleados, Pacientes pacientes){
        //String para las listas
        String[] sexo = {"Hombre","Mujer"};
        String[] user = {"Paciente/a","Enfermero/a","Técnico/a","Administrativo/a"};
        Font fuente = new Font("Calibri", 1, 40);        

        frame = new JFrame("Clínica 2.0");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.white);
        
        JPanel panel1 = new JPanel();
        panel1.setSize(400,50);
        panel1.setVisible(true);
        frame.add(panel1);
        //Interfaz
        titulo = new JLabel("Nuevo usuario");
        titulo.setFont(fuente);
        titulo.setForeground(Color.black);
        panel1.add(titulo);
        
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);
        
        fecha = new JLabel("Fecha");
        fecha.setBounds(85,70,80,30);
        panel.add(fecha);
        
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tffecha = new JFormattedTextField(format);
        tffecha.setColumns(10);
        tffecha.setBounds(85,95,220,35);
        panel.add(tffecha);
        
        nombre = new JLabel("Nombre");
        nombre.setBounds(85,135,80,30);
        panel.add(nombre);
        
        tfnombre = new JTextField();
        tfnombre.setBounds(85,160,220,35);
        panel.add(tfnombre);
        
        apellidos = new JLabel("Apellidos");
        apellidos.setBounds(85,200,80,30);
        panel.add(apellidos);
        
        tfapellidos = new JTextField();
        tfapellidos.setBounds(85,225,220,35);
        panel.add(tfapellidos);
        
        edad = new JLabel("Edad");
        edad.setBounds(85,265,80,30);
        panel.add(edad);
        
        tfedad = new JTextField();
        tfedad.setBounds(85,290,220,35);
        panel.add(tfedad);
        
        sex = new JLabel("Sexo");
        sex.setBounds(85,330,80,30);
        panel.add(sex);
        
        listaSexo = new JComboBox(sexo);
        listaSexo.setBounds(85,355,220,35);
        panel.add(listaSexo);
        
        usuario = new JLabel("Tipo de usuario");
        usuario.setBounds(85,395,120,30);
        panel.add(usuario);
        
        listaUsuario = new JComboBox(user);
        listaUsuario.setBounds(85,420,220,35);
        panel.add(listaUsuario);
        //Boton de alta
        JButton bt_alta = new JButton("Alta usuario");
        bt_alta.setBounds(95,500,200,40);
        bt_alta.setBackground(new Color(121,255,127));
        bt_alta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                eleccion(empleados, pacientes);
                frame.setVisible(false);
                JOptionPane.showMessageDialog(null,"Dado de alta correctamente");
                frame.dispose();
            }
        });
        panel.add(bt_alta);
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
    //Al tener una lista desplegable utilizaremos un switch para no ir con if-else
    public void eleccion(Empleados empleados, Pacientes pacientes){
        String person = String.valueOf(listaUsuario.getSelectedItem().toString());
        switch(person){
            case "Enfermero/a":
                añadirEnfermero(empleados, enfermero);
                break;
            case "Técnico/a":
                añadirTecnico(empleados, tecnico);
                break;
            case "Paciente/a":
                añadirPaciente(pacientes, paciente);
                break;
            case "Administrativo/a":
                añadirAdministrativo(empleados, administrador);
                break;
        }
    }
    //Aqui implantaremos la funcionalidad de añadir un enfermero si se ha elegido en la lista
    public void añadirEnfermero(Empleados empleados, Enfermeros enfermeros){
        int tamaño = empleados.numeroEnfermeros + 1;
        String ID = "Enf"+tamaño;
        String name = tfnombre.getText().toString();
        String surname = tfapellidos.getText().toString();
        int edad = Integer.parseInt(tfedad.getText());
        String sex = String.valueOf(listaSexo.getSelectedItem().toString());
        String usuario = String.valueOf(listaUsuario.getSelectedItem().toString());
        String date = tffecha.getText().toString();
        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
        try
        {
            Date mydate = format.parse(date);
            enfermero = new Enfermeros(ID, mydate, name, surname, edad, sex, usuario);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
        empleados.addEnfermeros(enfermero);    
    }
    //Aqui implantaremos la funcionalidad de añadir un tecinco si se ha elegido en la lista
    public void añadirTecnico(Empleados empleados, Tecnicos tecnicos){
        int tamaño = empleados.numeroTecnicos + 1;
        String ID = "Tec"+tamaño;
        String name = tfnombre.getText().toString();
        String surname = tfapellidos.getText().toString(); 
        int edad = Integer.parseInt(tfedad.getText());
        String sex = String.valueOf(listaSexo.getSelectedItem().toString());
        String usuario = String.valueOf(listaUsuario.getSelectedItem().toString());
        String date = tffecha.getText().toString();
        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
        try
        {
            Date mydate = format.parse(date);
            tecnico = new Tecnicos(ID, mydate, name, surname, edad, sex, usuario);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
        empleados.addTecnicos(tecnico);
    }
    //Aqui implantaremos la funcionalidad de añadir un administrativo si se ha elegido en la lista
    public void añadirAdministrativo(Empleados empleados, Administradores administrador){
        int tamaño = empleados.numeroAdministradores + 1;
        String ID = "Adm"+tamaño;
        String name = tfnombre.getText().toString();
        String surname = tfapellidos.getText().toString(); 
        int edad = Integer.parseInt(tfedad.getText());
        String sex = String.valueOf(listaSexo.getSelectedItem().toString());
        String usuario = String.valueOf(listaUsuario.getSelectedItem().toString());
        String date = tffecha.getText().toString();
        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
        try
        {
            Date mydate = format.parse(date);
            administrador = new Administradores(ID, mydate, name, surname, edad, sex, usuario);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
        empleados.addAdministradores(administrador);
    }
    //Aqui implantaremos la funcionalidad de añadir un paciente si se ha elegido en la lista
    public void añadirPaciente(Pacientes pacientes, Paciente paciente){
        int tamaño = pacientes.numeroPacientes + 1;
        String ID = "Pac"+tamaño;
        String name = tfnombre.getText().toString();
        String surname = tfapellidos.getText().toString(); 
        int edad = Integer.parseInt(tfedad.getText());
        String sex = String.valueOf(listaSexo.getSelectedItem().toString());
        String usuario = String.valueOf(listaUsuario.getSelectedItem().toString());
        boolean resultado = false;
        String date = tffecha.getText().toString();
        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
        try
        {
            Date mydate = format.parse(date);
            paciente = new Paciente(ID, mydate, name, surname, edad, sex, usuario, resultado);
        }
        catch (java.text.ParseException pe)
        {
            pe.printStackTrace();
        }
        pacientes.addPacientes(paciente);
    }   
}
