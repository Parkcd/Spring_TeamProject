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
		<TR>
			<TD><strong>${board.boardNO }. </strong></TD>
			<TD><strong>${board.title }</strong></TD>
			<TD><strong>${board.content }</strong></TD>
			<td><strong>${board.writeDate }</strong></td>
			<%-- <td>
				    <c:set var="pub_date" value="${item.goods_published_date}" />
					   <c:set var="arr" value="${fn:split(pub_date,' ')}" />
					<strong>
					   <c:out value="${arr[0]}" />
					</strong>
				</td>	 --%>
		</TR>
	</TABLE>


	<c:choose>
		<c:when test="${memberInfo.member_id == 'admin' }">
			<a
				href="${contextPath}/admin/board/modifyBoardForm.do?boardNO=${board.boardNO}"
				class="no-underline"><br>[수정하기]</a>
			<a
				href="${contextPath}/admin/board/removeBoard.do?boardNO=${board.boardNO}"
				class="no-underline">[삭제하기]</a>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>




</body>
</html>
