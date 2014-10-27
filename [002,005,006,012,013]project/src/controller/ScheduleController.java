package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ScheduleDAO;
import domain.ScheduleDTO;

public class ScheduleController extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		process(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		process(request,response);
	}
	public void process(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("EUC-KR");
		String action=request.getParameter("action");
		if(action.equals("input")){
			input(request,response);
		}else if(action.equals("selectOne")){
			selectOne(request,response);
		}else if(action.equals("updateForm")){
			updateForm(request,response);
		}else if(action.equals("update")){
			update(request,response);
		}else if(action.equals("selectAll")){
			selectAll(request,response);
		}else if(action.equals("delete")){
			delete(request,response);
		}else if(action.equals("inputForm")){
			inputForm(request,response);
		}else if(action.equals("selectMonth")){
			selectMonth(request,response);
		}else if(action.equals("selectDay")){
			selectDay(request,response);
		}else if(action.equals("selectAllList")){
			selectAllList(request,response);
		}
	}
	public void input(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		HttpSession session = request.getSession();
		String date = request.getParameter("date").trim();
		String year =date.split("-")[0];
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		String hour = request.getParameter("hour").trim().split(":")[0];
		String firstTeam =request.getParameter("firstTeam").trim();
		String secondTeam = request.getParameter("secondTeam").trim();
		ScheduleDTO schedule = new ScheduleDTO(year, month, day, hour, firstTeam, secondTeam);
		try {
			ScheduleDAO.insert(schedule);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void selectOne(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		int code = Integer.parseInt(request.getParameter("code"));
		ScheduleDTO schedule;
		try {
			schedule = ScheduleDAO.selectOne(code);
			request.setAttribute("schedule", schedule);
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleView.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void updateForm(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		int code = Integer.parseInt(request.getParameter("code"));
		try {
			request.setAttribute("schedule", ScheduleDAO.selectOne(code));
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleUpdateForm.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		int code = Integer.parseInt(request.getParameter("code"));
		HttpSession session = request.getSession();
		String date = request.getParameter("date").trim();
		String year =date.split("-")[0];
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		String hour = request.getParameter("hour").trim().split(":")[0];
		String firstTeam =request.getParameter("firstTeam").trim();
		String secondTeam = request.getParameter("secondTeam").trim();
		ScheduleDTO schedule = new ScheduleDTO(code, year, month, day, hour, firstTeam, secondTeam);
		try {
			ScheduleDAO.update(schedule);
			request.setAttribute("schedule", ScheduleDAO.selectOne(code));
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleView.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}  
	
	public void selectAll (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		try {
			List<ScheduleDTO> list = ScheduleDAO.selectAll();
			int size = list.size();
			List firstTeam=new ArrayList();
			for(int i=0; i<size; i++){
				firstTeam.add(i,list.get(i).getFirstTeam());
			}
			List secondTeam=new ArrayList();
			for(int i=0; i<size; i++){
				secondTeam.add(i,list.get(i).getSecondTeam());
			}
			List year=new ArrayList();
			for(int i=0; i<size; i++){
				year.add(i,list.get(i).getYear());
			}
			List month=new ArrayList();
			for(int i=0; i<size; i++){
				month.add(i,list.get(i).getMonth());
			}
			List day=new ArrayList();
			for(int i=0; i<size; i++){
				day.add(i,list.get(i).getDay());
			}
			List code=new ArrayList();
			for(int i=0; i<size; i++){
				code.add(i,list.get(i).getCode());
			}
			System.out.println(firstTeam);
			request.setAttribute("list", ScheduleDAO.selectAll());
			request.setAttribute("firstTeam", firstTeam);
			request.setAttribute("secondTeam", secondTeam);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("code", code);
			request.setAttribute("size", size);
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleMonthManager.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void selectAllList (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		try {
			List<ScheduleDTO> list = ScheduleDAO.selectAll();
			int size = list.size();
			List firstTeam=new ArrayList();
			for(int i=0; i<size; i++){
				firstTeam.add(i,list.get(i).getFirstTeam());
			}
			List secondTeam=new ArrayList();
			for(int i=0; i<size; i++){
				secondTeam.add(i,list.get(i).getSecondTeam());
			}
			List year=new ArrayList();
			for(int i=0; i<size; i++){
				year.add(i,list.get(i).getYear());
			}
			List month=new ArrayList();
			for(int i=0; i<size; i++){
				month.add(i,list.get(i).getMonth());
			}
			List day=new ArrayList();
			for(int i=0; i<size; i++){
				day.add(i,list.get(i).getDay());
			}
			List code=new ArrayList();
			for(int i=0; i<size; i++){
				code.add(i,list.get(i).getCode());
			}
			System.out.println(firstTeam);
			request.setAttribute("list", ScheduleDAO.selectAll());
			request.setAttribute("firstTeam", firstTeam);
			request.setAttribute("secondTeam", secondTeam);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			request.setAttribute("code", code);
			request.setAttribute("size", size);
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleMonth.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void selectMonth (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String date = request.getParameter("monthInfo").trim();
		String year =date.split("-")[0];
		String month = date.split("-")[1];
		try {
			request.setAttribute("list", ScheduleDAO.selectMonth(year, month));
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleMonth2.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void selectDay (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String date = request.getParameter("dayInfo").trim();
		String year =date.split("-")[0];
		String month = date.split("-")[1];
		String day = date.split("-")[2];
		try {
			request.setAttribute("list", ScheduleDAO.selectDay(year, month, day));
			request.getRequestDispatcher("index.jsp?action=schedule/scheduleDay.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void delete (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		int code = Integer.parseInt(request.getParameter("code"));
		try {
			ScheduleDAO.delete(code);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}
	
	public void inputForm (HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect("index.jsp?action=schedule/sInputForm.jsp");
	}
}
