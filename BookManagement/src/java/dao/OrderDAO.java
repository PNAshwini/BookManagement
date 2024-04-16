package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

/**
 *
 * @author tarun
 */
public class OrderDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/ebook";
	private String jdbcUsername = "ebook";
	private String jdbcPassword = "ebook";

	private static final String INSERT_ORDERS_SQL = "INSERT INTO bookorder" + "  (bname, bprice, bquantity, cname, phone, email, address) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?);";
        private static final String SELECT_ALL_ORDERS = "select * from bookorder";
	
	public OrderDAO() {
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

	public void insertOrder(Order order) throws SQLException {
		System.out.println(INSERT_ORDERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL)) {
			preparedStatement.setString(1, order.getBname());
			preparedStatement.setString(2, order.getBprice());
			preparedStatement.setString(3, order.getBquantity());
                        preparedStatement.setString(4, order.getCname());
                        preparedStatement.setString(5, order.getPhone());
                        preparedStatement.setString(6, order.getEmail());
                        preparedStatement.setString(7, order.getAddress());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
        
        public List<Order> selectAllOrders() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Order> orders = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int oid = rs.getInt("oid");
				String bname = rs.getString("bname");
				String bprice = rs.getString("bprice");
				String bquantity = rs.getString("bquantity");
                                String cname = rs.getString("cname");
                                String phone = rs.getString("phone");
                                String email = rs.getString("email");
                                String address = rs.getString("address");
				orders.add(new Order(oid, bname, bprice, bquantity, cname, phone, email, address));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return orders;
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
