package problems.report_generator.charts.saver;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import problems.report_generator.charts.chart.Chart;
import problems.report_generator.charts.chart.ImgType;

import java.io.File;
import java.io.IOException;

public class SaveChartFactory {
    public static  File save(Chart chart, SaveMeta meta) throws IOException {
        JFreeChart createdChart =chart.create();
        File saveToFile =new File(meta.path);
        switch (meta.type){
            case ImgType.PNG :

                 ChartUtils.saveChartAsPNG(saveToFile,createdChart,(int)meta.dimension.x, (int)meta.dimension.y);
                 break;
            default:
                throw new IllegalArgumentException("Invalid file save type");

        }
        return saveToFile;
    }
}
