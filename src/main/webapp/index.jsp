<%@ page import="org.example.mission1.wifiInfo.WifiInfoDto" %>
<%@ page import="org.example.mission1.wifiInfo.WifiInfoService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.example.mission1.locationHistory.LocationHistoryService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
        <script type = "text/javascript" src="findLocation.js"></script>
    </head>
    <body>
        <h1>와이파이 정보 구하기</h1>
        <div>
            <a href="index.jsp">홈</a>
            <a href="history.jsp">위치 히스토리 목록</a>
            <a href="load-wifi.jsp">Open Api 와이파이 정보 가져오기</a>
            <a href="bookmarkList.jsp">북마크 보기</a>
            <a href="bookmarkGroup.jsp">북마크 그룹 관리</a>
        </div>
        <div>

            <%
                // 데이터 수신 및 처리
                double lat = 0.0;
                double lnt = 0.0;
                if (request.getMethod().equals("POST")) {
                    lat = Double.parseDouble(request.getParameter("lat"));
                    lnt = Double.parseDouble(request.getParameter("lnt"));
                }
            %>

            <form action="index.jsp" method="post">
                <label>LAT:</label>
                <input type="text" value="<%=lat%>" id="latitude" name="lat">
                ,
                <label>LNT:</label>
                <input type="text" value="<%=lnt%>" id="longitude" name="lnt">
                <input type="button" value="내 위치 가져오기" onclick="findLocation()">
                <input type="submit" value="근처 WIFI 정보 보기">
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>거리(Km)</th>
                    <th>관리번호</th>
                    <th>자치구</th>
                    <th>와이파이명</th>
                    <th>도로명주소</th>
                    <th>상세주소</th>
                    <th>설치위치(층)</th>
                    <th>설치유형</th>
                    <th>설치기관</th>
                    <th>서비스구분</th>
                    <th>망종류</th>
                    <th>설치년도</th>
                    <th>실내외구분</th>
                    <th>WIFI접속환경</th>
                    <th>X좌표</th>
                    <th>Y좌표</th>
                    <th>작업일자</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <% if (lat == 0.0 && lnt == 0.0) { %>
                        <tr>
                            <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
                        </tr>
                    <%
                        } else {
                        LocationHistoryService locationHistoryService = new LocationHistoryService();
                        locationHistoryService.saveLocation(lat, lnt);

                        WifiInfoService wifiInfoService = new WifiInfoService();
                        List<Map.Entry<WifiInfoDto, Double>> closeWifiEntryList = wifiInfoService.getCloseWifi(lat, lnt, 20);
                        for (Map.Entry<WifiInfoDto, Double> closeWifiEntry : closeWifiEntryList) {
                            Double dist = closeWifiEntry.getValue();
                            WifiInfoDto closeWifi = closeWifiEntry.getKey();
                    %>
                        <tr>
                            <td><%=Math.round(dist * 10000) / 10000.0%></td>
                            <td><%=closeWifi.getX_SWIFI_MGR_NO()%></td>
                            <td><%=closeWifi.getX_SWIFI_WRDOFC()%></td>
                            <td>
                                <a href="detail.jsp?MGR_NO=<%=closeWifi.getX_SWIFI_MGR_NO()%>">
                                    <%=closeWifi.getX_SWIFI_MAIN_NM()%>
                                </a>
                            </td>
                            <td><%=closeWifi.getX_SWIFI_ADRES1()%></td>
                            <td><%=closeWifi.getX_SWIFI_ADRES2()%></td>
                            <td><%=closeWifi.getX_SWIFI_INSTL_FLOOR()%></td>
                            <td><%=closeWifi.getX_SWIFI_INSTL_TY()%></td>
                            <td><%=closeWifi.getX_SWIFI_INSTL_MBY()%></td>
                            <td><%=closeWifi.getX_SWIFI_SVC_SE()%></td>
                            <td><%=closeWifi.getX_SWIFI_CMCWR()%></td>
                            <td><%=closeWifi.getX_SWIFI_CNSTC_YEAR()%></td>
                            <td><%=closeWifi.getX_SWIFI_INOUT_DOOR()%></td>
                            <td><%=closeWifi.getX_SWIFI_REMARS3()%></td>
                            <td><%=closeWifi.getLAT()%></td>
                            <td><%=closeWifi.getLNT()%></td>
                            <td><%=closeWifi.getWORK_DTTM()%></td>
                        </tr>
                    <%  }
                    }%>
                </tr>
            </tbody>
        </table>
    </body>
</html>