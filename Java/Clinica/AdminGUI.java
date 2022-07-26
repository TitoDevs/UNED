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
 * AdminGUI es la clase interfaz de los administradores. En ella se hace prácticamente todas
 * las funciones que tiene los administradores.
 * 
 * @author Luis Daniel Guardado Garcia 
 * @version v1.0
 */
public class AdminGUI{
    public JLabel userLabel, passwordLabel, success, image, profile, background;
    public JTextField userText;
    public JPasswordField passwordText;
    public JButton button, button1, button2, button3, button4,
    button5, button6, button7;
    public ImageIcon icon, ic_profile, ic_background;
    public JPanel panel1;
    public DefaultTableModel model, model1;
    public JTable table, table1;
    public JScrollPane scroll, scroll1;
    public JTableHeader header;
    public String [] head = {"ID", "Nombre"};
    
    public AdminGUI(Vacunas vacuna, Personas personas, PruebasDiagnosticas pruebasDiagnosticas, Empleados empleados,
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
        JLabel title = new JLabel("Administrador");
        title.setBounds(40,200,200,40);
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
        
        button = new JButton("Gestión de usuarios");
        button.setBounds(0,240,200,40);
        button.setBackground(new Color(251,132,132));
        panel.add(button);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gestionUsuarios(empleados, pacientes);
            }
        });
        
        button1 = new JButton("Asignar pruebas");
        button1.setBounds(0,280,200,40);
        button1.setBackground(new Color(251,132,132));
        panel.add(button1);
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                asignarPruebas(empleados, pacientes);
            }
        });
                
        button2 = new JButton("Lista de usuarios");
        button2.setBounds(0,320,200,40);
        button2.setBackground(new Color(251,132,132));
        panel.add(button2);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                listaUsuarios(empleados, pacientes);
            }
        });
        
        button3 = new JButton("Pacientes asignados");
        button3.setBounds(0,360,200,40);
        button3.setBackground(new Color(251,132,132));
        panel.add(button3);
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pacientesAsignados(empleados);
            }
        });
        
        button4 = new JButton("Pacientes confinados");
        button4.setBounds(0,400,200,40);
        button4.setBackground(new Color(251,132,132));
        panel.add(button4);
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pacientesConfinados(pacientes);
            }
        });
        
        button5 = new JButton("Gestión de pruebas");
        button5.setBounds(0,440,200,40);
        button5.setBackground(new Color(251,132,132));
        panel.add(button5);
        button5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                gestionPruebas(empleados, pacientes);
            }
        });
        
        button6 = new JButton("Stock de vacunas");
        button6.setBounds(0,480,200,40);
        button6.setBackground(new Color(251,132,132));
        panel.add(button6);
        button6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                stockVacunas(vacuna);
            }
        });
        
        button7 = new JButton("Planificación de vacunas");
        button7.setBounds(0,520,200,40);
        button7.setBackground(new Color(251,132,132));
        panel.add(button7);
        button7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                planificacionVacunas(empleados, pacientes);
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
        item = new JMenuItem("Cambiar a enfermeros");
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, SHORTCUT_MASK));
        item.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
            EnfermeroGUI admin = new EnfermeroGUI(personas,pruebasDiagnosticas,empleados,pacientes);
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
    //Gestion usuarios
    public void gestionUsuarios(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelGestion = new JPanel();
        panelGestion.setLayout(null);
        panelGestion.setBounds(0,0,700,622);
        panelGestion.setBackground(Color.white);
        Font fuente = new Font("Calibri", 1, 40);

        JLabel tf_titulo = new JLabel("Gestión de usuarios");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelGestion.add(tf_titulo);
        
        JLabel tf_list = new JLabel("Todos los usuarios");
        tf_list.setBounds(10,155,600,10);
        panelGestion.add(tf_list);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Altas, bajas y modificaciones de todas las personas registradas");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelGestion.add(tf_subtitulo);
        
        JButton bt_alta = new JButton("Alta usuario");
        bt_alta.setBounds(10,500,200,40);
        bt_alta.setBackground(new Color(121,255,127));
        bt_alta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AltaUsuario user = new AltaUsuario(empleados, pacientes);
            }
        });
        panelGestion.add(bt_alta);
        
        JButton bt_mod = new JButton("Modificar usuario");
        bt_mod.setBounds(241,500,200,40);
        bt_mod.setBackground(new Color(255,159,75));
        bt_mod.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ModUsuario user = new ModUsuario(empleados, pacientes);
            }
        });
        panelGestion.add(bt_mod);
        
        JButton bt_eliminar = new JButton("Eliminar usuario");
        bt_eliminar.setBounds(473,500,200,40);
        bt_eliminar.setBackground(new Color(255,130,91));
        bt_eliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ElimUsuario user = new ElimUsuario(empleados, pacientes);
            }
        });
        panelGestion.add(bt_eliminar);

        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Sexo");
        
        //Lista enfermeros
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.enfermeros.size(); i++){
            column[0] = empleados.enfermeros.get(i).getID();
            column[1] = empleados.enfermeros.get(i).getNombre();
            column[2] = empleados.enfermeros.get(i).getApellidos();
            column[3] = empleados.enfermeros.get(i).getSexo();
            model.addRow(column);
        }
        //Lista tecnicos
        for(int i = 0; i < empleados.tecnicos.size(); i++){
            column[0] = empleados.tecnicos.get(i).getID();
            column[1] = empleados.tecnicos.get(i).getNombre();
            column[2] = empleados.tecnicos.get(i).getApellidos();
            column[3] = empleados.tecnicos.get(i).getSexo();
            model.addRow(column);
        }
        //Lista administradores
        for(int i = 0; i < empleados.administradores.size(); i++){
            column[0] = empleados.administradores.get(i).getID();
            column[1] = empleados.administradores.get(i).getNombre();
            column[2] = empleados.administradores.get(i).getApellidos();
            column[3] = empleados.administradores.get(i).getSexo();
            model.addRow(column);
        }
        //Lista pacientes
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            column[0] = pacientes.listPacientes.get(i).getID();
            column[1] = pacientes.listPacientes.get(i).getNombre();
            column[2] = pacientes.listPacientes.get(i).getApellidos();
            column[3] = pacientes.listPacientes.get(i).getSexo();
            model.addRow(column);
        }
        
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
    
    public void listaEnfermeros(Empleados empleado){
        if(empleado == null){
            System.out.println("No hay datos");
        } else {
            int lista = empleado.enfermeros.size();
            System.out.println(lista);
            
            for(int i = 0; i<lista;i++){
                System.out.println(empleado.enfermeros.get(i));
                String nombre = empleado.enfermeros.get(i).getNombre().toString();
                System.out.println(nombre);
            }
        }
    }
    //Asignar pruebas
    public void asignarPruebas(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Asignar pruebas");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Asignación de pruebas diagnósticas y vacunaciones");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel tf_pac = new JLabel("Pacientes con enfermeros y técnicos asociados");
        tf_pac.setBounds(10,155,600,10);
        panelAsignar.add(tf_pac);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("ID Enfermero");
        model.addColumn("ID Técnico");
        model.addColumn("Fecha de Entrada");

        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            if(pacientes.listPacientes.get(i).getEnfAsignado() != null && pacientes.listPacientes.get(i).getEnfAsignado() != null){
                column[0] = pacientes.listPacientes.get(i).getID();
                column[1] = pacientes.listPacientes.get(i).getNombre();
                column[2] = pacientes.listPacientes.get(i).getEnfAsignado();
                column[3] = pacientes.listPacientes.get(i).getTecAsignado();
                Date date = pacientes.listPacientes.get(i).getFecha();
                DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                String stdate = format.format(date);
                column[4] = stdate;
                model.addRow(column);
            }
        }
        
        JButton bt_asignarTecnico = new JButton("Asignar técnico a paciente");
        bt_asignarTecnico.setBounds(110,500,200,40);
        bt_asignarTecnico.setBackground(new Color(121,255,127));
        bt_asignarTecnico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigTecnico paciente = new AsigTecnico(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarTecnico);
        
        JButton bt_asignarEnfermero = new JButton("Asignar enfermero a paciente");
        bt_asignarEnfermero.setBounds(373,500,200,40);
        bt_asignarEnfermero.setBackground(new Color(255,130,91));
        bt_asignarEnfermero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigEnfermero paciente = new AsigEnfermero(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarEnfermero);
        
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
    //Lista usuarios
    public void listaUsuarios(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Lista de usuarios");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Visualización de datos de todas las personas registradas");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel tf_list = new JLabel("Todos los usuarios");
        tf_list.setBounds(10,155,600,10);
        panelAsignar.add(tf_list);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Sexo");
        model.addColumn("Edad");
        model.addColumn("Fecha de Entrada");
        
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.enfermeros.size(); i++){
            column[0] = empleados.enfermeros.get(i).getID();
            column[1] = empleados.enfermeros.get(i).getNombre();
            column[2] = empleados.enfermeros.get(i).getApellidos();
            column[3] = empleados.enfermeros.get(i).getSexo();
            column[4] = empleados.enfermeros.get(i).getEdad();
            Date date = empleados.enfermeros.get(i).getFecha();
            DateFormat format = new SimpleDateFormat("dd-M-yyyy");
            String stdate = format.format(date);
            column[5] = stdate;
            model.addRow(column);
        }
        
        for(int i = 0; i < empleados.tecnicos.size(); i++){
            column[0] = empleados.tecnicos.get(i).getID();
            column[1] = empleados.tecnicos.get(i).getNombre();
            column[2] = empleados.tecnicos.get(i).getApellidos();
            column[3] = empleados.tecnicos.get(i).getSexo();
            column[4] = empleados.tecnicos.get(i).getEdad();
            Date date = empleados.tecnicos.get(i).getFecha();
            DateFormat format = new SimpleDateFormat("dd-M-yyyy");
            String stdate = format.format(date);
            column[5] = stdate;
            model.addRow(column);
        }
        
        for(int i = 0; i < empleados.administradores.size(); i++){
            column[0] = empleados.administradores.get(i).getID();
            column[1] = empleados.administradores.get(i).getNombre();
            column[2] = empleados.administradores.get(i).getApellidos();
            column[3] = empleados.administradores.get(i).getSexo();
            column[4] = empleados.administradores.get(i).getEdad();
            Date date = empleados.administradores.get(i).getFecha();
            DateFormat format = new SimpleDateFormat("dd-M-yyyy");
            String stdate = format.format(date);
            column[5] = stdate;
            model.addRow(column);
        }
        
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            column[0] = pacientes.listPacientes.get(i).getID();
            column[1] = pacientes.listPacientes.get(i).getNombre();
            column[2] = pacientes.listPacientes.get(i).getApellidos();
            column[3] = pacientes.listPacientes.get(i).getSexo();
            column[4] = pacientes.listPacientes.get(i).getEdad();
            Date date = pacientes.listPacientes.get(i).getFecha();
            DateFormat format = new SimpleDateFormat("dd-M-yyyy");
            String stdate = format.format(date);
            column[5] = stdate;
            model.addRow(column);
        }
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
    //Pacientes asignados
    public void pacientesAsignados(Empleados empleados){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Pacientes asignados");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Visualización de pacientes asignados a cada enfermero y paciente");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel tf_enf = new JLabel("Pacientes asignados a enfermeros");
        tf_enf.setBounds(10,155,600,10);
        panelAsignar.add(tf_enf);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Paciente");
        model.addColumn("Fecha prueba");
        
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.enfermeros.size(); i++){
            for(int k = 0; k < empleados.enfermeros.get(i).listPacAsignados.size(); k++){
                column[0] = empleados.enfermeros.get(i).getID();
                column[1] = empleados.enfermeros.get(i).getNombre();
                column[2] = empleados.enfermeros.get(i).getApellidos();
                column[3] = empleados.enfermeros.get(i).listPacAsignados.get(k).getIdPaciente();
                Date date = empleados.enfermeros.get(i).listPacAsignados.get(k).getDate();
                DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                String stdate = format.format(date);
                column[4] = stdate;
                model.addRow(column);
            }
        }
        
        table = new JTable(model);
        table.setBounds(10,180,665,150);
        
        JLabel tf_tec = new JLabel("Pacientes asignados a técnicos");
        tf_tec.setBounds(10,355,600,10);
        panelAsignar.add(tf_tec);
        
        model1 = new DefaultTableModel();
        model1.addColumn("ID");
        model1.addColumn("Nombre");
        model1.addColumn("Apellidos");
        model1.addColumn("Paciente");
        model1.addColumn("Fecha prueba");
        
        Object[] column1 = new Object[model.getColumnCount()];
        for(int i = 0; i < empleados.tecnicos.size(); i++){
            for(int k = 0; k < empleados.tecnicos.get(i).listPacAsignados.size(); k++){
                column1[0] = empleados.tecnicos.get(i).getID();
                column1[1] = empleados.tecnicos.get(i).getNombre();
                column1[2] = empleados.tecnicos.get(i).getApellidos();
                column1[3] = empleados.tecnicos.get(i).listPacAsignados.get(k).getIdPaciente();
                Date date = empleados.tecnicos.get(i).listPacAsignados.get(k).getDate();
                DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                String stdate = format.format(date);
                column1[4] = stdate;
                model1.addRow(column1);
            }
        }
        
        table1 = new JTable(model1);
        table1.setBounds(10,380,665,150);
        
        scroll = new JScrollPane();
        scroll.setViewportView(table);
        scroll.setBounds(10,180,665,150);
        panelAsignar.add(scroll);
        
        scroll1 = new JScrollPane();
        scroll1.setViewportView(table1);
        scroll1.setBounds(10,380,665,150);
        panelAsignar.add(scroll1);
        panelAsignar.setVisible(true);
        
        panel1.add(panelAsignar);
        panel1.repaint();
        panel1.revalidate();
    }
    //pacientes confinados
    public void pacientesConfinados(Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Pacientes confinados");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        JLabel tf_list = new JLabel("Pacientes confinados");
        tf_list.setBounds(10,155,600,10);
        panelAsignar.add(tf_list);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Visualización del lista de pacientes confinados");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Fecha de Entrada");
        model.addColumn("Inicio conf.");
        model.addColumn("Fin conf.");
        
        Object[] column = new Object[model.getColumnCount()];
        
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            column[0] = pacientes.listPacientes.get(i).getID();
            column[1] = pacientes.listPacientes.get(i).getNombre();
            column[2] = pacientes.listPacientes.get(i).getApellidos();
            Date date = pacientes.listPacientes.get(i).getFecha();
            DateFormat format = new SimpleDateFormat("dd-M-yyyy");
            String stdate = format.format(date);
            column[3] = stdate;
            if(pacientes.listPacientes.get(i).getInicioConf() != null){
                Date date1 = pacientes.listPacientes.get(i).getInicioConf();
                String stdate1 = format.format(date1);
                column[4] = stdate1;
                Date date2 = pacientes.listPacientes.get(i).getFinConf();
                String stdate2 = format.format(date2);
                column[5] = stdate2;
                model.addRow(column);
            }
        }
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
    //Gestion de pruebas
    public void gestionPruebas(Empleados empleados, Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Gestión de pruebas");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Gestión de la programación de pruebas serológicas tras los confinamientos");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel tf_enf = new JLabel("Pacientes con confinamiento finalizado");
        tf_enf.setBounds(10,155,600,10);
        panelAsignar.add(tf_enf);
        
        JButton bt_asignarTecnico = new JButton("Asignar técnico a paciente");
        bt_asignarTecnico.setBounds(110,500,200,40);
        bt_asignarTecnico.setBackground(new Color(121,255,127));
        bt_asignarTecnico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigTecnico paciente = new AsigTecnico(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarTecnico);
        
        JButton bt_asignarEnfermero = new JButton("Asignar enfermero a paciente");
        bt_asignarEnfermero.setBounds(373,500,200,40);
        bt_asignarEnfermero.setBackground(new Color(255,130,91));
        bt_asignarEnfermero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigEnfermero paciente = new AsigEnfermero(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarEnfermero);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID Enf");
        model.addColumn("Nombre");
        model.addColumn("ID Pac");
        model.addColumn("Nombre");
        model.addColumn("Fecha fin confinamiento");
        
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            String enfAsignado = pacientes.listPacientes.get(i).getEnfAsignado(); 
            if(enfAsignado != null){
                column[0] = enfAsignado;
                for(int j = 0; j < empleados.enfermeros.size(); j++){
                    if(empleados.enfermeros.get(j).getID().equals(enfAsignado)){
                        column[1] = empleados.enfermeros.get(j).getNombre();
                    }
                }
                column[2] = pacientes.listPacientes.get(i).getID();
                column[3] = pacientes.listPacientes.get(i).getNombre();
                Date date1 = pacientes.listPacientes.get(i).getFinConf();
                DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                String stdate1 = format.format(date1);
                column[4] = stdate1;
                model.addRow(column);
            }   
        }
        
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
    //Stock de vacunas
    public void stockVacunas(Vacunas vacunas){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Stock de vacunas");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Actualización del stock de vacunas");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel pfizer = new JLabel("Pfizer");
        pfizer.setBounds(20,150,200,30);
        panelAsignar.add(pfizer);
        
        JLabel cantidad = new JLabel("Cantidad");
        cantidad.setBounds(200,125,80,30);
        panelAsignar.add(cantidad);
        
        String numCa = String.valueOf(vacunas.getPfizer());
        JLabel numCantidad = new JLabel();
        numCantidad.setBounds(200,150,80,30);
        numCantidad.setText(numCa);
        panelAsignar.add(numCantidad);
        
        JLabel sol = new JLabel("Solicitar");
        sol.setBounds(300,125,80,30);
        panelAsignar.add(sol);
        
        JTextField jtsol = new JTextField();
        jtsol.setBounds(300,150,80,35);
        panelAsignar.add(jtsol);
        
        JButton bt_asignar1 = new JButton("Solicitar");
        bt_asignar1.setBounds(400,150,80,35);
        bt_asignar1.setBackground(new Color(121,255,127));
        bt_asignar1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jtP = Integer.parseInt(jtsol.getText());
                int numero = vacunas.getPfizer() + jtP;
                vacunas.setPfizer(numero);
            }
        });
        panelAsignar.add(bt_asignar1);
        
        JLabel moderna = new JLabel("Moderna");
        moderna.setBounds(20,190,200,30);
        panelAsignar.add(moderna);
        
        String numCa1 = String.valueOf(vacunas.getModerna());
        JLabel numCantidad1 = new JLabel();
        numCantidad1.setBounds(200,190,80,30);
        numCantidad1.setText(numCa1);
        panelAsignar.add(numCantidad1);
        
        JTextField jtsol1 = new JTextField();
        jtsol1.setBounds(300,190,80,35);
        panelAsignar.add(jtsol1);
        
        JButton bt_asignar2 = new JButton("Solicitar");
        bt_asignar2.setBounds(400,190,80,35);
        bt_asignar2.setBackground(new Color(121,255,127));
        bt_asignar2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jtP = Integer.parseInt(jtsol1.getText());
                int numero = vacunas.getModerna() + jtP;
                vacunas.setModerna(numero);
            }
        });
        panelAsignar.add(bt_asignar2);
        
        JLabel jonh = new JLabel("Jonhson & Jonhson");
        jonh.setBounds(20,230,200,30);
        panelAsignar.add(jonh);
       
        String numCa2 = String.valueOf(vacunas.getJJ());
        JLabel numCantidad2 = new JLabel();
        numCantidad2.setBounds(200,230,80,30);
        numCantidad2.setText(numCa2);
        panelAsignar.add(numCantidad2);
        
        JTextField jtsol2 = new JTextField();
        jtsol2.setBounds(300,230,80,35);
        panelAsignar.add(jtsol2);
        
        panel1.add(panelAsignar);
        panel1.repaint();
        panel1.revalidate();
        
        JButton bt_asignar3 = new JButton("Solicitar");
        bt_asignar3.setBounds(400,230,80,35);
        bt_asignar3.setBackground(new Color(121,255,127));
        bt_asignar3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int jtP = Integer.parseInt(jtsol2.getText());
                int numero = vacunas.getJJ() + jtP;
                vacunas.setPfizer(numero);
            }
        });
        panelAsignar.add(bt_asignar3);
        
        panelAsignar.setVisible(true);
        panel1.add(panelAsignar);
        panel1.repaint();
        panel1.revalidate();
    }
    //Planificación de vacunas
    public void planificacionVacunas(Empleados empleados,Pacientes pacientes){
        panel1.removeAll();
        JPanel panelAsignar = new JPanel();
        panelAsignar.setLayout(null);
        panelAsignar.setBounds(0,0,700,622);
        panelAsignar.setBackground(Color.white);
        
        Font fuente = new Font("Calibri", 1, 40);
        
        JLabel tf_titulo = new JLabel("Planificación de vacunas");
        tf_titulo.setBounds(10,20,500,40);
        tf_titulo.setFont(fuente);
        tf_titulo.setForeground(Color.black);
        panelAsignar.add(tf_titulo);
        
        Font fuente2 = new Font("Calibri", 1, 20);
        JLabel tf_subtitulo = new JLabel("Visualización de la planificación tentativa de vacunas");
        tf_subtitulo.setBounds(10, 80, 700, 20);
        tf_subtitulo.setFont(fuente2);
        panelAsignar.add(tf_subtitulo);
        
        JLabel tf_enf = new JLabel("Pacientes con confinamiento finalizado");
        tf_enf.setBounds(10,155,600,10);
        panelAsignar.add(tf_enf);
        
        JButton bt_asignarTecnico = new JButton("Asignar técnico a paciente");
        bt_asignarTecnico.setBounds(110,500,200,40);
        bt_asignarTecnico.setBackground(new Color(121,255,127));
        bt_asignarTecnico.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigTecnico paciente = new AsigTecnico(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarTecnico);
        
        JButton bt_asignarEnfermero = new JButton("Asignar enfermero a paciente");
        bt_asignarEnfermero.setBounds(373,500,200,40);
        bt_asignarEnfermero.setBackground(new Color(255,130,91));
        bt_asignarEnfermero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                AsigEnfermero paciente = new AsigEnfermero(empleados, pacientes);
            }
        });
        panelAsignar.add(bt_asignarEnfermero);
        
        model = new DefaultTableModel();
        String[]p1 = {"1"};
        model.addColumn("ID Enf");
        model.addColumn("Nombre");
        model.addColumn("ID Pac");
        model.addColumn("Nombre");
        model.addColumn("Fecha fin confinamiento");
        
        Object[] column = new Object[model.getColumnCount()];
        for(int i = 0; i < pacientes.listPacientes.size(); i++){
            String enfAsignado = pacientes.listPacientes.get(i).getEnfAsignado();
            if(enfAsignado != null){     
                column[0] = enfAsignado;
                for(int j = 0; j < empleados.enfermeros.size(); j++){
                    if(empleados.enfermeros.get(j).getID().equals(enfAsignado)){
                        column[1] = empleados.enfermeros.get(j).getNombre();
                    }
                }
                column[2] = pacientes.listPacientes.get(i).getID();
                column[3] = pacientes.listPacientes.get(i).getNombre();
                Date date1 = pacientes.listPacientes.get(i).getFinConf();
                DateFormat format = new SimpleDateFormat("dd-M-yyyy");
                String stdate1 = format.format(date1);
                column[4] = stdate1;
                model.addRow(column);
            }
        }
        
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
