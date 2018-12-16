package simulacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D.Double;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buffon extends JFrame {
	static Vector<Line2D.Double>lineas;	
	static int vec[];
	static int v;
	static String p="0.0";
	static JFrame ventana;
	static JTextField cant;
	static JButton lanzar;
	static boolean f=false;
	static int contador;
	static JLabel pi2;	
        
	public static void main(String[] args) {
		iniventana();
		lineas=new Vector<Line2D.Double>(1);	
	}
	public static void iniventana(){
            
		ventana = new JFrame();
		ventana.setVisible(true);
		ventana.setResizable(false);	
		ventana.setBounds(260,60 , 806, 550);
		ventana.setTitle("Experimento de Buffon");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		JPanel panel2 = new JPanel();
		
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		ventana.setLayout(null);
		panel.setBounds(0, 0, 800, 360);
		panel2.setBounds(0, 360,800, 550);
		panel2.setLayout(null);
		ventana.add(panel);
		ventana.add(panel2);
		
		
		
		JPanel panelint1 = new JPanel();
		JPanel panelint2 = new JPanel();
		JPanel panelint3 = new JPanel();
		
		panel2.add(panelint1);
		panelint1.setBounds(0, 0, 220, 190);		
		
		panel2.add(panelint2);
		panelint2.setBounds(220, 0, 350, 190);		
		
		
	    panel2.add(panelint3);
	    panelint3.setBounds(550, 0, 250, 190);	 
	    
		
	    panelint1.setLayout(null);
	    JLabel agujas = new JLabel("Cuantas agujas quieres lanzar?");
	    panelint1.add(agujas);
	    agujas.setBounds(40, 80,180,40);
			    	    
	    cant = new JTextField();	
		panelint1.add(cant);
		cant.setBounds(40, 60, 160, 25);
		
		OyenteLanzar oyentelanzar = new OyenteLanzar();
		
		panelint2.setLayout(null);
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(oyentelanzar);
		panelint2.add(lanzar);
		lanzar.setBounds(60, 50, 110,60);
		
		OyenteBorrar oyenteborrar = new OyenteBorrar();
		JButton borrar = new JButton("Borrar");
		borrar.addActionListener(oyenteborrar);
		panelint2.add(borrar);
		borrar.setBounds(210, 50, 110,60);
		
		panelint3.setLayout(null);
		JLabel pi=new JLabel("El valor actual de pi es:");
		panelint3.add(pi);
		pi.setBounds(40, 20, 130, 50);
		
		pi2=new JLabel(p);		
		panelint3.add(pi2);
		pi2.setBounds(50, 60, 60, 30);
		
		
	}
	

}
class OyenteLanzar implements ActionListener{
             GraficoSimpleLin miventana;
	
	public void actionPerformed(ActionEvent e) {
		try {
			Buffon.f=true;	
			String x=Buffon.cant.getText();
			int y=Integer.parseInt(x);
			Buffon.v=y;
			for (int i = 0; i < y; i++) {
				Line2D.Double linea=Panel.linea();
				Buffon.lineas.addElement(linea);
			}
			Buffon.lanzar.setEnabled(false);	
			Buffon.ventana.repaint();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog( null, "Escribe cuantas agujas quieres lanzar "  );
		}
		Buffon.vec= new int[Buffon.v];
		miventana=new GraficoSimpleLin();         
	        miventana.setSize(450,450);
	        miventana.setVisible(true);
	        
	        
	}
	
}
class OyenteBorrar implements ActionListener{
	public void actionPerformed(ActionEvent e){		
		Buffon.lanzar.setEnabled(true);
		Buffon.lineas.removeAllElements();
		Buffon.ventana.repaint();
		Buffon.contador=0;
		Buffon.pi2.setText("0.0");	
		
	}
}
