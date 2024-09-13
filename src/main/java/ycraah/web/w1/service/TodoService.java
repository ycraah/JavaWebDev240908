package ycraah.web.w1.service;

import lombok.extern.log4j.Log4j2;
import ycraah.web.w1.dao.TodoDAO;
import ycraah.web.w1.dto.TodoDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Log4j2
public enum TodoService {
  //Service는 프로그램 기능의 실제 처리 담당. 싱글톤 패턴을 위해 enum 타입으로 지정
  INSTANCE;

  public void register(TodoDTO todoDTO){
    log.info("TodoService register() 실행");
  }

  public List<TodoDTO> getList(){
    log.info("TodoService getList() 실행");
    List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
      TodoDTO dto = TodoDTO.builder()
          .tno((long)i)
          .title("Todo..." + i)
          .dueDate(LocalDate.now())
          .build();
      return dto;
    }).collect(Collectors.toList());
    return todoDTOS;
  }

  public TodoDTO get(Long tno){
    log.info("TodoService get() 실행");
    TodoDTO dto = TodoDTO.builder()
        .tno(tno)
        .title("sample Todo")
        .dueDate(LocalDate.now())
        .finished(true)
    .build();
    return dto;
  }
}
