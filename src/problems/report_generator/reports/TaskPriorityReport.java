package problems.report_generator.reports;


import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import problems.report_generator.charts.chart.*;
import problems.report_generator.exporters.Exporter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TaskPriorityReport implements Report {
    private Exporter exporter;
    public TaskPriorityReport(Exporter exporter){
        this.exporter=exporter;
    }

    private ChartData<Map<String,Number>> chartData;

    private Map<String,Number> getDataPoints(){
        Map<String,Number> dataset =  new HashMap<>();
        dataset.put("Low", 40);
        dataset.put("Medium", 30);
        dataset.put("Critical", 20);
        dataset.put("High", 10);
        return dataset;
    }
    private void createChartData(){

        this.chartData = new ChartData<>(this.getDataPoints());
        chartData.setTitle("Tasks completed by priority");
    }
    @Override
    public void generate() throws IOException {

        Chart pieChart = new PieChart(this.chartData);
        exporter.addPage();
        exporter.setFont(Standard14Fonts.FontName.HELVETICA_BOLD , 30);
        exporter.addText("Sprint Task report", new Dimension(100,60));

        exporter.addChart(pieChart,new Dimension(50,100),new Dimension(800,600));

        exporter.export("sprint_report.pdf");

    }

    @Override
    public void fetch() {
        // fetch sprint data and setup the data points
    }

    public void create() throws IOException {
        this.fetch();
        this.createChartData();
        this.generate();
    }
}
