package com.bookshop01.cart.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.cart.service.CartService;
import com.bookshop01.cart.vo.CartVO;
import com.bookshop01.common.base.BaseController;
import com.bookshop01.goods.vo.GoodsVO;
import com.bookshop01.member.vo.MemberVO;

@Controller("cartController")
@RequestMapping(value="/cart")
public class CartControllerImpl extends BaseController implements CartController{
	@Autowired
	CartService cartService;
	@Autowired
	CartVO cartVO;
	@Autowired
	MemberVO memberVO;
	
	@RequestMapping(value="/myCartList.do" ,method = RequestMethod.GET)
	public ModelAndView myCartMain(HttpServletRequest request, HttpServletResponse response)  throws Exception {
		String viewName=(String)request.getAttribute("viewName"); // view 안의 jsp 이름을 불러와 viewName을 대입
		ModelAndView mav = new ModelAndView(viewName); // viewName을 매개변수로 ModelAndview 객체 생성.
		HttpSession session=request.getSession(); // Session 정보를 얻어와 session 에 대입
		MemberVO memberVO=(MemberVO)session.getAttribute("memberInfo"); //memberInfo 정보를 얻어와 memberVO에 대입
		String member_id=memberVO.getMember_id(); // member_id에 MemberVO에 있는 getMember_id 값 가져와 대입 
		cartVO.setMember_id(member_id); // setMember_id 메소드에 member_id 매개변수로 수행한 결과 저장.
		Map<String ,List> cartMap=cartService.myCartList(cartVO); // catMap에 myCarList메소드를 cartVO 매개변수로 넣고 수행한 결과 대입
		session.setAttribute("cartMap", cartMap); // key를 cartMap value를 cartMap 정보를 session Map에 대입
		//mav.addObject("cartMap", cartMap);
		return mav; // mav 반환
	}
	@RequestMapping(value="/addGoodsInCart.do" ,method = RequestMethod.POST,produces = "application/text; charset=utf8")
	public  @ResponseBody String addGoodsInCart(@RequestParam("goods_id") int goods_id,
			                    HttpServletRequest request, HttpServletResponse response)  throws Exception{
		HttpSession session=request.getSession(); // session 정보 불러옴.
		memberVO=(MemberVO)session.getAttribute("memberInfo"); // memberInfo 를 매개변수로 session값 불러와 memberVO에 저장
		String member_id=memberVO.getMember_id(); // memberVO에 있는 getMember_id 불러와 member_id에 대입.
		
		cartVO.setMember_id(member_id); // setMember_id를 member_id 매개변수로 수행.
	
		cartVO.setGoods_id(goods_id); // setGoods_id를 goods_id 매개변수로 수행.
		cartVO.setMember_id(member_id); // setMember_id를 member_id 매개변수로 수행.
		boolean isAreadyExisted=cartService.findCartGoods(cartVO); // findcartGoods에 cartVO 정보를 매개변수로 넣고 수행한 결과 isAreadyExisted에 대입
		System.out.println("isAreadyExisted:"+isAreadyExisted); // isAreadyExisted 정보 출력 
		if(isAreadyExisted==true){ // 카트에 이미 존재하는지 여부 체크하여 존재하면 already_existed 반환하고 없으면 addGoodsInCart메소드 수행 후 add_success 반환
			return "already_existed";
		}else{
			cartService.addGoodsInCart(cartVO);
			return "add_success";
		}
	}
	
	@RequestMapping(value="/modifyCartQty.do" ,method = RequestMethod.POST)
	public @ResponseBody String  modifyCartQty(@RequestParam("goods_id") int goods_id,
			                                   @RequestParam("cart_goods_qty") int cart_goods_qty,
			                                    HttpServletRequest request, HttpServletResponse response)  throws Exception{
		HttpSession session=request.getSession(); // Session 정보 가져옴.
		memberVO=(MemberVO)session.getAttribute("memberInfo"); // memberInfo를 매개변수로 session 정보 memberVO에 저장
		String member_id=memberVO.getMember_id(); // memberVO에서 getMember_id 수행한 값 member_id 에 대입
		cartVO.setGoods_id(goods_id); // goods_id 매개변수로 setGoods_id 수행
		cartVO.setMember_id(member_id); // member_id 매개변수로 setMember_id 수행
		cartVO.setCart_goods_qty(cart_goods_qty); // cart_goods_qty 매개변수로 setCart_goods_qty 수행   
		boolean result=cartService.modifyCartQty(cartVO); // cartVO 매개변수로 modifyCartQty 수행 후 결과 result에 저장
		
		if(result==true){ // result 가 true면 modify_success 수정완료 message 반환하고 아니면 modify_failed 반환  
		   return "modify_success";
		}else{
			  return "modify_failed";	
		}
		
	}
	
	@RequestMapping(value="/removeCartGoods.do" ,method = RequestMethod.POST) 
	public ModelAndView removeCartGoods(@RequestParam("cart_id") int cart_id,
			                          HttpServletRequest request, HttpServletResponse response)  throws Exception{
		ModelAndView mav=new ModelAndView(); // ModelAndView 객체 생성
		cartService.removeCartGoods(cart_id); // cart_id 매개변수로 removeCartGoods 메소드 수행
		mav.setViewName("redirect:/cart/myCartList.do");  // mav.setViewName으로 redirect 결과 저장 
		return mav; // mav 반환
	}
}
