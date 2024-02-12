<%@ page import="org.example.mission1.bookmark.BookmarkService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("UTF-8");

    String id = request.getParameter("id");

    BookmarkService bookmarkService = new BookmarkService();
    bookmarkService.delete(Integer.parseInt(id));

    response.sendRedirect("bookmarkList.jsp");

%>
