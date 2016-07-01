package pkgConfiguracion;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;
import pkgUtil.Utiles;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon; 

public class JPremioSorpresa extends JDialog { 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumCliente;
	private JTextField txtSorpresa;
	
	private JPremioSorpresa este;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPremioSorpresa frame = new JPremioSorpresa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JPremioSorpresa() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Configurar premio sorpresa\r");
		este=this;
		setBounds(100, 100, 417, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero Cliente");
		lblNewLabel.setBounds(10, 11, 100, 14);
		contentPane.add(lblNewLabel);
		
		txtNumCliente = new JTextField();
		txtNumCliente.setBounds(148, 11, 100, 20);
		contentPane.add(txtNumCliente);
		txtNumCliente.setColumns(10);
		
		txtSorpresa = new JTextField();
		txtSorpresa.setColumns(10);
		txtSorpresa.setBounds(148, 39, 100, 20);
		contentPane.add(txtSorpresa);
		
		JLabel lblA = new JLabel("Premio Sorpresa");
		lblA.setBounds(10, 39, 115, 14);
		contentPane.add(lblA);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(JPremioSorpresa.class.getResource("/images/ok16.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Main.numeroClienteSorpresa=Integer.parseInt(txtNumCliente.getText().trim());
				Main.obsequio=txtSorpresa.getText().trim();
								
				Utiles.mensaje="";
				int aux=Utiles.validarEntero(txtNumCliente, "Numero Cliente Sorpresa");
				if(aux!=-1){
					Main.numeroClienteSorpresa=aux;
					JOptionPane.showMessageDialog(null, "Configuracion Guardada!!!");
				}else{
					JOptionPane.showMessageDialog(null, Utiles.mensaje,"Error",JOptionPane.ERROR_MESSAGE);
				}   
			}
		});
		btnAceptar.setBounds(281, 11, 110, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(JPremioSorpresa.class.getResource("/images/cancel16.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				este.setVisible(false);
			}
		});
		btnCancelar.setBounds(283, 45, 108, 23);
		contentPane.add(btnCancelar);
		
		
		txtNumCliente.setText(Main.numeroClienteSorpresa+"");
		txtSorpresa.setText(Main.premioSorpresa);
		
		this.setLocationRelativeTo(null);
		
	}
}
