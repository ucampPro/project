package model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;
import domain.ScheduleDTO;

public class ScheduleDAO {
	public static void insert(ScheduleDTO schedule) throws SQLException{
		SqlSession session = DBUtil.getSqlSession(true);
		try{
			String year = schedule.getYear();
			String month = schedule.getMonth();
			String day = schedule.getDay();
			String hour = schedule.getHour();
			String firstTeam = schedule.getFirstTeam();
			String secondTeam = schedule.getSecondTeam();
			ScheduleDTO scheduleData = new ScheduleDTO(year, month, day, hour, firstTeam, secondTeam);
			session.insert("s.insert", scheduleData);
		} finally{
			session.close();
		}
	}
	public static List selectAll() throws SQLException{
		SqlSession session = DBUtil.getSqlSession();
		List list = null;
		try{
			list = session.selectList("s.selectAll");			
			System.out.println(list);
		}finally{
			session.close();
		} 
		return list;
	}
	public static List selectMonth(String year, String month) throws SQLException{
		SqlSession session = DBUtil.getSqlSession();
		List list = null;
		try{
			HashMap data = new HashMap();
			data.put("year", year);
			data.put("month", month);
			list = session.selectList("s.selectMonth", data);			
			System.out.println(list);
		}finally{
			session.close();
		} 
		return list;
	}
	public static List selectDay(String year, String month, String day) throws SQLException{
		SqlSession session = DBUtil.getSqlSession();
		List list = null;
		try{
			HashMap data = new HashMap();
			data.put("year", year);
			data.put("month", month);
			data.put("day", day);
			list = session.selectList("s.selectDay", data);			
			System.out.println(list);
		}finally{
			session.close();
		} 
		return list;
	}
	public static ScheduleDTO selectOne(int code) throws SQLException{
		SqlSession session = DBUtil.getSqlSession();
		ScheduleDTO schedule = null;
		try{
			schedule = (ScheduleDTO)session.selectOne("s.selectOne", code);
		}finally{
			session.close();
		}
		return schedule;
	}
	public static int delete(int code) throws SQLException{
		SqlSession session = DBUtil.getSqlSession(true);
		int result = 0;
		try{
			result = session.delete("s.delete", code);
		}finally{
			session.close();
		}
		return result;
	}
	public static void update(ScheduleDTO schedule) throws SQLException{
		SqlSession session = DBUtil.getSqlSession(true);
		try{
			session.update("s.update", schedule);
		}finally{
			session.close();
		}
	}
	
	public static void updateScore(ScheduleDTO schedule) throws SQLException{
		SqlSession session = DBUtil.getSqlSession(true);
		try{
			session.update("s.updateScore", schedule);
		}finally{
			session.close();
		}
	}
}
