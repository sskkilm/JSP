<%@ page import="java.util.List" %>
<%@ page import="org.example.mission1.bookmark.BookmarkService" %>
<%@ page import="org.example.mission1.bookmark.BookmarkDto" %>
<%@ page import="org.example.mission1.bookmarkAndWifi.BookmarkAndWifiDao" %>
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
<h1>북마크 목록</h1>
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
    <td>북마크 이름</td>
    <td>와이파이명</td>
    <td>등록일자</td>
    <td>비고</td>
  </tr>
  </thead>
  <tbody>
  <tr>
  <%
    BookmarkAndWifiDao bookmarkAndWifiDao = new BookmarkAndWifiDao();
    BookmarkService bookmarkService = new BookmarkService();
    List<BookmarkDto> bookmarkDtoList = bookmarkService.getList();
    for (BookmarkDto bookmarkDto : bookmarkDtoList) {

  %>
  <tr>
    <td><%=bookmarkDto.getId()%></td>
    <td><%=bookmarkDto.getBookmarkName()%></td>
    <td><a href="detail.jsp?MGR_NO=<%=bookmarkAndWifiDao.select(bookmarkDto.getId()).getWifiId()%>"><%=bookmarkDto.getWifiName()%></a></td>
    <td><%=bookmarkDto.getRegisterDate()%></td>
    <td><a href="bookmarkDelete.jsp?id=<%=bookmarkDto.getId()%>">삭제</a></td>
  </tr>
  <%
    }
  %>
  </tr>
  </tbody>
</table>
</body>
</html>
