<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-collapse : collapes;
}
th, td{
	padding:5px;
}
</style>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="/Chapter06_Web/user/upload">
		<table border="1">
			<tr>
				<th>상품명</th>
				<td>
					<input type="text">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea name="imageContent" rows="10" cols="50"></textarea>
				</td>
			</tr>
			
			<!-- 다중 업로드 할 경우 name속성의 이름이 같아야 하낟 -->
			<!-- 
			<tr>
				<td colspan="2">
					<input type="file" name="img">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="file" name="img">
				</td>
			</tr>
			 -->
			 
			 <!-- 하나 또는 여러개 선택 -->
			<tr>
				<td colspan="2">
					<input type="file" name="img[]" multiple="multiple">
				</td>
			</tr>
			 
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="이미지 업로드">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>