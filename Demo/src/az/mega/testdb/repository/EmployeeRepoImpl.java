package az.mega.testdb.repository;

import az.mega.testdb.model.Configuration;
import az.mega.testdb.model.Employee;
import az.mega.testdb.util.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeRepoImpl implements EmployeeRepository {

    private final Configuration conf;
    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public EmployeeRepoImpl(Configuration conf) {
        this.conf = conf;
    }

    @Override
    public List<Employee> getAll() {

        List<Employee> employeeList = new ArrayList<>();

        try {
            con = DBConnectionHelper.connect(conf);
            stm = con.prepareStatement(SqlQuery.GET_ALL_EMPLOYEE);
            rs = stm.executeQuery();

            while (rs.next()){
                Employee employee = getEmployee(rs);
                employeeList.add(employee);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnectionHelper.close(rs, stm, con);
        }

        return employeeList;
    }


    @Override
    public Employee getOne(Long id) {
        Employee employee = null;
        try {
            con = DBConnectionHelper.connect(conf);
            stm = con.prepareStatement(SqlQuery.GET_EMPLOYEE);
            stm.setLong(1, id);
            rs = stm.executeQuery();
            while (rs.next()){
                employee = getEmployee(rs);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnectionHelper.close(rs,stm,con);
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        try {
            con = DBConnectionHelper.connect(conf);
            stm = con.prepareStatement(SqlQuery.UPDATE_EMPLOYEE);
            commonUpdateSaveParams(employee);
            stm.setLong(5, employee.getId());
            stm.executeUpdate();
            con.commit();

        }catch (SQLException e){
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBConnectionHelper.close(rs,stm,con);
        }

        return employee;
    }


    @Override
    public Employee save(Employee employee) {

        try {
            con = DBConnectionHelper.connect(conf);
            stm = con.prepareStatement(SqlQuery.SAVE_EMPLOYEE);
            commonUpdateSaveParams(employee);
            stm.executeUpdate();
            con.commit();

        }catch (SQLException e){
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBConnectionHelper.close(rs,stm,con);
        }

        return employee;

    }

    @Override
    public void delete(Long id) {

        try {
            con = DBConnectionHelper.connect(conf);
            stm = con.prepareStatement(SqlQuery.DELETE_EMPLOYEE);
            stm.setLong(1, id);
            stm.executeUpdate();
            con.commit();

        }catch (SQLException e){
            try {
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBConnectionHelper.close(rs,stm,con);
        }
    }

    private void commonUpdateSaveParams(Employee employee) throws SQLException {
        stm.setString(1, employee.getName());
        stm.setString(2, employee.getSurname());
        stm.setString(3, employee.getEmail());
        stm.setBigDecimal(4, employee.getSalary());
    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getLong("id"));
        employee.setName(rs.getString("name"));
        employee.setSurname(rs.getString("surname"));
        employee.setEmail(rs.getString("email"));
        employee.setSalary(rs.getBigDecimal("salary"));
        return employee;
    }
}
