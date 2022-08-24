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
		String viewName = (String)request.getAttribute("viewName");
		List listBoard = boardService.listBoard();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("listBoard",listBoard);
		return mav;
	}
	
	//공지사항 상세보기
	@Override
	@RequestMapping(value = "admin/board/boardDetail.do" , method = RequestMethod.GET)
	public ModelAndView detailBoard(@RequestParam("boardNO")int boardNO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(boardNO);
		boardVO  = boardService.detailBoard(boardNO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("board", boardVO);
		return mav;
	}
	
	//admin/board/*.FORM 화면으로 넘어가기
		@RequestMapping(value="admin/board/*Form.do", method = RequestMethod.GET)
		private ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception {
			String viewName = (String)request.getAttribute("viewName");
			System.out.println(viewName);
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("board", boardVO);
			return mav;	
		}
	
	
	
	//공지사항 삭제
	@Override
	@RequestMapping(value = "admin/board/removeBoard.do" , method = RequestMethod.GET)
	public ModelAndView removeBoard(@RequestParam("boardNO")int boardNO,HttpServletRequest request) throws Exception {
		boardService.removeBoard(boardNO);
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do");
		return mav;
	}
	
	//공지사항 추가
	@Override
	@RequestMapping(value = "admin/board/addBoard.do" , method = RequestMethod.POST)
	public ModelAndView addBoard(@ModelAttribute("board") BoardVO board,HttpServletRequest request) throws Exception {
		int result = 0;
		result = boardService.addBoard(board);
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do");
		return mav;
	}
	
	//공지사항 수정
	@Override
	@RequestMapping(value = "admin/board/modifyBoard.do" , method = RequestMethod.POST)
	public ModelAndView modifyBoard(@ModelAttribute("board") BoardVO board,HttpServletRequest request) throws Exception {
		
		int result = boardService.modifyBoard(board);
		ModelAndView mav = new ModelAndView("redirect:/admin/board/adminBoardMain.do");
		return mav;
	}


	
}
