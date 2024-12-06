package problems.report_generator.charts.chart;

import java.util.ArrayList;
import java.util.List;

public class ChartData <T>{
    String title ;
    List<AxisConfig> axisConfigList ;
    T data;

    public ChartData( T data) {
        this.title = "Simple chart";
        this.axisConfigList = new ArrayList<>();
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AxisConfig> getAxisConfigList() {
        return axisConfigList;
    }

    public void setAxisConfigList(List<AxisConfig> axisConfigList) {
        this.axisConfigList = axisConfigList;
    }
}
