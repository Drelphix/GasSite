package by.instasite.database.employee;

import by.instasite.database.gas_station.Station;

import java.util.List;

public interface EmployeeService {
    Employee getUserByNameAndSurname(String name, String surname);

    void addEmployee(Station station, Employee employee);

    void updateEmployee(int id, String name, String surname, String address, String telephone);

    void deleteEmployee(int id);

    List<Employee> findAll();
}