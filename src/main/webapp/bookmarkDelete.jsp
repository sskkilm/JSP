<%@ page import="org.example.mission1.bookmark.BookmarkService" %>
<%@ page import="org.example.mission1.bookmark.BookmarkDto" %>
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
<h1>북마크 삭제</h1>
<div>
    <a href="index.jsp">홈</a>
    <a href="history.jsp">위치 히스토리 목록</a>
    <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
    <a href="bookmarkList.jsp">북마크 보기</a>
    <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
</div>
북마크를 삭제하시겠습니까?
<div>
    <%
        String id = request.getParameter("id");
        BookmarkService bookmarkService = new BookmarkService();
        BookmarkDto bookmarkDto = bookmarkService.select(Integer.parseInt(id));
    %>
    <form action="bookmarkDeleteOk.jsp?id=<%=id%>" method="post">

        <table>
            <colgroup>
                <col style="width: 20%">
            </colgroup>

            <tr>
                <th>북마크 이름</th>
                <td><%=bookmarkDto.getBookmarkName()%></td>
            </tr>
            <tr>
                <th>와이파이명</th>
                <td><%=bookmarkDto.getWifiName()%></td>
            </tr>
            <tr>
                <th>등록일자</th>
                <td><%=bookmarkDto.getRegisterDate()%></td>
            </tr>
            <tr><td colspan="2" style="text-align: center"><a href="bookmarkList.jsp">돌아가기</a><input type="submit" value="삭제"></td></tr>
        </table>
    </form>
</div>
</body>
</html>
