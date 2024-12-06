package problems.report_generator.reports;

import problems.report_generator.reports.generator.ReportGenerator;

import java.io.IOException;

public interface Report extends ReportGenerator {
    void fetch();
    void create() throws IOException;
}
