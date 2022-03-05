package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionProvider {
    private volatile static DBConnectionProvider instance;
    private static Connection connection;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/program?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    private DBConnectionProvider() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static DBConnectionProvider getInstance() {
        if(instance==null) {
            synchronized (DBConnectionProvider.class) {
                if ((instance == null)) {

                    instance = new DBConnectionProvider();

                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection==null || connection.isClosed()){
                connection=DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
