<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ȸ��Ż��_������Ʈ2</title>
</head>
<body>


<c:if test="${check==1}">
	<script>
		alert("�����Ϸ�..���� �ٲ�� �ٽ� �����ϼ���");
		
	</script>
	
	<c:redirect url="/finder/main.do"></c:redirect>
</c:if>

<c:if test="${check!=1}">
	<script>
		alert("����ƴѵ���");
		history.go(-1);
	</script>
</c:if>
</body>
</html>