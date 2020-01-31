package by.instasite.database.report;

import java.util.List;

public interface ReportService {

    void saveReport(Report report);

    void deleteReport(int id);

    List<Report> findAll();
}