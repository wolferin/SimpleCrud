import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Kenny on 01.08.2015.
 */
public class MyDBController {

    private static final String URL = "jdbc:mysql://localhost:3306/testwebjdbc";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null) {
            return connection;
        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL, NAME, PASSWORD);


            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        return connection;

    }



}
