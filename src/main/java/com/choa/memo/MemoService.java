package com.choa.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {
	
	@Autowired
	private MemoDAO memoDAO;
	
	
	
	public List<MemoDTO> boardList(ListInfo listInfo) throws Exception{
		int result = memoDAO.boardCount(listInfo);
		listInfo.makePage(result);
		listInfo.setRow();
		
		return memoDAO.boardList(listInfo); 
	}
	
	public MemoDTO boardView(int num) throws Exception{
		return memoDAO.boardView(num);
	}
	
	public int boardWrite(MemoDTO memoDTO) throws Exception{
		return memoDAO.boardWrite(memoDTO);
	}
	
	public int boardUpdate(MemoDTO memoDTO) throws Exception{
		return memoDAO.boardUpdate(memoDTO);
	}
	
	public int boardDelete(int num) throws Exception{
		return memoDAO.boardDelete(num);
	}
	

}
