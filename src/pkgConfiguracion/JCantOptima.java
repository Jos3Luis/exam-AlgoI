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

public class JCantOptima extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCantOptima;
	
	private JCantOptima este;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCantOptima frame = new JCantOptima();
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
	public JCantOptima() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Configurar cantidad \u00F3ptima de resmas vendidas\r");
		este=this;
		setBounds(100, 100, 478, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad Optima de resmas vendidas");
		lblNewLabel.setBounds(10, 15, 224, 14);
		contentPane.add(lblNewLabel);
		
		txtCantOptima = new JTextField();
		txtCantOptima.setBounds(244, 12, 81, 20);
		contentPane.add(txtCantOptima);
		txtCantOptima.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(JCantOptima.class.getResource("/images/ok16.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utiles.mensaje="";
				int aux=Utiles.validarEntero(txtCantOptima, "Cantidad Optima");
				if(aux!=-1){
					Main.cantidadTotalOptima=aux;
					JOptionPane.showMessageDialog(null, "Configuracion Guardada!!!");
				}else{
					JOptionPane.showMessageDialog(null, Utiles.mensaje,"Error",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnAceptar.setBounds(341, 11, 111, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(JCantOptima.class.getResource("/images/cancel16.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				este.setVisible(false);
			}
		});
		btnCancelar.setBounds(343, 45, 109, 23);
		contentPane.add(btnCancelar);
		
		
		txtCantOptima.setText(Main.cantidadTotalOptima+"");
		
		this.setLocationRelativeTo(null);
		
	}
}
