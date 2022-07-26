import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

/**
 * EliminarUsuario es la clase que vamos a utilizar para eliminar los usuarios.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElimUsuario
{
    //definimos variables
    private int numeroUsuarios;
    private JLabel nombre, apellidos, edad, titulo, sex, usuario, buscar;
    private JTextField tfnombre, tfapellidos, tfedad, tfbuscar;
    private JFrame frame;
    private Enfermeros enfermero;
    private Tecnicos tecnico;
    private Administradores administrador;
    private Paciente paciente;
    private Personas persona;
    private JComboBox listaUsuario, listaSexo;
    private String idUser;
    
    public ElimUsuario(Empleados empleados, Pacientes pacientes){
        //String para las listas
        String[] sexo = {"Hombre","Mujer"};
        String[] user = {"Paciente/a","Enfermero/a","Técnico/a","Administrativo/a"};
        Font fuente = new Font("Calibri", 1, 40);        
        //Interfaz
        frame = new JFrame("Clínica 2.0");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.white);
        
        JPanel panel1 = new JPanel();
        panel1.setSize(400,50);
        panel1.setVisible(true);
        frame.add(panel1);
        
        titulo = new JLabel("Eliminar usuario");
        titulo.setFont(fuente);
        titulo.setForeground(Color.black);
        panel1.add(titulo);
        
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);
        
        buscar = new JLabel("Buscar ID");
        buscar.setBounds(85,60,80,30);
        panel.add(buscar);
        
        tfbuscar = new JTextField();
        tfbuscar.setBounds(85,85,80,30);
        panel.add(tfbuscar);
       
        nombre = new JLabel("Nombre");
        nombre.setBounds(85,125,80,30);
        panel.add(nombre);
        
        tfnombre = new JTextField();
        tfnombre.setBounds(85,150,220,35);
        tfnombre.setEditable(false);
        panel.add(tfnombre);
        
        apellidos = new JLabel("Apellidos");
        apellidos.setBounds(85,190,80,30);
        panel.add(apellidos);
        
        tfapellidos = new JTextField();
        tfapellidos.setBounds(85,215,220,35);
        tfapellidos.setEditable(false);
        panel.add(tfapellidos);
        
        edad = new JLabel("Edad");
        edad.setBounds(85,255,80,30);
        panel.add(edad);
        
        tfedad = new JTextField();
        tfedad.setBounds(85,280,220,35);
        tfedad.setEditable(false);
        panel.add(tfedad);
        
        sex = new JLabel("Sexo");
        sex.setBounds(85,320,80,30);
        panel.add(sex);
        
        listaSexo = new JComboBox(sexo);
        listaSexo.setBounds(85,345,220,35);
        listaSexo.setEditable(false);
        panel.add(listaSexo);
        
        usuario = new JLabel("Tipo de usuario");
        usuario.setBounds(85,385,120,30);
        panel.add(usuario);
        
        listaUsuario = new JComboBox(user);
        listaUsuario.setBounds(85,410,220,35);
        listaUsuario.setEditable(false);
        panel.add(listaUsuario);
        //Boton que rellena los textfield con los datos del paciente
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(175,85,80,30);
        panel.add(buscar);
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i <= empleados.numeroEmpleados; i++){
                    String id = tfbuscar.getText().toString();
                    if(i < empleados.enfermeros.size()){
                        String idenfermeros = empleados.enfermeros.get(i).getID();
                        if(idenfermeros.equals(id)){
                            String nombre = empleados.enfermeros.get(i).getNombre();
                            tfnombre.setText(nombre);
                            String apellidos = empleados.enfermeros.get(i).getApellidos();
                            tfapellidos.setText(apellidos);
                            String edad = String.valueOf(empleados.enfermeros.get(i).getEdad());
                            tfedad.setText(edad);
                            String sexo = empleados.enfermeros.get(i).getSexo();
                            listaSexo.setSelectedItem(sexo);
                            String usuario = empleados.enfermeros.get(i).getUsuario();
                            listaUsuario.setSelectedItem(usuario);
                            idUser = String.valueOf(empleados.enfermeros.get(i));
                            break;
                        }
                    }
                    
                    if(i< empleados.tecnicos.size()){
                        String idtecnicos = empleados.tecnicos.get(i).getID();
                        if(idtecnicos.equals(id)){
                            String nombre = empleados.tecnicos.get(i).getNombre();
                            tfnombre.setText(nombre);
                            String apellidos = empleados.tecnicos.get(i).getApellidos();
                            tfapellidos.setText(apellidos);
                            String edad = String.valueOf(empleados.tecnicos.get(i).getEdad());
                            tfedad.setText(edad);
                            String sexo = empleados.tecnicos.get(i).getSexo();
                            listaSexo.setSelectedItem(sexo);
                            String usuario = empleados.tecnicos.get(i).getUsuario();
                            listaUsuario.setSelectedItem(usuario);
                            idUser = String.valueOf(empleados.tecnicos.get(i));
                            break;
                        }
                    }
            
                    if(i< empleados.administradores.size()){
                        String idadministrativos = empleados.administradores.get(i).getID();
                        
                        if(idadministrativos.equals(id)){
                            String nombre = empleados.administradores.get(i).getNombre();
                            tfnombre.setText(nombre);
                            String apellidos = empleados.administradores.get(i).getApellidos();
                            tfapellidos.setText(apellidos);
                            String edad = String.valueOf(empleados.administradores.get(i).getEdad());
                            tfedad.setText(edad);
                            String sexo = empleados.administradores.get(i).getSexo();
                            listaSexo.setSelectedItem(sexo);
                            String usuario = empleados.administradores.get(i).getUsuario();
                            listaUsuario.setSelectedItem(usuario);
                            idUser = String.valueOf(empleados.administradores.get(i));
                            break;
                        }
                    }
                    if(i<pacientes.listPacientes.size()){
                        String idpacientes = pacientes.listPacientes.get(i).getID();
                        if(idpacientes.equals(id)){
                            String nombre = pacientes.listPacientes.get(i).getNombre();
                            tfnombre.setText(nombre);
                            String apellidos = pacientes.listPacientes.get(i).getApellidos();
                            tfapellidos.setText(apellidos);
                            String edad = String.valueOf(pacientes.listPacientes.get(i).getEdad());
                            tfedad.setText(edad);
                            String sexo = pacientes.listPacientes.get(i).getSexo();
                            listaSexo.setSelectedItem(sexo);
                            String usuario = pacientes.listPacientes.get(i).getUsuario();
                            listaUsuario.setSelectedItem(usuario);
                            idUser = String.valueOf(pacientes.listPacientes.get(i));
                            break;
                        }
                    }
                }
            }
        });
        //Boton que elimina el usuario
        JButton bt_baja = new JButton("Eliminar usuario");
        bt_baja.setBounds(95,500,200,40);
        bt_baja.setBackground(new Color(121,255,127));
        bt_baja.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int j = 0; j < empleados.numeroEmpleados; j++){
                    if(j<empleados.enfermeros.size()){
                        String idenf = empleados.enfermeros.get(j).toString();
                        if(idUser.equals(idenf)){
                        empleados.enfermeros.remove(j);
                        }
                    }
                    if(j<empleados.tecnicos.size()){
                        String idtec = empleados.tecnicos.get(j).toString();
                        if(idUser.equals(idtec)){
                        empleados.tecnicos.remove(j);
                        }
                    }
                    if(j<empleados.administradores.size()){
                        String idadm = empleados.administradores.get(j).toString();
                        if(idUser.equals(idadm)){
                        empleados.administradores.remove(j);
                        }
                    }
                    if(j<pacientes.listPacientes.size()){
                        String idpac = pacientes.listPacientes.get(j).toString();
                        if(idUser.equals(idpac)){
                        pacientes.listPacientes.remove(j);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,"Eliminado correctamente");
                frame.setVisible(false);
                frame.dispose();
            }
        });
        panel.add(bt_baja);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
