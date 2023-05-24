package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.Book;


public class Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Detail() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Search Servlet");
	      request.setCharacterEncoding("UTF8");
	      response.setContentType("text/html;charset=utf8");
	      String titleOrAuthor = request.getParameter("author");
	      BookDAO bookDao = new BookDAO();
	      
	      List<Book> detaildBook = bookDao.searchBookByTitleOrAuthor(titleOrAuthor);
	      System.out.println(detaildBook.size());
	      for(Book book : detaildBook) {
	         System.out.println(book.getTitle());
	      }
	      request.setAttribute("detaildBook", detaildBook);
	      ServletContext context =getServletContext();
	      RequestDispatcher dispatcher = context.getRequestDispatcher("/detail.jsp");
	      dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
