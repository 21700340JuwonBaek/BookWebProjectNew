package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import vo.Book;

public class BookDAO{
	
	public Connection connDB() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/db01"; 
		String id = "root";
		String pw = "1234";
		
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
	    	  conn = DriverManager.getConnection(url, id, pw);
		}catch(SQLException e) {
	          System.err.println("MySQL 데이터베이스 연결 중 오류가 발생하였습니다.");
	          e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public List<Book> getBestSeller(){
		Connection conn = connDB();
		List<Book> returnValue = null;
		try {
			// SQL 문 준비
			String sql = "SELECT * FROM book order by saledNum desc limit 5";
			PreparedStatement statement = conn.prepareStatement(sql);
			returnValue = new LinkedList();

			// 쿼리 실행 및 결과 처리
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title"); 
				String author = resultSet.getString("author");
				Date writtenDate = resultSet.getDate("writtenDate");
				String company = resultSet.getString("company");
				int price = resultSet.getInt("price");
				String category = resultSet.getString("category");
				int remain = resultSet.getInt("remain");
				int saledNum = resultSet.getInt("saledNum");
				Book book = new Book(id, title, author, writtenDate, company, price, category, remain, saledNum);
				returnValue.add(book);
			}
			conn.close();
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			System.err.println("오류 발생");
			e.printStackTrace();
		}
		return returnValue;	
	}
	
	
	public List<Book> getAllBook(){
		Connection conn = connDB();
		List<Book> returnValue = null;
		try {
			// SQL 문 준비
			String sql = "SELECT * FROM book";
			PreparedStatement statement = conn.prepareStatement(sql);
			returnValue = new LinkedList();

			// 쿼리 실행 및 결과 처리
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				int id = rs.getInt("id");
				String title = rs.getString("title"); 
				String author = rs.getString("author");
				Date writtenDate = rs.getDate("writtenDate");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				int remain = rs.getInt("remain");
				int saledNum = rs.getInt("saledNum");
				Book book = new Book(id, title, author, writtenDate, company, price, category, remain, saledNum);
				returnValue.add(book);
			}
			conn.close();
			rs.close();
			statement.close();

		} catch (SQLException e) {
			System.err.println("오류 발생");
			e.printStackTrace();
		}
		return returnValue;	
	}
	
	//검색. 
	
	//추가(아예 없는 책)
	public void addBook(Book book) {
		Connection conn = connDB();

		String query = "INSERT INTO book(title, author, writtenDate, company, price, category, remain, saledNum)"
				 + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setDate(3, book.getWrittenDate());
			ps.setString(4, book.getCompany());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getCategory());
			ps.setInt(7, book.getRemain());
			ps.setInt(8, book.getSaledNum());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	//삭제(책 id로 삭제)
	public void deleteBookById(int id) {
		String query = "DELETE FROM book WHERE id=?";
		PreparedStatement ps = null;
		Connection conn = null;
	   try {
		   conn = connDB();
		   ps = conn.prepareStatement(query);
		   ps.setInt(1, id);
		   ps.executeUpdate();
		   conn.close();
		   ps.close();
	   } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	   }
	}
	
	
	//업데이트(책 객체 가져와서.)
	public void updateBook(Book book) {
		Connection conn = connDB();

		String query = "UPDATE book set title = ?, author = ?, writtenDate = ?,"
				   + " company = ?, price = ?,  category = ?, remain = ?, saledNum = ? "
				   + "WHERE ID = ?";
	
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setDate(3, book.getWrittenDate());
			ps.setString(4, book.getCompany());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getCategory());
			ps.setInt(7, book.getRemain());
			ps.setInt(8, book.getSaledNum());
			ps.setInt(9, book.getId());
			ps.executeUpdate();
			conn.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//id로 책 가져오기(책 id)
	public Book getBookById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM book WHERE id=?";
		Book book = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String title = rs.getString("title"); 
				String author = rs.getString("author");
				Date writtenDate = rs.getDate("writtenDate");
				String company = rs.getString("company");
				int price = rs.getInt("price");
				String category = rs.getString("category");
				int remain = rs.getInt("remain");
				int saledNum = rs.getInt("saledNum");			
				book = new Book(id, title, author, writtenDate, company, price, category, remain, saledNum);
				conn.close();
				rs.close();
				ps.close();
			}
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return book;

	}
	
	public List<Book> searchBookByTitleOrAuthor(String titleOrAuthor) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM book WHERE title like '%"+titleOrAuthor+"%' or author like '%"+titleOrAuthor+"%'";
		List<Book> bookList = new LinkedList<>();
		try {
			conn = connDB();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				Book currentBook = new Book(
						rs.getInt("ID"),
						rs.getString("title"),
						rs.getString("author"),
						rs.getDate("writtenDate"),
						rs.getString("company"),
						rs.getInt("price"),
						rs.getString("category"),
						rs.getInt("remain"),
						rs.getInt("saledNum")
						);
				bookList.add(currentBook);
			}
			conn.close();
			ps.close();
			rs.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return bookList;

	}
	
	
	

}
