package simulacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JPanel;

public class Panel extends JPanel {
	public void panel(){
		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawLine(100, 0, 100,360);
        g.drawLine(200, 0, 200,360);
        g.drawLine(300, 0, 300,360);
        g.drawLine(400, 0, 400,360);
        g.drawLine(500, 0, 500,360);
        g.drawLine(600, 0, 600,360);
        g.drawLine(700, 0, 700,360);
        Line2D linea=null;
        Line2D.Double linea1= new Line2D.Double(100,0,100,360);
		Line2D.Double linea2= new Line2D.Double(200,0,200,360);
		Line2D.Double linea3= new Line2D.Double(300,0,300,360);
		Line2D.Double linea4= new Line2D.Double(400,0,400,360);
		Line2D.Double linea5= new Line2D.Double(500,0,500,360);
		Line2D.Double linea6= new Line2D.Double(600,0,600,360);
		Line2D.Double linea7= new Line2D.Double(700,0,700,360);	
		double s=0;
        if (Buffon.f==true) {
        	for (int i = 0; i < Buffon.lineas.size(); i++) {
        		linea=linea();        		        		
            	int x1=(int) linea.getP1().getX();
            	int y1=(int) linea.getP1().getY();
            	int x2=(int) linea.getP2().getX();
            	int y2=(int) linea.getP2().getY();
            	if (!(linea.intersectsLine(linea1)||linea.intersectsLine(linea2)||linea.intersectsLine(linea3)||linea.intersectsLine(linea4)||linea.intersectsLine(linea5)||linea.intersectsLine(linea6)||linea.intersectsLine(linea7))) {
            		g.drawLine(x1, y1, x2, y2);  
            		String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea1)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;			    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea2)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;	    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea3)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea4)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea5)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;	    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea6)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;	    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}
            	if (linea.intersectsLine(linea7)) {
            		g.setColor(Color.red);
    				g.drawLine(x1, y1, x2, y2);
    				Buffon.contador++;
    				String x=Buffon.cant.getText();
    				double y=Double.parseDouble(x);	
    				s=(2*y)/Buffon.contador;	    				
    				Buffon.pi2.setText(Buffon.p=String.valueOf(s));
				}        
            	Buffon.vec[i]=Buffon.contador;
            	g.setColor(Color.black);
            	
    		}
		}
        
        
        
        
	}
	
	public static Line2D.Double linea(){
		Random rn = new Random();
		int x=(int)(rn.nextDouble()*800);
		int y=(int)(rn.nextDouble()*360);
				
		int x2;	
		int y2;
		
		do {
			
			 double angulo = Math.toRadians(rn.nextInt(360));
			
			y2=(int) (Math.cos(angulo)*100+y);
			x2=(int) (Math.sin(angulo)*100+x);
		} while (x2>=800||x2<=0||y2>=360||y2<0);	
		
		Line2D.Double linea = new Line2D.Double( x,y,x2,y2);			
		
		return linea;
	}
	
	
}
