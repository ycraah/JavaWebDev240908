import org.junit.jupiter.api.Test;
import ycraah.web.w1.dao.TodoDAO;
import ycraah.web.w1.domain.TodoVO;

import java.sql.SQLException;
import java.time.LocalDate;

public class TodoDAOTests {
  TodoDAO dao = new TodoDAO();
  @Test
  public void testUpdateOne() throws SQLException {
    TodoVO todoVO = TodoVO.builder()
        .tno(1L)
        .title("test Title...")
        .dueDate(LocalDate.of(2021,12,31))
        .finished(true)
        .build();
    System.out.println(todoVO);
    dao.updateOne(todoVO);
  }
}
