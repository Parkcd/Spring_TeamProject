package com.bookshop01.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.board.service.BoardService;
import com.bookshop01.board.vo.BoardVO;

@Controller("boardController")
public class BoardControllerImpl implements BoardController{

	@Autowired
	BoardService boardService;
	@Autowired
	BoardVO boardVO;
	
	//공지사항 메인으로 
	@Override
	@RequestMapping(value = "admin/board/adminBoardMain.do", method = RequestMethod.GET)
	public ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName"); // viewName에 jsp viewName 정보 가져와 viewName 에 대입
		List listBoard = boardService.listBoard(); // List 형태로 되어있는 listBoard에 boardService에있는 listBoard 메소드를 수행한 결과 대입.
		ModelAndView mav = new ModelAndView(viewName); // mav에 ModelAndView 객체를 생성하고 viewName을 매개변수로 넣은 정보 삽입.
		mav.addObject("listBoard",listBoard); // mav에 Key를 listBoard로 value를 listBoard 값으로 대입.
		return mav; // mav 반환
	}
	
	//공지사항 상세보기
	@Override
	@RequestMapping(value = "admin/board/boardDetail.do" , method = RequestMethod.GET)
	public ModelAndView detailBoard(@RequestParam("boardNO")int boardNO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName"); // viewName에 jsp viewName 정보 가져와 viewName 에 대입
		System.out.println(boardNO); // boardNO 출력
		boardVO  = boardService.detailBoard(boardNO); // detailBoard메소드에 boardNO 매개변수 넣고 나온결과 boardVO에 대입
		 
		ModelAndView mav = new ModelAndView(); // ModelAndView 객체 생성
		mav.setViewName(viewName);  // ViewName을 jsp의 viewName으로 설정
		mav.addObject("board", boardVO); // mav에 key를 board로 value를 boardVO 값으로 설정하여 추가.
		return mav; // mav 반환
	}
	
	//admin/board/*.FORM 화면으로 넘어가기
		@RequestMapping(value="admin/board/*Form.do", method = RequestMethod.GET)
		private ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception {
			String viewName = (String)request.getAttribute("viewName"); // viewName에 jsp viewName 정보 가져와 viewName 에 대입
			System.out.println(viewName); // viewName 출력
			ModelAndView mav = new ModelAndView(viewName); // ModelAndView 객체 생성
			mav.addObject("board", boardVO); // key를 board로 value를 boardVO 값으로 설정하여 추가.
			return mav; // mav 반환
		}
	
	
	
	//공지사항 삭제
	@Override
	@RequestMapping(value = "admin/board/removeBoard.do" , method = RequestMethod.GET)
	public ModelAndView removeBoard(@RequestParam("boardNO")int boardNO,HttpServletRequest request) throws Exception {
		boardService.removeBoard(boardNO); // removeboard 메소드에 boardNO 정보 매개변수로 대입하여 수행
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do"); // ModelAndView 객체 생성 후 redirect를 
																						// adminBoardMain.do로 지정함.
		return mav; // mav 반환.
	}
	
	//공지사항 추가
	@Override
	@RequestMapping(value = "admin/board/addBoard.do" , method = RequestMethod.POST)
	public ModelAndView addBoard(@ModelAttribute("board") BoardVO board,HttpServletRequest request) throws Exception {
		int result = 0; // result 초기값 설정
		result = boardService.addBoard(board); // result에 addBoard 메소드 board값을 매개변수로 넣고 수행한 결과 대입
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do"); // ModelAndView 객체 생성 후 redirect를
																						// adminBoardMain.do로 지정함.
		return mav; // mav 반환
	}
	
	//공지사항 수정
	@Override
	@RequestMapping(value = "admin/board/modifyBoard.do" , method = RequestMethod.POST)
	public ModelAndView modifyBoard(@ModelAttribute("board") BoardVO board,HttpServletRequest request) throws Exception {
		
		int result = boardService.modifyBoard(board); // result에 modifyBoard 메소드 board값을 매개변수로 넣고 수행한 결과 대입
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do");  // ModelAndView 객체 생성 후 redirect를
																					     // adminBoardMain.do로 지정함.
		return mav; // mav 반환.
	}


	
}
