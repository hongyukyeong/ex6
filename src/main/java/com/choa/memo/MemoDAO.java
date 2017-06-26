package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;

@Repository
public class MemoDAO {
	
	
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="MemoMapper.";
	
	
	//list
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	
	}
		
	//insert
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
		
	}
	
	//view
	public MemoDTO boardView(int num) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"view", num);//arg1에는 내가 넘겨줘야 하는 데이터
	}
	
	
	//update
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	
	//delete
	public int boardDelete(int num) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	//count
	public int boardCount(ListInfo listInfo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}

}
