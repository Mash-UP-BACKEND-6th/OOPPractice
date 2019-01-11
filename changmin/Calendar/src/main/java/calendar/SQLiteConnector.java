package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * SQLite의 커넥션을 1개로 유지한다.
 */
public class SQLiteConnector {
    public static Connection connection;
    public static Connection getConnection(String database) throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(database);
        }
        return connection;
    }

    public static void close() throws SQLException {
        if(connection != null) {
            connection.close();
        }
    }
}
