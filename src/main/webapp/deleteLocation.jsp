<%@ page import="org.example.mission1.locationHistory.LocationHistoryService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));

    LocationHistoryService locationHistoryService = new LocationHistoryService();
    locationHistoryService.deleteLocation(id);

    response.sendRedirect("history.jsp");
%>
