package com.bookshop01.admin.member.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.admin.member.service.AdminMemberService;
import com.bookshop01.common.base.BaseController;
import com.bookshop01.member.vo.MemberVO;

@Controller("adminMemberController")
@RequestMapping(value = "/admin/member")
public class AdminMemberControllerImpl extends BaseController implements AdminMemberController {
	@Autowired
	AdminMemberService adminMemberService;

	@RequestMapping(value = "/adminMemberMain.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView adminGoodsMain(@RequestParam Map<String, String> dateMap, // 날짜를 가져온다
			@RequestParam(required = false) String s_search_type, // s_search_type을 가져온다
			@RequestParam(required = false) String t_search_word, // t__search_word를 가져온다
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = (String) request.getAttribute("viewName");// viewName을 저장
		ModelAndView mav = new ModelAndView(viewName);// 저장한 viewName을 mav에 담는다

		String fixedSearchPeriod = dateMap.get("fixedSearchPeriod");// fixedSerchPerod라는 변수에 dateMap에서 가져온
																	// foxedSerchPeriod를 담는다
		String section = dateMap.get("section");// section변수에 dateMap에서 가져온 section을 담는다
		String pageNum = dateMap.get("pageNum");// pageNum변수에 dateMap에서 가져온 pageNum을 담는다

		String beginDate = null, endDate = null;// beginDate와endDate변수 선언

		String beginYear = dateMap.get("beginYear");
		String beginMonth = dateMap.get("beginMonth");
		String beginDay = dateMap.get("beginDay");

		System.out.println("!!!!받은 비긴데이터" + beginYear);

		String[] tempDate = calcSearchPeriod(fixedSearchPeriod).split(",");// calcSerchReriod(fixedSearchPeriod)함수에서
																			// 가져온값을 ,를 기준으로 나눈뒤 tempDate라는배열 변수에 저장한다.
		// beginDate = tempDate[0];// tempDate의 0번째 배열값은 beginDate로 사용
		endDate = tempDate[1];// tempDate의 1번째 배열값은 endDate로 사용하겠다
		// dateMap.put("beginDate", beginDate);// dateMap에 begindate값을 begindate라는 키로
		// 전달해준다
		dateMap.put("endDate", endDate);// dateMap에 enddate값을 enddate라는 키로 전달해준다

		System.out.println("!!!!초기화된 비긴데이터" + beginDate);

		/* String beginDate1[] = null; */ /*
											 * = beginDate.split("-");// beginDate1이라는 배열 변수에 beginDate를 -를 기준으로 나눈 값들을
											 * 저장
											 */

		if (beginYear == null) {
			beginYear = "2018";
			beginMonth = "01";
			beginDay = "01";
		}

		beginDate = beginYear + "-" + beginMonth + "-" + beginDay;

		// 그냥Map과HashMap은 뭘까?
		HashMap<String, Object> condMap = new HashMap<String, Object>();// Car car = new Car 와 같음
		if (section == null) {
			section = "1"; // section이 널이면 section은 1
		}
		condMap.put("section", section); // condMap에 section값을 section이라는 키에 전달
		if (pageNum == null) {
			pageNum = "1"; // pageNum이 null이면 pageNum은 1
		}
		System.out.println(beginDate);// 데이터를 콘솔에서 확인하기위해 작성
		System.out.println(endDate);
		condMap.put("pageNum", pageNum);// pageNum condMap에 전달
		condMap.put("beginDate", beginDate);// beginDate condMap에 전달
		condMap.put("endDate", endDate);// endDate condMap에 전달
		condMap.put("s_search_type", s_search_type);// s_search_type condMap에 전달
		condMap.put("t_search_word", t_search_word);// t_search_word condMap에 전달

		ArrayList<MemberVO> member_list = adminMemberService.listMember(condMap);// (위에서 값들을저장한 condMap을
																					// Service.listMember에 넣은 상태)
		mav.addObject("member_list", member_list);// mav에 service에서 전달받은 member_list를 member_list로 저장
		/*
		 * mav.addObject("s_search_type",s_search_type);
		 * mav.addObject("t_search_word",t_search_word);
		 */

		System.out.println(s_search_type);
		System.out.println(t_search_word);

		String endDate2[] = endDate.split("-");// endDate2이라는 배열 변수에 endDate를 -를 기준으로 나눈 값들을 저장
		mav.addObject("beginYear", beginYear);// beginDate1의 배열 영 번째 값을 beginYear이라는 키로 mav전달
		mav.addObject("beginMonth", beginMonth);// beginDate1의 배열 첫 번째 값을 beginMonth라는 키로 mav전달
		mav.addObject("beginDay", beginDay);// beginDate1의 배열 두번 째 값을 beginDay라는 키로 mav전달
		mav.addObject("endYear", endDate2[0]);// endDate2의 배열 영 번째 값을 endYear이라는 키로 mav전달
		mav.addObject("endMonth", endDate2[1]);// endDate2의 배열 첫 번째 값을 endMonth라는 키로 mav전달
		mav.addObject("endDay", endDate2[2]);// endDate2의 배열 두 번째 값을 endDay라는 키로 mav전달

		mav.addObject("section", section);// 위에서 설정한 section 전달
		mav.addObject("pageNum", pageNum);// 위에서 설정한 section 전달
		return mav;

	}

