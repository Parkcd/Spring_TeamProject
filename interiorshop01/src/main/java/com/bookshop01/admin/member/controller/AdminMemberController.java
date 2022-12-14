package com.bookshop01.admin.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.member.vo.MemberVO;

public interface AdminMemberController {
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap, @RequestParam String s_search_type,
			   @RequestParam String t_search_word,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView memberDetail(@RequestParam("member_id")String member_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response)  throws Exception;
}
