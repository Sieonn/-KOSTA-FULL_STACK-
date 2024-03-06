<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<jsp:forward page='<%=request.getParameter("forwardPage") %>'></jsp:forward>
<jsp:include page='<%=request.getParameter("includePage") %>'></jsp:include>
