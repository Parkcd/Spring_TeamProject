package com.bookshop01.qna.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.qna.vo.QnaVO;

public interface QnaController {

	public ModelAndView listQna(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView detailQna(@RequestParam("qnaNO") int qnaNO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public ModelAndView removeQna(@RequestParam("qnaNO")int qnaNO,HttpServletRequest request)throws Exception;
	
	public ModelAndView addQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request)throws Exception;
	
	public ModelAndView modifyQna(@ModelAttribute("qna") QnaVO qna,HttpServletRequest request)throws Exception;
}
