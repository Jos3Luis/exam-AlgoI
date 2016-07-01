package pkgMain;
 
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel; 
import javax.swing.UIManager; 

import pkgAyuda.JPanelAyuda;
import pkgConfiguracion.JCantOptima;
import pkgConfiguracion.JDescuentos;
import pkgConfiguracion.JObsequio;
import pkgConfiguracion.JPremioSorpresa;
import pkgMantenimiento.JConsultarPapel;
import pkgMantenimiento.JListarPapeles;
import pkgReportes.JReportes;
import pkgVentas.JVentas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException; 
import java.awt.event.ActionEvent;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Color;  
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;  

public class Main extends JFrame {
 
	private static final long serialVersionUID = 1L;
	// Datos mínimos de la primera marca
	public static String marca0 = "Class Bond";
	public static String dimensiones0 = "21.6 x 28.0 cm";
	public static double gramaje0 = 74.8;
	public static double blancura0 = 90.2;
	public static double precio0 = 12.0;
	// Datos mínimos de la segunda marca
	public static String marca1 = "Copy Premium";
	public static String dimensiones1 = "21.6 x 27.9 cm";
	public static double gramaje1 = 74.3;
	public static double blancura1 = 90.0;
	public static double precio1 = 11.5;
	// Datos mínimos de la tercera marca
	public static String marca2 = "Master Bond";
	public static String dimensiones2 = "21.6 x 28.0 cm";
	public static double gramaje2 = 74.4;
	public static double blancura2 = 90.3;
	public static double precio2 = 13.0;
	// Datos mínimos de la cuarta marca
	public static String marca3 = "Vision Bond";
	public static String dimensiones3 = "21.6 x 27.9 cm";
	public static double gramaje3 = 74.5;
	public static double blancura3 = 96.1;
	public static double precio3 = 14.5;
	// Datos mínimos de la quinta marca
	public static String marca4 = "Copy Paper";
	public static String dimensiones4 = "21.6 x 27.9";
	public static double gramaje4 = 75.0;
	public static double blancura4 = 93.9;
	public static double precio4 = 11.0;
	// Porcentajes de descuento
	public static double porcentaje1 = 4.0;
	public static double porcentaje2 = 5.5;
	public static double porcentaje3 = 7.0;
	public static double porcentaje4 = 8.5;
	// Cantidad toal óptima de resmas vendidas
	public static int cantidadTotalOptima = 50;
	// Cantidad mínima de resmas adquiridas para obtener el obsequio
	public static int cantidadObsequiable = 6;
	// Obsequio
	public static String obsequio = "Un lapicero";
	// Número de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	// Premio sorpresa
	public static String premioSorpresa = "Un chocolate";
	
	public static final int V_CLASSBOND=0;
	public static final int V_COPYPREMIUM=1;
	public static final int V_MASTERBOND=2;
	public static final int V_VISIONBOND=3;
	public static final int V_COPYPAPER=4;
	
	public static int contadorClientes=0;
	
	public static int contClassBond=0;
	public static int cantClassBond=0;
	public static double importeClassBond=0;
	
	public static int contCopyPremium=0;
	public static int cantCopyPremium=0;
	public static double importeCopyPremium=0;
	
	public static int contMasterBond=0;
	public static int cantMasterBond=0;
	public static double importeMasterBond=0;
	
	public static int contVisionBond=0;
	public static int cantVisionBond=0;
	public static double importeVisionBond=0;
	
	public static int contCopyPaper=0;
	public static int cantCopyPaper=0;
	public static double importeCopyPaper=0;

	private JConsultarPapel jcp;
	private JListarPapeles jlp;
	private JDescuentos jd;
	private JObsequio jo;
	private JCantOptima jco;
	private JPremioSorpresa jps;
	private JVentas jv;
	private JReportes jr;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  
	 
