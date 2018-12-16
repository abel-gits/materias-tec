/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

/**
 *
 * @author Diego Mendez
 */

import java.util.*;

import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;
import java.awt.event.*;
public class Metodosrandom extends JFrame implements ActionListener{
	JLabel TxtSeed,TxtIter,TxtMetodo;
	JTextField Seed,Iter;
	JButton BG,BC;
	JPanel P1,P2;
	ButtonGroup Grupo;
	JRadioButton MMC,MN;
	GridBagConstraints GBC;
	JTable table;
    JScrollPane tableContainer;
    TableColumn column = null,column1=null;
    Vector <String> columnas;
	Vector filas,fila;
	String seed,SC,SA="";
	long N,Cuadrado;
	int SLength,iter,op;
	char Car;
	Random R;
	boolean b=false;

	public Metodosrandom(){
		super("Números aleatorios");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz(){
		this.setLayout(new GridBagLayout());
		Grupo=new ButtonGroup();
		MMC=new JRadioButton("Medios Cuadrados");
		MN=new JRadioButton("Newman");
		Grupo.add(MMC);
		Grupo.add(MN);
		Seed = new JTextField(10);
		GBC = new GridBagConstraints();
		R = new Random();
		
		Tabla();
		Paneles();
	    setSize(500,550);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}
	public void HazEscuchas(){
		Seed.addActionListener(this);
		Iter.addActionListener(this);
		MMC.addActionListener(this);
		MN.addActionListener(this);
		BG.addActionListener(this);
		BC.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		//Enter en boton guardar
		InputMap enter = new InputMap();
		enter.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "pressed");
		enter.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "released");
		BC.setInputMap(0, enter);
		//Focus
		if (e.getSource() == Seed)
			Iter.requestFocus();
		if (e.getSource() == Iter)
			BC.requestFocus();
		//Radio
		if (e.getSource() == MMC){
			op=0;b=true;}
		if (e.getSource() == MN){
			op=1;b=true;}
		//Acciones de los botones
		if (e.getSource() == BG){
			BotonGenerar(op);
			if(b!=false)
				Iter.requestFocus();}
			//BotonGenerar();
		if (e.getSource() == BC)
			BotonCalcular(op);
	}
	//Accione de los botones
	public void BotonGenerar(int op){
		if (b==false){
			JOptionPane.showMessageDialog(null, "Seleccione un método" );MMC.requestFocus();return;}
		if (op==0){
			N=R.nextInt(8999)+1000;
			Seed.setText(""+N+"");
			return;
		}
		N=(long) Math.floor(Math.random() * 8999999999L) + 1000000000L;
		Seed.setText(""+N+"");
	}
	public void BotonCalcular(int op){
		if (b==false){
			JOptionPane.showMessageDialog(null, "Seleccione un método" );MMC.requestFocus();return;}
		if (Seed.getText().length()==0||Iter.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Llena los campos vacios" );
			if(Seed.getText().length()==0){
				Seed.requestFocus();return;}
			Iter.requestFocus();
			return;
		}
		if (op==0&&Seed.getText().length()!=4){
			JOptionPane.showMessageDialog(null, "No. de digitos inadecuados para este método" );Seed.requestFocus();return;}
		if (op==1&&Seed.getText().length()!=10){
			JOptionPane.showMessageDialog(null, "No. de digitos inadecuados para este método" );Seed.requestFocus();return;}
		//Recupera los datos de los TextField y envia para dar de alta
		seed = Seed.getText();
		iter = Integer.parseInt(Iter.getText());
		filas.clear();
		Metodo(0);
		table = new JTable(filas, columnas);
		remove(P2);
		add(P2,GBC);
		JOptionPane.showMessageDialog(null, "Valores generados correctamente" );
	}
	//////
	//Metodos de GUI
	public void Paneles(){
		P1 = new JPanel();
		P1.setLayout(new GridBagLayout());
		P2 = new JPanel();
		P2.setLayout(new GridLayout(0,1));
		//Panel 1
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.gridx = 0;
	    GBC.gridy = 0;
	    P1.add(TxtMetodo = new JLabel("Metodo", SwingConstants.CENTER), GBC);
	    GBC.gridy = 1;
	    P1.add(MMC,GBC);
	    GBC.gridy = 2;
	    P1.add(MN,GBC);
		GBC.gridx = 1;
	    GBC.gridy = 0;
	    P1.add(TxtSeed = new JLabel("Semilla", SwingConstants.CENTER), GBC);
	    GBC.gridy = 1;
	    P1.add(Seed=new JEnteroField(11), GBC);
	    Seed.setHorizontalAlignment(0);
	    GBC.gridy = 2;
	    P1.add(BG = new JButton("Generar Random"),GBC);
	    GBC.gridx = 2;
	    GBC.gridy = 0;
	    P1.add(TxtIter = new JLabel("Iteracciones", SwingConstants.CENTER), GBC);
	    GBC.gridy = 1;
	    P1.add(Iter=new JEnteroField(3), GBC);
	    Iter.setHorizontalAlignment(0);
	    GBC.gridy = 2;
	    P1.add(BC = new JButton("Calcular"),GBC);
	    GBC.gridy = 0;
	    add(P1,GBC);
	    //Panel 2
	    P2.add(tableContainer);
	    GBC.gridy = 1;
	    add(P2,GBC);
	}
	public void Tabla() {
		columnas = new Vector <String>();
		filas = new Vector();
		fila = new Vector();
		columnas.addElement("Semilla");
		columnas.addElement("Número Aleatorio");
		table = new JTable(filas, columnas);
        tableContainer = new JScrollPane(table);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setEnabled(false);
	}
	//////
	//Metodo
	public void Metodo(int n){
		if(iter==n)
			return;
		fila.addElement(seed);
		N=Long.parseLong(seed);
		Cuadrado=N*N;
		if(Cuadrado==0)
			return;
		SC=String.valueOf(Cuadrado);
		if(op==0){
			SLength=(SC.length()-4)/2;
			for (int i=SLength;i<SLength+4;i++){
				Car=SC.charAt(i);
				SA+=""+Car;}}
		else{
			SLength=(SC.length()-5)/2;
			for (int i=SLength;i<SLength+5;i++){
				Car=SC.charAt(i);
				SA+=""+Car;}}
		fila.addElement(SA);
		filas.addElement(fila);
		fila = new Vector();
		seed=SA;
		SA="";
		n++;
		Metodo(n);
	}
	public static void main(String [] a)  {
		Metodosrandom  Obj = new Metodosrandom();
    	Obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//Otras clases
class JEnteroField extends JTextField implements KeyListener {
	private int Tamano;
	public JEnteroField(int n) {
		super(n);
		Tamano = n;
		addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) {	}
	public void keyTyped(KeyEvent e) {
		if (getText().length() == Tamano)e.consume();
		else if (getText().length() != 0 && e.getKeyChar() == '-')e.consume();
		else if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == '-'))e.consume();
	}
}
