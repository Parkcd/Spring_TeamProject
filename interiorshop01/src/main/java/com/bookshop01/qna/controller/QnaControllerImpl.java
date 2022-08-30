package com.bookshop01.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.member.vo.MemberVO;
import com.bookshop01.qna.service.QnaService;
import com.bookshop01.qna.vo.QnaVO;

@Controller("qnaController")
public class QnaControllerImpl implements QnaController{

	@Autowired
	QnaService qnaService;
	@Autowired
	QnaVO qnaVO;
	@Autowired
	MemberVO memberVO;
	
	
	//qna 메인으로 
	@Override
	@RequestMapping(value = "qna/qnaMain.do", method = RequestMethod.GET)
	public ModelAndView listQna(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List listQna = qnaService.listQna();
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("MemberInfo");
		System.out.println(id);
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("listQna",listQna);
		return mav;
	}
	
	//qna 상세보기
	@Override
	@RequestMapping(value = "qna/qnaDetail.do" , method = RequestMethod.GET)
	public ModelAndView detailQna(@RequestParam("qNO")int qNO,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		System.out.println(qNO);
		qnaVO  = qnaService.detailQna(qNO);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("qna", qnaVO);
		return mav;
	}
	
	//qna/*.FORM 화면으로 넘어가기
		@RequestMapping(value="qna/*Form.do", method = RequestMethod.GET)
		private ModelAndView login(HttpServletRequest request, HttpServletResponse response)throws Exception {
			String viewName = (String)request.getAttribute("viewName");
			System.out.println(viewName);
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("qna", qnaVO);
			return mav;	
		}
	
	
	
	//qna삭제
	@Override
	@RequestMapping(value = "qna/removeQna.do" , method = RequestMethod.GET)
	public ModelAndView removeQna(@RequestParam("qNO")int qNO,HttpServletRequest request) throws Exception {
		qnaService.removeQna(qNO);
		ModelAndView mav = new ModelAndView("redirect:/qna/qnaMain.do");
		return mav;
	}
	
	//질문하기
	@Override
	@RequestMapping(value = "qna/writeQna.do" , method = RequestMethod.POST)
	public ModelAndView addQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request) throws Exception {
		int result = 0;
		HttpSession session = request.getSession();
		session.setAttribute("memberInfo", memberVO);
		result = qnaService.addQna(qna);
		ModelAndView mav = new ModelAndView("redirect:/qna/qnaMain.do");
		return mav;
	}
	
	//답변하기
	@Override
	@RequestMapping(value = "qna/writeAnswer.do" , method = RequestMethod.POST)
	public ModelAndView modifyQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request) throws Exception {
		
		int result = qnaService.modifyQna(qna);
		System.out.println("!!!!!!!!!"+result);
		ModelAndView mav = new ModelAndView("redirect:/qna/qnaMain.do");
		return mav;
	}


	
}
