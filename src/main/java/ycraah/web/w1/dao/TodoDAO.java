package ycraah.web.w1.dao;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import ycraah.web.w1.domain.TodoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class TodoDAO {
  //TodoService와 연동되어 DB를 중재하는 클래스
  public void insert(TodoVO vo) throws SQLException {
    log.info("insert 실행");
    String sql = "insert into tbl_todo(title, dueDate, finished) values(?,?,?)";

    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, vo.getTitle());
    preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
    preparedStatement.setBoolean(3, vo.isFinished());

    preparedStatement.executeUpdate();
  }

  public List<TodoVO> selectAll() throws SQLException {
    String sql = "select * from tbl_todo";
    @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
    @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
    List<TodoVO> list = new ArrayList<>();

    while (resultSet.next()) {
      TodoVO vo = TodoVO.builder()
          .tno(resultSet.getLong("tno"))
          .title(resultSet.getString("title"))
          .dueDate(resultSet.getDate("dueDate").toLocalDate())
          .finished(resultSet.getBoolean("finished"))
          .build();
      list.add(vo);
    }
    return list;
  }
}
