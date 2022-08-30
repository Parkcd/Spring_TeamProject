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
	
	<form action="${contextPath}/qna/writeAnswer.do" method="post"
		enctype="multipart/form-data">
		<H3>답글 쓰기</H3>
		<table>
			 <tr>
				<td>번호</td>
				<td><input name="qnaNO" type="text" size="40" 
				value='<c:out value="${qna.qNO }"/>'	readonly="readonly"/></td>
			</tr>

			<tr>
				<td>제목</td>
				<td><input name="qnaTitle" type="text" size="40" 
				value = "${qna.qnaTitle }"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input name="qnaContent" type="text" size="40" 
				value = "${qna.qnaContent }"/></td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td><input name="answerDate" type="text" size="40" 
				value = "${qna.answerDate }"	readonly="readonly"/></td>
			</tr> 
			<tr>
				<td>답변</td>
				<td><input name="answer" type="text" size="40" 
				value = "${qna.answer }"	/></td>
			</tr>
		</table>
		<td align=center><input type="submit" value="답변하기"></td>
	</form>


	


</body>
</html>
