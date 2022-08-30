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
	<H3>공지사항 상세보기</H3>
	<form method="post">

		<DIV class="clear"></DIV>
	</form>
	<DIV class="clear"></DIV>
	<TABLE class="list_view">
		
		<TR>	<TD><strong>작성자:${qna.qnaId } </strong></TD><TR>
		<TR>	<TD><strong>${qna.qNO } </strong><strong style="border-left-width:0.1em; border-left-style:solid; border-left-color:#000">${qna.qnaTitle } </strong></TD><TR>
		<TR>	<TD>내용:<strong>${qna.qnaContent }</strong></TD><TR>
		<TR>	<td>질문 날짜:<strong>${qna.qnaWriteDate }</strong></td><TR>
		<TR>	<td>답변:<strong>${qna.answer }</strong></td><TR>
		<TR>	<td>답변 날짜:<strong>${qna.answerDate }</strong></td><TR>
			
			<%-- <td>
				    <c:set var="pub_date" value="${item.goods_published_date}" />
					   <c:set var="arr" value="${fn:split(pub_date,' ')}" />
					<strong>
					   <c:out value="${arr[0]}" />
					</strong>
				</td>	 --%>
		
	</TABLE>


	<c:choose>
		<c:when test="${memberInfo.member_id == 'admin' }">
			<a
				href="${contextPath}/qna/writeAnswerForm.do?qNO=${qna.qNO}"
				class="no-underline"><br>[답변하기]</a>
			<a
				href="${contextPath}/qna/removeQna.do?qNO=${qna.qNO}"
				class="no-underline">[삭제하기]</a>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>




</body>
</html>
