<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupService" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String order = request.getParameter("order");

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");
    Date now = Calendar.getInstance().getTime();
    String updateDate = simpleDateFormat.format(now).toString();

    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    bookmarkGroupService.update(id, name, order, updateDate);

    response.sendRedirect("bookmarkGroup.jsp");
%>