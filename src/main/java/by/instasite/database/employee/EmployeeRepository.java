package by.instasite.database.employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByNameAndSurname(String name, String surname);

    Employee findByTelephone(String telephone);
}