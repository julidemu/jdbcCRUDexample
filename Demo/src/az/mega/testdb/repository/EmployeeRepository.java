package az.mega.testdb.repository;

import az.mega.testdb.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> getAll();

    Employee getOne(Long id);

    Employee update(Employee employee);

    Employee save(Employee employee);

    void delete(Long id);
}
