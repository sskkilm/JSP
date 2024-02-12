<%@ page import="org.example.mission1.locationHistory.LocationHistoryService" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.mission1.locationHistory.LocationHistoryDto" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
      table {
        width: 100%;
        text-align: center;
        border : 1px solid black;
        border-collapse : collapse;
      }
      thead {
        background-color: lightgreen;
      }
      tr, th, td {
        border : 1px solid black;
        border-collapse : collapse;
      }
    </style>
</head>
<body>
  <h1>위치 히스토리 목록</h1>
  <div>
    <a href="index.jsp">홈</a>
    <a href="history.jsp">위치 히스토리 목록</a>
    <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
    <a href="bookmarkList.jsp">북마크 보기</a>
    <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
  </div>
  <table>
    <thead>
    <tr>
      <td>ID</td>
      <td>X좌표</td>
      <td>Y좌표</td>
      <td>조회일자</td>
      <td>비고</td>
    </tr>
    </thead>
    <tbody>
    <tr>
      <%
        LocationHistoryService locationHistoryService = new LocationHistoryService();
        List<LocationHistoryDto> locationHistoryDtoList = locationHistoryService.getList();
        Collections.sort(locationHistoryDtoList);
        for (LocationHistoryDto locationHistoryDto : locationHistoryDtoList) {
      %>
      <form action="deleteLocation.jsp?id=<%=locationHistoryDto.getId()%>" method="post">
        <tr>
          <td><%=locationHistoryDto.getId()%></td>
          <td><%=locationHistoryDto.getGpsX()%></td>
          <td><%=locationHistoryDto.getGpsY()%></td>
          <td><%=locationHistoryDto.getViewDate()%></td>
          <td><input type="submit" value="삭제"></td>
        </tr>
      </form>
      <%}%>
    </tr>
    </tbody>
  </table>
</body>
</html>
