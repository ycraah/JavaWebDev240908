package ycraah.web.w1.dao;

import lombok.Cleanup;
import ycraah.web.w1.domain.TodoVO;

import java.sql.*;

public class TodoDAO {
  public String getTime() throws SQLException {
    String sql = "select now()";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    String now = resultSet.getString(1);
    return now;
  }

  public void insert(TodoVO vo) throws SQLException {
    String sql = "insert into tbl_todo(title, dueDate, finished) values(?,?,?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, vo.getTitle());
    preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
    preparedStatement.setBoolean(3, vo.isFinished());

    preparedStatement.executeUpdate();
  }
}
