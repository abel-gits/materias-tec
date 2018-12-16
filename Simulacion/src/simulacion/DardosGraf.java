/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Diego Mendez
 */
public class DardosGraf extends JFrame implements ActionListener {
    DibujaDardos Panel1;
    JPanel Panel2;
    JLabel JLBtitulo,resultado;
    JButton JbnAceptar;
    JTextField jtxtdato;
    static Vector<Dardo> dardos = new Vector<Dardo>();
    int ejex,ejey;
    double pii=0;
    double h1,h2;
    double itera;
    double fuera,dentro;
    Random r=new Random();
    Dardo dardo;
    
    public DardosGraf(){
        super("DARDOS 2000");
        this.setSize(500,650);
        InitComponets();
        setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
        
    }
    
   

    private void InitComponets() {
     this.setLayout(new BorderLayout());
     Panel1= new DibujaDardos();
     Panel1.setBackground(Color.white);
     Panel1.setBounds(0,0,500,500);
    
     this.add(Panel1);
     Panel2=new JPanel();
     JLBtitulo=new JLabel("Inserte cuantos dardos quieres lanzar");
     resultado=new JLabel("");
     JbnAceptar=new JButton("Aceptar");
     jtxtdato=new JTextField(12);
     Panel2.add(JLBtitulo,BorderLayout.NORTH);
     Panel2.add(JbnAceptar,BorderLayout.CENTER);
     JbnAceptar.addActionListener(this);
     Panel2.add(jtxtdato,BorderLayout.NORTH);
     Panel2.setBounds(500,500,200,200);
     Panel2.add(resultado);
     this.add(Panel2,BorderLayout.SOUTH);
     
     
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==JbnAceptar)
        {
           itera=Integer.parseInt(jtxtdato.getText());
           for(int i=0;i<itera;i++){
                    
			ejex=(int)(r.nextInt(500));
			ejey=(int)(r.nextInt(500));
                        dardo= new Dardo(ejex,ejey);
                      
                        dardos.add(dardo);
                        
                       
			h1=Math.pow(250-ejex, 2)+Math.pow(250-ejey, 2);
			h2=Math.sqrt(h1);
			
				if(h2<=250)
					dentro++;
             
                    
        }
         
           pii=(dentro/itera)*4;
          Panel1.repaint();
          //resultado.setText(String.valueOf(pii));

           JOptionPane.showConfirmDialog(null,"Resultado: "+pii+"\n"+"Tiros Acertados: "+dentro,"Resultado",JOptionPane.CLOSED_OPTION);
           
           JFree jf=new JFree();
            jf.jfrech();
       }
         
    }
 
    
      public static void main(String[] a)
    {
        DardosGraf ventana= new DardosGraf();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
