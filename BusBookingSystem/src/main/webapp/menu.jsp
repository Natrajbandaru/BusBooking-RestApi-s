<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Application </title>

<style type="text/css">

h1{
	color:blue;
}

body {font-family: Arial;}

/* Style the tab */
.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  text-align:center;
  
  margin-left:200px;
  width:600px;
  
}

a{
	
	text-decoration-line: none;
}
/* Style the buttons inside the tab */
.tab a {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}

/* Change background color of buttons on hover */
.tab a:hover {
  background-color: #eb8c34;
}

/* Create an active/current tablink class */
.tab a.active {
  background-color: #6beb34;
  background:#6beb34;
}

/* Style the tab content */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}



</style>
</head>
<body>


	
	
<div class="tab" align="center">
	<a class="tablinks"  href="hello.jsp" target="frame2">Bus</a>
	<a class="tablinks"   href="#" target="frame2">Booking History</a>
	
	<a class="tablinks"  href="#" target="index.html">Logout</a>
</div>
	
	
	
	<table align="center">
		<tr>
			<td>From  </td> <td> <input type="text" name="from"/> </td>
		</tr>
		
		<tr>
			<td>To  </td> <td> <input type="text" name="to"/> </td>
		</tr>
		
		<tr>
			<td> <a href="hello.jsp" target="frame2"><input type="submit" value="Search"> </a></td>
		</tr>
		
	</table>
	
	
	
	
</body>
</html>