package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.DBUtil;
import domain.BaseBallDTO;
import exception.RecordNotFoundException;

public class BaseBallDAO {
	public static List<BaseBallDTO> selectAll() throws Exception{
		SqlSession session = DBUtil.getSqlSession();
		List<BaseBallDTO> listAll = null;
		
		try{
			listAll = session.selectList("base.selectAll");
		}finally{
			session.close();
		}
		return listAll;
	}
	
	public static BaseBallDTO getPercent(String teamname) throws Exception{
		SqlSession session = DBUtil.getSqlSession();
		BaseBallDTO listAll = null;
		try{
			listAll = session.selectOne("base.getPercent",teamname);
		}finally{
			session.close();
		}
		return listAll;
	}
	
	public static void updateBase(BaseBallDTO dto) throws Exception{
		SqlSession session = DBUtil.getSqlSession();
		int result = 0;
		try{
			result = session.update("base.updateBase",dto);
			if(result == 0){
				throw new RecordNotFoundException();
			}
			session.commit();
		}finally{
			session.close();
		}
	}
}
