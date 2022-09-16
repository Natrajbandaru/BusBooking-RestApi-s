<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		</ul><h1 style="color:#0f3040">BusName <span style="color:#13663b">Hyderabad Volva Express </span>    </h1>
		<div>
		<table  align='center'  border='1' cellpadding='4' width='60%' style='background:#1b8278;color:white;font-size:25px;'>
			<%
				for(int i=1;i<=10;i++){
			%>
			<tr>
					<td> Seat No <%=i++ %> <input type="checkbox" width="300px" value="true"> </td> 
					 <td> Seat No <%=i++ %>   <input type="checkbox" value="true"> </td> 
					    <td> Seat No <%=i %>  <input type="checkbox" value="true"> </td>
			</tr>
		<%} %>
		</table>
			
		
		</div>
		
		

</body>
</html>