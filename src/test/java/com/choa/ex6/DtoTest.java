package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOImpl;

public class DtoTest extends MyabstractTestUnit {
	
	@Autowired
	private NoticeDAOImpl noticeDAOImpl;
	

	@Test
	public void test() throws Exception {
		BoardDTO boardDTO=noticeDAOImpl.boardView(730);
		
		assertNotNull(boardDTO);
	}

}
