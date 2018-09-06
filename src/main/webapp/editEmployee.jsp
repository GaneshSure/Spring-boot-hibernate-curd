<html>
	<head>
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Edit Employee Data</h2>
		
		<form method="POST" action="save.html">
	   		<table>
			    <tr>
			        <td>Employee ID:</td>
			        <td><input type=text   name="empid" value=<%=request.getAttribute("eid")%>  readonly="true"></td>
			    </tr>
			    <tr>
			        <td>Employee Name:</td>
			        <td><input  type=text   name="empname"></td>
			    </tr>
			    <tr>
			        <td>Employee Age:</td>
			        <td><input type=text   name="empage"></td>
			    </tr>
			    <tr>
			        <td>Employee Salary:</td>
			        <td><input type=text   name="empsalary"></td>
			    </tr>
			    
			    <tr>
			        <td>Employee Address:</td>
                    <td><input  type=text   name="empaddress"></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form>
	</body>
</html>