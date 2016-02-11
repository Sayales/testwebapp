<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Example :: Spring Application</title>
    </head>
    <body>
        <form:form method="POST" commandName="note" action="add-note">
        <form:label path="text">Note text:</form:label>
        <form:input path="text"/>
        <footer> <input type="submit" class="btnLogin" value="AddNote" tabindex="4" />
        </footer>
        </form:form>
    </body>
</html>