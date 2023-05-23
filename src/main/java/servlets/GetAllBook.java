package servlets;

import java.io.IOException;
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


public class GetAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetAllBook() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDao = new BookDAO();
		List<Book> bookList = bookDao.getAllBook();
		request.setAttribute("bookList", bookList);
		ServletContext context =getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("viewAll.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
