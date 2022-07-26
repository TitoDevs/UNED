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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
/**
 * Prueba es la clase que utiliza los tecnicos para realizar las pruebas de los pacientes.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class Prueba{
    private int numeroUsuarios, numTF1, numPac1, n;
    private boolean bool;
    private JLabel idPac, idEnf, idTec, titulo, fecha, prueba;
    private JTextField tfidPac, tfidEnf, tfidTec, tffecha;
    private JFrame frame;
    private Enfermeros enfermero;
    private Tecnicos tecnico;
    private Administradores administrador;
    private Paciente paciente;
    private Personas persona;
    private JComboBox listaPruebas;
    private String idUser;
    private Calendar calendar1, calendar2, calendar3, calendar4;
    private JPanel panel1;
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scroll;
    private Date datePaciente;
    
    public Prueba(Empleados empleados, Pacientes pacientes){
        String[] prueb = {"Positivo", "Negativo"};
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
        
        titulo = new JLabel("Asignar resultado");
        titulo.setFont(fuente);
        titulo.setForeground(Color.black);
        panel1.add(titulo);
        
        JPanel panel = new JPanel();
        panel.setSize(400,600);
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);
        
        idPac = new JLabel("ID del paciente");
        idPac.setBounds(10,60,200,30);
        panel.add(idPac);
        
        tfidPac = new JTextField();
        tfidPac.setBounds(10,85,80,30);
        panel.add(tfidPac);
       
        idEnf = new JLabel("ID del técnico");
        idEnf.setBounds(120,60,200,30);
        panel.add(idEnf);
        
        tfidEnf = new JTextField();
        tfidEnf.setBounds(120,85,80,30);
        panel.add(tfidEnf);
        
        fecha = new JLabel("Fecha");
        fecha.setBounds(240,60,80,30);
        panel.add(fecha);
        
        tffecha = new JTextField();
        tffecha.setBounds(240,85,80,30);
        panel.add(tffecha);
        
        prueba = new JLabel("Seleccione");
        prueba.setBounds(340,60,80,30);
        panel.add(prueba);
        
        listaPruebas = new JComboBox(prueb);
        listaPruebas.setBounds(340,85,100,30);
        panel.add(listaPruebas);
        
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Prueba");
        //Lista pacientes
        Object[] column = new Object[model.getColumnCount()];
       
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            column[0] = pacientes.listPacientes.get(i).getID();
            column[1] = pacientes.listPacientes.get(i).getNombre();
            column[2] = pacientes.listPacientes.get(i).getApellidos();
            column[3] = pacientes.listPacientes.get(i).getPrueba();
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
        //Boton que asigna la prueba
        JButton bt_asignar = new JButton("Asignar");
        bt_asignar.setBounds(470,85,100,30);
        bt_asignar.setBackground(new Color(121,255,127));
        bt_asignar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Obtenemos los strings de cada jtextfield creado.
                String idPac = tfidPac.getText().toString();
                String idEnf = tfidEnf.getText().toString();
                String idFecha = tffecha.getText().toString();
                int pruebas = 0;
                
                if(tfidPac.getText().equals("") || tfidEnf.getText().equals("") || tffecha.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Rellene los campos");
                }else{
                    for(int i = 0; i < empleados.tecnicos.size(); i++){
                        for(int j = 0; j < empleados.tecnicos.get(i).listPacAsignados.size();j++){
                            if(empleados.tecnicos.get(i).listPacAsignados.get(j).getIdPaciente().equals(idPac)){
                                for(int k = 0; k < pacientes.listPacientes.size(); k++){
                                    if(pacientes.listPacientes.get(k).getID().equals(idPac)){
                                        //Despues de los parametros decidimos que resultado obtiene los pacientes según
                                        //la selección
                                        String prub = String.valueOf(listaPruebas.getSelectedItem().toString());
                                         DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                                         try{
                                             Date prueba = format.parse(idFecha);
                                             switch(prub){
                                                case "Positivo":
                                                    if(pacientes.listPacientes.get(k).getResultadoCovid() == false){
                                                        pacientes.listPacientes.get(k).setResultadoCovid(true);
                                                        Date date = format.parse(idFecha);
                                                        pacientes.listPacientes.get(k).setInicioConf(date);
                                                        Calendar calendar = Calendar.getInstance();
                                                        calendar.setTime(date);
                                                        calendar.add(Calendar.DAY_OF_YEAR, 10);
                                                        pacientes.listPacientes.get(k).setFinConf(calendar.getTime());
                                                    }else{
                                                        JOptionPane.showMessageDialog(null,"Ya tiene asignad un resultado");
                                                    }
                                                    break;
                                                case "Negativo":
                                                    if(pacientes.listPacientes.get(k).getResultadoCovid() == false){
                                                        pacientes.listPacientes.get(k).setResultadoCovid(false);
                                                    }else{
                                                        JOptionPane.showMessageDialog(null,"Ya tiene asignad un resultado");
                                                    }
                                                    break;
                                            }
                                         }
                                         catch (java.text.ParseException pe)
                                         {
                                             pe.printStackTrace();
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
