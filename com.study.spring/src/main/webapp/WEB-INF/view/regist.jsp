<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������</title>
</head>
<body>

	<form action="confirmRegist" method="post">
	<label>���̵� : <input type="text" name="userId" id="userId" placeholder="���̵�" value="${formData.userId}">
	��й�ȣ : <input type="text" name="userPw" id="userPw" placeholder="��й�ȣ" value="${formData.userPw}">
	</label>
		<button>�����ϱ�</button>
	</form>
</body>
</html>