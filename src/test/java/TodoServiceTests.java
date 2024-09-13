import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ycraah.web.w1.dto.TodoDTO;
import ycraah.web.w1.service.TodoService;

import java.sql.SQLException;
import java.time.LocalDate;

public class TodoServiceTests {
  private TodoService todoService;

  @BeforeEach
  public void setUp() {
    todoService = TodoService.INSTANCE;
  }

  @Test
  public void testRegister() throws SQLException {
    TodoDTO todoDTO = TodoDTO.builder()
        .title("JDBC Test Title")
        .dueDate(LocalDate.now())
        .build();
    todoService.register(todoDTO);
  }
}
