<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  

<div id="ad_main_banner">
	<ul class="bjqs">	 	
	  <li><a href="https://ohou.se/" target="_blank"><img width="775" height="450" src="${contextPath}/resources/image/main/main1.png"></a></li>
		<li><a href="https://zipdoc.co.kr/" target="_blank"><img width="775" height="450" src="${contextPath}/resources/image/main/main3.png"></a></li>
		<li><a href="https://houseapp.co.kr/" target="_blank"><img width="775" height="450" src="${contextPath}/resources/image/main/main4.png"></a></li> 
	</ul>
</div>
<div class="main_book">
   <c:set  var="goods_count" value="0" />
	<h3>가전 베스트</h3>
	<c:forEach var="item" items="${goodsMap.best_homeappliances }">
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
			<img class="link"  src="${contextPath}/resources/image/1px.gif"> 
			</a> 
				<img width="121" height="154" 
				     src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="price">
		  	   <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		          ${goods_price}원
			</div>
		</div>
	   <c:if test="${goods_count==15   }">
         <div class="book">
           <font size=20> <a href="#">more</a></font>
         </div>
     </c:if>
  </c:forEach>
</div>
<div class="clear"></div>

<div></div>

<div class="main_book">
   <c:set  var="goods_count" value="0" />
	<h3>가구 베스트</h3>
	<c:forEach var="item" items="${goodsMap.best_furniture }">
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
			<img class="link"  src="${contextPath}/resources/image/1px.gif"> 
			</a> 
				<img width="121" height="154" 
				     src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="price">
		  	   <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		          ${goods_price}원
			</div>
		</div>
	   <c:if test="${goods_count==15   }">
         <div class="book">
           <font size=20> <a href="#">more</a></font>
         </div>
     </c:if>
  </c:forEach>
</div>
<div class="clear"></div>

<div id="ad_sub_banner">
	<img width="770" height="117" src="${contextPath}/resources/image/sub_banner01.jpg">
</div>

<div class="main_book">
   <c:set  var="goods_count" value="0" />
	<h3>주방 베스트</h3>
	<c:forEach var="item" items="${goodsMap.best_kitchen }">
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
			<img class="link"  src="${contextPath}/resources/image/1px.gif"> 
			</a> 
				<img width="121" height="154" 
				     src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="price">
		  	   <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		          ${goods_price}원
			</div>
		</div>
	   <c:if test="${goods_count==15   }">
         <div class="book">
           <font size=20> <a href="#">more</a></font>
         </div>
     </c:if>
  </c:forEach>
</div>
<div class="clear"></div>


<div></div>



<div class="main_book">
   <c:set  var="goods_count" value="0" />
	<h3>생활용품 베스트</h3>
	<c:forEach var="item" items="${goodsMap.best_housegoods }">
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
			<a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
			<img class="link"  src="${contextPath}/resources/image/1px.gif"> 
			</a> 
				<img width="121" height="154" 
				     src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">

			<div class="title">${item.goods_title }</div>
			<div class="price">
		  	   <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		          ${goods_price}원
			</div>
		</div>
	   <c:if test="${goods_count==15   }">
         <div class="book">
           <font size=20> <a href="#">more</a></font>
         </div>
     </c:if>
  </c:forEach>
</div>
<div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117" src="${contextPath}/resources/image/sub_banner01.jpg">
</div>


<%-- <div class="main_book" >
<c:set  var="goods_count" value="0" />
	<h3>새로 출판된 책</h3>
	<c:forEach var="item" items="${goodsMap.newbook }" >
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
		  <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
	       <img class="link"  src="${contextPath}/resources/image/1px.gif"> 
	      </a>
		 <img width="121" height="154" 
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
		<div class="title">${item.goods_title }</div>
		<div class="price">
		    <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		       ${goods_price}원
		  </div>
	</div>
	 <c:if test="${goods_count==15   }">
     <div class="book">
       <font size=20> <a href="#">more</a></font>
     </div>
   </c:if>
	</c:forEach>
</div> --%>

<%-- <div class="clear"></div>
<div id="ad_sub_banner">
	<img width="770" height="117" src="${contextPath}/resources/image/sub_banner02.jpg">
</div>


<div class="main_book" >
<c:set  var="goods_count" value="0" />
	<h3>스테디셀러</h3>
	<c:forEach var="item" items="${goodsMap.steadyseller }" >
	   <c:set  var="goods_count" value="${goods_count+1 }" />
		<div class="book">
		  <a href="${contextPath}/goods/goodsDetail.do?goods_id=${item.goods_id }">
	       <img class="link"  src="${contextPath}/resources/image/1px.gif"> 
	      </a>
		 <img width="121" height="154" 
				src="${contextPath}/thumbnails.do?goods_id=${item.goods_id}&fileName=${item.goods_fileName}">
		<div class="title">${item.goods_title }</div>
		<div class="price">
		    <fmt:formatNumber  value="${item.goods_price}" type="number" var="goods_price" />
		       ${goods_price}원
		  </div>
	</div>
	 <c:if test="${goods_count==15   }">
     <div class="book">
       <font size=20> <a href="#">more</a></font>
     </div>
   </c:if>
	</c:forEach>
</div> --%>

   
   