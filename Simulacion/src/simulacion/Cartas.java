package simulacion;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cartas 
{
	
		public static void main( String[] args )
		{
			JFrame miVentana = new JFrame("JUEGO DE CARTAS");			
			miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			miVentana.setVisible(true);
			miVentana.setSize(1200,750);			
			MiPanel juego = new MiPanel();			
			miVentana.add(juego);				
			miVentana.setSize(1200,780);
					
		}
}
	class MiPanel extends JPanel
	{
		JLabel[]  cartasJugador1;
		JLabel[]  cartasJugador2;
		JLabel[]  cartasJugador3;
		JLabel[]  cartasJugador4;
		static JButton jugar;
		JLabel jugador1;
		JLabel jugador2;
		JLabel jugador3;
		JLabel jugador4;
		JTextField juegos;
		
		ArrayList<Double> lista;
		Double[] mazo1;
		Double[] mazo2;
		Double[] mazo3;
		Double[] mazo4;
		Double[] mazoSeleccionado;
		
		public MiPanel ()
		{
			setLayout(null);
			MiOyente mioyente = new MiOyente();
							
			
			jugar = new JButton (" Jugar ");
			jugar.addActionListener(mioyente);
			add(jugar);
			jugar.setBounds(1060,20, 80, 30);
			
			juegos= new JTextField(10);			
			add(juegos);			
			juegos.setBounds(960,20, 100, 30);			
			
			JLabel et = new JLabel("Cuantas veces deseas jugar?");
			add(et);			
			et.setBounds(960,45, 180, 30);
		}
		public void paint(Graphics g) 
		{
			
			super.paint(g);
			ImageIcon vacio = new ImageIcon();
			ImageIcon mesa = new ImageIcon(("mesa.jpg"));
		
			//izquierda
			int x=5,y=-50;
			g.drawImage(mesa.getImage(), 0, 0, 920, 750, null);
			g.setColor(Color.RED);
			Font f1 = new Font( "Algerian", Font.PLAIN, 20 );
			g.setFont(f1);
			g.drawString("Jugador1",50,340);
			for(int i=0;i<10;i++)
			{
				y=y+70;
				if(mazo1!=null)
					vacio= new ImageIcon(String.valueOf(mazo1[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//derecha
			x=860;
			y=-50;
			g.drawString("Jugador2",750,340);
			for(int i=0;i<10;i++)
			{
				y=y+70;
				if(mazo2!=null)
					vacio= new ImageIcon(String.valueOf(mazo2[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//arriba
			x=50;
			y=20;
			g.drawString("Jugador3",400,100);
			for(int i=0;i<10;i++)
			{
				x=x+70;
				if(mazo3!=null)
					vacio= new ImageIcon(String.valueOf(mazo3[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//abajo
			x=50;
			y=650;
			g.drawString("Jugador4",400,640);
			for(int i=0;i<10;i++)
			{
				x=x+70;
				if(mazo4!=null)
					vacio= new ImageIcon(String.valueOf(mazo4[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//centro
			
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(String.valueOf(mazoSeleccionado[0])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 300, 310, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(String.valueOf(mazoSeleccionado[1])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 570, 310, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(String.valueOf(mazoSeleccionado[2])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 435, 200, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(String.valueOf(mazoSeleccionado[3])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 435, 420, 40, 60, null);
		}
		
		public void actualizar() 
		{
			Graphics g;
			g= MiPanel.this.getGraphics();
			ImageIcon vacio = new ImageIcon();
			ImageIcon mesa = new ImageIcon(("mesa.jpg"));
		
			//izquierda
			int x=5,y=-50;
			g.drawImage(mesa.getImage(), 0, 0, 920, 750, null);
			
			for(int i=0;i<10;i++)
			{
				y=y+70;
				if(mazo1!=null)
					vacio= new ImageIcon(String.valueOf(mazo1[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//derecha
			x=860;
			y=-50;
			for(int i=0;i<10;i++)
			{
				y=y+70;
				if(mazo2!=null)
					vacio= new ImageIcon(String.valueOf(mazo2[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//arriba
			x=50;
			y=20;
			for(int i=0;i<10;i++)
			{
				x=x+70;
				if(mazo3!=null)
					vacio= new ImageIcon(String.valueOf(mazo3[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//abajo
			x=50;
			y=650;
			for(int i=0;i<10;i++)
			{
				x=x+70;
				if(mazo4!=null)
					vacio= new ImageIcon(String.valueOf(mazo4[i])+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), x, y, 40, 60, null);
			}
			//centro
			
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(mazoSeleccionado[0]+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 300, 310, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(mazoSeleccionado[1]+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 570, 310, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(mazoSeleccionado[2]+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 435, 200, 40, 60, null);
				
				if(mazoSeleccionado!=null)
					vacio= new ImageIcon(mazoSeleccionado[3]+".jpg");
				else
					vacio = new ImageIcon(("color-blanco.png"));
				g.drawImage(vacio.getImage(), 435, 420, 40, 60, null);
				
			
			
		}
		class MiOyente implements ActionListener
		{
			int contVictTotJugador1=0;
			int contVictTotJugador2=0;
			int contVictTotJugador3=0;
			int contVictTotJugador4=0;
			public void actionPerformed(ActionEvent e) 
			{
			for(int j=0; j<Integer.valueOf(juegos.getText()); j++)
			{
				int contVictXPartJugador1=0;
				int contVictXPartJugador2=0;
				int contVictXPartJugador3=0;
				int contVictXPartJugador4=0;
				mazo1 = new Double[10];
				mazo2 = new Double[10];
				mazo3 = new Double[10];
				mazo4 = new Double[10];
				asignarCartas();
				mazoSeleccionado= new Double[4];
				
				for(int i=0;i<lista.size();i++)
				{
					if(i<10)
						mazo1[i]=lista.get(i);
					else
						if(i<20)
							mazo2[i-10]=lista.get(i);
						else
							if(i<30)
								mazo3[i-20]=lista.get(i);
							else 
								if(i<40)
									mazo4[i-30]=lista.get(i);
				}
				
				for(int f=0;f<10;f++) 
				{
					repaint();
					
					Double numCarta1= sacarCarta(mazo1);
					Double numCarta2= sacarCarta(mazo2);
					Double numCarta3= sacarCarta(mazo3);
					Double numCarta4= sacarCarta(mazo4);
					
					
					mazoSeleccionado[0]=numCarta1;
					mazoSeleccionado[1]=numCarta2;
					mazoSeleccionado[2]=numCarta3;
					mazoSeleccionado[3]=numCarta4;
					
										
					double mayor=0;
		
					if(numCarta1 > numCarta2 && numCarta1 > numCarta3 && numCarta1 > numCarta4)
					{
						mayor=numCarta1;
					}
					else
						if(numCarta2 > numCarta1 && numCarta2 > numCarta3 && numCarta2 > numCarta4)
						{
							mayor=numCarta2;
						}
						else
							if(numCarta3 > numCarta1 && numCarta3 > numCarta2 && numCarta3 > numCarta4)
							{
								mayor=numCarta3;
								
							}
							else
								if(numCarta4 > numCarta1 && numCarta4 > numCarta2 && numCarta4 > numCarta3)
								{
									mayor=numCarta4;
									
								}			
					
					if(mayor==numCarta1)
						contVictXPartJugador1++;
					if(mayor==numCarta2)
						contVictXPartJugador2++;
					if(mayor==numCarta3)
						contVictXPartJugador3++;
					if(mayor==numCarta4)
						contVictXPartJugador4++;
					
				
					try 
					{
						Thread.sleep(1000);
						
						actualizar();
					} catch (InterruptedException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}//fin del for de 10
				int mayor=0;
				if(contVictXPartJugador1 >contVictXPartJugador2 && contVictXPartJugador1 > contVictXPartJugador3 && contVictXPartJugador1 > contVictXPartJugador4)
				{
					mayor=1;
				}
				else
			    {
					if(contVictXPartJugador2 > contVictXPartJugador1 && contVictXPartJugador2 > contVictXPartJugador3 && contVictXPartJugador2 > contVictXPartJugador4)
			        {
						mayor=2;
			        }
					else
					{
						if(contVictXPartJugador3 > contVictXPartJugador1 && contVictXPartJugador3 > contVictXPartJugador2 && contVictXPartJugador3 > contVictXPartJugador4)
						{
							mayor=3;
						}
						else
						{
							mayor=4;
						}																																		
					}
				}
				if(mayor==1)
					contVictTotJugador1++;
				if(mayor==2)
					contVictTotJugador2++;
				if(mayor==3)
					contVictTotJugador3++;
				if(mayor==4)
					contVictTotJugador4++;
				contVictXPartJugador1=0;
				contVictXPartJugador2=0;
				contVictXPartJugador3=0;
				contVictXPartJugador4=0;
				
				
			}
			int x[]=new int[4];
			x[0]=contVictTotJugador1;
			x[1]=contVictTotJugador2;
			x[2]=contVictTotJugador3;
			x[3]=contVictTotJugador4;
			Arrays.sort(x);
																																				
			if (contVictTotJugador1==x[3]) {
				JOptionPane.showMessageDialog(null,"El ganador es el jugador 1");
			}
			if (contVictTotJugador2==x[3]) {
				JOptionPane.showMessageDialog(null,"El ganador es el jugador 2");
			}
			if (contVictTotJugador3==x[3]) {
				JOptionPane.showMessageDialog(null,"El ganador es el jugador 3");
			}
			if (contVictTotJugador4==x[3]) {
				JOptionPane.showMessageDialog(null,"El ganador es el jugador 4");
			}			
			DefaultPieDataset dataset = new DefaultPieDataset();
			dataset.setValue("Jugador 1",new Integer(contVictTotJugador1));
			dataset.setValue("Jugador 2",new Integer(contVictTotJugador2));
			dataset.setValue("Jugador 3",new Integer(contVictTotJugador3));
			dataset.setValue("Jugador 4",new Integer(contVictTotJugador4));
			
			JFreeChart chart = ChartFactory.createPieChart("Resultados",dataset,true,true,false);
			
			ChartPanel panel = new ChartPanel(chart);
			
			JFrame ventana = new JFrame("RESULTADOS");
			ventana.setVisible(true);
			ventana.setSize(800,600);
			
			ventana.add(panel);
			
			contVictTotJugador1=0;
			contVictTotJugador2=0;
			contVictTotJugador3=0;
			contVictTotJugador4=0;
			
			
			
			}
		}
		
		public void asignarCartas()
		{
			double carta=0;
			double tipo=0;
			int cont=0;
			double numeroRandomCarta;
			double numeroRandomTipo;
			lista = new ArrayList<Double>();
			do
			{
				numeroRandomTipo= Math.random();
				numeroRandomCarta= Math.random();
				
				if(numeroRandomTipo <= 0.25)
				{
					//Espadas
					tipo=0.4;
				}
				else
					if(numeroRandomTipo> 0.25 && numeroRandomTipo <=.50 )
					{
						//Bastos
						tipo=0.3;
					}
					else
						if(numeroRandomTipo> 0.50 && numeroRandomTipo <=.75 )
						{
							//Copas
							tipo=0.2;
						}
						else
						{
							//Oros
							tipo=0.1;
						}
			
				if(numeroRandomCarta <= 0.10)
				{
					carta=1;
				}
				else
					if(numeroRandomCarta> 0.10 && numeroRandomCarta <=.20 )
					{
						carta=2;
						
					}
					else
						if(numeroRandomCarta> 0.20 && numeroRandomCarta <=.30 )
						{
							carta=3;
						}
						else
							if(numeroRandomCarta> 0.30 && numeroRandomCarta <=.40 )
							{
								carta=4;
							}
							else
								if(numeroRandomCarta> 0.40 && numeroRandomCarta <=.50 )
								{
									carta=5;
								}
								else
									if(numeroRandomCarta> 0.50 && numeroRandomCarta <=.60 )
									{
										carta=6;
									}
									else
										if(numeroRandomCarta> 0.60 && numeroRandomCarta <=.70 )
										{
											carta=7;
										}
										else
											if(numeroRandomCarta> 0.70 && numeroRandomCarta <=.80 )
											{
												carta=10;
											}
											else
												if(numeroRandomCarta> 0.80 && numeroRandomCarta <=.90 )
												{
													carta=11;
												}
												else
												{
													carta=12;
						
												}

					Double aux=tipo+carta;
				
					if(!lista.contains(aux))
					{
						lista.add(aux);
						cont++;
					}
					
				
				}while(cont!=40);
			
			
			}
		
		public Double sacarCarta(Double[] mazo)
		{
			int carta=0;
		
		
			double numeroRandomCarta;
			
			
			do
			{
				numeroRandomCarta= Math.random();
			
				if(numeroRandomCarta <= 0.10)
				{
					carta=0;
				}
				else
					if(numeroRandomCarta> 0.10 && numeroRandomCarta <=.20 )
					{
						carta=1;
						
					}
					else
						if(numeroRandomCarta> 0.20 && numeroRandomCarta <=.30 )
						{
							carta=2;
						}
						else
							if(numeroRandomCarta> 0.30 && numeroRandomCarta <=.40 )
							{
								carta=3;
							}
							else
								if(numeroRandomCarta> 0.40 && numeroRandomCarta <=.50 )
								{
									carta=4;
								}
								else
									if(numeroRandomCarta> 0.50 && numeroRandomCarta <=.60 )
									{
										carta=5;
									}
									else
										if(numeroRandomCarta> 0.60 && numeroRandomCarta <=.70 )
										{
											carta=6;
										}
										else
											if(numeroRandomCarta> 0.70 && numeroRandomCarta <=.80 )
											{
												carta=7;
											}
											else
												if(numeroRandomCarta> 0.80 && numeroRandomCarta <=.90 )
												{
													carta=8;
												}
												else
												{
													carta=9;
						
												}

					if(noSeHaRetirado(mazo,carta))
					{
						Double valor= mazo[carta];
						mazo[carta]=null;
						return valor;
					}
					
				
				}while(true);
			
			
			}
		public boolean noSeHaRetirado(Double[] vector,int carta)
		{
				if(vector[carta]!=null)
					return true;
			return false;
		}
		
		
	}
	
	


