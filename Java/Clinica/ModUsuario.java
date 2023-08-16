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


/**
 * Mod Usuario es una clase que utilizaremos para modificar todos los usuarios del sistema.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class ModUsuario {
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
    
    public ModUsuario(Empleados empleados, Pacientes pacientes){
        //String para las listas
        String[] sexo = {"Hombre","Mujer"};
        String[] user = {"Paciente/a","Enfermero/a","Técnico/a","Administrativo/a"};
        Font fuente = new Font("Calibri", 1, 40);        
        //Creamos frame
        frame = new JFrame("Clínica 2.0");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.white);
        //Creamos panel
        JPanel panel1 = new JPanel();
        panel1.setSize(400,50);
        panel1.setVisible(true);
        frame.add(panel1);
        //Diseño
        titulo = new JLabel("Modificar usuario");
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
        panel.add(tfnombre);
        
        apellidos = new JLabel("Apellidos");
        apellidos.setBounds(85,190,80,30);
        panel.add(apellidos);
        
        tfapellidos = new JTextField();
        tfapellidos.setBounds(85,215,220,35);
        panel.add(tfapellidos);
        
        edad = new JLabel("Edad");
        edad.setBounds(85,255,80,30);
        panel.add(edad);
        
        tfedad = new JTextField();
        tfedad.setBounds(85,280,220,35);
        panel.add(tfedad);
        
        sex = new JLabel("Sexo");
        sex.setBounds(85,320,80,30);
        panel.add(sex);
        
        listaSexo = new JComboBox(sexo);
        listaSexo.setBounds(85,345,220,35);
        panel.add(listaSexo);
        
        usuario = new JLabel("Tipo de usuario");
        usuario.setBounds(85,385,120,30);
        panel.add(usuario);
        
        listaUsuario = new JComboBox(user);
        listaUsuario.setBounds(85,410,220,35);
        panel.add(listaUsuario);
        //Este boton sirve para que se rellene los textfield de la interfaz con los datos de
        //los usuarios
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(175,85,80,30);
        panel.add(buscar);
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Buscamos si existen empleados
                for(int i = 0; i <= empleados.numeroEmpleados; i++){
                    //String de textfield para luego utilizarlo y filtrar
                    String id = tfbuscar.getText().toString();
                    //Verificamos si enfermeros tiene menos tamaño que todos los empleados(obvio)
                    if(i < empleados.enfermeros.size()){
                        //String del ID de enfermeros para filtrar luego
                        String idenfermeros = empleados.enfermeros.get(i).getID();
                        //Si el id de enfermeros es igual al del textfield
                        if(idenfermeros.equals(id)){
                        //Rellenamos los textfield
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
                    //Comprobamos esta vez la lista de tecnicos
                    if(i< empleados.tecnicos.size()){
                        String idtecnicos = empleados.tecnicos.get(i).getID();
                        //Si id de tecnico es igual a id de textfield, rellenamos
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
                    //Comprobarmos de nuevo la lista de administradores
                    if(i< empleados.administradores.size()){
                        String idadministrativos = empleados.administradores.get(i).getID();
                        //Si id admin es igual al de textfield, rellenamos los textfield
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
                    //Compronbamos la lista de pacientes
                    if(i<pacientes.listPacientes.size()){
                        String idpacientes = pacientes.listPacientes.get(i).getID();
                        //Si id de pacientes es igual al de textfield, rellenamos
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
        //Ahora este boton es para modificar el usuario
        JButton bt_mod = new JButton("Modificar usuario");
        bt_mod.setBounds(95,500,200,40);
        bt_mod.setBackground(new Color(121,255,127));
        bt_mod.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                for(int j = 0; j < empleados.numeroEmpleados; j++){
                    if(j<empleados.enfermeros.size()){
                        String idenf = empleados.enfermeros.get(j).toString();
                        if(idUser.equals(idenf)){
                            String nombre = tfnombre.getText();
                            empleados.enfermeros.get(j).setNombre(nombre);
                            String apellidos = tfapellidos.getText();
                            empleados.enfermeros.get(j).setApellidos(apellidos);
                            int edad = Integer.parseInt(tfedad.getText());
                            empleados.enfermeros.get(j).setEdad(edad);
                            String sex = String.valueOf(listaSexo.getSelectedItem().toString());
                            empleados.enfermeros.get(j).setSexo(sex);
                        }
                    }
                    if(j<empleados.tecnicos.size()){
                        String idtec = empleados.tecnicos.get(j).toString();
                        if(idUser.equals(idtec)){
                            String nombre = tfnombre.getText();
                            empleados.tecnicos.get(j).setNombre(nombre);
                            String apellidos = tfapellidos.getText();
                            empleados.tecnicos.get(j).setApellidos(apellidos);
                            int edad = Integer.parseInt(tfedad.getText());
                            empleados.tecnicos.get(j).setEdad(edad);
                            String sex = String.valueOf(listaSexo.getSelectedItem().toString());
                            empleados.tecnicos.get(j).setSexo(sex);
                        }
                    }
                    if(j<empleados.enfermeros.size()){
                        String idadm = empleados.administradores.get(j).toString();
                        if(idUser.equals(idadm)){
                            String nombre = tfnombre.getText();
                            empleados.administradores.get(j).setNombre(nombre);
                            String apellidos = tfapellidos.getText();
                            empleados.administradores.get(j).setApellidos(apellidos);
                            int edad = Integer.parseInt(tfedad.getText());
                            empleados.administradores.get(j).setEdad(edad);
                            String sex = String.valueOf(listaSexo.getSelectedItem().toString());
                            empleados.administradores.get(j).setSexo(sex);
                        }
                    }
                    if(j<pacientes.listPacientes.size()){
                        String idpac = pacientes.listPacientes.get(j).toString();
                        if(idUser.equals(idpac)){
                            String nombre = tfnombre.getText();
                            pacientes.listPacientes.get(j).setNombre(nombre);
                            String apellidos = tfapellidos.getText();
                            pacientes.listPacientes.get(j).setApellidos(apellidos);
                            int edad = Integer.parseInt(tfedad.getText());
                            pacientes.listPacientes.get(j).setEdad(edad);
                            String sex = String.valueOf(listaSexo.getSelectedItem().toString());
                            pacientes.listPacientes.get(j).setSexo(sex);
                        }
                    }
                }
                JOptionPane.showMessageDialog(null,"Modificado correctamente");
                frame.setVisible(false);
                frame.dispose();
            }
        });
        panel.add(bt_mod);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}