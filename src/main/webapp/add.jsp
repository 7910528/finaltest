<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Note</title>
</head>
<body>
<h2>Add a New Note</h2>
<form action="${pageContext.request.contextPath}/notes" method="post">
  Title: <input type="text" name="title"><br>
  Content: <textarea name="content"></textarea><br>
  <input type="submit" value="Add Note">
</form>
</body>
</html>
