<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<p> Student's name : ${student1.studentName }</p>
	<p> Student's hobby : ${student1.studentHobby }</p>
	<p> Student's Mobile : ${student1.studentMobile }</p>
	<p> Student's DOB : ${student1.studentDob }</p>
	<p> Student's Skills : ${student1.studentSkills }</p>
	<p> Student's Country : ${student1.studentAddress.country }</p>
	<p> Student's City : ${student1.studentAddress.city }</p>
</body>
</html>