package charts;

import constants.Constants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HuffmanChart extends ApplicationFrame {
    public HuffmanChart(String title, String chartTitle) throws IOException {
        super(title);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Number of lines","Time",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );

    }
    private DefaultCategoryDataset createDataset( ) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(Constants.PLOTTING_HUFFMAN_CSV_FILE_NAME));
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String line;
        while((line = br.readLine())!=null){
            String[] temp = line.split(",");
            dataset.addValue(Double.parseDouble(temp[0]),"records",temp[1]);
        }
        return dataset;
    }
}
