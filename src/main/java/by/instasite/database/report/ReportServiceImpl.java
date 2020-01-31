package by.instasite.database.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private ReportRepository repository;

    @Autowired
    public void setReportRepository(ReportRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveReport(Report report) {
        repository.save(report);
    }


    @Override
    public void deleteReport(int id) {
        Report deleted = repository.getOne(id);
        repository.delete(deleted);
    }

    @Override
    public List<Report> findAll() {
        return repository.findAll();
    }
}