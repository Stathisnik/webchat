<%-- 
    Document   : homepage
    Created on : Mar 24, 2019, 11:32:18 AM
    Author     : Nikolas
--%>

<%@page import="Entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <% User user = (User) request.getAttribute("user");%>
    </body>
</html>
