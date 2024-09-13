import org.junit.jupiter.api.Test;
import ycraah.web.w1.dao.TodoDAO;
import ycraah.web.w1.domain.TodoVO;

import java.sql.SQLException;
import java.util.List;

public class TodoDAOTest {
  TodoDAO dao = new TodoDAO();

  @Test
  public void testList() throws SQLException {
    List<TodoVO> list = dao.selectAll();
    list.forEach(vo -> System.out.println(vo));
  }
}
