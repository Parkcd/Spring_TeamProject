package com.bookshop01.goods.controller;

import java.util.ArrayList;
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

import com.bookshop01.board.service.BoardService;
import com.bookshop01.common.base.BaseController;
import com.bookshop01.goods.service.GoodsService;
import com.bookshop01.goods.vo.GoodsVO;

import net.sf.json.JSONObject;

@Controller("goodsController")
@RequestMapping(value="/goods")
public class GoodsControllerImpl extends BaseController   implements GoodsController {
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value="/goodsDetail.do" ,method = RequestMethod.GET)
	public ModelAndView goodsDetail(@RequestParam("goods_id") String goods_id,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName=(String)request.getAttribute("viewName"); // viewName에 jsp viewName 정보 가져와 viewName 에 대입
		HttpSession session=request.getSession(); // Session 정보 불러와 대입
		Map goodsMap=goodsService.goodsDetail(goods_id); // goods_id를 매개변수로 GoodsDetail 수행결과 goodsMap에 대입
		ModelAndView mav = new ModelAndView(viewName); // viewName을 매개변수로 ModelAndView 객체 생성
		mav.addObject("goodsMap", goodsMap); // key를 goodsMap으로 value로 goodsMap 값을 mav에 저장
		GoodsVO goodsVO=(GoodsVO)goodsMap.get("goodsVO"); // goodsVO 매개변수로 값 가져와 goodsVO에 값 저장
		addGoodsInQuick(goods_id,goodsVO,session); // goods_id , goodsVO,session을 매개변수로 addGoodsInQuick 수행
		return mav; // mav 반환
	}
	
	@RequestMapping(value="/keywordSearch.do",method = RequestMethod.GET,produces = "application/text; charset=utf8")
	public @ResponseBody String  keywordSearch(@RequestParam("keyword") String keyword,
			                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8"); // ContentType 지정
		response.setCharacterEncoding("utf-8"); // Encoding Type 지정 
		//System.out.println(keyword);
		if(keyword == null || keyword.equals("")) // keyword가 공백이거나 비어있으면
		   return null ; // null 반환
		keyword = keyword.toUpperCase(); // toUpperCase 메소드 수행 후 keyword 값 저장  
	    List<String> keywordList =goodsService.keywordSearch(keyword); // keywordsearch메소드에 keyword 매개변수 대입 후 수행 결과 keywordList에 대입
	    
	    
		JSONObject jsonObject = new JSONObject(); // JSONObject 객체 생성
		jsonObject.put("keyword", keywordList); // key를 keyword로 value를 keywordList 값을 주입.
		 		
	    String jsonInfo = jsonObject.toString(); // toString 수행 후 jsonInfo에 대입
	   // System.out.println(jsonInfo);
	    return jsonInfo ; // jsonInfo 반환
	}
	
	@RequestMapping(value="/searchGoods.do" ,method = RequestMethod.GET)
	public ModelAndView searchGoods(@RequestParam("searchWord") String searchWord,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=(String)request.getAttribute("viewName"); // viewName에 jsp viewName 정보 가져와 viewName 에 대입
		List<GoodsVO> goodsList=goodsService.searchGoods(searchWord); // searchGoods 메소드에 searchWord 매개변수로 수행 결과 goodsList에 대입 
		ModelAndView mav = new ModelAndView(viewName); // ModelAndView 객체를 viewName 매개변수 넣고 생성
		mav.addObject("goodsList", goodsList); // key를 goodsList로 value를 goodsList 값으로 지정하여 mav에 추가 
		return mav; // mav 반환
		
	}
	
	private void addGoodsInQuick(String goods_id,GoodsVO goodsVO,HttpSession session){
		boolean already_existed=false; // already_existed 초기값 지정
		List<GoodsVO> quickGoodsList; // quickGoodsList List 생성
		quickGoodsList=(ArrayList<GoodsVO>)session.getAttribute("quickGoodsList"); // quickGoodsList 정보를 불러와 quickGoodsList 에 저장
		
		if(quickGoodsList!=null){ // quickGoodsList 가 null이 아니면 quickgoodsList가 4보다 작을때 quickGoodsList get메소드 반복하여 getGoods_id만큼 같아지면 true 반환하고 종료
			if(quickGoodsList.size() < 4){ 
				for(int i=0; i<quickGoodsList.size();i++){
					GoodsVO _goodsBean=(GoodsVO)quickGoodsList.get(i);
					if(goods_id.equals(_goodsBean.getGoods_id())){
						already_existed=true;
						break;
					}
				}
				if(already_existed==false){ // already_existed가 false면 goodsVO매개변수로 add 메소드 수행
					quickGoodsList.add(goodsVO);
				}
			}
			
		}else{ // null이 아니면 List 생성 후 goodsVO 매개변수로 add 메소드 수행 
			quickGoodsList =new ArrayList<GoodsVO>();
			quickGoodsList.add(goodsVO);
			
		}
		session.setAttribute("quickGoodsList",quickGoodsList); // key 값으로 quickGoodsList value 로 quickGoodsList 값을 저장
		session.setAttribute("quickGoodsListNum", quickGoodsList.size()); // key 값으로 quickgoodsListNum value 값으로 quickGoodsList.size() 값을 저장
	}
	

	
	
}
