<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>�λ縻 : ${greeting}</div>
	<div>�ݰ����� : ${formData.userId} </div>
	<form action="step" method="post">
		<label><input type="checkbox" name="agree" value="true">��� ����</label>
		<input type="submit" value="���� �ܰ�">
	</form>
	<form action="regist" method="get">
		<button>ȸ������</button>
	</form>
	<form action="findid" method="get">
		<label>
			����� ã�� <input type="text" name="findIdData">
			<input type="submit" value="ã��">
		</label>
	</form>
</body>
</html>