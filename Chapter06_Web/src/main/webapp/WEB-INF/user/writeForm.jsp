<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="writeForm">
	<a href="/Chapter06_Web/"><img src="../image/img2.png"></a>
	<table border="1">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name">
				<div id="nameDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" id="id">
				<div id="idDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pwd" id="pwd">
				<div id="pwdDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="입력" id="writeBtn">
				<input type="reset" value="취소" >
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../js/write.js"></script>

</body>
</html>