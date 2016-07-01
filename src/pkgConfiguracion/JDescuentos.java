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

public class JDescuentos extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt15;
	private JTextField txt610;
	private JTextField txt1115;
	private JTextField txt15mas;
	
	private JDescuentos este;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDescuentos frame = new JDescuentos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public JDescuentos() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		//setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setTitle("Configurar descuentos\r");
		este=this;
		setBounds(100, 100, 472, 202);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1 a 5 resmas");
		lblNewLabel.setBounds(10, 11, 115, 14);
		contentPane.add(lblNewLabel);
		
		txt15 = new JTextField();
		txt15.setBounds(148, 7, 141, 20);
		contentPane.add(txt15);
		txt15.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(299, 10, 34, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(299, 38, 34, 14);
		contentPane.add(label_1);
		
		txt610 = new JTextField();
		txt610.setColumns(10);
		txt610.setBounds(148, 35, 141, 20);
		contentPane.add(txt610);
		
		JLabel lblA = new JLabel("6 a 10 resmas");
		lblA.setBounds(10, 39, 115, 14);
		contentPane.add(lblA);
		
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(299, 66, 34, 14);
		contentPane.add(label_3);
		
		txt1115 = new JTextField();
		txt1115.setColumns(10);
		txt1115.setBounds(148, 63, 141, 20);
		contentPane.add(txt1115);
		
		JLabel lblA_1 = new JLabel("11 a 15 resmas");
		lblA_1.setBounds(10, 67, 115, 14);
		contentPane.add(lblA_1);
		
		JLabel label_5 = new JLabel("%");
		label_5.setBounds(299, 94, 34, 14);
		contentPane.add(label_5);
		
		txt15mas = new JTextField();
		txt15mas.setColumns(10);
		txt15mas.setBounds(148, 91, 141, 20);
		contentPane.add(txt15mas);
		
		JLabel lblMasDe = new JLabel("Mas de 15 resmas");
		lblMasDe.setBounds(10, 95, 115, 14);
		contentPane.add(lblMasDe);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(JDescuentos.class.getResource("/images/ok16.png")));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utiles.mensaje="";
				
				String msgs="";
				double aux;
				aux=Utiles.validarReal(txt15, "1 a 5");
				if(aux!=-1){
					Main.porcentaje1=aux; 
				}else{
					msgs+=Utiles.mensaje;
				}
				aux=Utiles.validarReal(txt610, "6 a 10");
				if(aux!=-1){
					Main.porcentaje2=aux; 
				}else{
					msgs+=Utiles.mensaje;
				}
				aux=Utiles.validarReal(txt1115, "11 a 15");
				if(aux!=-1){
					Main.porcentaje3=aux; 
				}else{
					msgs+=Utiles.mensaje;
				}  
				aux=Utiles.validarReal(txt15mas, "15 a mas");
				if(aux!=-1){
					Main.porcentaje4=aux; 
				}else{
					msgs+=Utiles.mensaje;
				}
				
				if(msgs.equals("")){
					JOptionPane.showMessageDialog(null,"Configuracion Guardada Exitosamente!!");
				}else{
					msgs+="\n";
					JOptionPane.showMessageDialog(null, "Hubo Errores:\n\n"+msgs,"Error",JOptionPane.ERROR_MESSAGE);
				} 
			}
		});
		btnAceptar.setBounds(341, 11, 105, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(JDescuentos.class.getResource("/images/cancel16.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				este.setVisible(false);
			}
		});
		btnCancelar.setBounds(343, 45, 103, 23);
		contentPane.add(btnCancelar);
		
		txt15.setText(Main.porcentaje1+"");
		txt610.setText(Main.porcentaje2+"");
		txt1115.setText(Main.porcentaje3+"");
		txt15mas.setText(Main.porcentaje4+"");		
		
		this.setLocationRelativeTo(null);
		
	}
}
