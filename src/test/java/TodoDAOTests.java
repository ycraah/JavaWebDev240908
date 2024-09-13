import org.junit.jupiter.api.Test;
import ycraah.web.w1.dao.TodoDAO;
import ycraah.web.w1.domain.TodoVO;

import java.sql.SQLException;

public class TodoDAOTests {
  TodoDAO dao = new TodoDAO();
  @Test
  public void testSelectOne() throws SQLException {
    Long tno = 1L;
    TodoVO vo = dao.selectOne(tno);
    System.out.println(vo);
  }
}
