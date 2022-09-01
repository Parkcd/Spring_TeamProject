package com.bookshop01.admin.order.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.admin.goods.service.AdminGoodsService;
import com.bookshop01.admin.order.service.AdminOrderService;
import com.bookshop01.common.base.BaseController;
import com.bookshop01.goods.vo.GoodsVO;
import com.bookshop01.goods.vo.ImageFileVO;
import com.bookshop01.member.vo.MemberVO;
import com.bookshop01.mypage.controller.MyPageController;
import com.bookshop01.mypage.service.MyPageService;
import com.bookshop01.order.vo.OrderVO;

@Controller("adminOrderController")
@RequestMapping(value="/admin/order")
public class AdminOrderControllerImpl extends BaseController  implements AdminOrderController{
	@Autowired
	AdminOrderService adminOrderService;
	
	@Override
	@RequestMapping(value="/adminOrderMain.do" ,method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView adminOrderMain(@RequestParam Map<String, String> dateMap,
			@RequestParam(required = false) String s_search_type, // s_search_type을 가져온다
			@RequestParam(required = false) String t_search_word, // t__search_word를 가져온다
			                          HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName"); // view 안의 jsp 이름을 불러온다.
		ModelAndView mav = new ModelAndView(viewName); // viewName 매개변수로 ModelAndView 객채 생성

		System.out.println("!!!!!!!!!!"+dateMap); 
		String fixedSearchPeriod = dateMap.get("fixedSearchPeriod");  // fixedSearchPeriod 정보 가져와 대입.
		String section = dateMap.get("section"); // section 정보 가져옴.
		String pageNum = dateMap.get("pageNum"); // pageNum 정보 가져옴.
		String beginDate=null,endDate=null; // begindate , endDate 초기값 null 로 설정
		String beginYear = dateMap.get("beginYear"); // beginYear 정보 가져와 대입.
		String beginMonth = dateMap.get("beginMonth"); // beginMonth 정보 가져와 대입.
		String beginDay = dateMap.get("beginDay"); // beginDay 정보 가져와 대입.
		
		String [] tempDate=calcSearchPeriod(fixedSearchPeriod).split(","); // 매개변수로 fixedSearchPeriod 정보 넣고 , 형식에 맞춰서 tempdate 배열에 대입
		/* beginDate=tempDate[0]; */
		endDate=tempDate[1];
		/* dateMap.put("beginDate", beginDate); */
		dateMap.put("endDate", endDate); // dateMap에 endDate 형태로 값 집어넣음.
		
		if (beginYear == null) { // beginYear 조건 설정 후 밑의 설정값 대입.
			beginYear = "2018";
			beginMonth = "01";
			beginDay = "01";
		}
		
		beginDate = beginYear + "-" + beginMonth + "-" + beginDay; // beginDate에 각 Year , Month , Day 값 불러와 2018-01-01 형식으로 설정
		
		HashMap<String,Object> condMap=new HashMap<String,Object>();  // condMap 객채 생성.
		if(section== null) { // section 초기값 설정
			section = "1";
		}
		condMap.put("section",section); // CondMap에 key를 section으로 value를 pageNum 값 대입
		if(pageNum== null) {
			pageNum = "1";
		}
		condMap.put("pageNum",pageNum); // CondMap에 key를 pageNum으로 value를 pageNum 값 대입
		condMap.put("beginDate",beginDate); // CondMap에 key를 begiDate으로 value를 beginDate 값 대입 
		condMap.put("endDate", endDate); // CondMap에 key를 endDate으로 value를 endDate 값 대입
		condMap.put("s_search_type", s_search_type);// s_search_type condMap에 전달
		condMap.put("t_search_word", t_search_word);// t_search_word condMap에 전달
		List<OrderVO> newOrderList=adminOrderService.listNewOrder(condMap); // List 형식인 newOrderList에 listNewOrder메소드를 condMap에 저장되어있는 value로
																		    // 넣고 수행항 결과 newOrderList에 대입.
		mav.addObject("newOrderList",newOrderList); // ModelAndView에 Key를 newOrderList 로 value를 newOrderList 값으로 설정.
		
	
		String endDate2[]=endDate.split("-"); // endDate 형식에 - 으로 구별하여 endDate2 배열에 저장
		mav.addObject("beginYear", beginYear);// beginDate1의 배열 영 번째 값을 beginYear이라는 키로 mav전달
		mav.addObject("beginMonth", beginMonth);// beginDate1의 배열 첫 번째 값을 beginMonth라는 키로 mav전달
		mav.addObject("beginDay", beginDay);// beginDate1의 배열 두번 째 값을 beginDay라는 키로 mav전달
		mav.addObject("endYear",endDate2[0]);  // endYear로 key 설정하고 value로 endDate2 배열에 들어가있는 첫번째 값을 설정하여 mav에 전달 
		mav.addObject("endMonth",endDate2[1]); // endMonth로 key 설정하고 value로 endDate2 배열에 들어가있는 두번째 값을 설정하여 mav에 전달
		mav.addObject("endDay",endDate2[2]); // endDay로 key 설정하고 value로 endDate2 배열에 들어가있는 세번째 값을 설정하여 mav에 전달
		
		mav.addObject("section", section); // key를 section 으로 value를 section 값을 넣고 mav로 전달
		mav.addObject("pageNum", pageNum); // key를 pageNum 으로 value를 pageNum 값을 넣고 mav로 전달
		return mav; // mav 로 return
		
	}
	
	@Override
	@RequestMapping(value="/modifyDeliveryState.do" ,method={RequestMethod.POST})
	public ResponseEntity modifyDeliveryState(@RequestParam Map<String, String> deliveryMap, 
			                        HttpServletRequest request, HttpServletResponse response)  throws Exception {
		adminOrderService.modifyDeliveryState(deliveryMap);
		
		String message = null; // message 초기값 설정
		ResponseEntity resEntity = null; // resEntity 초기값 설정
		HttpHeaders responseHeaders = new HttpHeaders(); // HttpHeaders 객체 생성
		message  = "mod_success"; // message에 수정 성공 message 대입
		resEntity =new ResponseEntity(message, responseHeaders, HttpStatus.OK); // resEntity에 객체생성 후 message, responseHeaders , HttpStatus.OK
																				// 매개변수로 넣고 resEntity에 결과값 대입 
		return resEntity; // resEntity 반환
		
	}
	
	@Override
	@RequestMapping(value="/orderDetail.do" ,method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView orderDetail(@RequestParam("order_id") int order_id, 
			                      HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName"); // viewName에 jsp view이름을 불러와 viewName에 대입.
		ModelAndView mav = new ModelAndView(viewName); // viewName 매개변수로 ModelAndView 객체 생성.
		Map orderMap =adminOrderService.orderDetail(order_id); // orderMap에 orderDetail메소드 order_id 매개변수로 넣고 수행한 결과 orderMap에 값 저장
		mav.addObject("orderMap", orderMap); // key를 orderMap 으로 value를 orderMap으로 넣고 mav에 대입 
		return mav; // mav 반환 
	}
	
}
