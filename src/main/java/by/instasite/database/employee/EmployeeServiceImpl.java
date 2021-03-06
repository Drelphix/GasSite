package by.instasite.database.employee;

import by.instasite.database.gas_station.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;


    @Autowired
    public void setEmployeeRepository(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee getUserByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    @Override
    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return repository.getOne(id);
    }

    @Override
    public void updateEmployee(int id, String name, String surname, String address, String telephone, Station station) {
        Employee updated = repository.getOne(id);
        updated.setStation(station);
        updated.setName(name);
        updated.setSurname(surname);
        updated.setAddress(address);
        updated.setTelephone(telephone);
        repository.save(updated);
    }

    @Override
    public void deleteEmployee(int id) {
        repository.delete(repository.getOne(id));
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }
}