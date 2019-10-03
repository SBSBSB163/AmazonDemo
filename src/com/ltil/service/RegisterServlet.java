package com.ltil.service;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltil.dao.UserDao;
import com.ltil.dao.UserDaoImpl;
import com.ltil.model.User;
import com.ltil.utilities.ConnectionManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private Connection connection=null;
private RequestDispatcher rd=null;
private UserDao dao=new UserDaoImpl();   
private HttpSession session=null;


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		connection = ConnectionManager.getConnection();
		response.getWriter().println(connection);
		String un = request.getParameter("userid");
		String us=request.getParameter("username");
		String pw=request.getParameter("password");
		User user = new User(un,us,pw);
		if(dao.insertUser(user)) {
			session=request.getSession();
			session.setAttribute("user",user);
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request,response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
