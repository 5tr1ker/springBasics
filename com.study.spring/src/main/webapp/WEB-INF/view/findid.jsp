<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 찾기</title>
</head>
<body>
	<h1>찾으시는 회원님의 아이디는 '${findResult}' 이며 비밀번호는 '${idData}' 입니다.</h1>
	해당 아이디를 삭제하시려면 해당 버튼을 눌러주세요.
	<form action="deleteId" method="post">
		<button name="userData" value="${idData}">회원 삭제</button>
	</form>
</body>
</html>