package ycraah.web.w1.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import ycraah.web.w1.dao.TodoDAO;
import ycraah.web.w1.domain.TodoVO;
import ycraah.web.w1.dto.TodoDTO;
import ycraah.web.w1.util.MapperUtil;

import java.sql.SQLException;
import java.time.LocalDate;


@Log4j2
public enum TodoService {
  //Service는 프로그램 기능의 실제 처리 담당. 싱글톤 패턴을 위해 enum 타입으로 지정
  INSTANCE;

  private TodoDAO dao;
  private ModelMapper modelMapper;

  TodoService(){
    dao = new TodoDAO();
    modelMapper = MapperUtil.INSTANCE.getModelMapper();
  }

  public void register(TodoDTO todoDTO) throws SQLException {
    log.info("TodoService register() 실행");
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class); // map(인자로 변환할 인자 소스, 인자로 변환할 타켓 클래스 타입)

    dao.insert(todoVO);
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
