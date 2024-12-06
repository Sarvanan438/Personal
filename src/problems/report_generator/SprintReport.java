package problems.report_generator;

import problems.report_generator.charts.saver.SaveChartAsImage;
import problems.report_generator.exporters.Exporter;
import problems.report_generator.exporters.PDFExporter;
import problems.report_generator.reports.Report;
import problems.report_generator.reports.TaskPriorityReport;
import problems.report_generator.reports.generator.ReportGenerator;

public class SprintReport {
    public static void main(String[] args) {
        try {
            Exporter pdfExport = new PDFExporter(new SaveChartAsImage());
            Report sprintTaskReport = new TaskPriorityReport(pdfExport);
            sprintTaskReport.create();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