	public Main() throws IOException {
		setResizable(false);
	
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("..:: TIENDA  ::..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 447);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setMnemonic(KeyEvent.VK_M);
		menuBar.add(mnMantenimiento);

		JMenuItem mntmConsultarPapel = new JMenuItem("Consultar papel");
		mntmConsultarPapel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mntmConsultarPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcp==null){
					jcp = new JConsultarPapel();	
				}
				jcp.setAccion(0);
				jcp.setVisible(true);

			}
		});
		mnMantenimiento.add(mntmConsultarPapel);

		JMenuItem mntmModificarPapel = new JMenuItem("Modificar papel");
		mntmModificarPapel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmModificarPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcp==null){
					jcp = new JConsultarPapel();	
				}
				jcp.setAccion(1);
				jcp.setVisible(true);			
				
			}
		});
		mnMantenimiento.add(mntmModificarPapel);

		JMenuItem mntmListarPapeles = new JMenuItem("Listar papeles");
		mntmListarPapeles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmListarPapeles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jlp==null){
					jlp = new JListarPapeles();	
				}
				jlp.setVisible(true);					
			}
		});
		mnMantenimiento.add(mntmListarPapeles);

		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setMnemonic(KeyEvent.VK_V);
		menuBar.add(mnVentas);

		JMenuItem mntmVender = new JMenuItem("Vender");
		mntmVender.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mntmVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jv==null){
					jv = new JVentas();	
				}
				jv.setVisible(true);
				 
			}
		});
		mnVentas.add(mntmVender);

		JMenuItem mntmGenerarReportes = new JMenuItem("Generar reportes");
		mntmGenerarReportes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGenerarReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jr==null){
					jr= new JReportes();
				}
				jr.setVisible(true);
			}
		});
		mnVentas.add(mntmGenerarReportes);

		JMenu mnConfiguracion = new JMenu("Configuracion");
		mnConfiguracion.setMnemonic(KeyEvent.VK_C);
		menuBar.add(mnConfiguracion);

		JMenuItem mntmConfigurarDescuentos = new JMenuItem("Configurar descuentos");
		mntmConfigurarDescuentos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_MASK));
		mntmConfigurarDescuentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jd==null){
					jd= new JDescuentos();
				}
				jd.setVisible(true);
			}
		});
		mnConfiguracion.add(mntmConfigurarDescuentos);

		JMenuItem mntmConfigurarObsequio = new JMenuItem("Configurar obsequio");
		mntmConfigurarObsequio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.ALT_MASK));
		mntmConfigurarObsequio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(jo==null){
					jo= new JObsequio();
				}
				jo.setVisible(true);
				
			}
		});
		mnConfiguracion.add(mntmConfigurarObsequio);

		JMenuItem mntmConfigurarCantidadptima = new JMenuItem("Configurar cantidad \u00F3ptima de resmas vendidas");
		mntmConfigurarCantidadptima.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		mntmConfigurarCantidadptima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jco==null){
					jco= new JCantOptima();
				}
				jco.setVisible(true);
			}
		});
		mnConfiguracion.add(mntmConfigurarCantidadptima);

		JMenuItem mntmNewMenuItem = new JMenuItem("Configurar premio sorpresa");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jps==null){
					jps= new JPremioSorpresa();
				}
				jps.setVisible(true);
			}
		});
		mnConfiguracion.add(mntmNewMenuItem);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDeTienda = new JMenuItem("Acerca de Tienda");
		mntmAcercaDeTienda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAcercaDeTienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanelAyuda panel = new JPanelAyuda();
				panel.setSize(500, 500);
				 JOptionPane.showMessageDialog(null, panel,"Acerca de ",JOptionPane.PLAIN_MESSAGE);

			}
		});
		mnAyuda.add(mntmAcercaDeTienda);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1362, 684);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/images/bg2.png")));
		lblNewLabel.setBounds(0, 78, 1160, 606);
		panel.add(lblNewLabel);
		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.JPG")));
	}
	 
}
