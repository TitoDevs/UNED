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
 * AsigTecnico es la clase donde vamos a asignar un tecnico a un paciente.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class AsigTecnico
{
    private int numeroUsuarios, numTF1, numPac1, n;
    private boolean bool;
    private JLabel idPac,idTec, titulo, fecha;
    private JTextField tfidPac, tfidTec, tffecha;
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
    
    public AsigTecnico(Empleados empleados, Pacientes pacientes){
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
        
        titulo = new JLabel("Asignar técnico");
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
       
        idTec = new JLabel("ID del técnico");
        idTec.setBounds(160,60,200,30);
        panel.add(idTec);
        
        tfidTec = new JTextField();
        tfidTec.setBounds(160,85,80,30);
        panel.add(tfidTec);
        
        fecha = new JLabel("Fecha");
        fecha.setBounds(300,60,200,30);
        panel.add(fecha);
        
        tffecha = new JTextField();
        tffecha.setBounds(300,85,80,30);
        panel.add(tffecha);
        //Creamos lista
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Sexo");
        
        //Lista de tecnicos
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.tecnicos.size(); i++){
            column[0] = empleados.tecnicos.get(i).getID();
            column[1] = empleados.tecnicos.get(i).getNombre();
            column[2] = empleados.tecnicos.get(i).getApellidos();
            column[3] = empleados.tecnicos.get(i).getSexo();
            model.addRow(column);
        }
        
        //Lista de pacientes
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
        
        //Boton para asignar tecnico
        //Practicamente hace lo mismo que la clase AsigEnfermero
        JButton bt_asignar = new JButton("Asignar");
        bt_asignar.setBounds(450,85,100,30);
        bt_asignar.setBackground(new Color(121,255,127));
        bt_asignar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Obtenemos los strings de cada jtextfield creado.
                String idPac = tfidPac.getText().toString();
                String idTec = tfidTec.getText().toString();
                String idFecha = tffecha.getText().toString();
                pruebas = 0;
                
                if(tfidPac.getText().equals("") || tfidTec.getText().equals("") || tffecha.getText().equals("")){
                    System.out.println("Rellena los campos");
                }else{
                    for(int i = 0; i < pacientes.listPacientes.size(); i++){
                        if(pacientes.listPacientes.get(i).getID().equals(idPac) && pacientes.listPacientes.get(i).getResultadoCovid() == false){
                            for(int j = 0; j < empleados.tecnicos.size(); j++){
                                if(empleados.tecnicos.get(j).getID().equals(idTec)){
                                    for(int k = 0; k < empleados.tecnicos.get(j).listPacAsignados.size(); k++){
                                        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                                        try{
                                            Date fechaTF = format.parse(idFecha);
                                            datePaciente = fechaTF;
                                            Date fechaPac= empleados.tecnicos.get(j).listPacAsignados.get(n).getDate();
                                            
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
                                            if(empleados.tecnicos.get(j).listPacAsignados.get(k).getIdPaciente().equals(idPac)){
                                                bool = true;
                                            }else{
                                                bool = false;
                                                pruebas++;
                                            }
                                        }catch (java.text.ParseException pe){
                                                pe.printStackTrace();
                                        }
                                    }
                                    if(pacientes.listPacientes.get(i).getTecAsignado() == null){
                                        if(pruebas == 4){
                                            JOptionPane.showMessageDialog(null,"Este tecnico tiene la semana seleccionada ocupada. Elija otro.");
                                        }else{
                                            if(numTF1==numPac1 && pruebas<4){
                                                if(bool == true){
                                                    JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                                }else{
                                                    PacientesAsignados pacAsi = new PacientesAsignados(datePaciente,idPac);
                                                    empleados.tecnicos.get(j).addPacientes(pacAsi);
                                                    pacientes.listPacientes.get(i).setTecAsignado(idTec);
                                                    JOptionPane.showMessageDialog(null,"Asignado correctamente");
                                                    frame.dispose();
                                                }
                                            }
                                            if(numTF1 != numPac1){
                                                if(bool == true){
                                                    JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                                }else{
                                                    PacientesAsignados pacAsi = new PacientesAsignados(datePaciente,idPac);
                                                    empleados.tecnicos.get(j).addPacientes(pacAsi);
                                                    pacientes.listPacientes.get(i).setTecAsignado(idTec);
                                                    JOptionPane.showMessageDialog(null,"Asignado correctamente");
                                                    frame.dispose();
                                                }
                                            }
                                        }
                                    }else{
                                        if(pruebas == 4){
                                        JOptionPane.showMessageDialog(null,"Este tecnico tiene la semana seleccionada ocupada. Elija otro.");
                                        }else{
                                            if(numTF1==numPac1 && pruebas<4){
                                                if(bool == true){
                                                    JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                                }else{
                                                    pacientes.listPacientes.get(i).setTecAsignado(idTec);
                                                    JOptionPane.showMessageDialog(null,"Asignado correctamente");
                                                    frame.dispose();
                                                }
                                            }
                                            if(numTF1 != numPac1){
                                                if(bool == true){
                                                    JOptionPane.showMessageDialog(null,"Ya está en la lista");
                                                }else{
                                                    pacientes.listPacientes.get(i).setTecAsignado(idTec);
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
            }
        });
        panel.add(bt_asignar);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
