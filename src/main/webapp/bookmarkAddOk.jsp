<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupService" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="org.example.mission1.bookmark.BookmarkService" %>
<%@ page import="org.example.mission1.bookmark.BookmarkDto" %>
<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupDto" %>
<%@ page import="org.example.mission1.wifiInfo.WifiInfoService" %>
<%@ page import="org.example.mission1.wifiInfo.WifiInfoDto" %>
<%@ page import="org.example.mission1.bookmarkAndWifi.BookmarkAndWifiDto" %>
<%@ page import="org.example.mission1.bookmarkAndWifi.BookmarkAndWifiDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String wifiId = request.getParameter("wifiId");
    String bookmarkName = request.getParameter("bookmarkName");

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");
    Date now = Calendar.getInstance().getTime();
    String registerDate = simpleDateFormat.format(now).toString();

    WifiInfoService wifiInfoService = new WifiInfoService();
    WifiInfoDto wifiInfoDto = wifiInfoService.select(wifiId);

    BookmarkService bookmarkService = new BookmarkService();
    BookmarkDto bookmarkDto = new BookmarkDto();
    bookmarkDto.setBookmarkName(bookmarkName);
    bookmarkDto.setWifiName(wifiInfoDto.getX_SWIFI_MAIN_NM());
    bookmarkDto.setRegisterDate(registerDate);
    bookmarkService.register(bookmarkDto);

    BookmarkAndWifiDto bookmarkAndWifiDto = new BookmarkAndWifiDto(bookmarkDto.getId(), wifiId);
    BookmarkAndWifiDao bookmarkAndWifiDao = new BookmarkAndWifiDao();
    bookmarkAndWifiDao.save(bookmarkAndWifiDto);

    response.sendRedirect("detail.jsp?MGR_NO=" + wifiInfoDto.getX_SWIFI_MGR_NO());
%>