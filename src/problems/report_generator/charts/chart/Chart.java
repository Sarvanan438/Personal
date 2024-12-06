package problems.report_generator.charts.chart;

import org.jfree.chart.JFreeChart;

/**
 *
 * convert to a builder for complex needs
 *
 */
public interface Chart<T> {
    void updateData(ChartData<T> data);
    JFreeChart create();
}
