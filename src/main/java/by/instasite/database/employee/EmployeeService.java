package by.instasite.database.employee;

import by.instasite.database.gas_station.Station;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@EnableTransactionManagement
public interface EmployeeService {
    Employee getUserByNameAndSurname(String name, String surname);

    @Transactional
    void addEmployee(Employee employee);

    @Transactional
    Employee getEmployeeById(int id);

    void updateEmployee(int id, String name, String surname, String address, String telephone, Station station);

    @Transactional
    void deleteEmployee(int id);

    @Transactional
    List<Employee> findAll();
}