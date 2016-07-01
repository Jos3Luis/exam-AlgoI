package pkgReportes;

 
import java.awt.EventQueue;
 
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pkgMain.Main;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;  
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent; 

public class JReportes extends JDialog {
 
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JReportes este;
	private JComboBox<String> cbxMarca;
	private JEditorPane jepLista;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JReportes frame = new JReportes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	public JReportes() {
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		este=this;
		setTitle("..:: Reportes ::..");
		setBounds(100, 100, 545, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 529, 251);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setIcon(new ImageIcon(JReportes.class.getResource("/images/cerrar16.png")));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				este.setVisible(false);
			}
		});
		btnCerrar.setBounds(417, 11, 102, 23);
		panel.add(btnCerrar);
		
		cbxMarca = new JComboBox<>();
		cbxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String msg="";
				switch (cbxMarca.getSelectedIndex()) {
				case 0:msg=getVentaxMarca(); break;
				case 1:msg=getMarcasVentaOptima(); break;				
				case 2:msg=getPreciosMenores85(); break;
				case 3:msg=getPreciosMayores85(); break;
				case 4:msg=getMenorMayorPromedio(); break;
				default:
					break;
				}
				jepLista.setText(msg);
				jepLista.setCaretPosition(0);
			}
		});
		cbxMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Ventas por marca", "Marcas con venta \u00F3ptima", "Marcas con precios menores al 85% del precio m\u00E1ximo", "Marcas con precios mayores al 85% del precio m\u00E1ximo", "Precios menor, mayor y promedio"}));
		cbxMarca.setBounds(10, 12, 391, 20);
		panel.add(cbxMarca);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(10, 43, 509, 197);
		panel.add(scrollPane_1);
		
		jepLista = new JEditorPane();
		jepLista.setContentType("text/html");
		scrollPane_1.setViewportView(jepLista);
		
		cbxMarca.setSelectedIndex(1);
		cbxMarca.setSelectedIndex(0);
		
		setLocationRelativeTo(null);
	}
	private String getMenorMayorPromedio(){
		String marcas="<span style='font-family:Tahoma;color:gray;margin:0px;padding:0px;font-size:14px'><u>MAYOR, MENOR, PROMEDIO</u></span>"
				+ "<table style='font-family:Tahoma;color:gray;margin:0px'>";		
		 
		marcas+="<tr><td>Gramaje Promedio</td><td>: "+promedio(Main.gramaje0,Main.gramaje1,Main.gramaje2,Main.gramaje3,Main.gramaje4)+" g/m²</td></tr>"
				+ "<tr><td>Gramaje Minimo</td><td>: "+getMinimo(Main.gramaje0,Main.gramaje1,Main.gramaje2,Main.gramaje3,Main.gramaje4)+" g/m²</td></tr>"
				+ "<tr><td>Gramaje Maximo</td><td>: "+getMaximo(Main.gramaje0,Main.gramaje1,Main.gramaje2,Main.gramaje3,Main.gramaje4)+" g/m²</td></tr>"
				+ "<tr><td colspan='2'></td></tr>"
				+ "<tr><td>Blancura Promedio</td><td>: "+promedio(Main.blancura0,Main.blancura1,Main.blancura2,Main.blancura3,Main.blancura4)+"</td></tr>"
				+ "<tr><td>Blancura Minimo</td><td>: "+getMinimo(Main.blancura0,Main.blancura1,Main.blancura2,Main.blancura3,Main.blancura4)+"</td></tr>"
				+ "<tr><td>Blancura Maximo</td><td>: "+getMaximo(Main.blancura0,Main.blancura1,Main.blancura2,Main.blancura3,Main.blancura4)+"</td></tr>"
				+ "<tr><td colspan='2'></td></tr>"
				+ "<tr><td>Precio Promedio</td><td>: "+promedio(Main.precio0,Main.precio1,Main.precio2,Main.precio3,Main.precio4)+"</td></tr>"
				+ "<tr><td>Precio Minimo</td><td>: "+getMinimo(Main.precio0,Main.precio1,Main.precio2,Main.precio3,Main.precio4)+"</td></tr>"
				+ "<tr><td>Precio Maximo</td><td>: "+getMaximo(Main.precio0,Main.precio1,Main.precio2,Main.precio3,Main.precio4)+"</td></tr>"
				+ "<tr><td colspan='2'></td></tr>"
				+ "</table>";
		return marcas;
	}
	private double promedio(double num1,double num2, double num3,double num4,double num5){
		return ((num1+num2+num3+num4+num5)/5);
	}
	private double getMaximo(double num1,double num2, double num3,double num4,double num5){
		double aux=num1;
		if(aux<num2)
			aux=num2;
		if(aux<num3)
			aux=num3;
		if(aux<num4)
			aux=num4;
		if(aux<num5)
			aux=num5;
		return aux;
	}
	private double getMinimo(double num1,double num2, double num3,double num4,double num5){
		double aux=num1;
		if(aux>num2)
			aux=num2;
		if(aux>num3)
			aux=num3;
		if(aux>num4)
			aux=num4;
		if(aux>num5)
			aux=num5;
		return aux;
	}
	private double getMaximo85(){		 
		return (getMaximo(Main.precio0,Main.precio1,Main.precio2,Main.precio3,Main.precio4)*0.85);
	}
	private String getPreciosMayores85(){
		double max=getMaximo85();
		String marcas="<span style='font-family:Tahoma;color:gray;margin:0px;padding:0px;font-size:12px'><u>MARCAS CON PRECIOS MAYORES AL 85% DEL PRECIO MAXIMO</u></span>"
				+ "<table style='font-family:Tahoma;color:gray;margin:0px'>";
		int contador=0;
		if(Main.precio0>max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca0+"</td></tr>";
			contador++;
		}
		if(Main.precio1>max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca1+"</td></tr>";
			contador++;
		}
		if(Main.precio2>max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca2+"</td></tr>";
			contador++;
		}
		if(Main.precio3>max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca3+"</td></tr>";
			contador++;
		}
		if(Main.precio4>max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca4+"</td></tr>";
			contador++;
		}
		marcas+="<tr><td colspan='2'><hr></td></tr>"
				+ "<tr><td>85% del precio maximo</td><td>: S/."+max+"</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "<tr><td>Numero de marcas</td><td>: "+contador+"</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "</table>";
		return marcas;
	}
	private String getPreciosMenores85(){
		//obtencion del precio maximo
		double max=getMaximo85();
				
		String marcas="<span style='font-family:Tahoma;color:gray;margin:0px;padding:0px;font-size:12px'><u>MARCAS CON PRECIOS MENORES AL 85% DEL PRECIO MAXIMO</u></span>"
				+ "<table style='font-family:Tahoma;color:gray;margin:0px'>";
		int contador=0;
		if(Main.precio0<max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca0+"</td></tr>";
			contador++;
		}
		if(Main.precio1<max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca1+"</td></tr>";
			contador++;
		}
		if(Main.precio2<max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca2+"</td></tr>";
			contador++;
		}
		if(Main.precio3<max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca3+"</td></tr>";
			contador++;
		}
		if(Main.precio4<max){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca4+"</td></tr>";
			contador++;
		}
		marcas+="<tr><td colspan='2'><hr></td></tr>"
				+ "<tr><td>85% del precio maximo</td><td>: S/."+max+"</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "<tr><td>Numero de marcas</td><td>: "+contador+"</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "</table>";
		return marcas;
	}
	private String getMarcasVentaOptima(){
		String marcas="<span style='font-family:Tahoma;color:gray;margin:0px;padding:0px;font-size:14px'><u>MARCAS POR VENTA OPTIMA</u></span>"
				+ "<table style='font-family:Tahoma;color:gray;margin:0px'>";		
		if(Main.cantClassBond>=Main.cantidadTotalOptima){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca0+"</td></tr>"
					+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantClassBond+"</td></tr>";
		}
		if(Main.cantCopyPremium>=Main.cantidadTotalOptima){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca1+"</td></tr>" 
					+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantCopyPremium+"</td></tr>";
		}
		if(Main.cantMasterBond>=Main.cantidadTotalOptima){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca2+"</td></tr>" 
					+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantMasterBond+"</td></tr>";
		}
		if(Main.cantVisionBond>=Main.cantidadTotalOptima){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca3+"</td></tr>" 
					+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantVisionBond+"</td></tr>";
		}
		if(Main.cantCopyPaper>=Main.cantidadTotalOptima){
			marcas+="<tr><td>Marca</td><td>: "+Main.marca4+"</td></tr>" 
					+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantCopyPaper+"</td></tr>";
		}
		marcas+="</table>";
		return marcas;
	}
	private String getVentaxMarca(){
		return ("<span style='font-family:Tahoma;color:gray;margin:0px;padding:0px;font-size:14px'><u>VENTA POR MARCA</u></span>"
				+ "<table style='font-family:Tahoma;color:gray;margin:0px'>"
				+ "<tr><td>Marca</td><td>: "+Main.marca0+"</td></tr>"
				+ "<tr><td>Cantidad Ventas</td><td>: "+Main.contClassBond+"</td></tr>"
				+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantClassBond+"</td></tr>"
				+ "<tr><td>Importe Total Acumulado</td><td>: "+Main.importeClassBond+"</td></tr>" 
				+ "<tr><td colspan='2'></td></tr>" 				
				+ "<tr><td>Marca</td><td>: "+Main.marca1+"</td></tr>"
				+ "<tr><td>Cantidad Ventas</td><td>: "+Main.contCopyPremium+"</td></tr>"
				+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantCopyPremium+"</td></tr>"
				+ "<tr><td>Importe Total Acumulado</td><td>: "+Main.importeCopyPremium+"</td></tr>"
				+ "<tr><td colspan='2'></td></tr>" 
				+ "<tr><td>Marca</td><td>: "+Main.marca2+"</td></tr>"
				+ "<tr><td>Cantidad Ventas</td><td>: "+Main.contMasterBond+"</td></tr>"
				+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantMasterBond+"</td></tr>"
				+ "<tr><td>Importe Total Acumulado</td><td>: "+Main.importeMasterBond+"</td></tr>"
				+ "<tr><td colspan='2'></td></tr>" 
				+ "<tr><td>Marca</td><td>: "+Main.marca3+"</td></tr>"
				+ "<tr><td>Cantidad Ventas</td><td>: "+Main.contVisionBond+"</td></tr>"
				+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantVisionBond+"</td></tr>"
				+ "<tr><td>Importe Total Acumulado</td><td>: "+Main.importeVisionBond+"</td></tr>"
				+ "<tr><td colspan='2'></td></tr>" 
				+ "<tr><td>Marca</td><td>: "+Main.marca4+"</td></tr>"
				+ "<tr><td>Cantidad Ventas</td><td>: "+Main.contCopyPaper+"</td></tr>"
				+ "<tr><td>Cantidad Total de Resmas Vendidas</td><td>: "+Main.cantCopyPaper+"</td></tr>"
				+ "<tr><td>Importe Total Acumulado</td><td>: "+Main.importeCopyPaper+"</td></tr>"
				
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "<tr><td>Importe Total Acumulado General</td><td>: "+(Main.importeCopyPaper + Main.importeClassBond+Main.importeCopyPremium+Main.importeMasterBond+Main.importeVisionBond)+"</td></tr>"
				+ "<tr><td colspan='2'><hr></td></tr>"
				+ "</table>");
	}
	@Override
	public void setVisible(boolean b) { 
		super.setVisible(b);
		this.repaint();
	}
}
