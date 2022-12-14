package com.bookshop01.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.board.service.BoardService;
import com.bookshop01.common.base.BaseController;
import com.bookshop01.goods.service.GoodsService;
import com.bookshop01.goods.vo.GoodsVO;

@Controller("mainController")
@EnableAspectJAutoProxy
public class MainController extends BaseController {
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private BoardService boardService;
	@RequestMapping(value= "/main/main.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) throws Exception{ // ModelAndView에 main viewName 와 boardlist 
																									     // session 정보등을 저장
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List listBoard = boardService.listBoard();
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		session.setAttribute("listBoard",listBoard);
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		//mav.addObject("listBoard",listBoard);
		return mav; // mav 반환 
	}
	
	@RequestMapping(value= "main/Home_Appliances.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView HomeAppliances(HttpServletRequest request, HttpServletResponse response) throws Exception{ // ModelAndView에 HomeAppliances viewName 와 boardlist 
	     																										   // session 정보등을 저장
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List listBoard = boardService.listBoard();
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		mav.addObject("listBoard",listBoard);
		return mav; // mav 반환 
	}
	
	@RequestMapping(value= "main/Kitchen.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Kitchen(HttpServletRequest request, HttpServletResponse response) throws Exception{ // ModelAndView에 Kitchen viewName 와 boardlist 
		   																									// session 정보등을 저장
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List listBoard = boardService.listBoard();
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		mav.addObject("listBoard",listBoard);
		return mav; // mav 반환 
	}
	
	@RequestMapping(value= "main/Furniture.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Furniture(HttpServletRequest request, HttpServletResponse response) throws Exception{ // ModelAndView에 Furniture viewName 와 boardlist 
		   																									  // session 정보등을 저장
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List listBoard = boardService.listBoard();
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		mav.addObject("listBoard",listBoard);
		return mav; // mav 반환 
	}
	
	@RequestMapping(value= "main/Housegoods.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView Housegoods(HttpServletRequest request, HttpServletResponse response) throws Exception{ // ModelAndView에 Housegoods viewName 와 boardlist 
		   																									   // session 정보등을 저장
		HttpSession session;
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List listBoard = boardService.listBoard();
		session=request.getSession();
		session.setAttribute("side_menu", "user");
		Map<String,List<GoodsVO>> goodsMap=goodsService.listGoods();
		mav.addObject("goodsMap", goodsMap);
		mav.addObject("listBoard",listBoard);
		return mav; // mav 반환 
	}
	
	
}
