package problems.report_generator.charts.saver;

import problems.report_generator.charts.chart.Dimension;
import problems.report_generator.charts.chart.ImgType;

public class SaveMeta {
    public final String path;
    public final ImgType type;
    public Dimension dimension;

    public SaveMeta(String path, ImgType type, Dimension dimension) {
        this.path = path;
        this.type = type;
        this.dimension = dimension;
    }

    public SaveMeta(String path, ImgType type) {
        this(path,type, new Dimension(800,600));
    }
}
