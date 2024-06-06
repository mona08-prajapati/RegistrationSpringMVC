<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%out.println(request.getAttribute("message")); %></h1>
<form action="registerform" method="POST">
    <!-- <input type="hidden" name="modalForm" value="modalFormPush"/> -->
Firstname:<input type="text"name="firstname"><br>
Lastname:<input type="text"name="lastname"><br>
username:<input type="text"name="username"><br>
Password:<input type="text"name="password"><br>
id:<input type="text"name="id"><br>
<input type="submit">
</form>
</body>
</html>