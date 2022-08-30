<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script>
	
</script>
</head>
<body>
	<H3>고객센터</H3>
	<form method="post">

		<DIV class="clear"></DIV>
	</form>
	<DIV class="clear"></DIV>
	<TABLE class="list_view">
		<c:choose>
			<c:when test="${empty listQna }">
				<TR>
					<TD colspan=8 class="fixed"><strong>공지 사항이 없습니다.</strong></TD>
				</TR>
			</c:when>
			<c:otherwise>
				<c:forEach var="qna" items="${listQna }" varStatus="status">
					<TR>

						<%-- <TD><strong>${qna.qNO }. </strong></TD> --%>
						
						<td><c:out value="${status.count}" /></td>
						<TD><strong><a
								href="${contextPath}/qna/qnaDetail.do?qNO=${qna.qNO}">${qna.qnaTitle }</a></strong>
						</TD>
						<td><strong>${qna.qnaWriteDate }</strong></td>
						
						
						<%-- <td><c:set var="pub_date"
								value="${item.goods_published_date}" /> <c:set var="arr"
								value="${fn:split(pub_date,' ')}" /> <strong> <c:out
									value="${arr[0]}" />
						</strong></td> --%>

					</TR>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</TABLE>
	 <c:choose>
		     <c:when test="${isLogOn==true and not empty memberInfo }">
			  <a href="${contextPath}/qna/writeQnaForm.do"
				class="no-underline"><br>[질문하기]</a>
			 </c:when>
			 <c:otherwise>
			   게시글을 작성하려면 로그인 해야합니다 <a href="${contextPath}/member/loginForm.do">[로그인]</a> 
			 </c:otherwise>
			</c:choose>
			
	


</body>
</html>
