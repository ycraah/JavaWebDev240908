package ycraah.web.w1.controller;

import lombok.extern.log4j.Log4j2;
import ycraah.web.w1.dto.TodoDTO;
import ycraah.web.w1.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Log4j2
@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log.info("/todo/list(GET)");
    List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
    req.setAttribute("list", dtoList);
    req.getRequestDispatcher("/todo/list.jsp").forward(req, resp);
  }
}
