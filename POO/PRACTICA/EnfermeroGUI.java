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
/**
 * Write a description of class Enfermero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnfermeroGUI
{
    private JLabel userLabel, passwordLabel, success, image, profile, background;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton button, button1, button2, button3, button4,
    button5, button6, button7;
    private ImageIcon icon, ic_profile, ic_background;
    private JPanel panel1;
    private DefaultTableModel model, model1;
    private JTable table, table1;
    private JScrollPane scroll, scroll1;
    private JTableHeader header;
    private String [] head = {"ID", "Nombre"};
    private Vacunas vacuna;

    public EnfermeroGUI(Personas personas, PruebasDiagnosticas pruebasDiagnosticas, Empleados empleados,
    Pacientes pacientes){
        JPanel panel = new JPanel();
        panel1 = new JPanel();
        JFrame frame = new JFrame("Clínica 2.0");
        frame.setSize(900,622);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setBackground(Color.white);
        //Interfaz
        makeMenuBar(frame, personas, pruebasDiagnosticas, empleados, pacientes);
        
        icon = new ImageIcon("src/ic_clinia.png");
        image = new JLabel(icon);
        
        ic_profile = new ImageIcon("src/ic_person.png");
        profile = new JLabel(ic_profile);
        profile.setBounds(18,18,164,164);
        panel.add(profile);
        
        ic_background = new ImageIcon("src/ic_background.png");
        background = new JLabel(ic_background);
        background.setBounds(0,0,680,622);
        panel1.add(background);
        
        Font ftitle = new Font("Calibri", 1, 20);
        JLabel title = new JLabel("Enfermero");
        title.setBounds(57,200,200,40);
        title.setFont(ftitle);
        panel.add(title);
        
        frame.setIconImage(icon.getImage());
        panel.setLayout(null);
        panel.setBounds(0,0,200,560);
        panel.setBackground(new Color(249,73,73));
        
        panel1.setLayout(null);
        panel1.setBounds(200,0,700,622);
        panel1.setVisible(true);
        panel.add(panel1);
        
        button = new JButton("Listado pacientes");
        button.setBounds(0,240,200,40);
        button.setBackground(new Color(251,132,132));
        panel.add(button);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listadoPacientes(empleados, pacientes);
            }
        });
        
        button1 = new JButton("Registro de pruebas");
        button1.setBounds(0,280,200,40);
        button1.setBackground(new Color(251,132,132));
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                registroPruebas(empleados, pacientes);
            }
        });

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
      
    public void makeMenuBar(JFrame frame, Personas personas, PruebasDiagnosticas pruebasDiagnosticas, Empleados empleados, Pacientes pacientes)
    {
        final int SHORTCUT_MASK =
        Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // Crea el menú Archivo
        menu = new JMenu("Archivo");
        menubar.add(menu);
        
        // Crea el submenú Cambiar a administrador
        item = new JMenuItem("Cambiar a administrador");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, SHORTCUT_MASK));
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
            AdminGUI admin = new AdminGUI(vacuna, personas,pruebasDiagnosticas,empleados,pacientes);
            frame.dispose();
            }
        });
        menu.add(item);
        
        // Crea el submenú Cambiar a técnico
        item = new JMenuItem("Cambiar a técnico");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, SHORTCUT_MASK));
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TecnicoGUI admin = new TecnicoGUI(personas,pruebasDiagnosticas,empleados,pacientes);
                frame.dispose();
            }
        });
        menu.add(item);
        
        // Crea el submenú Cerrar Programa
        item = new JMenuItem("Cerrar programa");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        menu.add(item);
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    //Listado de pacientes
    public void listadoPacientes(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelGestion = new JPanel();
        panelGestion.setLayout(null);
        panelGestion.setBounds(0,0,700,622);
        panelGestion.setBackground(Color.white);
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Listado de pacientes");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelGestion.add(tf_titulo);
        
        JLabel jbuscar = new JLabel("Filtrar por ID");
        jbuscar.setBounds(10,110,80,30);
        panelGestion.add(jbuscar);
        
        JTextField tfbuscar = new JTextField();
        tfbuscar.setBounds(10,135,80,30);
        panelGestion.add(tfbuscar);

        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Visualización de datos de los pacientes asignados");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelGestion.add(tf_subtitulo);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Inicio Conf");
        model.addColumn("Fin Conf");
        model.addColumn("Prox Prueba");
        model.addColumn("Fecha Prueba");
        
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(100,135,105,30);
        panelGestion.add(buscar);
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                String idEnf = tfbuscar.getText().toString();
                
                Object[] column = new Object[model.getColumnCount()];
                model.setRowCount(0);
                if(idEnf != ""){
                    for(int i = 0; i < empleados.enfermeros.size(); i++){
                        if(idEnf.equals(empleados.enfermeros.get(i).getID())){
                            for(int j = 0; j < empleados.enfermeros.get(i).listPacAsignados.size();j++){
                                for(int k = 0; k < pacientes.listPacientes.size(); k++){
                                    if(empleados.enfermeros.get(i).listPacAsignados.get(j).getIdPaciente().equals(pacientes.listPacientes.get(k).getID())){
                                        column[0] = pacientes.listPacientes.get(k).getID();
                                        column[1] = pacientes.listPacientes.get(k).getNombre();
                                        Date date = pacientes.listPacientes.get(k).getInicioConf();
                                        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                                        if(date == null){
                                            column[2] = "No determinada";
                                        }else{
                                            String stdate = format.format(date);
                                            column[2] = stdate;
                                        }
                                        
                                        Date date1 = pacientes.listPacientes.get(k).getFinConf();
                                        if(date1 == null){
                                            column[3] = "No determinada";
                                        }else{
                                            String stdate1 = format.format(date1);
                                            column[3] = stdate1;
                                        }
                                        
                                        if(pacientes.listPacientes.get(k).getProxPrueba() == null){
                                            column[4] = "No determinada";
                                        }else{
                                            column[4] = pacientes.listPacientes.get(k).getProxPrueba();
                                        }
                                        
                                        Date date2 = pacientes.listPacientes.get(k).getFechaPrueba();
                                        if(date2 == null){
                                            column[5] = "No determinada";
                                        }else{
                                            String stdate2 = format.format(date2);
                                            column[5] = stdate2;
                                        }
                                        
                                
                                        model.addRow(column);
                                    }
                                }   
                            }
                        }
                    }
                }
            }
        });
        
        table = new JTable(model);
        table.setBounds(10,180,665,300);
        
        scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setBounds(10,180,665,300);
        panelGestion.add(scroll);
        panelGestion.setVisible(true);
        
        panel1.add(panelGestion);
        panel1.repaint();
        panel1.revalidate();
    }

    //Registro de pruebas
    public void registroPruebas(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Registro de pruebas");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        JLabel jbuscar = new JLabel("Filtrar por ID");
        jbuscar.setBounds(10,110,80,30);
        panelAsignar.add(jbuscar);
        
        JTextField tfbuscar = new JTextField();
        tfbuscar.setBounds(10,135,80,30);
        panelAsignar.add(tfbuscar);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Registro y actualización de pruebas diagnósticas y vacunas");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Inicio Conf");
        model.addColumn("Fin Conf");
        model.addColumn("Prox Prueba");
        model.addColumn("Fecha Prueba");
        
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(100,135,105,30);
        panelAsignar.add(buscar);
        buscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Object[] column = new Object[model.getColumnCount()];
                model.setRowCount(0);
                String idEnf = tfbuscar.getText().toString();
                if(idEnf != ""){
                    for(int i = 0; i < empleados.enfermeros.size(); i++){
                        if(idEnf.equals(empleados.enfermeros.get(i).getID())){
                            for(int j = 0; j < empleados.enfermeros.get(i).listPacAsignados.size();j++){
                                for(int k = 0; k < pacientes.listPacientes.size(); k++){
                                    if(empleados.enfermeros.get(i).listPacAsignados.get(j).getIdPaciente().equals(pacientes.listPacientes.get(k).getID())){
                                        column[0] = pacientes.listPacientes.get(k).getID();
                                        column[1] = pacientes.listPacientes.get(k).getNombre();
                                        Date date = pacientes.listPacientes.get(k).getInicioConf();
                                        DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                                        if(date == null){
                                            column[2] = "No determinada";
                                        }else{
                                            String stdate = format.format(date);
                                            column[2] = stdate;
                                        }
                                        
                                        Date date1 = pacientes.listPacientes.get(k).getFinConf();
                                        if(date1 == null){
                                            column[3] = "No determinada";
                                        }else{
                                            String stdate1 = format.format(date1);
                                            column[3] = stdate1;
                                        }
                                        
                                        if(pacientes.listPacientes.get(k).getProxPrueba() == null){
                                            column[4] = "No determinada";
                                        }else{
                                            column[4] = pacientes.listPacientes.get(k).getProxPrueba();
                                        }
                                        
                                        Date date2 = pacientes.listPacientes.get(k).getFechaPrueba();
                                        if(date2 == null){
                                            column[5] = "No determinada";
                                        }else{
                                            String stdate2 = format.format(date2);
                                            column[5] = stdate2;
                                        }
                                        
                                
                                        model.addRow(column);
                                    }
                                }   
                            }
                        }
                    }
                }
            }
        });

        JButton bt_asignarTecnico = new JButton("Asignar prueba o vacuna");
        bt_asignarTecnico.setBounds(230,500,200,40);
        bt_asignarTecnico.setBackground(new Color(121,255,127));
        bt_asignarTecnico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigPruebaVacuna prueba = new AsigPruebaVacuna(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarTecnico);
        
        table = new JTable(model);
        table.setBounds(10,180,665,300);
        
        scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setBounds(10,180,665,300);
        panelAsignar.add(scroll);
        panelAsignar.setVisible(true);
        
        panel1.add(panelAsignar);
        panel1.repaint();
        panel1.revalidate();
    }
}
