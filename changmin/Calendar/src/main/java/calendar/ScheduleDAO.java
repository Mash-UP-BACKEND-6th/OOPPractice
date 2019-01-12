package calendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    private static final String TABLE_NAME = "schedule";
    private String database;

    public ScheduleDAO(String database) {
        this.database = database;
    }

    public List<Schedule> select() throws SQLException {
        String sql = "SELECT * FROM " + TABLE_NAME;
        Connection connection = SQLiteConnector.getConnection(this.database);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Schedule> list = new ArrayList<Schedule>();

        while(resultSet.next()) {
            list.add(new Schedule(resultSet.getString("date"),
                                resultSet.getString("contents")));
        }

        return list;
    }

    public void insert(Schedule schedule) throws SQLException {
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES(?, ?)";
        Connection connection = SQLiteConnector.getConnection(this.database);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, schedule.getDate());
        preparedStatement.setString(2, schedule.getContents());
        preparedStatement.execute();
    }

    public void delete(Schedule schedule) throws SQLException {
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE date=? AND date=?";
        Connection connection = SQLiteConnector.getConnection(this.database);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, schedule.getDate());
            preparedStatement.setString(2, schedule.getContents());
            connection.setSavepoint();
            preparedStatement.execute();
        } catch (SQLException ex) {
            connection.rollback();
        }
    }

    public void update(Schedule old, Schedule renew) throws SQLException{
        delete(old);
        insert(renew);
    }
}
