package pkgMantenimiento;


import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;
import pkgUtil.Utiles;

import javax.swing.JComboBox; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon; 

public class JConsultarPapel extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDimensiones;
	private JTextField txtGramaje;
	private JTextField txtBlancura;
	private JTextField txtPrecio;
	
	private JConsultarPapel este;
	
	 
	private JButton btnModificar;
	
	public void setAccion(int accion){
		switch (accion) {
			case 0:{//consultar
				this.setTitle("..:: Consulta de Papel ::..");				
				btnModificar.setVisible(false);
				txtDimensiones.setEditable(false);
				txtBlancura.setEditable(false);
				txtGramaje.setEditable(false);
				txtPrecio.setEditable(false);
			}break;
			case 1:{
				//Modificar
				this.setTitle("..:: Modificar Papel ::..");
				btnModificar.setVisible(true);
				txtDimensiones.setEditable(true);
				txtBlancura.setEditable(true);
				txtGramaje.setEditable(true);
				txtPrecio.setEditable(true);				
			}break;
		}
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JConsultarPapel frame = new JConsultarPapel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JConsultarPapel() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		este=this;
		setTitle("..:: Consulta de Papel ::..");
		setBounds(100, 100, 477, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 441, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> cbxMarcas = new JComboBox<>();
		cbxMarcas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED) {					 
						switch (cbxMarcas.getSelectedIndex()) {						 
							case Main.V_CLASSBOND:{ 
								txtDimensiones.setText(Main.dimensiones0);
								txtGramaje.setText(Main.gramaje0+"");
								txtBlancura.setText(Main.blancura0+"");
								txtPrecio.setText(Main.precio0+""); 							 
							} break;
							case Main.V_COPYPREMIUM:{ 
								txtDimensiones.setText(Main.dimensiones1);
								txtGramaje.setText(Main.gramaje1+"");
								txtBlancura.setText(Main.blancura1+"");
								txtPrecio.setText(Main.precio1+""); 							 
							} break;
							case Main.V_MASTERBOND:{ 
								txtDimensiones.setText(Main.dimensiones2);
								txtGramaje.setText(Main.gramaje2+"");
								txtBlancura.setText(Main.blancura2+"");
								txtPrecio.setText(Main.precio2+""); 							 
							} break;
							case Main.V_VISIONBOND:{ 
								txtDimensiones.setText(Main.dimensiones3);
								txtGramaje.setText(Main.gramaje3+"");
								txtBlancura.setText(Main.blancura3+"");
								txtPrecio.setText(Main.precio3+""); 							 
							} break;
							case Main.V_COPYPAPER:{ 
								txtDimensiones.setText(Main.dimensiones4);
								txtGramaje.setText(Main.gramaje4+"");
								txtBlancura.setText(Main.blancura4+"");
								txtPrecio.setText(Main.precio4+""); 							 
							} break;
						 
						}
					 
			          
			       }
				
				
				
			}
		});
		cbxMarcas.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
		cbxMarcas.setBounds(108, 22, 202, 19);
		 
		panel.add(cbxMarcas);
		
		JLabel label = new JLabel("Marca");
		label.setBounds(10, 23, 88, 19);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Dimensiones");
		label_1.setBounds(10, 53, 88, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Gramaje");
		label_2.setBounds(10, 78, 76, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Blancura");
		label_3.setBounds(10, 103, 88, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Precio (S/)");
		label_4.setBounds(10, 128, 88, 14);
		panel.add(label_4);
		
		txtDimensiones = new JTextField();
		txtDimensiones.setEditable(false);
		txtDimensiones.setBounds(108, 50, 202, 20);
		panel.add(txtDimensiones);
		txtDimensiones.setColumns(10);
		
		txtGramaje = new JTextField();
		txtGramaje.setEditable(false);
		txtGramaje.setColumns(10);
		txtGramaje.setBounds(108, 75, 202, 20);
		panel.add(txtGramaje);
		
		txtBlancura = new JTextField();
		txtBlancura.setEditable(false);
		txtBlancura.setColumns(10);
		txtBlancura.setBounds(108, 100, 202, 20);
		panel.add(txtBlancura);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(108, 125, 202, 20);
		panel.add(txtPrecio);
		setLocationRelativeTo(null);
		cbxMarcas.setSelectedIndex(1);
		cbxMarcas.setSelectedIndex(0);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(JConsultarPapel.class.getResource("/images/cerrar16.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				este.setVisible(false);
			}
		});
		btnCerrar.setBounds(320, 49, 100, 23);
		panel.add(btnCerrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon(JConsultarPapel.class.getResource("/images/edit16.png")));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double aux=-1;
				String msgs="";
				Utiles.mensaje="";
				
				switch (cbxMarcas.getSelectedIndex()) {						 
					case Main.V_CLASSBOND:{ 
						Main.dimensiones0=txtDimensiones.getText().trim();
						aux=Utiles.validarReal(txtGramaje,"Gramaje");
						if(aux!=-1){
							Main.gramaje0=aux; 
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtBlancura,"Blancura");
						if(aux!=-1){
							Main.blancura0=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtPrecio,"Precio");
						if(aux!=-1){
							Main.precio0=aux;
						}else{
							msgs+=Utiles.mensaje;
						}			
					} break;
					case Main.V_COPYPREMIUM:{
						//String marca0 = "Class Bond";					
						Main.dimensiones1=txtDimensiones.getText().trim();
						
						aux=Utiles.validarReal(txtGramaje,"Gramaje");
						if(aux!=-1){
							Main.gramaje1=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtBlancura,"Blancura");
						if(aux!=-1){
							Main.blancura1=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtPrecio,"Precio");
						if(aux!=-1){
							Main.precio1=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						
					} break;
					case Main.V_MASTERBOND:{
						//String marca0 = "Class Bond";
						Main.dimensiones2=txtDimensiones.getText().trim(); 
						aux=Utiles.validarReal(txtGramaje,"Gramaje");
						if(aux!=-1){
							Main.gramaje2=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtBlancura,"Blancura");
						if(aux!=-1){
							Main.blancura2=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtPrecio,"Precio");
						if(aux!=-1){
							Main.precio2=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
					} break;
					case Main.V_VISIONBOND:{
						//String marca0 = "Class Bond";
						Main.dimensiones3=txtDimensiones.getText().trim();
						aux=Utiles.validarReal(txtGramaje,"Gramaje");
						if(aux!=-1){
							Main.gramaje3=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtBlancura,"Blancura");
						if(aux!=-1){
							Main.blancura3=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtPrecio,"Precio");
						if(aux!=-1){
							Main.precio3=aux;
						}else{
							msgs+=Utiles.mensaje;
						}  							 
					} break;
					case Main.V_COPYPAPER:{
						//String marca0 = "Class Bond";
						Main.dimensiones4=txtDimensiones.getText().trim();
						aux=Utiles.validarReal(txtGramaje,"Gramaje");
						if(aux!=-1){
							Main.gramaje4=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtBlancura,"Blancura");
						if(aux!=-1){
							Main.blancura4=aux;
						}else{
							msgs+=Utiles.mensaje;
						}
						aux=Utiles.validarReal(txtPrecio,"Precio");
						if(aux!=-1){
							Main.precio4=aux;
						}else{
							msgs+=Utiles.mensaje;
						}  							 
					} break;
				 
				}				
				if(msgs.equals("")){
					JOptionPane.showMessageDialog(null,"Se ha Guardado Exitosamente!!");
				}else{
					msgs+="\n";
					JOptionPane.showMessageDialog(null, "Hubo Errores:\n\n"+msgs,"Error",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnModificar.setBounds(320, 20, 100, 23);
		panel.add(btnModificar);
	}
}
