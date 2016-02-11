<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 10.02.2016
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>List of notes</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>TEXT</th>
        <th>Is Done</th>
        <th colspan="3"></th>
    </tr>
    <c:forEach items="${notes}" var="note">
        <c:url var="editUrl" value="/edit?id=${note.id}" />
        <c:url var="deleteUrl" value="/delete?id=${note.id}" />
        <c:url var="makeDone" value="/makedone?id=${note.id}"/>
        <c:url var="makeUndone" value="/makeundone?id=${note.id}"/>
        <tr>
            <td><c:out value="${note.id}"/></td>
            <td><c:out value="${note.text}"/></td>
            <td><c:out value="${note.done}"/> </td>
            <td><a href="${editUrl}">Edit text</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>
            <c:if test="${note.done}">
            <td><a href="${makeUndone}">Undone</a></td>
            </c:if>
            <c:if test="${!note.done}">
                <td><a href="${makeDone}">Done</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<br><a href="/add-note">Add note</a>
<c:if test="${!empty notes}">
    <br><a href="/alldone">Get done notes</a>
    <br><a href="/allundone">Get undone notes</a>
    <br><a href="/allnote">Get all notes</a>
</c:if>
<c:if test="${empty notes}">
    There are currently no TODOs in the list.
</c:if>
</body>
</html>
