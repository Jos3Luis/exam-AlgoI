package pkgUtil; 
import javax.swing.JTextField;

public class Utiles {
	public static String mensaje;
	public static double validarReal(JTextField n,String label){
		mensaje="";
		try {
			double num= Double.parseDouble(n.getText().trim());
			if(num>=0){
				return num;
			}else{
				mensaje=" - Solo Numeros no Negativos en "+label+": "+n.getText()+"  \n"; 
			}
		} catch (Exception e) {
			mensaje= " - Error de Conversion Real en "+label+": "+n.getText()+"  \n"; 
		}
		return -1;
	}
	
	public static int validarEntero(JTextField n,String label){
		mensaje="";
		try {
			int num=Integer.parseInt(n.getText().trim());
			if(num>=0){
				return num;
			}else{
				mensaje= " - Solo Numeros no Negativos en "+label+": "+n.getText()+"  \n";
			}
		} catch (Exception e) {
			mensaje=" - Error de Conversion Entera en "+label+": "+n.getText()+"  \n";			
		}
		return -1;
	}
}
