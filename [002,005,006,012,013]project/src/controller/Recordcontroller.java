package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BaseBallDAO;
import model.ScheduleDAO;
import domain.BaseBallDTO;
import domain.ScheduleDTO;
public class Recordcontroller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("setValue")){
			setValue(request, response);
		}else if(action.equals("gameStart")){
			gameStart(request, response);
		}else if(action.equals("rank")){
			rank(request,response);
		}
		
	}
	
	protected void setValue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("setValue");
		String code = request.getParameter("code").trim();
		String ft = request.getParameter("ft").trim();
		String st = request.getParameter("st").trim();
		
		request.setAttribute("code", code);
		request.setAttribute("ft", ft);
		request.setAttribute("st", st);
		
		request.setAttribute("imgft", ft.toLowerCase());
		request.setAttribute("imgst", st.toLowerCase());
		request.getRequestDispatcher("index.jsp?action=baseball/startGame.jsp").forward(request, response);
	}
		
	protected void gameStart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gameStart");
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		int code = Integer.parseInt(request.getParameter("code")); //°íÀ¯ÄÚµå
		String ft = request.getParameter("ft"); //firstteam
		String st = request.getParameter("st"); //secondteam
		
		System.out.println(code);
		System.out.println(ft);
		System.out.println(st);
		PrintWriter out = response.getWriter();
		
		Random a = new Random();
		int gamecount = 0, win = 0, moo = 0, lose = 0, total1 = 0, total2 = 0, score1 = 0, score2 = 0; 
		double percent1 = 0;
		double percent2 = 0;
		String jumsoo1 = null;
		String jumsoo2 = null;
		String team1 = ft;
		String team2 = st;
		BaseBallDTO bean1 = null;
		BaseBallDTO bean2 = null;
		for(int i = 0; i < 9; i++){
			score1 = a.nextInt(3);
			score2 = a.nextInt(3);
			
			total1 += score1;
			total2 += score2;
			if(jumsoo1 == null && jumsoo2 == null){
				jumsoo1 = Integer.toString(score1) + ",";
				jumsoo2 = Integer.toString(score2) + ",";
			}else if(i == 8){
				jumsoo1 += Integer.toString(score1) + "/";
				jumsoo2 += Integer.toString(score2) + "/";
			}else{
				jumsoo1 += Integer.toString(score1) + ",";
				jumsoo2 += Integer.toString(score2) + ",";
			}
		}
		out.print(jumsoo1 + jumsoo2);
		System.out.println("total1 : " + total1);
		System.out.println("total2 : " + total2);
		try {
			ScheduleDAO.updateScore(new ScheduleDTO(code, total1, total2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("3");
			e1.printStackTrace();
		}
		
		if(total1 > total2){
			try{
				System.out.println(team1);
				System.out.println(team2);
				
				try{
					bean1 = BaseBallDAO.getPercent(team1);
					System.out.println(bean1);
					bean2 = BaseBallDAO.getPercent(team2);
					System.out.println("2-1½Ã½º¾Æ¿ô");
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("bean1getWin() : " + bean1.getWin());
				System.out.println("bean1.getGamecount() : " + bean1.getGamecount());
				percent1 = ((double)bean1.getWin() / (bean1.getGamecount() + 1));
				percent2 = ((double)bean2.getWin() + 1) / (bean1.getGamecount() + 1);
				bean1 = BaseBallDAO.getPercent(team1);
				bean2 = BaseBallDAO.getPercent(team2);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("bean1.getWin() : " + bean1.getWin());
			System.out.println("bean1.getGamecount() : " + bean1.getGamecount());
			percent1 = ((double)bean1.getWin() + 1) / (bean1.getGamecount() + 1);
			percent2 = ((double)bean2.getWin()) / (bean2.getGamecount() + 1);
			out.print("°á°ú : " + team1 + "½Â¸®");
			System.out.println(team1 + "per1: " + percent1);
			System.out.println(team2 + "per2: " + percent2);
			try{
				BaseBallDAO.updateBase(new BaseBallDTO(team1, 1, 1, 0, 0, percent1));
				BaseBallDAO.updateBase(new BaseBallDTO(team2, 1, 0, 0, 1, percent2));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(total1 < total2){
			System.out.println(team1);
			System.out.println(team2);
			
			try{
				bean1 = BaseBallDAO.getPercent(team1);
				bean2 = BaseBallDAO.getPercent(team2);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("bean1getWin() : " + bean1.getWin());
			System.out.println("bean1.getGamecount() : " + bean1.getGamecount());
			percent1 = ((double)bean1.getWin() / (bean1.getGamecount() + 1));
			percent2 = ((double)bean2.getWin() + 1) / (bean2.getGamecount() + 1);
			out.print("°á°ú : " + team2 + "½Â¸®");
			System.out.println("team2½Â¸®ÂÊper1: " + percent1);
			System.out.println("team2½Â¸®ÂÊper2: " + percent2);
			try{
				BaseBallDAO.updateBase(new BaseBallDTO(team1, 1, 0, 0, 1, percent1));
				BaseBallDAO.updateBase(new BaseBallDTO(team2, 1, 1, 0, 0, percent2));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(total1 == total2){
			try{
				bean1 = BaseBallDAO.getPercent(team1);
				bean2 = BaseBallDAO.getPercent(team2);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("bean1getWin() : " + bean1.getWin());
			System.out.println("bean1.getGamecount() : " + bean1.getGamecount());
			percent1 = ((double)bean1.getWin() / (bean1.getGamecount() + 1));
			percent2 = ((double)bean2.getWin() / (bean1.getGamecount() + 1));
			out.print("°á°ú : ¹«½ÂºÎ");
			try{
				BaseBallDAO.updateBase(new BaseBallDTO(team1, 1, 0, 1, 0, percent1));
				BaseBallDAO.updateBase(new BaseBallDTO(team2, 1, 0, 1, 0, percent2));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	protected void rank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BaseBallDTO> list = BaseBallDAO.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp?action=baseball/baseballRanking.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}



