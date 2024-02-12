<%@ page import="org.example.mission1.wifiInfo.WifiInfoService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
</head>
<body>
    <%
        WifiInfoService wifiInfoService = new WifiInfoService();
        wifiInfoService.updateDB();
        int cnt = wifiInfoService.getAllCnt();
    %>

    <h1 style="text-align: center"><%=cnt%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
    <div style="text-align: center">
        <a href="index.jsp">홈으로 가기</a>
    </div>
</body>
</html>
