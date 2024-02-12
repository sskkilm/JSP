<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupService" %>
<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupDto" %>
<%@ page import="java.util.List" %>
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
<h1>북마크 그룹</h1>
<div>
  <a href="index.jsp">홈</a>
  <a href="history.jsp">위치 히스토리 목록</a>
  <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
  <a href="bookmarkList.jsp">북마크 보기</a>
  <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
</div>
<button onclick="location.href = 'bookmarkGroupAdd.jsp'">북마크 그룹 이름 추가</button>
<table>
  <thead>
  <tr>
    <td>ID</td>
    <td>북마크 이름</td>
    <td>순서</td>
    <td>등록일자</td>
    <td>수정일자</td>
    <td>비고</td>
  </tr>
  </thead>
  <tbody>
  <tr>
  <%
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    List<BookmarkGroupDto> bookmarkGroupDtoList = bookmarkGroupService.getList();
    for (BookmarkGroupDto bookmarkGroupDto : bookmarkGroupDtoList) {

  %>
  <tr>
    <td><%=bookmarkGroupDto.getId()%></td>
    <td><%=bookmarkGroupDto.getName()%></td>
    <td><%=bookmarkGroupDto.getOrder()%></td>
    <td><%=bookmarkGroupDto.getRegisterDate()%></td>
    <td><%=bookmarkGroupDto.getUpdateDate()%></td>
    <td><a href="bookmarkGroupUpdate.jsp?id=<%=bookmarkGroupDto.getId()%>">수정</a> <a href="bookmarkGroupDeleteOk.jsp?id=<%=bookmarkGroupDto.getId()%>">삭제</a></td>
  </tr>
  <%
    }
  %>
  </tr>
  </tbody>
</table>
</body>
</html>
