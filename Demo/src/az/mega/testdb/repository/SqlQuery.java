package az.mega.testdb.repository;


public class SqlQuery {

    public static final String GET_ALL_EMPLOYEE = "select * from employee";

    public static final String GET_EMPLOYEE = "select * from employee where id=?";

    public static final String UPDATE_EMPLOYEE = "update employee set name=?,surname=?,email=?,salary=? where id=?";

    public static final String SAVE_EMPLOYEE = "insert into employee (name,surname,email,salary) values(?,?,?,?)";

    public static final String DELETE_EMPLOYEE = "delete from employee where id=?";
}