	@RequestMapping(value = "/memberDetail.do", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView memberDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String) request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView(viewName);
		String member_id = request.getParameter("member_id");
		MemberVO member_info = adminMemberService.memberDetail(member_id);
		mav.addObject("member_info", member_info);
		return mav;
	}

	@RequestMapping(value = "/modifyMemberInfo.do", method = { RequestMethod.POST, RequestMethod.GET })
	public void modifyMemberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HashMap<String, String> memberMap = new HashMap<String, String>();
		String val[] = null;
		PrintWriter pw = response.getWriter();
		String member_id = request.getParameter("member_id");
		String mod_type = request.getParameter("mod_type");
		String value = request.getParameter("value");
		if (mod_type.equals("member_birth")) {
			val = value.split(",");
			memberMap.put("member_birth_y", val[0]);
			memberMap.put("member_birth_m", val[1]);
			memberMap.put("member_birth_d", val[2]);
			memberMap.put("member_birth_gn", val[3]);
		} else if (mod_type.equals("tel")) {
			val = value.split(",");
			memberMap.put("tel1", val[0]);
			memberMap.put("tel2", val[1]);
			memberMap.put("tel3", val[2]);

		} else if (mod_type.equals("hp")) {
			val = value.split(",");
			memberMap.put("hp1", val[0]);
			memberMap.put("hp2", val[1]);
			memberMap.put("hp3", val[2]);
			memberMap.put("smssts_yn", val[3]);
		} else if (mod_type.equals("email")) {
			val = value.split(",");
			memberMap.put("email1", val[0]);
			memberMap.put("email2", val[1]);
			memberMap.put("emailsts_yn", val[2]);
		} else if (mod_type.equals("address")) {
			val = value.split(",");
			memberMap.put("zipcode", val[0]);
			memberMap.put("roadAddress", val[1]);
			memberMap.put("jibunAddress", val[2]);
			memberMap.put("namujiAddress", val[3]);
		}

		memberMap.put("member_id", member_id);

		adminMemberService.modifyMemberInfo(memberMap);
		pw.print("mod_success");
		pw.close();

	}

	@RequestMapping(value = "/deleteMember.do", method = { RequestMethod.POST })
	public ModelAndView deleteMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		HashMap<String, String> memberMap = new HashMap<String, String>();
		String member_id = request.getParameter("member_id");
		String del_yn = request.getParameter("del_yn");
		memberMap.put("del_yn", del_yn);
		memberMap.put("member_id", member_id);

		adminMemberService.modifyMemberInfo(memberMap);
		mav.setViewName("redirect:/admin/member/adminMemberMain.do");
		return mav;

	}

}
