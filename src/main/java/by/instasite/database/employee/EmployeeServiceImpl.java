package by.instasite.database.employee;

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
    public void updateEmployee(int id, String name, String surname, String address, String telephone) {
        Employee updated = repository.getOne(id);
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