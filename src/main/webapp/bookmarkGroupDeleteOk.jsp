<%@ page import="org.example.mission1.bookmarkGroup.BookmarkGroupService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");
    BookmarkGroupService bookmarkGroupService = new BookmarkGroupService();
    bookmarkGroupService.delete(Integer.parseInt(id));

    response.sendRedirect("bookmarkGroup.jsp");
%>