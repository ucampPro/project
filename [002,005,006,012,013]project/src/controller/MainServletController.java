package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CustomerDAO;
import domain.CustomerDTO;
import exception.DuplicatedException;
import exception.RecordNotFoundException;

public class MainServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String action = request.getParameter("action");
		if(action.equals("joinCustomer")){
			joinCustomer(request,response);
		}else if(action.equals("login")){
			login(request,response);
		}else if(action.equals("logout")){
			logout(request,response);
		}else if(action.equals("detailCustomer")){
			detailCustomer(request,response);
		}else if(action.equals("listCustomer")){
			listCustomer(request,response);
		}else if(action.equals("updateCustomer")){
			updateCustomer(request,response);
		}else if(action.equals("executeUpdate")){
			executeUpdate(request,response);
		}else if(action.equals("deleteCustomer")){
			deleteCustomer(request,response);
		}
	}
	protected void joinCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("custId");
		String name = request.getParameter("custName");
		String pwd = request.getParameter("custPwd");
		String address = request.getParameter("address");
		try {
			CustomerDAO.insertCustomer(new CustomerDTO(id,name,pwd,address));
		} catch (DuplicatedException e) {
			response.sendRedirect("error.html");
		}
		response.sendRedirect("index.jsp");
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("custId");
		String pwd = request.getParameter("custPwd");
		boolean check = CustomerDAO.customerIdCheck(new CustomerDTO(id,pwd));
		if(check){
			HttpSession session = request.getSession();
			session.setAttribute("user", id);
			response.sendRedirect("index.jsp");
		}else{
			response.sendRedirect("error.html");
		}
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	protected void detailCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user");
		request.setAttribute("cust",CustomerDAO.getCustomerById(id));
		request.getRequestDispatcher("index.jsp?action=member/customerDetail.jsp").forward(request, response);
	}
	protected void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", CustomerDAO.getCustomerAll());
		request.getRequestDispatcher("index.jsp?action=member/customerList.jsp").forward(request, response);
	}
	protected void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user");
		request.setAttribute("cust",CustomerDAO.getCustomerById(id));
		request.getRequestDispatcher("index.jsp?action=member/viewUpdate.jsp").forward(request, response);
	}
	protected void executeUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user");
		String name = request.getParameter("custName");
		String pwd = request.getParameter("custPwd");
		String address = request.getParameter("address");
		try {
			CustomerDAO.updateCustomer(new CustomerDTO(id,name,pwd,address));
		} catch (RecordNotFoundException e) {
			response.sendRedirect("error.html");
		}
		response.sendRedirect("index.jsp");
	}
	protected void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("user");
		try {
			CustomerDAO.deleteCustomer(id);
		} catch (RecordNotFoundException e) {
			response.sendRedirect("error.html");
		}
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}
