package ycraah.web.w1.dto;

import lombok.*;

import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TodoDTO {
  //DTO(Data Transfter Object) 데이터를 묶어서 하나의 객체로 전달
  private Long tno;
  private String title;
  private LocalDate dueDate;
  private boolean finished;
}
