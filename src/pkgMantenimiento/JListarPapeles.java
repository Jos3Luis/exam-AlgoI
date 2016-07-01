package pkgMantenimiento;
 
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon; 

public class JListarPapeles extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JListarPapeles este;
	private JTextArea txtLista;
	 
	public void setMensaje(String mensaje) {
		txtLista.setText(mensaje);
		txtLista.setCaretPosition(0);
	}
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListarPapeles frame = new JListarPapeles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public JListarPapeles() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		este=this;
		setTitle("..:: Listar Papel ::..");
		setBounds(100, 100, 545, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 529, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 529, 196);
		panel.add(scrollPane);
		
		txtLista = new JTextArea();
		scrollPane.setViewportView(txtLista);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(JListarPapeles.class.getResource("/images/cerrar16.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				este.setVisible(false);
			}
		});
		btnCerrar.setBounds(10, 207, 99, 23);
		panel.add(btnCerrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setIcon(new ImageIcon(JListarPapeles.class.getResource("/images/list16.png")));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tab="\t";
				String msg="LISTADO DE PAPELES\n\n"
						+ "Marca"+tab+": " +Main.marca0+"\n"
						+ "Dimensiones"+tab+": " +Main.dimensiones0+"\n"
						+ "Gramaje"+tab+": " +Main.gramaje0+"\n"
						+ "Blancura"+tab+": " +Main.blancura0+"\n"
						+ "Precio"+tab+": " +Main.precio0+"\n"
						+ "\n"
						+ "Marca"+tab+": " +Main.marca1+"\n"
						+ "Dimensiones"+tab+": " +Main.dimensiones1+"\n"
						+ "Gramaje"+tab+": " +Main.gramaje1+"\n"
						+ "Blancura"+tab+": " +Main.blancura1+"\n"
						+ "Precio"+tab+": " +Main.precio1+"\n"
						+ "\n"
						+ "Marca"+tab+": " +Main.marca2+"\n"
						+ "Dimensiones"+tab+": " +Main.dimensiones2+"\n"
						+ "Gramaje"+tab+": " +Main.gramaje2+"\n"
						+ "Blancura"+tab+": " +Main.blancura2+"\n"
						+ "Precio"+tab+": " +Main.precio2+"\n"
						+ "\n"
						+ "Marca"+tab+": " +Main.marca3+"\n"
						+ "Dimensiones"+tab+": " +Main.dimensiones3+"\n"
						+ "Gramaje"+tab+": " +Main.gramaje3+"\n"
						+ "Blancura"+tab+": " +Main.blancura3+"\n"
						+ "Precio"+tab+": " +Main.precio3+"\n"
						+ "\n"	
						+ "Marca"+tab+": " +Main.marca4+"\n"
						+ "Dimensiones"+tab+": " +Main.dimensiones4+"\n"
						+ "Gramaje"+tab+": " +Main.gramaje4+"\n"
						+ "Blancura"+tab+": " +Main.blancura4+"\n"
						+ "Precio"+tab+": " +Main.precio4+"\n";
				txtLista.setText(msg);
				txtLista.setCaretPosition(0);
			}
		});
		btnListar.setBounds(119, 207, 99, 23);
		panel.add(btnListar);
		setLocationRelativeTo(null);
	}
}
