package com.bookshop01.admin.order.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface AdminOrderController {
	public ModelAndView adminOrderMain(@RequestParam Map<String, String> dateMap,
			@RequestParam(required = false) String s_search_type, // s_search_type을 가져온다
			@RequestParam(required = false) String t_search_word, // t__search_word를 가져온다
            HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ResponseEntity modifyDeliveryState(@RequestParam Map<String, String> deliveryMap, 
            HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView orderDetail(@RequestParam("order_id") int order_id, 
            HttpServletRequest request, HttpServletResponse response)  throws Exception;
	
	
}
