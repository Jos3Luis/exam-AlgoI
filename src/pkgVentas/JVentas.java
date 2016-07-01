package pkgVentas;
 
import java.awt.EventQueue;
 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;
import pkgUtil.Utiles;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon; 

public class JVentas extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JVentas este;
	private JTextArea txtLista;
	private JTextField txtResmas;
	private JComboBox<String> cbxMarca;
	 
	public void setMensaje(String mensaje) {
		txtLista.setText(mensaje);
		txtLista.setCaretPosition(0);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JVentas frame = new JVentas();
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
	public JVentas() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		este=this;
		setTitle("..:: Vender ::..");
		setBounds(100, 100, 545, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 529, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 509, 212);
		panel.add(scrollPane);
		
		txtLista = new JTextArea();
		scrollPane.setViewportView(txtLista);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(JVentas.class.getResource("/images/cerrar16.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				este.setVisible(false);
			}
		});
		btnCerrar.setBounds(419, 39, 100, 23);
		panel.add(btnCerrar);
		
		JButton btnVender = new JButton("Vender");
		btnVender.setIcon(new ImageIcon(JVentas.class.getResource("/images/sell16.png")));
		btnVender.addActionListener(new ActionListener() {
			
			private void setVenta(int marca, int cantidad){				 
				double importe;
				double descuento;
				String tab="\t";
				txtLista.setText("BOLETA DE VENTA\n==================================\n");			
				Main.contadorClientes++; 
			 	switch (marca) {
				 	case Main.V_CLASSBOND:{ 
				 		Main.contClassBond++;//cuento la venta
				 		Main.cantClassBond+=cantidad;//cuento la cantidad  de resmas				 		
				 		importe=Main.precio0*cantidad;
				 		descuento=getDescuento(cantidad,importe);				 		
				 		Main.importeClassBond+=importe - descuento;//calculo el importe Total
				 		
				 		txtLista.append("Marca del papel"+tab+tab+": "+Main.marca0+"\n");
				 		txtLista.append("Precio de la resma"+tab+": "+Main.precio0+"\n");
				 		txtLista.append("Cantidad adquirida"+tab+": "+cantidad+"\n");
				 		txtLista.append("Importe compra"+tab+tab+": "+importe+"\n"); 
				 		txtLista.append("Importe de descuento"+tab+": "+descuento+"\n");
				 		txtLista.append("Importe a pagar"+tab+tab+": "+(importe - descuento)+"\n");
				 		txtLista.append("Obsequio"+tab+tab+": "+getObsequio(cantidad)+"\n");
				 		txtLista.append("Premio sorpresa"+tab+": "+getPremioSorpresa(Main.contadorClientes)+"\n");
				 	}break;
			 		case Main.V_COPYPREMIUM:{  
			 			Main.contCopyPremium++;//cuento la venta
				 		Main.cantCopyPremium+=cantidad;//cuento la cantidad  de resmas
				 		importe=Main.precio1*cantidad;
				 		descuento=getDescuento(cantidad,importe);	
				 		Main.importeCopyPremium+=importe - descuento;//calculo el importe Total
				 		
				 		txtLista.append("Marca del papel"+tab+tab+": "+Main.marca1+"\n");
				 		txtLista.append("Precio de la resma"+tab+": "+Main.precio1+"\n");
				 		txtLista.append("Cantidad adquirida"+tab+": "+cantidad+"\n");
				 		txtLista.append("Importe compra"+tab+tab+": "+importe+"\n"); 
				 		txtLista.append("Importe de descuento"+tab+": "+descuento+"\n");
				 		txtLista.append("Importe a pagar"+tab+tab+": "+(importe - descuento)+"\n");
				 		txtLista.append("Obsequio"+tab+tab+": "+getObsequio(cantidad)+"\n");
				 		txtLista.append("Premio sorpresa"+tab+": "+getPremioSorpresa(Main.contadorClientes)+"\n");
			 		}break;
			 		case Main.V_MASTERBOND:{
			 			Main.contMasterBond++;
			 			Main.cantMasterBond+=cantidad;//cuento la cantidad  de resmas
				 		importe=Main.precio2*cantidad;
				 		descuento=getDescuento(cantidad,importe);
				 		Main.importeMasterBond+=importe - descuento;//calculo el importe Total
				 		
				 		txtLista.append("Marca del papel"+tab+tab+": "+Main.marca2+"\n");
				 		txtLista.append("Precio de la resma"+tab+": "+Main.precio2+"\n");
				 		txtLista.append("Cantidad adquirida"+tab+": "+cantidad+"\n");
				 		txtLista.append("Importe compra"+tab+tab+": "+importe+"\n"); 
				 		txtLista.append("Importe de descuento"+tab+": "+descuento+"\n");
				 		txtLista.append("Importe a pagar"+tab+tab+": "+(importe - descuento)+"\n");
				 		txtLista.append("Obsequio"+tab+tab+": "+getObsequio(cantidad)+"\n");
				 		txtLista.append("Premio sorpresa"+tab+": "+getPremioSorpresa(Main.contadorClientes)+"\n");
				 		
			 		}break;
			 		case Main.V_VISIONBOND:{ 
			 			Main.contVisionBond++;
			 			Main.cantVisionBond+=cantidad;//cuento la cantidad  de resmas
				 		importe=Main.precio3*cantidad;
				 		descuento=getDescuento(cantidad,importe);
				 		Main.importeVisionBond+=importe - descuento;//calculo el importe Total
				 		
				 		txtLista.append("Marca del papel"+tab+tab+": "+Main.marca3+"\n");
				 		txtLista.append("Precio de la resma"+tab+": "+Main.precio3+"\n");
				 		txtLista.append("Cantidad adquirida"+tab+": "+cantidad+"\n");
				 		txtLista.append("Importe compra"+tab+tab+": "+importe+"\n"); 
				 		txtLista.append("Importe de descuento"+tab+": "+descuento+"\n");
				 		txtLista.append("Importe a pagar"+tab+tab+": "+(importe - descuento)+"\n");
				 		txtLista.append("Obsequio"+tab+tab+": "+getObsequio(cantidad)+"\n");
				 		txtLista.append("Premio sorpresa"+tab+": "+getPremioSorpresa(Main.contadorClientes)+"\n");				 		
			 		}break;
			 		case Main.V_COPYPAPER:{
			 			Main.contCopyPaper++;
			 			Main.cantCopyPaper+=cantidad;//cuento la cantidad  de resmas
				 		importe=Main.precio4*cantidad;
				 		descuento=getDescuento(cantidad,importe);
				 		Main.importeCopyPaper+=importe - descuento;//calculo el importe Total
				 		
				 		txtLista.append("Marca del papel"+tab+tab+": "+Main.marca4+"\n");
				 		txtLista.append("Precio de la resma"+tab+": "+Main.precio4+"\n");
				 		txtLista.append("Cantidad adquirida"+tab+": "+cantidad+"\n");
				 		txtLista.append("Importe compra"+tab+tab+": "+importe+"\n"); 
				 		txtLista.append("Importe de descuento"+tab+": "+descuento+"\n");
				 		txtLista.append("Importe a pagar"+tab+tab+": "+(importe - descuento)+"\n");
				 		txtLista.append("Obsequio"+tab+tab+": "+getObsequio(cantidad)+"\n");
				 		txtLista.append("Premio sorpresa"+tab+": "+getPremioSorpresa(Main.contadorClientes)+"\n");
				 		
			 		}
			 	} 
			} 
			  
			private double getDescuento(int cantidad,double importe){
				if(cantidad>=1){
					if(cantidad<=5){
						return importe*Main.porcentaje1/100;
					}else if(cantidad<=10){
						return importe*Main.porcentaje2/100;
					}else if(cantidad<=15){
						return importe*Main.porcentaje3/100;
					}else if(cantidad>15){
						return importe*Main.porcentaje4/100;
					} 
				}
				return 0;
			}
			private String getObsequio(int cantidad){
				if(cantidad>=Main.cantidadObsequiable){
					return Main.obsequio;
				}
				return "No hay Obsequio";
			}
			private String getPremioSorpresa(int cliente){
				if(cliente==Main.numeroClienteSorpresa){
					return Main.premioSorpresa;
				}
				return "No hay Premio";
			}
			public void actionPerformed(ActionEvent arg0) {
				if(txtResmas.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "Cadena Vacia!!!","Error",JOptionPane.ERROR_MESSAGE);
				}else{
					Utiles.mensaje="";
					int cantidad=Utiles.validarEntero(txtResmas, "Cantidad");
					if(cantidad!=-1){						 						 
						setVenta(cbxMarca.getSelectedIndex(),cantidad);						 
					}else{
						JOptionPane.showMessageDialog(null, Utiles.mensaje,"Error",JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		btnVender.setBounds(419, 8, 100, 23);
		panel.add(btnVender);
		
		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(10, 12, 115, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad de resmas");
		lblNewLabel_1.setBounds(10, 43, 115, 14);
		panel.add(lblNewLabel_1);
		
		txtResmas = new JTextField();
		txtResmas.setBounds(155, 40, 179, 20);
		panel.add(txtResmas);
		txtResmas.setColumns(10);
		
		cbxMarca = new JComboBox<String>();
		cbxMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Class Bond", "Copy Premium", "Master Bond", "Vision Bond", "Copy Paper"}));
	 
		cbxMarca.setBounds(154, 11, 179, 19);
		panel.add(cbxMarca);
		setLocationRelativeTo(null);
	}
	@Override
	public void setVisible(boolean b) {		// 
		super.setVisible(b);
		txtLista.setText("");
		txtResmas.setText("");
	}
}
