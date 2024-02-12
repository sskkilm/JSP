<%@ page import="org.example.mission1.wifiInfo.WifiInfoService" %>
<%@ page import="org.example.mission1.wifiInfo.WifiInfoDto" %>
<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupService" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>와이파이 정보 구하기</title>
    <style>
        table {
            width: 100%;
            height: 100%;
            text-align: center;
            border : 1px solid black;
            border-collapse : collapse;
        }
        th {
            background-color: lightgreen;
            border : 1px solid black;
            border-collapse : collapse;
        }
        td {
            border : 1px solid black;
            border-collapse : collapse;
        }
    </style>
</head>
<body>
<%
    String wifiId = request.getParameter("MGR_NO");
    WifiInfoService wifiInfoService = new WifiInfoService();
    WifiInfoDto wifiInfoDto = wifiInfoService.select(wifiId);
%>
<h1>와이파이 정보 구하기</h1>
<div>
    <a href="index.jsp">홈</a>
    <a href="history.jsp">위치 히스토리 목록</a>
    <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
    <a href="bookmarkList.jsp">북마크 보기</a>
    <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
</div>
<div>
    <form action="bookmarkAddOk.jsp?wifiId=<%=wifiInfoDto.getX_SWIFI_MGR_NO()%>" method="post">
    <select name="bookmarkName">
        <option selected>북마크 그룹 이름 선택</option>
        <%
            BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
            List<BookmarkGroupDto> bookmarkGroupDtoList = bookmarkGroupService.getList();
            Collections.sort(bookmarkGroupDtoList);
            for (BookmarkGroupDto bookmarkGroupDto : bookmarkGroupDtoList) {
        %>
        <option><%=bookmarkGroupDto.getName()%></option>
        <%
            }
        %>
    </select>
    <button type="submit">북마크 추가하기</button>
    </form>
</div>
<table>
    <colgroup>
        <col style="width: 50%">
    </colgroup>
    <tbody>
    <tr>
        <th>거리(Km)</th>
        <td>0.0000</td>
    </tr>
    <tr>
        <th>관리번호</th>
        <td><%=wifiInfoDto.getX_SWIFI_MGR_NO()%></td>
    </tr>
    <tr>
        <th>자치구</th>
        <td><%=wifiInfoDto.getX_SWIFI_WRDOFC()%></td>
    </tr>
    <tr>
        <th>와이파이명</th>
        <td>
            <a href="detail.jsp?MGR_NO=<%=wifiInfoDto.getX_SWIFI_MGR_NO()%>">
                <%=wifiInfoDto.getX_SWIFI_MAIN_NM()%>
            </a>
        </td>
    </tr>
    <tr>
        <th>도로명주소</th>
        <td><%=wifiInfoDto.getX_SWIFI_ADRES1()%></td>
    </tr>
    <tr>
        <th>상세주소</th>
        <td><%=wifiInfoDto.getX_SWIFI_ADRES2()%></td>
    </tr>
    <tr>
        <th>설치위치(층)</th>
        <td><%=wifiInfoDto.getX_SWIFI_INSTL_FLOOR()%></td>
    </tr>
    <tr>
        <th>설치유형</th>
        <td><%=wifiInfoDto.getX_SWIFI_INSTL_TY()%></td>
    </tr>
    <tr>
        <th>설치기관</th>
        <td><%=wifiInfoDto.getX_SWIFI_INSTL_MBY()%></td>
    </tr>
    <tr>
        <th>서비스구분</th>
        <td><%=wifiInfoDto.getX_SWIFI_SVC_SE()%></td>
    </tr>
    <tr>
        <th>망종류</th>
        <td><%=wifiInfoDto.getX_SWIFI_CMCWR()%></td>
    </tr>
    <tr>
        <th>설치년도</th>
        <td><%=wifiInfoDto.getX_SWIFI_CNSTC_YEAR()%></td>
    </tr>
    <tr>
        <th>실내외구분</th>
        <td><%=wifiInfoDto.getX_SWIFI_INOUT_DOOR()%></td>
    </tr>
    <tr>
        <th>WIFI접속환경</th>
        <td><%=wifiInfoDto.getX_SWIFI_REMARS3()%></td>
    </tr>
    <tr>
        <th>X좌표</th>
        <td><%=wifiInfoDto.getLAT()%></td>
    </tr>
    <tr>
        <th>Y좌표</th>
        <td><%=wifiInfoDto.getLNT()%></td>
    </tr>
    <tr>
        <th>작업일자</th>
        <td><%=wifiInfoDto.getWORK_DTTM()%></td>
    </tr>
    </tbody>
</table>

</body>
</html>
