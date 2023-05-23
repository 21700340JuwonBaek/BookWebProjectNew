package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.Book;

public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=utf8");
		BookDAO bookDao = new BookDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String writtenDateStr = request.getParameter("writtenDate");
		Date writtenDate = Date.valueOf(writtenDateStr);
		String company = request.getParameter("company");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		int remain = Integer.parseInt(request.getParameter("remain"));
		int saledNum = Integer.parseInt(request.getParameter("saledNum"));
		
		Book book = new Book(id, title, author, writtenDate, company, price, category, remain, saledNum); 
		bookDao.updateBook(book);
		
		response.sendRedirect("main");
		
	}

}
