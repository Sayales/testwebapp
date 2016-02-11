<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" %>
<html>
<head>
<title> main </title>
</head>
<body>
<table>
    <tr><th>ID</th><th>Text</th><th>Is Done?</th></tr>
    <tr>
        <td>${note.id}</td>
        <td>${note.text}</td>
        <td>${note.done}</td>
    </tr>
</table>
</body>
</html>