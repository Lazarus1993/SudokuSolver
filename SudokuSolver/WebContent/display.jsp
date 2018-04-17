<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="sudoku.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sudoku Solution</title>

Sudoku Solution:
</head>
<div style="width:800px; margin:0 auto;">
<table>
<colgroup><col><col><col>
  <colgroup><col><col><col>
  <colgroup><col><col><col>
<%
String arr[] = new String[9];
for(int i=0;i<=8;i++) { 
if(i%3 == 0) {%>
<tbody>
<%} %>
<tr>
	<% for(int j=0;j<=8;j++){ %>
		<td><%=request.getAttribute("element"+i+j) %></td>
	<% }%>
	</tr>
<% } %>
</table>
The runtime is: <%=request.getAttribute("totalTime")%> ms
</div>
<body>
</body>
</html>