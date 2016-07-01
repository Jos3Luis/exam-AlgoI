package pkgConfiguracion;
 
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;
import pkgUtil.Utiles;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon; 

public class JObsequio extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantMinima;
	private JTextField txtObsequio;
	
	private JObsequio este;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JObsequio frame = new JObsequio();
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
	public JObsequio() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Configurar obsequio");
		este=this;
		setBounds(100, 100, 507, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad minima de resmas adquiridas");
		lblNewLabel.setBounds(10, 11, 232, 14);
		contentPane.add(lblNewLabel);
		
		txtCantMinima = new JTextField();
		txtCantMinima.setBounds(252, 7, 100, 20);
		contentPane.add(txtCantMinima);
		txtCantMinima.setColumns(10);
		
		txtObsequio = new JTextField();
		txtObsequio.setColumns(10);
		txtObsequio.setBounds(252, 35, 100, 20);
		contentPane.add(txtObsequio);
		
		JLabel lblA = new JLabel("obsequios");
		lblA.setBounds(10, 36, 232, 14);
		contentPane.add(lblA);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(JObsequio.class.getResource("/images/ok16.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Main.cantidadObsequiable=Integer.parseInt(txtCantMinima.getText().trim());
				Main.obsequio=txtObsequio.getText().trim();
				Utiles.mensaje="";
				int aux=Utiles.validarEntero(txtCantMinima, "Cantidad Minima obsequiable");
				if(aux!=-1){
					Main.cantidadObsequiable=aux;
					JOptionPane.showMessageDialog(null, "Configuracion Guardada!!!");
				}else{
					JOptionPane.showMessageDialog(null, Utiles.mensaje,"Error",JOptionPane.ERROR_MESSAGE);
				} 				 
			}
		});
		btnAceptar.setBounds(362, 7, 119, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(JObsequio.class.getResource("/images/cancel16.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				este.setVisible(false);
			}
		});
		btnCancelar.setBounds(362, 32, 119, 23);
		contentPane.add(btnCancelar);		
		
		txtCantMinima.setText(Main.cantidadObsequiable+"");
		txtObsequio.setText(Main.obsequio);
		
		this.setLocationRelativeTo(null);
		
	}
}
