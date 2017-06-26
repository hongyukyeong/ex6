package com.choa.ex6;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

//@RestController //responseBody를 대신해서 controller부분을 이렇게 바꿔줌 json애들을 모아서 한꺼번에 처리해줘도 괜찮음
@Controller
@RequestMapping(value="/memo/**")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="memoList")
	public void memoList() throws Exception{}
	
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody
	public List<MemoDTO> getMemoList(@PathVariable("curPage") int curPage, @PathVariable("find") String find, @PathVariable("search") String search) throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		List<MemoDTO> list =memoService.boardList(listInfo);
		
		return list;
		
	}
	
	@RequestMapping(value="memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num)throws Exception{//@PathVariable("num")변수로 만드는 방법
		MemoDTO memoDTO = memoService.boardView(num);
		
		return memoDTO;
	}
	
	
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	@ResponseBody
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model) throws Exception{
		int result=memoService.boardWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list=memoService.boardList(listInfo);
		
		return list;
	}
	
}
