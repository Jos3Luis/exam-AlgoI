package pkgAyuda;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JPanelAyuda extends JPanel { 
	private static final long serialVersionUID = 1L;
	 
	public JPanelAyuda() {
		setBackground(Color.WHITE);
		
		JLabel lblTienda = new JLabel("TIENDA");
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTienda.setForeground(new Color(0, 0, 0));
		
		JSeparator separator = new JSeparator();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JPanelAyuda.class.getResource("/images/logo-cibertec.gif")));
		
		JLabel lblAutores = new JLabel("AUTORES");
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblJoseLuis = new JLabel("<html>\r\n- QUISPE ARACAYO, JOSE LUIS (COORDINADOR)<br />\r\n- MEZA OCHOA,  ANDY<br />\r\n- PARIONA VILCHEZ, ROSMEL<br />\r\n- ESPINOZA CADILLO, DEYVIS<br />\r\n- CHUQUIVILCA ALEJO, ANA JNOSELYN<br />\r\n\r\n</html>");
		lblJoseLuis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(lblTienda, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(36)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblJoseLuis, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblAutores, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lblTienda, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(21)
									.addComponent(lblAutores, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addComponent(lblJoseLuis, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
