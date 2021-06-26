<%-- 
    Document   : register
    Created on : Jun 24, 2021, 7:32:50 PM
    Author     : 839217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Here</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form method="post" action="ShoppingList" >
            <label>Username: </label>
            <input type="text" name="username" required>
            <input type="submit" value="Register name"> 
            <input type="hidden" name="action" value="register">       
        </form>
    </body>
</html>
