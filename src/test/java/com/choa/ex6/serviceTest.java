package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;

public class serviceTest extends MyabstractTestUnit {
	
	@Autowired
	private MemoService memoService;
	private MemoDTO memoDTO;

	@Test
	public void test() throws Exception {
		memoDTO = new MemoDTO();
		
		memoDTO.setContents("dddd");
		memoDTO.setWriter("ddd");
		
		int result=memoService.boardWrite(memoDTO);
		
		assertNotEquals(0, result);
		
		
	}

}
