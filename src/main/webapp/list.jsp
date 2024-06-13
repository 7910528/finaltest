<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Notes</title>
</head>
<body>
<h2>List of Notes</h2>
<ul>
    <c:forEach var="note" items="${notes}">
        <li>${note.title}</li>
        <p>${note.content}</p>
    </c:forEach>
</ul>
</body>
</html>
