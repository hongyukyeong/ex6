package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableADTO;
import com.choa.table.TableService;

public class TableTest extends MyabstractTestUnit {
	
	@Autowired
	private TableService tableService;

	@Test
	public void test() throws Exception {
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(2);
		tableADTO.setTitle("t2");
		tableADTO.setWriter("t2");
		int result = tableService.insertTable(tableADTO, 1);
		assertNotEquals(0, result);
	}

}
