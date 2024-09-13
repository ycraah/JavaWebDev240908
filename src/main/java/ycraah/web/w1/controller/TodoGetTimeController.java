package ycraah.web.w1.controller;

import ycraah.web.w1.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/todo/now")
public class TodoGetTimeController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String now = null;
    try {
      now = TodoService.INSTANCE.getTime();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    req.setAttribute("now", now);
    req.getRequestDispatcher("/todo/now.jsp").forward(req,resp);
  }
}
