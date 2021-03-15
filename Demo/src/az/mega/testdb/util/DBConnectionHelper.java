package az.mega.testdb.util;

import az.mega.testdb.model.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnectionHelper {

    public static Connection connect(Configuration configuration){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection(configuration.getUrl(),
                         configuration.getUsername(),configuration.getPassword());

            connection.setAutoCommit(false);

        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }

    public static void close(ResultSet set, PreparedStatement statement, Connection connection){
        try {
            if(set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
