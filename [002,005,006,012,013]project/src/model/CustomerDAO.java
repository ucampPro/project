package model;

import java.util.List;

import domain.CustomerDTO;
import exception.DuplicatedException;
import exception.RecordNotFoundException;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;

public class CustomerDAO {
	public static int insertCustomer(CustomerDTO cust) throws DuplicatedException{
		if(isExit(cust.getCustId())){
			throw new DuplicatedException();
		}
		
		SqlSession session = null;
		int result = 0;
		try{
			session = DBUtil.getSqlSession(true);
			result = session.insert("c.insertCustomer",cust);
		}finally{
			DBUtil.closeSqlSession(true, session);
		}
		return result;
	}
	public static List<CustomerDTO> getCustomerAll(){
		SqlSession session = null;
		List<CustomerDTO> list = null;
		try{
			session = DBUtil.getSqlSession();
			list = session.selectList("c.selectAll");
		}finally{
			DBUtil.closeSqlSession(false, session);
		}
		return list;
	}
	public static boolean customerIdCheck(CustomerDTO cust){
		SqlSession session = null;
		boolean check = false;
		try{
			session = DBUtil.getSqlSession();
			if(session.selectOne("c.selectCheck", cust) != null){
				check = true;
				return check;
			}
		}finally{
			DBUtil.closeSqlSession(false, session);
		}
		return check;
	}
	public static CustomerDTO getCustomerById(String custId){
		SqlSession session = null;
		CustomerDTO cust = null;
		try{
			session = DBUtil.getSqlSession();
			cust = session.selectOne("c.selectId", custId);
		}finally{
			DBUtil.closeSqlSession(false, session);
		}
		return cust;
	}
	public static int updateCustomer(CustomerDTO cust) throws RecordNotFoundException{
		if(!isExit(cust.getCustId())){
			throw new RecordNotFoundException();
		}
		
		SqlSession session = null;
		int result = 0;
		try{
			session = DBUtil.getSqlSession(true);
			result = session.update("c.updateCustomer", cust);
		}finally{
			DBUtil.closeSqlSession(true, session);
		}
		return result;
	}
	public static int deleteCustomer(String custId) throws RecordNotFoundException{
		if(!isExit(custId)){
			throw new RecordNotFoundException();
		}
		
		SqlSession session = null;
		int result = 0;
		try{
			session = DBUtil.getSqlSession(true);
			result = session.delete("c.deleteCustomer", custId);
		}finally{
			DBUtil.closeSqlSession(true, session);
		}
		return result;
	}
	
	private static boolean isExit(String custId){
		SqlSession session = null;
		CustomerDTO cust = null;
		boolean check = false;
		try{
			session = DBUtil.getSqlSession();
			cust = session.selectOne("c.selectId", custId);
			if(cust != null){
				check = true;
				return check;
			}
		}finally{
			DBUtil.closeSqlSession(false, session);
		}
		return check;
	}
}
