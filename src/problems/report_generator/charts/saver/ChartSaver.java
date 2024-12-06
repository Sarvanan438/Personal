package problems.report_generator.charts.saver;

import org.jfree.chart.JFreeChart;
import problems.report_generator.charts.chart.Chart;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ChartSaver {
    File saveToFile(Chart chart , SaveMeta meta) throws IOException;
}
