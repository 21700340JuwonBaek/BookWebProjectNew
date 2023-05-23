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

public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddBook() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AddBook Test 진입");
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=utf8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String writtenDateStr = request.getParameter("writtenDate");
		Date writtenDate = Date.valueOf(writtenDateStr);
		String company = request.getParameter("company");
		int price = Integer.parseInt(request.getParameter("price"));
		String category = request.getParameter("category");
		int remain = Integer.parseInt(request.getParameter("remain"));
		int saledNum = Integer.parseInt(request.getParameter("saledNum"));
		String imgUrl = request.getParameter("imgUrl");
		System.out.println(category);

		Book book = new Book(-1, title, author, writtenDate, company, price, category, remain, saledNum, imgUrl); 
		
		BookDAO bookDao = new BookDAO();
		bookDao.addBook(book);
		
		response.sendRedirect("main.jsp");	
	}

}
