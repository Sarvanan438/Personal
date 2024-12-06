package problems.report_generator.exporters;

import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import problems.report_generator.charts.chart.Chart;
import problems.report_generator.charts.chart.Dimension;

import java.io.IOException;

public interface Exporter {

    void addPage() throws IOException;
    void addText(String text , Dimension dimension) throws IOException;
    void setFont(Standard14Fonts.FontName font,int size);
    void addChart(Chart chart,Dimension position,Dimension size) throws IOException;
    void export(String filename) throws IOException;
}
