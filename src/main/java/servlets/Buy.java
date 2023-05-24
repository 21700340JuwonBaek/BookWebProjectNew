package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Buy() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html;charset=utf8");
	      int id = Integer.parseInt(request.getParameter("id"));
	      int saledNum = Integer.parseInt(request.getParameter("saledNum"));
	      int remainNum = Integer.parseInt(request.getParameter("remainNum"));
	      
	      if(remainNum == 0) {
	    	  	PrintWriter printer = response.getWriter();
				printer.println("<script>");
				printer.println("alert('일치하지 않습니다.');");
				printer.println("history.back(-1);");
				printer.println("</script>");
	      }
	      
	      BookDAO bookDao = new BookDAO();
	      bookDao.buyBook(id, saledNum+1, remainNum-1);
	      
	      response.sendRedirect("main");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
