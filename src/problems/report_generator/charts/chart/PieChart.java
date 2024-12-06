package problems.report_generator.charts.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Map;

public class PieChart implements Chart<Map<String,Number>> {
    private ChartData<Map<String,Number>> data ;
    private DefaultPieDataset<String> dataset;
    public PieChart(ChartData<Map<String, Number>> data){
       this.updateData(data);
    }
    void createDataset(){
        this.dataset = new DefaultPieDataset<>();
        Map<String,Number> dataPoints = this.data.data;
        for(String key:dataPoints.keySet()){
            dataset.setValue(key,dataPoints.get(key));
        }
    }

    @Override
    public void updateData(ChartData<Map<String,Number>>data) {
        this.data=data;
        this.createDataset();
    }

    public JFreeChart create(){
        return ChartFactory.createPieChart(this.data.title,this.dataset,true,true,false);
    }

}
