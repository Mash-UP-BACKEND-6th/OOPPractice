import calendar.SQLiteConnector;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLiteConnectorTest {
    private static final String DATABASE = "jdbc:sqlite:calendar.db";
    @Test
    public void testConnection() throws SQLException {
        Connection connection = SQLiteConnector.getConnection(DATABASE);
        SQLiteConnector.close();
    }
}
