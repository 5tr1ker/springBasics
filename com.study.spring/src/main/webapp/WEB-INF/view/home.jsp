<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>인사말 : ${greeting}</div>
	<div>반가워용 : ${formData.userId} </div>
	<form action="step" method="post">
		<label><input type="checkbox" name="agree" value="true">약관 동의</label>
		<input type="submit" value="다음 단계">
	</form>
	<form action="regist" method="get">
		<button>회원가입</button>
	</form>
	<form action="findid" method="get">
		<label>
			사용자 찾기 <input type="text" name="findIdData">
			<input type="submit" value="찾기">
		</label>
	</form>
</body>
</html>