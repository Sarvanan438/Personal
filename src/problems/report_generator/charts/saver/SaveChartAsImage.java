package problems.report_generator.charts.saver;

import org.jfree.chart.JFreeChart;
import problems.report_generator.charts.chart.Chart;

import java.io.File;
import java.io.IOException;

public class SaveChartAsImage implements ChartSaver{
    @Override
    public File saveToFile(Chart chart, SaveMeta meta) throws IOException {
        return SaveChartFactory.save(chart,meta);
    }
}
