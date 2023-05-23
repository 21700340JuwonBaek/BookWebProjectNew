package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DBFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		response.setContentType("text/html;charset=utf8");
		String dbID = request.getParameter("id");
		String dbPw = request.getParameter("pw");
		response.setContentType("text/html;charset=utf8");
		if(dbID.equals("root") && dbPw.equals("1234")) {
			response.sendRedirect("main");
		}else {
			PrintWriter printer = response.getWriter();
			printer.println("<script>");
			printer.println("alert('일치하지 않습니다.');");
			printer.println("history.back(-1);");
			printer.println("</script>");
		}	
	}
	

}
