<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ã��</title>
</head>
<body>
	<h1>ã���ô� ȸ������ ���̵�� '${findResult}' �̸� ��й�ȣ�� '${idData}' �Դϴ�.</h1>
	�ش� ���̵� �����Ͻ÷��� �ش� ��ư�� �����ּ���.
	<form action="deleteId" method="post">
		<button name="userData" value="${idData}">ȸ�� ����</button>
	</form>
</body>
</html>