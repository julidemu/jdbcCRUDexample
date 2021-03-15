package az.mega.testdb;

import az.mega.testdb.config.DatabaseConfig;
import az.mega.testdb.model.Configuration;
import az.mega.testdb.model.Employee;
import az.mega.testdb.repository.EmployeeRepoImpl;
import az.mega.testdb.repository.EmployeeRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Samir Ramazanov
 *
 * */

public class MainDemo {
    public static void main(String[] args) {

//        Configuration configuration = DatabaseConfig.read("jdbc.properties");
//        EmployeeRepository repo = new EmployeeRepoImpl(configuration);
//        List<Employee> all = repo.getAll();
//
//        Employee newEmployee = new Employee();
//        newEmployee.setName("Qilman");
//        newEmployee.setSurname("Qilmanov");
//        newEmployee.setEmail("qilman@email.com");
//        newEmployee.setSalary(BigDecimal.valueOf(1200));
//
//        repo.save(newEmployee);
//
//
//
//        System.out.println("+++++++++++++++++++++++++++++++++++++++");
//
//        all.forEach(System.out::println);
//
//        System.out.println("++++++++++++++++++++++++++++++++++++++++");
//
//        Employee employee = repo.getOne(2L);
//        employee.setSalary(BigDecimal.valueOf(1500));
//        repo.update(employee);
//        System.out.println(employee);
//
//        System.out.println("++++++++++++++++++++++++++++++++++++++++");
//
//        repo.delete(4L);


    }
}
