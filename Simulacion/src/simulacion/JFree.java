package simulacion;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class JFree  {
        Dardo punto;
        double h1,h2;
      double itera;
     double fuera,dentro;
	 XYSeries series = new XYSeries("Acercamiento a PII"); 
	XYSeriesCollection datos = new XYSeriesCollection();
	JFreeChart chart;

	public void jfrech() {
		JFrame jf=new JFrame();
		datos.addSeries(series);
		chart=ChartFactory.createXYLineChart("Tiro de dardo", "Tiros", "desplazamiento grafico", datos, PlotOrientation.VERTICAL, true, true, false);
	    XYPlot plot=(XYPlot) chart.getPlot();
	    ValueAxis YAxis=plot.getRangeAxis();
            
	    //Set Rango en especifico por defecto
	    //YAxis.setRange(100,200);
        ChartPanel panel = new ChartPanel(chart);
        
        for (int i =0; i <DardosGraf.dardos.size(); i++) {
            punto=DardosGraf.dardos.get(i);
                    h1=Math.pow(250-punto.getX(), 2)+Math.pow(250-punto.getY(), 2);
			h2=Math.sqrt(h1);
			
				if((h2<=250))
					dentro++;
                               
                                    
        	series.add(i,((dentro)/DardosGraf.dardos.size())*4);
        }
        
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jf.add(panel);
	}

}
