<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원가입</title>
</head>
<body>

	<form action="confirmRegist" method="post">
	<label>아이디 : <input type="text" name="userId" id="userId" placeholder="아이디" value="${formData.userId}">
	비밀번호 : <input type="text" name="userPw" id="userPw" placeholder="비밀번호" value="${formData.userPw}">
	</label>
		<button>가입하기</button>
	</form>
</body>
</html>