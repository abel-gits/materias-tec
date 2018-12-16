package Simulacion;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class grafica {

	public grafica(int cara, int cruz) {
		
		// Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Cara: "+cara, cara);
        data.setValue("Cruz: "+cruz, cruz);
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Estadisticas de la moneda", 
         data, 
         true, true, false);
 
        // Mostrar Grafico
        ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);
	}
	
}