/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Diego Mendez
 */
public class DibujaDardos extends JPanel {
    Random r=new Random();
    int x;
    int y;
    Dardo punto;
    public DibujaDardos(){
        
    }
    

    
    public void paint(Graphics g){
        super.paint(g);  
        g.drawRect(0, 0, 501, 501);
        g.setColor(Color.black);
        g.fillOval(0, 0, 501, 501);
        g.setColor(Color.white);
        g.fillOval(50, 50, 399, 399);
        g.setColor(Color.black);
        g.fillOval(100, 100, 299, 299);
        g.setColor(Color.white);
        g.fillOval(150, 150, 199, 199);
        g.setColor(Color.black);
        g.fillOval(200, 200, 99, 99);
        g.setColor(Color.red);
        g.fillOval(235, 235, 29, 29);
        g.setColor(Color.blue);
        
           for (int i =0; i <DardosGraf.dardos.size(); i++) {
                punto=DardosGraf.dardos.get(i);
                x=punto.getX();
                y=punto.getY();
            
             g.fillOval(x,y, 7, 7);
             repaint();
        } 
        
        
       
 
 
    }
    

}

