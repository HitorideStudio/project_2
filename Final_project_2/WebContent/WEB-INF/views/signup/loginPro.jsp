<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${c==1 }">
	<c:redirect url="testloginout.do"/>
</c:if>
<c:if test="${c!=1}">
	<script>
	alert("���̵���Ȯ���ض�");
	window.location="login.do";
	</script>
</c:if>>
<body>

</body>
</html>