package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.*;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
        private BookDAO bookDAO;
        private OrderDAO orderDAO;
	
	public void init() {
		userDAO = new UserDAO();
                bookDAO = new BookDAO();
                orderDAO = new OrderDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            response.setContentType("text/html");
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
                        case "/newBook":
				showNewBookForm(request, response);
				break;
			case "/insertBook":
				insertBook(request, response);
				break;
			case "/deleteBook":
				deleteBook(request, response);
				break;
			case "/editBook":
				showEditBook(request, response);
				break;
			case "/updateBook":
				updateBook(request, response);
				break;
                        case "/listBook":
				listBook(request, response);
				break;
                        case "/orderBook":
				orderBook(request, response);
				break;
                        case "/index":
				indexBook(request, response);
				break;
                        case "/admin":
				listUser(request, response);
				break;
                        case "/list":
                                listUser(request, response);
                                break;
                        case "/buyBook":
                                buyBook(request, response);
                                break;
                        case "/listOrder":
                                listOrder(request, response);
                                break;
                        case "/loginCheck":
                                loginCheck(request, response);
                                break;
                        case "/register":
                                register(request, response);
                                break;
                        case "/registerUser":
                                registerUser(request, response);
                                break;
                        default:
				login(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
        
        private void login(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
        
        private void register(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}
        
        private void loginCheck(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                String uname=request.getParameter("uname");
                String password=request.getParameter("password");
                boolean checkUser=userDAO.login(uname,password);
                System.out.println(checkUser);
                if(checkUser==true){
                    List<Book> listBook = bookDAO.selectAllBooks();
                    request.setAttribute("listBook", listBook);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                }else{
                    request.setAttribute("error", "user not found");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);
                }                
	}
        
        private void indexBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                List<Book> listBook = bookDAO.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String fname = request.getParameter("fname");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
                String cpassword = request.getParameter("cpassword");
		User newUser = new User(fname, uname, password, cpassword);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
	}
        
        private void registerUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String fname = request.getParameter("fname");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
                String cpassword = request.getParameter("cpassword");
		User newUser = new User(fname, uname, password, cpassword);
		userDAO.insertUser(newUser);
		response.sendRedirect("login.jsp");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
                String cpassword = request.getParameter("cpassword");

		User book = new User(id, fname, uname, password, cpassword);
		userDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("list");

	}
        
        private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                List<Book> listBook = bookDAO.selectAllBooks();
		request.setAttribute("listBook", listBook);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
		dispatcher.forward(request, response);
	}        

	private void showNewBookForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditBook(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		Book existingBook = bookDAO.selectBook(bid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);

	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bprice = request.getParameter("bprice");
                String bdescription = request.getParameter("bdescription");
                String bimage = request.getParameter("bimage");
		Book newBook = new Book(bname,bauthor,bprice,bdescription,bimage);
		bookDAO.insertBook(newBook);
		response.sendRedirect("listBook");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bprice = request.getParameter("bprice");
                String bdescription = request.getParameter("bdescription");
                String bimage = request.getParameter("bimage");
		Book book = new Book(bid,bname,bauthor,bprice,bdescription,bimage);
                bookDAO.updateBook(book);
		response.sendRedirect("listBook");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		bookDAO.deleteBook(bid);
		response.sendRedirect("listBook");

	}
        
        private void orderBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                int bid = Integer.parseInt(request.getParameter("bid"));
		Book existingBook = bookDAO.selectBook(bid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
	}
        
        private void buyBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
            String bname = request.getParameter("bname");
            String price = request.getParameter("bprice");
            String quantity = request.getParameter("bquantity");
            String cname = request.getParameter("cname");
            String phone = request.getParameter("phone");            
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            int quantity1=Integer.parseInt(quantity);
            int price1=Integer.parseInt(price);
            int price2=quantity1*price1;
            String bquantity=Integer.toString(quantity1);
            String bprice=Integer.toString(price2);
            Order newOrder = new Order(bname, bprice, bquantity, cname, phone, email, address);
            orderDAO.insertOrder(newOrder);
            response.sendRedirect("index");
            
        }
        
        private void listOrder(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
                List<Order> listOrder = orderDAO.selectAllOrders();
		request.setAttribute("listOrder", listOrder);
		RequestDispatcher dispatcher = request.getRequestDispatcher("order-list.jsp");
		dispatcher.forward(request, response);
	}
}
