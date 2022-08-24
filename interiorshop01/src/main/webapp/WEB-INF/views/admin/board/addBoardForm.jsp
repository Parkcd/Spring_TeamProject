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

	<form action="${contextPath}/admin/board/addBoard.do" method="post"
		enctype="multipart/form-data">
		<H3>공지사항 작성</H3>
		<table>
			<tr>
				<td>번호</td>
				<td><input name="boardNO" type="text" size="40" /></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input name="title" type="text" size="40" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="content" type="text" size="40" /></td>
			</tr>
		</table>
		<td align=center><input type="submit" value="등록하기"></td>
	</form>




</body>
</html>
