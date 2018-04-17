<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function worstCase(){
	for(var j=0;j<9;j++){
		for(var k=0;k<9;k++){
			document.getElementById(j+","+k).value = 0;
		}
	}
}
function bestCase(){
	var best = [
			[1,2,3,4,5,6,7,8,9],
			[4,5,6,7,8,9,1,2,3],
			[7,8,9,1,2,3,4,5,6],
			[2,1,4,3,6,5,8,9,7],
			[3,6,5,8,9,7,2,1,4],
			[8,9,7,2,1,4,3,6,5],
			[5,3,1,6,4,2,9,7,8],
			[6,4,2,9,7,8,5,3,1],
			[9,7,8,5,3,1,6,4,2]
			];
	
	for(var j=0;j<9;j++){
		for(var k=0;k<9;k++){
			document.getElementById(j+","+k).value = best[j][k];
		}
	}
}
</script>
<link rel="stylesheet" type="text/css" href="sudoku.css">
Sudoku Question:
</head>

<body>
<div style="width:800px; margin:0 auto;">
    <form action="SudokuServlet" method="POST" id="SudokuChallenge">
<table>
<colgroup><col><col><col>
  <colgroup><col><col><col>
  <colgroup><col><col><col>
    <% 
            for(int j=0;j<=8;j++){
            	if(j%3 == 0) {%>
            	<tbody>
            	<%} %>
    <tr>
        <% for(int k=0;k<=8;k++){ %>
        <td>
            
         <select id='<%=j%>,<%=k%>' name='<%=j%>,<%=k%>'>
        <%  for(int q=0;q<=9;q++) {%>
        <option value='<%=q %>'><%=q %></option>
        <% } %>
        </td>
            <%  } %>
    </tr>
    <% } %>
    </table>
        <input type="submit" value="Solve it">
    </form>
    
    <button onclick="worstCase()">Populate worst case</button>
    <button onclick="bestCase()">Populate best case</button>
    </div>
</body>
</html>