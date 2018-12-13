<%-- 
    Document   : index
    Created on : Dec 10, 2018, 5:08:54 PM
    Author     : aryas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Available Courses </h1>
        <ol>

            <c:forEach var="skill" items="${skills}">
                <li>${skill.name}</li>
                </c:forEach>
        </ol>
    </body>
</html>
