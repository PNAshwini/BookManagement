package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author tarun
 */
public class BookDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ebook";
	private String jdbcUsername = "ebook";
	private String jdbcPassword = "ebook";

	private static final String INSERT_BOOKS_SQL = "INSERT INTO books" + "  (bname, bauthor, bprice, bimage, bdescription) VALUES "
			+ " (?, ?, ?, ?, ?"
                + ");";
        
	private static final String SELECT_BOOK_BY_ID = "select bname, bauthor, bprice, bimage, bdescription from books where bid =?";
	private static final String SELECT_ALL_BOOKS = "select * from books";
	private static final String DELETE_BOOKS_SQL = "delete from books where bid = ?;";
	private static final String UPDATE_BOOKS_SQL = "update books set bname=?, bauthor=?, bprice=?, bimage=?, bdescription =? where bid = ?;";

	public BookDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertBook(Book book) throws SQLException {
		System.out.println(INSERT_BOOKS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
			preparedStatement.setString(1, book.getBname());
			preparedStatement.setString(2, book.getBauthor());
			preparedStatement.setString(3, book.getBprice());
                        preparedStatement.setString(4, book.getBimage());
                        preparedStatement.setString(5, book.getBdescription());
                        System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Book selectBook(int bid) {
		Book book = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
			preparedStatement.setInt(1, bid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String bname = rs.getString("bname");
				String bauthor = rs.getString("bauthor");
				String bprice = rs.getString("bprice");
                                String bimage = rs.getString("bimage");
                                String bdescription = rs.getString("bdescription");
				book = new Book(bid, bname, bauthor, bprice, bdescription, bimage);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return book;
	}

	public List<Book> selectAllBooks() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Book> books = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String bauthor = rs.getString("bauthor");
				String bprice = rs.getString("bprice");
                                String bimage = rs.getString("bimage");
                                String bdescription = rs.getString("bdescription");
				books.add(new Book(bid, bname, bauthor, bprice, bdescription, bimage));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return books;
	}

	public boolean deleteBook(int bid) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
			statement.setInt(1, bid);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateBook(Book book) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
			statement.setString(1, book.getBname());
			statement.setString(2, book.getBauthor());
			statement.setString(3, book.getBprice());
                        statement.setString(4, book.getBimage());
                        statement.setString(5, book.getBdescription());
			statement.setInt(6, book.getBid());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
    
}
