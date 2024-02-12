<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
      table {
        width: 100%;
        border : 1px solid black;
        border-collapse : collapse;
      }
      th {
        background-color: lightgreen;
        border : 1px solid black;
        border-collapse : collapse;
      }
      tr {
        border : 1px solid black;
        border-collapse : collapse;
      }
    </style>
</head>
<body>
<h1>북마크 그룹 수정</h1>
<div>
  <a href="index.jsp">홈</a>
  <a href="history.jsp">위치 히스토리 목록</a>
  <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
  <a href="bookmarkList.jsp">북마크 보기</a>
  <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
</div>
<div>
  <%
    String id = request.getParameter("id");
  %>
<form action="bookmarkGroupUpdateOk.jsp?id=<%=id%>" method="post">
  <table>
    <colgroup>
      <col style="width: 20%">
    </colgroup>
    <tr>
      <th>북마크 이름</th>
      <td>
        <input type="text" name="name">
      </td>
    </tr>
    <tr>
      <th>순서</th>
      <td>
        <input type="text" name="order">
      </td>
    </tr>
    <tr><td colspan="2" style="text-align: center"><a href="bookmarkGroup.jsp">돌아가기</a><input type="submit" value="수정"></td></tr>
  </table>
</form>
</div>
</body>
</html>
