<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<img src="/Final_project_2/imgs/${vo.img}" width="250"/><br/>
<b>${sessionScope.memId }</b><br/>
${vo.name}/${vo.age}

<button onclick="window.location='modifyForm.do'">����</button>
<button onclick="window.location='logout.do'">�α׾ƿ�</button>
<button onclick="window.location='deleteForm.do'">Ż��</button>
