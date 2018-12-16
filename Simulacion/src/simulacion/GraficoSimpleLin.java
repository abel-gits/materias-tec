package simulacion;

import org.jfree.data.xy.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.awt.image.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import java.io.File;

import javax.swing.JFrame;

import org.jfree.chart.plot.*;
import java.io.*;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author  Roberto Leon Cruz
 */
public class GraficoSimpleLin extends JFrame {
    BufferedImage grafica = null;
    
    public GraficoSimpleLin() {
        super(" ");
        
    }
   
    public BufferedImage creaImagen()
    {
        
        XYSeries series = new XYSeries("titulo de la serie");

       for (int i = 0; i < Buffon.v; i++) {
    	if (Buffon.vec[i]!=0) {
    		double y=(double) Buffon.vec[i];     	  
     	   double x=(2*(i+1))/y;
         	series.add(i+1,x );
		}      		   		
    	   
        	
		}
       
        XYDataset juegoDatos= new XYSeriesCollection(series);
        
        JFreeChart chart = ChartFactory.createXYLineChart        ("Agujas de buffon",
        "Agujas lanzadas","Valor de pi",juegoDatos,PlotOrientation.VERTICAL,
        false,
        false,
        true                
        );
      
        BufferedImage image = chart.createBufferedImage(400,400);
        
        return image;
    }
      
    public void paint(java.awt.Graphics g) {
      
        if(grafica == null)
        {
            grafica = this.creaImagen();
        }
        g.drawImage(grafica,30,30,null);
    }
      
    
}