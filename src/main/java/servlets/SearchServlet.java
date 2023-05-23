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


@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public SearchServlet() {
        super();
    }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Search Servlet");
      request.setCharacterEncoding("UTF8");
      response.setContentType("text/html;charset=utf8");
      String titleOrAuthor = request.getParameter("searchText");
      BookDAO bookDao = new BookDAO();
      
      List<Book> searchedBook = bookDao.searchBookByTitleOrAuthor(titleOrAuthor);
      System.out.println(searchedBook.size());
      for(Book book : searchedBook) {
         System.out.println(book.getTitle());
      }
      request.setAttribute("searchedBook", searchedBook);
      ServletContext context =getServletContext();
      RequestDispatcher dispatcher = context.getRequestDispatcher("/searched.jsp");
      dispatcher.forward(request, response);
      
      
   }

}