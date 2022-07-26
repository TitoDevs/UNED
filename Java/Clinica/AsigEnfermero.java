import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * Write a description of class AsigPaciente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsigEnfermero
{
   // instance variables - replace the example below with your own
    private int numeroUsuarios, numTF1, numPac1, n;
    private boolean bool;
    private JLabel idPac, idEnf, idTec, titulo, fecha;
    private JTextField tfidPac, tfidEnf, tfidTec, tffecha;
    private JFrame frame;
    private Enfermeros enfermero;
    private Tecnicos tecnico;
    private Administradores administrador;
    private Paciente paciente;
    private Personas persona;
    private JComboBox listaUsuario, listaSexo;
    private String idUser;
    private Calendar calendar1, calendar2, calendar3, calendar4;
    private JPanel panel1;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scroll;
    private Date datePaciente;
    private int pruebas;
    
    public AsigEnfermero(Empleados empleados, Pacientes pacientes){
        String[] sexo = {"Hombre","Mujer"};
        Font fuente = new Font("Calibri", 1, 40);        
        //Interfaz  
        frame = new JFrame("Clínica 2.0");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBackground(Color.white);
        
        JPanel panel1 = new JPanel();
        panel1.setSize(600,50);
        panel1.setVisible(true);
        frame.add(panel1);
        
        titulo = new JLabel("Asignar enfermero");
        titulo.setFont(fuente);
        titulo.setForeground(Color.black);
        panel1.add(titulo);
        
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);
        
        idPac = new JLabel("ID del paciente");
        idPac.setBounds(25,60,200,30);
        panel.add(idPac);
        
        tfidPac = new JTextField();
        tfidPac.setBounds(25,85,80,30);
        panel.add(tfidPac);
       
        idEnf = new JLabel("ID del enfermero");
        idEnf.setBounds(160,60,200,30);
        panel.add(idEnf);
        
        tfidEnf = new JTextField();
        tfidEnf.setBounds(160,85,80,30);
        panel.add(tfidEnf);
        
        fecha = new JLabel("Fecha");
        fecha.setBounds(300,60,200,30);
        panel.add(fecha);
        
        tffecha = new JTextField();
        tffecha.setBounds(300,85,80,30);
        panel.add(tffecha);
        
        //crear tabla
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Sexo");
        
        //Lista de enfermeros y pacientes con los datos que veo oportuno
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.enfermeros.size(); i++){
            column[0] = empleados.enfermeros.get(i).getID();
            column[1] = empleados.enfermeros.get(i).getNombre();
            column[2] = empleados.enfermeros.get(i).getApellidos();
            column[3] = empleados.enfermeros.get(i).getSexo();
            model.addRow(column);
        }
        
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            column[0] = pacientes.listPacientes.get(i).getID();
            column[1] = pacientes.listPacientes.get(i).getNombre();
            column[2] = pacientes.listPacientes.get(i).getApellidos();
            column[3] = pacientes.listPacientes.get(i).getSexo();
            model.addRow(column);
        }
        
        table = new JTable(model);
        table.setBounds(10,160,560,180);
        
        scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setBounds(10,160,560,180);
        panel.add(scroll);
        panel.setVisible(true);
        panel.repaint();
        panel.revalidate();
        
        //Boton para asignar el enfermero
        JButton bt_asignar = new JButton("Asignar");
        bt_asignar.setBounds(450,85,100,30);
        bt_asignar.setBackground(new Color(121,255,127));
        bt_asignar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Obtenemos los strings de cada jtextfield creado.
                String idPac = tfidPac.getText().toString();
                String idEnf = tfidEnf.getText().toString();
                String idFecha = tffecha.getText().toString();
                pruebas = 0;
                //Verificamos que todos los campos esten rellenos
                if(tfidPac.getText().equals("") || tfidEnf.getText().equals("") || tffecha.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Rellene los campos");
                }else{
                    //Comprobamos el tamaño de la lista de pacientes
                    for(int i = 0; i < pacientes.listPacientes.size(); i++){
                        //Si el id de algun pacientes es igual que el textfield y si el paciente es negativo
                        if(pacientes.listPacientes.get(i).getID().equals(idPac) && pacientes.listPacientes.get(i).getResultadoCovid() == false){
                            for(int j = 0; j < empleados.enfermeros.size(); j++){
                                //si el id del paciente que tiene asignado el enfermero es igual al del textfield
                                if(empleados.enfermeros.get(j).getID().equals(idEnf)){
                                    for(int k = 0; k < empleados.enfermeros.get(j).listPacAsignados.size(); k++){
                                        //Se comprueba que la semana del año que contiene la fecha del textfield
                                        //Luego la comparamos con todas las que tiene el enfermero y si supera 5,
                                        //tiene que elegir otro enfermero o cambiar de semana.
                                        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                                        try{
                                            Date fechaTF = format.parse(idFecha);
                                            datePaciente = fechaTF;
                                            Date fechaPac= empleados.enfermeros.get(j).listPacAsignados.get(n).getDate();
                                            
                                            calendar1 = Calendar.getInstance();
                                            calendar1.setFirstDayOfWeek(Calendar.MONDAY);
                                            calendar1.setMinimalDaysInFirstWeek( 4 );
                                            calendar1.setTime(fechaTF);
                                            int numTF = calendar1.get(Calendar.WEEK_OF_YEAR);
                                            numTF1 = numTF;
                                            calendar2 = Calendar.getInstance();
                                            calendar2.setFirstDayOfWeek(Calendar.MONDAY);
                                            calendar2.setMinimalDaysInFirstWeek( 4 );
                                            calendar2.setTime(fechaPac);
                                            int numPac = calendar2.get(Calendar.WEEK_OF_YEAR);
                                            numPac1 = numPac;
                                            //comprobamos si el id del pacientes es igual al del textfield
                                            if(empleados.enfermeros.get(j).listPacAsignados.get(k).getIdPaciente().equals(idPac)){
                                                //creamos un booleano para comprobarlo
                                                bool = true;
                                            }else{
                                                //si es falso se añade al entero 1 
                                                bool = false;
                                                pruebas++;
                                            }
                                        }catch (java.text.ParseException pe){
                                                pe.printStackTrace();
                                        }
                                    }
                                    //Aqui se asigna los pacientes a los enfermeros con ciertas limitaciones
                                    if(pruebas == 5){
                                        JOptionPane.showMessageDialog(null,"Este enfermero tiene la semana seleccionada ocupada. Elija otro.");
                                    }else{
                                        if(numTF1==numPac1 && pruebas<5){
                                            if(bool == true){
                                                JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                            }else{
                                                PacientesAsignados pacAsi = new PacientesAsignados(datePaciente,idPac);
                                                empleados.enfermeros.get(j).addPacientes(pacAsi);
                                                pacientes.listPacientes.get(i).setEnfAsignado(idEnf);
                                                JOptionPane.showMessageDialog(null,"Asignado correctamente");
                                                frame.dispose();
                                            }
                                        }
                                        if(numTF1 != numPac1){
                                            if(bool == true){
                                                JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                            }else{
                                                PacientesAsignados pacAsi = new PacientesAsignados(datePaciente,idPac);
                                                empleados.enfermeros.get(j).addPacientes(pacAsi);
                                                pacientes.listPacientes.get(i).setEnfAsignado(idEnf);
                                                JOptionPane.showMessageDialog(null,"Asignado correctamente");
                                                frame.dispose();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
        panel.add(bt_asignar);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
