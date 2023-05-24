package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.Book;


public class BookInfoForUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BookInfoForUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=utf8");
		System.out.println("UPDATE GET INFO");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.getBookById(id);
		System.out.println(book.getTitle());
		request.setAttribute("id", id);
		request.setAttribute("title", book.getTitle());
		request.setAttribute("author", book.getAuthor());
		request.setAttribute("writtenDate", book.getWrittenDate());
		request.setAttribute("company", book.getCompany());
		request.setAttribute("price", book.getPrice());
		request.setAttribute("category", book.getCategory());
		request.setAttribute("remain", book.getRemain());
		request.setAttribute("saledNum", book.getSaledNum());
		request.setAttribute("imgUrl", book.getImgUrl());

		ServletContext context =getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=utf8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.getBookById(id);
		
		request.setAttribute("title", book.getTitle());
		request.setAttribute("author", book.getAuthor());
		request.setAttribute("writtenDate", book.getWrittenDate());
		request.setAttribute("company", book.getCompany());
		request.setAttribute("price", book.getPrice());
		request.setAttribute("category", book.getCategory());
		request.setAttribute("remain", book.getRemain());
		request.setAttribute("saledNum", book.getSaledNum());

		ServletContext context =getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/update.html");
		dispatcher.forward(request, response);
		
	}

}
