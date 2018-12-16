package castillo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Castillo extends JFrame {
	public static void main(String[] args) {	
		Castillo ventana = new Castillo("Castillo medieval");
		Panel mipanel = new Panel();
		mipanel.setBackground(Color.white);
		ventana.add(mipanel);		
	}
	
	public Castillo(String titulo){
		super(titulo);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
class Panel extends JPanel{	
	public void paint(Graphics g){		
		super.paint(g);						
		//colores 
		Color negro = new Color(0,2,3);
		Color azul = new Color(107,194,224);
		Color azul2 = new Color(26,98,121);
		Color gris = new Color(216,224,235);
		Color cafe = new Color(84,84,84);
		Color amarillo = new Color(248,203,12);
		Color rojo = new Color(204,53,34);
		Color tierra = new Color(80,40,0);
		//fondo		
		Graphics2D q = (Graphics2D) g;
		GradientPaint Gradient = new GradientPaint(0, 0,amarillo,getWidth() ,getHeight(),rojo);		
		q.setPaint(Gradient);		 
		q.fillRect(0, 0, getWidth(), getHeight());
		//arreglos de puntos
		int coordenadasX[];
        int coordenadasY[];
        int nPuntos=0;
        //ladrillos
        BufferedImage dibujo = new BufferedImage( 8, 8, BufferedImage.TYPE_INT_RGB );
		Graphics2D g2DDibujo = dibujo.createGraphics();
		Rectangle2D.Double rectangulo = new Rectangle2D.Double( 0, 0, 8, 8 );
		g2DDibujo.setColor( Color.WHITE );
		g2DDibujo.fill( rectangulo );
		g2DDibujo.setColor( new Color(190,200,220));
		rectangulo = new Rectangle2D.Double( 0, 1, 4, 3 );
		g2DDibujo.fill( rectangulo );
		rectangulo = new Rectangle2D.Double( 5, 1, 3, 3 );
		g2DDibujo.fill( rectangulo );
		rectangulo = new Rectangle2D.Double( 1, 5, 7, 3 );
		g2DDibujo.fill( rectangulo );
		TexturePaint relleno = new TexturePaint( dibujo, new Rectangle2D.Double( 0, 0, 25, 15 ) );
		
		
		//torre principal       
		//techo de la torre principal        
		coordenadasX=new int[]{536,515,534,590,643,660,641};
        coordenadasY=new int[]{310,310,295,179,295,310,310};
        nPuntos=7;                
        q.setColor(azul);        
        GradientPaint paint = new GradientPaint(584, 212,azul, 635, 300,azul2);
        q.setPaint(paint);
		q.fillPolygon(coordenadasX, coordenadasY, nPuntos);
		q.setColor(Color.black);
		q.setStroke(new BasicStroke(new Float(2)));
		q.drawLine(534,310,515,310);		
		q.drawLine(515,310,534,295);
		q.drawLine(534,295,590,179);
		q.drawLine(590,179,643,295);
		q.drawLine(643,295,660,310);
		q.drawLine(660,310,641,310);
		
		//base de la torre principal				
		q.setPaint( relleno );
		q.fillRect(536,308,104,324);		
		q.setColor(Color.black);		
		q.drawArc(287,305,600,600,80,20);
		q.drawLine(535,633,535,310);
		q.drawLine(639,633,639,310);	
		
		//sol
		q.setColor(Color.yellow);
		q.fillOval(-30, -30, 100, 100);
		//tierra
		q.setColor(tierra);
		q.fillRect(0,633 , 1500, 633);
		//torre principal izquierda t1
		q.setColor(negro);
		q.setStroke(new BasicStroke(3));
		q.drawLine(0, 633, 1500, 633);
		q.setStroke(new BasicStroke(new Float(2.6)));
		//techo de la torre t1		
		coordenadasX=new int[]{241,222,237,295,348,363,345};
        coordenadasY=new int[]{416,416,401,286,401,416,416};
        nPuntos=7;                
        q.setColor(azul);                     
        paint = new GradientPaint(275, 337,azul, 335,411,azul2);
        q.setPaint(paint);
        q.fillPolygon(coordenadasX, coordenadasY, nPuntos);
		
		//base de la rorre t1
		q.setStroke(new BasicStroke(2));				
		q.setPaint( relleno );
		q.fillRect(241, 413,104,219);
		
		//contorno de la torre t1
		q.setColor(Color.black);		
		q.drawLine(241, 416, 222, 416);
		q.drawLine(222, 416, 237, 401);
		q.drawLine(237, 401, 295, 286);
		q.drawLine(295, 286, 348, 401);
		q.drawLine(348, 401, 363, 416);
		q.drawLine(363, 416, 345, 416);		
		q.setStroke(new BasicStroke(new Float(2.5)));
		q.drawLine(241, 633, 241, 416);				
		g.drawArc(3,411,580,580,80,20);
				
		//edificios de la parte izquierda
		q.setStroke(new BasicStroke(1));		
		q.setPaint( relleno );
		q.fillRect(344, 519,190,113 );									
		paint = new GradientPaint(411, 487,azul, 505,516,azul2);
        q.setPaint(paint);
		q.fillRect(345, 485,189,34);
		
		q.setStroke(new BasicStroke(new Float(2.5)));
		q.setColor(Color.black);
		q.drawLine(344, 416, 344, 633);					
		q.setPaint( relleno );
		q.fillRect(375, 365,159,120);
				
		q.setStroke(new BasicStroke(new Float(1.4)));
		q.setColor(Color.black);
		g.drawLine(344, 519, 534, 519);
		
		q.setStroke(new BasicStroke(new Float(1.5)));
		g.drawLine(346, 485, 533, 485);		
		q.setColor(negro);
		g.drawLine(375, 483, 375, 365);
		g.drawLine(375, 365, 533, 365);
				
		coordenadasX=new int[]{375,359,386,534,534};
        coordenadasY=new int[]{365,365,322,322,365};
        nPuntos=5;                
        q.setColor(azul);
        Polygon x1= new Polygon(coordenadasX, coordenadasY, nPuntos);
        paint = new GradientPaint(433, 423,azul, 531,360,azul2);
        q.setPaint(paint);
		q.fillPolygon(x1);				
		//torre pequeña de la parte izquierda t2		
		coordenadasX=new int[]{418,406,416,435,454,462,451};
        coordenadasY=new int[]{269,269,256,198,256,269,269};
        nPuntos=7;                
        q.setColor(azul);
        //techo de la torre t2
        Polygon x3= new Polygon(coordenadasX, coordenadasY, nPuntos);
        paint = new GradientPaint(425, 240,azul, 459,258,azul2);
        q.setPaint(paint);
		q.fillPolygon(x3);
		q.setColor(negro);
        q.drawPolygon(x3);
        //base de la torre t2                
        q.setPaint( relleno );
		q.fillRect(418,266,33,56);
		//contorno de la torre t2
		q.setColor(negro);
		q.setStroke(new BasicStroke(new Float(1.5)));
		q.drawPolygon(x1);
		q.drawArc(298,265,275,275,80,20);
		
		q.drawLine(418,322,418,268);
		q.drawLine(452,322,452,268);		
		
		//edificios de la parte derecha
		q.setStroke(new BasicStroke(1));		
		q.setPaint( relleno );
		q.fillRect(640, 519,190,113);
		q.setColor(negro);
						
		q.setColor(azul);
		paint = new GradientPaint(733, 488,azul, 640,517,azul2);
        q.setPaint(paint);
		q.fillRect(640, 485,190,34);
		q.setColor(Color.black);
		q.drawLine(639,519,829,519);			
			
		q.setStroke(new BasicStroke(2));		
		q.setPaint( relleno );
		q.fillRect(640, 365,159,119);
		q.setColor(negro);
		q.drawLine(798,364,798,485);
		
		q.setColor(Color.black);
		q.drawLine(640,485,828,485);
		
		coordenadasX=new int[]{640,640,790,815};
        coordenadasY=new int[]{365,322,322,365};
        nPuntos=4;                
        q.setColor(azul);
        Polygon x4= new Polygon(coordenadasX, coordenadasY, nPuntos);
        paint = new GradientPaint(720, 364,azul, 641,360,azul2);
        q.setPaint(paint);
		q.fillPolygon(x4);
		q.setColor(negro);
		q.setStroke(new BasicStroke(new Float(1.5)));
		q.drawPolygon(x4);
		
		
		
		//torre pequeña de la parte derecha t3		
		coordenadasX=new int[]{727,715,725,744,763,771,760};
		coordenadasY=new int[]{269,269,256,198,256,269,269};
		nPuntos=7;                
		q.setColor(azul);
		//techo de la torre t3
		Polygon x5= new Polygon(coordenadasX, coordenadasY, nPuntos);
		paint = new GradientPaint(735, 239,azul, 768,268,azul2);
        q.setPaint(paint);
		q.fillPolygon(x5);
		q.setColor(negro);
		q.drawPolygon(x5);
		//base de la torre t3     		
		q.setPaint( relleno );
		q.fillRect(727,266,33,55);
		//contorno de la torre t3
		q.setColor(negro);
		q.setStroke(new BasicStroke(new Float(1.5)));
		q.drawArc(607,265,275,275,80,20);
		
		q.drawLine(727,322,727,268);
		q.drawLine(761,322,761,268);
		
				
		//torre principal derecha t4					
		q.setStroke(new BasicStroke(new Float(2.6)));		
		//techo de la torre t4		
		coordenadasX=new int[]{829,810,825,883,936,951,933};
		coordenadasY=new int[]{416,416,401,286,401,416,416};
		nPuntos=7;                
		q.setColor(azul);
		Polygon x6= new Polygon(coordenadasX, coordenadasY, nPuntos);
		paint = new GradientPaint(850, 365,azul, 930,414,azul2);
        q.setPaint(paint);
		q.fillPolygon(x6);
		
		//base de la rorre t4
		q.setStroke(new BasicStroke(2));				
		q.setPaint( relleno );
		q.fillRect(829, 413,104,219);
		
		//contorno de la torre t4
		q.setColor(Color.black);		
		q.drawLine(829, 416, 810, 416);
		q.drawLine(810, 416, 825, 401);
		q.drawLine(825, 401, 883, 286);
		q.drawLine(883, 286, 936, 401);
		q.drawLine(936, 401, 951, 416);
		q.drawLine(951, 416, 933, 416);		
		q.setStroke(new BasicStroke(new Float(2.5)));
		q.drawLine(829, 633, 829, 416);
		q.drawLine(933,416,933,633);
		g.drawArc(591,411,580,580,80,20);
		
		
		
		//puerta de la torre principal					
		q.setColor(cafe);
		q.fillRect(571,584,31,48);		
		q.fillOval(571, 572, 31, 31);
		
		q.setColor(negro);			
		q.drawLine(571,613,602,613);
		q.drawLine(571,592,602,592);
		q.drawLine(571,633,571,584);
		q.drawLine(602,633,602,584);
		g.drawArc(571,571,31,31,0,180);
		g.drawLine(577,632,577,575);
		g.drawLine(583,632,583,571);
		g.drawLine(589,633,589,572);
		g.drawLine(595,633,595,573);
		
		
		//ventanas de la torre t1					
		q.setColor(cafe);
		q.fillRect(250,415,7,18);				
		q.setColor(negro);
		q.drawRect(250,415,7,18);
							
		q.setColor(cafe);
		q.fillRect(275,414,7,18);				
		q.setColor(negro);
		q.drawRect(275,414,7,18);
							
		q.setColor(cafe);
		q.fillRect(302,413,7,18);				
		q.setColor(negro);
		q.drawRect(302,413,7,18);
							
		q.setColor(cafe);
		q.fillRect(330,415,7,18);				
		q.setColor(negro);
		q.drawRect(330,415,7,18);
				
		q.setColor(negro);
		q.fillOval(274,484, 9, 9);
		q.setColor(cafe);				
		q.fillRect(275,487,7,18);				
		q.setColor(negro);
		q.drawRect(275,487,7,18);
					
		q.setColor(negro);
		q.fillOval(303,559, 9, 9);
		q.setColor(cafe);
		q.fillRect(304,562,7,18);				
		q.setColor(negro);
		q.drawRect(304,562,7,18);
		
		
		//ventanas de la torre t4		
		q.setColor(negro);
		q.fillOval(891,559, 9, 9);
		q.setColor(cafe);
		q.fillRect(892,562,7,18);				
		q.setColor(negro);
		q.drawRect(892,562,7,18);
				
		q.setColor(negro);
		q.fillOval(863,484, 9, 9);
		q.setColor(cafe);				
		q.fillRect(864,487,7,18);				
		q.setColor(negro);
		q.drawRect(864,487,7,18);
							
		q.setColor(cafe);
		q.fillRect(838,415,7,18);				
		q.setColor(negro);
		q.drawRect(838,415,7,18);
							
		q.setColor(cafe);
		q.fillRect(864,413,7,18);				
		q.setColor(negro);
		q.drawRect(864,413,7,18);
							
		q.setColor(cafe);
		q.fillRect(891,413,7,18);				
		q.setColor(negro);
		q.drawRect(891,413,7,18);
							
		q.setColor(cafe);
		q.fillRect(918,414,7,18);				
		q.setColor(negro);
		q.drawRect(918,414,7,18);
		
		//ventanas de la torre principal					
		q.setColor(cafe);
		q.fillRect(543,414,7,18);				
		q.setColor(negro);
		q.drawRect(543,414,7,18);
							
		q.setColor(cafe);
		q.fillRect(569,414,7,18);				
		q.setColor(negro);
		q.drawRect(569,414,7,18);
							
		q.setColor(cafe);
		q.fillRect(596,414,7,18);				
		q.setColor(negro);
		q.drawRect(596,414,7,18);
							
		q.setColor(cafe);
		q.fillRect(623,414,7,18);				
		q.setColor(negro);
		q.drawRect(623,414,7,18);
				
		q.setColor(negro);
		q.fillOval(583,362, 9, 9);
		q.setColor(cafe);
		q.fillRect(584,365,7,18);				
		q.setColor(negro);
		q.drawRect(584,365,7,18);
				
		q.setColor(negro);
		q.fillOval(583,485, 9, 9);
		q.setColor(cafe);
		q.fillRect(584,488,7,18);				
		q.setColor(negro);
		q.drawRect(584,488,7,18);
							
		q.setColor(cafe);
		q.fillRect(542,309,7,18);				
		q.setColor(negro);
		q.drawRect(542,309,7,18);
							
		q.setColor(cafe);
		q.fillRect(570,307,7,18);				
		q.setColor(negro);
		q.drawRect(570,307,7,18);
							
		q.setColor(cafe);
		q.fillRect(596,307,7,18);				
		q.setColor(negro);
		q.drawRect(596,307,7,18);
							
		q.setColor(cafe);
		q.fillRect(624,309,7,18);				
		q.setColor(negro);
		q.drawRect(624,309,7,18);
		//rombo de la torre principal
		q.setStroke(new BasicStroke(new Float(1.5)));	
		q.setColor(azul);
		coordenadasX=new int[]{520,530,642,653};
        coordenadasY=new int[]{414,400,400,414};
        nPuntos=4;
		Polygon x7= new Polygon(coordenadasX, coordenadasY, nPuntos);
		paint = new GradientPaint(508, 412,azul, 647,412,azul2);
        q.setPaint(paint);
		q.fillPolygon(x7);
		q.setColor(negro);
		q.drawPolygon(x7);
		
		
		//ventana de la torre t2		
		q.setColor(negro);
		q.fillOval(430,275, 9, 9);
		q.setColor(cafe);
		q.fillRect(431,278,7,18);				
		q.setColor(negro);
		q.drawRect(431,278,7,18);
		
		//ventana de la torre t3		
		q.setColor(negro);
		q.fillOval(739,275, 9, 9);
		q.setColor(cafe);
		q.fillRect(740,278,7,18);				
		q.setColor(negro);
		q.drawRect(740,278,7,18);
		
		//ventanas de los edificios de la prte izquierda	
		q.setColor(negro);
		q.fillOval(361,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(362,534,7,18);				
		q.setColor(negro);
		q.drawRect(362,534,7,18);
				
		q.setColor(negro);
		q.fillOval(399,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(400,534,7,18);				
		q.setColor(negro);
		q.drawRect(400,534,7,18);
			
		q.setColor(negro);
		q.fillOval(436,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(437,534,7,18);				
		q.setColor(negro);
		q.drawRect(437,534,7,18);
				
		q.setColor(negro);
		q.fillOval(472,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(473,534,7,18);				
		q.setColor(negro);
		q.drawRect(473,534,7,18);
	
		q.setColor(negro);
		q.fillOval(510,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(511,534,7,18);				
		q.setColor(negro);
		q.drawRect(511,534,7,18);
					
		q.setColor(negro);
		q.fillOval(361,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(362,584,7,10);				
		q.setColor(negro);
		q.drawRect(362,584,7,10);
				
		q.setColor(negro);
		q.fillOval(399,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(400,584,7,10);				
		q.setColor(negro);
		q.drawRect(400,584,7,10);
			
		q.setColor(negro);
		q.fillOval(436,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(437,584,7,10);				
		q.setColor(negro);
		q.drawRect(437,584,7,10);
				
		q.setColor(negro);
		q.fillOval(473,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(474,584,7,10);				
		q.setColor(negro);
		q.drawRect(474,584,7,10);
				
		q.setColor(negro);
		q.fillOval(510,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(511,584,7,10);				
		q.setColor(negro);
		q.drawRect(511,584,7,10);
				
		q.setColor(negro);
		q.fillOval(392,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(393,466,7,10);				
		q.setColor(negro);
		q.drawRect(393,466,7,10);
				
		q.setColor(negro);
		q.fillOval(430,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(431,466,7,10);				
		q.setColor(negro);
		q.drawRect(431,466,7,10);
				
		q.setColor(negro);
		q.fillOval(467,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(468,466,7,10);				
		q.setColor(negro);
		q.drawRect(468,466,7,10);
				
		q.setColor(negro);
		q.fillOval(504,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(505,466,7,10);				
		q.setColor(negro);
		q.drawRect(505,466,7,10);
				
		q.setColor(negro);
		q.fillOval(395,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(396,383,7,18);				
		q.setColor(negro);
		q.drawRect(396,383,7,18);
				
		q.setColor(negro);
		q.fillOval(432,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(433,383,7,18);				
		q.setColor(negro);
		q.drawRect(433,383,7,18);
				
		q.setColor(negro);
		q.fillOval(469,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(470,383,7,18);				
		q.setColor(negro);
		q.drawRect(470,383,7,18);
				
		q.setColor(negro);
		q.fillOval(507,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(508,383,7,18);				
		q.setColor(negro);
		q.drawRect(508,383,7,18);
		
		//ventanas de los edificios de la prte derecha
		q.setColor(negro);
		q.fillOval(656,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(657,534,7,18);				
		q.setColor(negro);
		q.drawRect(657,534,7,18);
				
		q.setColor(negro);
		q.fillOval(694,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(695,534,7,18);				
		q.setColor(negro);
		q.drawRect(695,534,7,18);
				
		q.setColor(negro);
		q.fillOval(731,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(732,534,7,18);				
		q.setColor(negro);
		q.drawRect(732,534,7,18);
				
		q.setColor(negro);
		q.fillOval(767,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(768,534,7,18);				
		q.setColor(negro);
		q.drawRect(768,534,7,18);
		
		q.setColor(negro);
		q.fillOval(805,531, 9, 9);
		q.setColor(cafe);
		q.fillRect(806,534,7,18);				
		q.setColor(negro);
		q.drawRect(806,534,7,18);
						
		q.setColor(negro);
		q.fillOval(656,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(657,584,7,10);				
		q.setColor(negro);
		q.drawRect(657,584,7,10);
				
		q.setColor(negro);
		q.fillOval(694,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(695,584,7,10);				
		q.setColor(negro);
		q.drawRect(695,584,7,10);
				
		q.setColor(negro);
		q.fillOval(731,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(732,584,7,10);				
		q.setColor(negro);
		q.drawRect(732,584,7,10);
				
		q.setColor(negro);
		q.fillOval(768,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(769,584,7,10);				
		q.setColor(negro);
		q.drawRect(769,584,7,10);
				
		q.setColor(negro);
		q.fillOval(805,581, 9, 9);
		q.setColor(cafe);
		q.fillRect(806,584,7,10);				
		q.setColor(negro);
		q.drawRect(806,584,7,10);
				
		q.setColor(negro);
		q.fillOval(662,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(663,466,7,10);				
		q.setColor(negro);
		q.drawRect(663,466,7,10);
				
		q.setColor(negro);
		q.fillOval(700,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(701,466,7,10);				
		q.setColor(negro);
		q.drawRect(701,466,7,10);
				
		q.setColor(negro);
		q.fillOval(737,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(738,466,7,10);				
		q.setColor(negro);
		q.drawRect(738,466,7,10);
			
		q.setColor(negro);
		q.fillOval(774,463, 9, 9);
		q.setColor(cafe);
		q.fillRect(775,466,7,10);				
		q.setColor(negro);
		q.drawRect(775,466,7,10);
				
		q.setColor(negro);
		q.fillOval(660,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(661,383,7,18);				
		q.setColor(negro);
		q.drawRect(661,383,7,18);
				
		q.setColor(negro);
		q.fillOval(697,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(698,383,7,18);				
		q.setColor(negro);
		q.drawRect(698,383,7,18);
				
		q.setColor(negro);
		q.fillOval(734,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(735,383,7,18);				
		q.setColor(negro);
		q.drawRect(735,383,7,18);
				
		q.setColor(negro);
		q.fillOval(772,380, 9, 9);
		q.setColor(cafe);
		q.fillRect(773,383,7,18);				
		q.setColor(negro);
		q.drawRect(773,383,7,18);
			
		//banderas
		q.setStroke(new BasicStroke(new Float(2.6)));
		coordenadasX=new int[]{295,295,310,305,310,295};
		coordenadasY=new int[]{288,264,264,269,274,274};
		nPuntos=6;                
		q.setColor(negro);
		Polygon x8= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x8);
		q.setColor(Color.white);
		q.fillPolygon(x8);
		
		
		q.setColor(negro);
		coordenadasX=new int[]{883,883,898,893,898,883};
		coordenadasY=new int[]{288,264,264,269,274,274};				
		Polygon x9= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x9);
		q.setColor(Color.white);
		q.fillPolygon(x9);
		
		q.setColor(negro);
		coordenadasX=new int[]{435,435,457,451,457,435};
		coordenadasY=new int[]{203,182,182,188,194,194};				
		Polygon x10= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x10);
		q.setColor(Color.white);
		q.fillPolygon(x10);
		
		q.setColor(negro);
		coordenadasX=new int[]{744,744,766,760,766,744};
		coordenadasY=new int[]{203,182,182,188,194,194};				
		Polygon x11= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x11);
		q.setColor(Color.white);
		q.fillPolygon(x11);
		
		q.setColor(negro);
		coordenadasX=new int[]{590,590,607,601,606,590};
		coordenadasY=new int[]{181,158,158,163,168,168};				
		Polygon x12= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x12);
		q.setColor(Color.white);
		q.fillPolygon(x12);
		
		q.setColor(negro);
		nPuntos=5;   
		coordenadasX=new int[]{160,160,153,168,160};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x13= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x13);
		q.drawLine(160,565,160,573);		
		
		
		coordenadasX=new int[]{187,187,180,195,187};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x14= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x14);
		q.drawLine(187,565,187,573);				
		
		
		coordenadasX=new int[]{214,214,207,222,214};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x15= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x15);
		q.drawLine(214,565,214,573);	
		q.setColor(gris);
		q.setStroke(new BasicStroke(new Float(3)));
		q.fillPolygon(x13);
		q.fillPolygon(x14);
		q.fillPolygon(x15);
						
		
		q.setColor(negro);
		coordenadasX=new int[]{958,958,951,966,958};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x16= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x16);
		q.drawLine(958,565,958,573);		
		
		
		coordenadasX=new int[]{985,985,978,993,985};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x17= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x17);
		q.drawLine(985,565,985,573);				
		
		
		coordenadasX=new int[]{1012,1012,1005,1020,1012};
		coordenadasY=new int[]{632,610,573,573,610};				
		Polygon x18= new Polygon(coordenadasX, coordenadasY, nPuntos);
		q.drawPolygon(x18);
		q.drawLine(1012,565,1012,573);	
		q.setColor(gris);		
		q.fillPolygon(x16);
		q.fillPolygon(x17);
		q.fillPolygon(x18);
		
		//detalles de los edificios de la izquierda
		q.setColor(negro);
		q.setStroke(new BasicStroke(new Float(2)));		
		g.drawArc(365,608,80,80,20,140);
		g.drawArc(440,608,80,80,20,140);
		q.setStroke(new BasicStroke(new Float(5)));
		g.drawArc(375,614,60,55,20,140);
		g.drawArc(450,614,60,55,20,140);		
		
		//detalles de los edificios de la parte derecha
		q.setStroke(new BasicStroke(new Float(2)));		
		g.drawArc(656,608,80,80,20,140);
		g.drawArc(731,608,80,80,20,140);
		q.setStroke(new BasicStroke(new Float(5)));
		g.drawArc(666,614,60,55,20,140);
		g.drawArc(741,614,60,55,20,140);
		
		//detalles de las torres
		q.setStroke(new BasicStroke(new Float(1.4)));		
		q.drawLine(428, 220, 442, 220);
		q.drawLine(738, 220, 751, 220);		
		q.setStroke(new BasicStroke(new Float(2)));
		q.drawLine(287, 302, 302, 302);
		q.drawLine(875, 302, 890, 302);
		q.drawLine(582, 197, 596, 197);
		g.drawArc(-34,398,654,654,80,20);
		g.drawArc(554,398,654,654,80,20);
		g.drawArc(279,290,620,620,80,20);
		q.drawLine(241, 452, 344, 452);
		q.drawLine(829, 452, 933, 452);
		q.drawLine(535, 452, 638, 452);
		q.drawLine(535, 344, 638, 344);
		//torre izquierda
		q.drawLine(241, 506, 250, 506);
		q.drawLine(241, 514, 256, 514);
		q.drawLine(241, 522, 249, 522);
		q.drawLine(241, 528, 256, 528);
		q.drawLine(241, 534, 249, 534);
		q.drawLine(241, 542, 256, 542);
		q.drawLine(241, 548, 250, 548);
		q.drawLine(241, 555, 256, 555);
		q.drawLine(241, 562, 250, 562);
		q.drawLine(241, 569, 256, 569);
		q.drawLine(272, 525, 281, 525);
		q.drawLine(280, 532, 296, 532);
		q.drawLine(273, 612, 290, 612);
		q.drawLine(260, 620, 278, 620);
		
		q.drawLine(335, 465, 344, 465);
		q.drawLine(328, 471, 344, 471);
		q.drawLine(335, 478, 344, 478);
		q.drawLine(328, 485, 344, 485);
		q.drawLine(335, 492, 344, 492);
		q.drawLine(328, 499, 344, 499);
		q.drawLine(335, 506, 344, 506);
		q.drawLine(328, 513, 344, 513);
		q.drawLine(335, 520, 344, 520);
		q.drawLine(328, 527, 344, 527);
		q.drawLine(335, 534, 344, 534);
		q.drawLine(328, 541, 344, 541);
		q.drawLine(335, 548, 344, 548);
		q.drawLine(328, 555, 344, 555);
		q.drawLine(335, 562, 344, 562);
		q.drawLine(328, 568, 344, 568);
		q.drawLine(335, 586, 344, 586);
		q.drawLine(328, 592, 344, 592);
		q.drawLine(335, 600, 344, 600);
		q.drawLine(328, 606, 344, 606);
		q.drawLine(335, 613, 344, 613);
		q.drawLine(328, 620, 344, 620);
		
		//torre derecha
		q.drawLine(923, 465, 932, 465);
		q.drawLine(916, 471, 932, 471);
		q.drawLine(923, 478, 932, 478);
		q.drawLine(916, 485, 932, 485);
		q.drawLine(923, 492, 932, 492);
		q.drawLine(916, 499, 932, 499);
		q.drawLine(923, 506, 932, 506);
		q.drawLine(916, 513, 932, 513);
		q.drawLine(923, 520, 932, 520);
		q.drawLine(916, 527, 932, 527);
		q.drawLine(923, 534, 932, 534);
		q.drawLine(916, 541, 932, 541);
		q.drawLine(923, 548, 932, 548);
		q.drawLine(916, 555, 932, 555);
		q.drawLine(923, 562, 932, 562);
		q.drawLine(916, 568, 932, 568);
		q.drawLine(923, 586, 932, 586);
		q.drawLine(916, 592, 932, 592);
		q.drawLine(923, 600, 932, 600);
		q.drawLine(916, 606, 932, 606);
		q.drawLine(923, 613, 932, 613);
		q.drawLine(916, 620, 932, 620);
		
		q.drawLine(829, 506, 838, 506);
		q.drawLine(829, 514, 844, 514);
		q.drawLine(829, 522, 837, 522);
		q.drawLine(829, 528, 844, 528);
		q.drawLine(829, 534, 837, 534);
		q.drawLine(829, 542, 844, 542);
		q.drawLine(829, 548, 838, 548);
		q.drawLine(829, 555, 844, 555);
		q.drawLine(829, 562, 838, 562);
		q.drawLine(829, 569, 844, 569);
		q.drawLine(860, 525, 869, 525);
		q.drawLine(869, 532, 884, 532);
		q.drawLine(861, 612, 878, 612);
		q.drawLine(848, 620, 866, 620);
				
		//torre principal
		q.drawLine(535, 506, 544, 506);
		q.drawLine(535, 514, 550, 514);
		q.drawLine(535, 522, 543, 522);
		q.drawLine(535, 528, 550, 528);
		q.drawLine(535, 534, 543, 534);
		q.drawLine(535, 542, 550, 542);
		q.drawLine(535, 548, 544, 548);
		q.drawLine(535, 555, 550, 555);
		q.drawLine(535, 562, 544, 562);
		q.drawLine(535, 569, 550, 569);
				
		q.drawLine(629, 465, 638, 465);
		q.drawLine(622, 471, 638, 471);
		q.drawLine(629, 478, 638, 478);
		q.drawLine(622, 485, 638, 485);
		q.drawLine(629, 492, 638, 492);
		q.drawLine(622, 499, 638, 499);
		q.drawLine(629, 506, 638, 506);
		q.drawLine(622, 513, 638, 513);
		q.drawLine(629, 520, 638, 520);
		q.drawLine(622, 527, 638, 527);
		q.drawLine(629, 534, 638, 534);
		q.drawLine(622, 541, 638, 541);
		q.drawLine(629, 548, 638, 548);
		q.drawLine(622, 555, 638, 555);
		q.drawLine(629, 562, 638, 562);
		q.drawLine(622, 568, 638, 568);
		q.drawLine(629, 586, 638, 586);
		q.drawLine(622, 592, 638, 592);
		q.drawLine(629, 600, 638, 600);
		q.drawLine(622, 606, 638, 606);
		q.drawLine(629, 613, 638, 613);
		q.drawLine(622, 620, 638, 620);
		
		q.drawLine(535, 355, 550, 355);
		q.drawLine(535, 363, 542, 363);
		q.drawLine(535, 371, 550, 371);
		q.drawLine(629, 355, 638, 355);
		q.drawLine(621, 363, 639, 363);
		q.drawLine(629, 369, 638, 369);
		q.drawLine(621, 376, 639, 376);
		q.drawLine(629, 383, 638, 383);		
		q.drawLine(556, 391, 569, 391);
		q.drawLine(570, 384, 577, 384);
		q.drawLine(577, 391, 590, 391);
		
		//detalles de edificios de la parte izquierda
		q.drawLine(350, 491, 365, 491);
		q.drawLine(350, 499, 358, 499);
		q.drawLine(350, 505, 365, 505);
		q.drawLine(350, 513, 357, 513);
		
		q.drawLine(514, 491, 529, 491);
		q.drawLine(521, 499, 529, 499);
		q.drawLine(514, 505, 529, 505);
		q.drawLine(521, 512, 529, 512);
		
		q.drawLine(376, 412, 391, 412);
		q.drawLine(376, 420, 385, 420);
		q.drawLine(376, 427, 391, 427);
		q.drawLine(376, 433, 385, 433);
		
		q.drawLine(413, 334, 510, 334);
		q.drawLine(458, 340, 510, 340);
		q.drawLine(413, 348, 510, 348);
		q.drawLine(458, 354, 510, 354);
		
		q.drawLine(375, 445, 534, 445);
		q.drawLine(375, 457, 534, 457);		
		q.drawLine(382, 445, 382, 457);
		q.drawLine(387, 445, 387, 457);
		q.drawLine(392, 445, 392, 457);
		q.drawLine(397, 445, 397, 457);
		q.drawLine(402, 445, 402, 457);
		q.drawLine(407, 445, 407, 457);
		q.drawLine(412, 445, 412, 457);
		q.drawLine(417, 445, 417, 457);
		q.drawLine(422, 445, 422, 457);
		q.drawLine(427, 445, 427, 457);
		q.drawLine(432, 445, 432, 457);
		q.drawLine(437, 445, 437, 457);
		q.drawLine(442, 445, 442, 457);
		q.drawLine(447, 445, 447, 457);
		q.drawLine(452, 445, 452, 457);
		q.drawLine(457, 445, 457, 457);
		q.drawLine(462, 445, 462, 457);
		q.drawLine(467, 445, 467, 457);
		q.drawLine(472, 445, 472, 457);
		q.drawLine(477, 445, 477, 457);
		q.drawLine(482, 445, 482, 457);
		q.drawLine(487, 445, 487, 457);
		q.drawLine(492, 445, 492, 457);
		q.drawLine(497, 445, 497, 457);
		q.drawLine(502, 445, 502, 457);
		q.drawLine(507, 445, 507, 457);
		q.drawLine(512, 445, 512, 457);
		q.drawLine(517, 445, 517, 457);
		q.drawLine(522, 445, 522, 457);
		q.drawLine(527, 445, 527, 457);
		q.drawLine(532, 445, 532, 457);
		
		
		q.drawLine(344, 560, 534, 560);
		q.drawLine(344, 572, 534, 572);		
		q.drawLine(352, 560, 352, 572);
		q.drawLine(357, 560, 357, 572);
		q.drawLine(362, 560, 362, 572);
		q.drawLine(367, 560, 367, 572);
		q.drawLine(372, 560, 372, 572);
		q.drawLine(377, 560, 377, 572);
		q.drawLine(382, 560, 382, 572);
		q.drawLine(387, 560, 387, 572);
		q.drawLine(392, 560, 392, 572);
		q.drawLine(397, 560, 397, 572);
		q.drawLine(402, 560, 402, 572);
		q.drawLine(407, 560, 407, 572);
		q.drawLine(412, 560, 412, 572);
		q.drawLine(417, 560, 417, 572);
		q.drawLine(422, 560, 422, 572);
		q.drawLine(427, 560, 427, 572);
		q.drawLine(432, 560, 432, 572);
		q.drawLine(437, 560, 437, 572);
		q.drawLine(442, 560, 442, 572);
		q.drawLine(447, 560, 447, 572);
		q.drawLine(452, 560, 452, 572);
		q.drawLine(457, 560, 457, 572);
		q.drawLine(462, 560, 462, 572);
		q.drawLine(467, 560, 467, 572);
		q.drawLine(472, 560, 472, 572);
		q.drawLine(477, 560, 477, 572);
		q.drawLine(482, 560, 482, 572);
		q.drawLine(487, 560, 487, 572);
		q.drawLine(492, 560, 492, 572);
		q.drawLine(497, 560, 497, 572);
		q.drawLine(502, 560, 502, 572);
		q.drawLine(507, 560, 507, 572);
		q.drawLine(512, 560, 512, 572);
		q.drawLine(517, 560, 517, 572);
		q.drawLine(522, 560, 522, 572);
		q.drawLine(527, 560, 527, 572);
		q.drawLine(532, 560, 532, 572);
		//detalles de edificios de la parte derecha
		q.drawLine(645, 491, 660, 491);
		q.drawLine(645, 499, 653, 499);
		q.drawLine(645, 505, 660, 505);
		q.drawLine(645, 513, 653, 513);
		
		q.drawLine(809, 491, 824, 491);
		q.drawLine(816, 499, 824, 499);
		q.drawLine(809, 505, 824, 505);
		q.drawLine(816, 512, 824, 512);
		
		q.drawLine(779, 412, 796, 412);
		q.drawLine(786, 420, 796, 420);
		q.drawLine(779, 427, 796, 427);
		q.drawLine(786, 433, 796, 433);
		
		q.drawLine(666, 334, 763, 334);
		q.drawLine(666, 340, 717, 340);
		q.drawLine(666, 348, 763, 348);
		q.drawLine(666, 354, 717, 354);
		
		q.drawLine(639, 445, 798, 445);
		q.drawLine(639, 457, 798, 457);		
		q.drawLine(382+260, 445, 382+260, 457);
		q.drawLine(382+264, 445, 382+264, 457);
		q.drawLine(387+264, 445, 387+264, 457);
		q.drawLine(392+264, 445, 392+264, 457);
		q.drawLine(397+264, 445, 397+264, 457);
		q.drawLine(402+264, 445, 402+264, 457);
		q.drawLine(407+264, 445, 407+264, 457);
		q.drawLine(412+264, 445, 412+264, 457);
		q.drawLine(417+264, 445, 417+264, 457);
		q.drawLine(422+264, 445, 422+264, 457);
		q.drawLine(427+264, 445, 427+264, 457);
		q.drawLine(432+264, 445, 432+264, 457);
		q.drawLine(437+264, 445, 437+264, 457);
		q.drawLine(442+264, 445, 442+264, 457);
		q.drawLine(447+264, 445, 447+264, 457);
		q.drawLine(452+264, 445, 452+264, 457);
		q.drawLine(457+264, 445, 457+264, 457);
		q.drawLine(462+264, 445, 462+264, 457);
		q.drawLine(467+264, 445, 467+264, 457);
		q.drawLine(472+264, 445, 472+264, 457);
		q.drawLine(477+264, 445, 477+264, 457);
		q.drawLine(482+264, 445, 482+264, 457);
		q.drawLine(487+264, 445, 487+264, 457);
		q.drawLine(492+264, 445, 492+264, 457);
		q.drawLine(497+264, 445, 497+264, 457);
		q.drawLine(502+264, 445, 502+264, 457);
		q.drawLine(507+264, 445, 507+264, 457);
		q.drawLine(512+264, 445, 512+264, 457);
		q.drawLine(517+264, 445, 517+264, 457);
		q.drawLine(522+264, 445, 522+264, 457);
		q.drawLine(527+264, 445, 527+264, 457);
		q.drawLine(532+264, 445, 532+264, 457);
		
		q.drawLine(639, 560, 829, 560);
		q.drawLine(639, 572, 829, 572);		
		q.drawLine(352+295, 560, 352+295, 572);
		q.drawLine(357+295, 560, 357+295, 572);
		q.drawLine(362+295, 560, 362+295, 572);
		q.drawLine(367+295, 560, 367+295, 572);
		q.drawLine(372+295, 560, 372+295, 572);
		q.drawLine(377+295, 560, 377+295, 572);
		q.drawLine(382+295, 560, 382+295, 572);
		q.drawLine(387+295, 560, 387+295, 572);
		q.drawLine(392+295, 560, 392+295, 572);
		q.drawLine(397+295, 560, 397+295, 572);
		q.drawLine(402+295, 560, 402+295, 572);
		q.drawLine(407+295, 560, 407+295, 572);
		q.drawLine(412+295, 560, 412+295, 572);
		q.drawLine(417+295, 560, 417+295, 572);
		q.drawLine(422+295, 560, 422+295, 572);
		q.drawLine(427+295, 560, 427+295, 572);
		q.drawLine(432+295, 560, 432+295, 572);
		q.drawLine(437+295, 560, 437+295, 572);
		q.drawLine(442+295, 560, 442+295, 572);
		q.drawLine(447+295, 560, 447+295, 572);
		q.drawLine(452+295, 560, 452+295, 572);
		q.drawLine(457+295, 560, 457+295, 572);
		q.drawLine(462+295, 560, 462+295, 572);
		q.drawLine(467+295, 560, 467+295, 572);
		q.drawLine(472+295, 560, 472+295, 572);
		q.drawLine(477+295, 560, 477+295, 572);
		q.drawLine(482+295, 560, 482+295, 572);
		q.drawLine(487+295, 560, 487+295, 572);
		q.drawLine(492+295, 560, 492+295, 572);
		q.drawLine(497+295, 560, 497+295, 572);
		q.drawLine(502+295, 560, 502+295, 572);
		q.drawLine(507+295, 560, 507+295, 572);
		q.drawLine(512+295, 560, 512+295, 572);
		q.drawLine(517+295, 560, 517+295, 572);
		q.drawLine(522+295, 560, 522+295, 572);
		q.drawLine(527+295, 560, 527+295, 572);
		q.drawLine(532+295, 560, 532+295, 572);
		
	}

}






