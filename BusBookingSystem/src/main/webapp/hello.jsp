<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.chenga.util.BusService,com.chenga.entites.Bus,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		
		
		<table align='center'  border='1' cellpadding='4' width='60%' style='background:#1b8278;color:white;font-size:25px;'>
				<%
					BusService busSerivce=new BusService();
					List<Bus> bus=busSerivce.getBuses();
					
					for(int i=0;i<bus.size();i++){
						
					
				%>
				
				<tr>
				
				<td style="color:#66432d">  <%=i+1 %>
				</td>
				</tr>
				
				<a href="index.jsp" target="index.jsp">
				<tr>
					<td>Bus Number</td> <td> <%=bus.get(i).getBusnumber() %>  </td>
				</tr> 
					<td>Bus Name</td>  <td> <%=bus.get(i).getBusname() %>  </td>
				</tr>  
					<td>Bus SeatingCapacity</td>  <td> <%=bus.get(i).getSeatingcapacity() %>  </td>
					
				</tr>
				
				
				
				</tr>  
					<td>  <a href="#" target="frame3">Book Your Ticket</a>    </td>  
					
				</tr>
				
				</a>
				
			
		<%} %>
		
		</table>
		
</body>
</html>