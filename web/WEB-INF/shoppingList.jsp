<%-- 
    Document   : shoppingList
    Created on : Jun 24, 2021, 7:35:10 PM
    Author     : 839217
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
         <h1>Shopping List</h1><br />
         Hello,${username}
         <a href="ShoppingList?action=logout"><input type="hidden" name="action" value="logout">Logout</a></p>
        <h2>List</h2>
        <form method="post" action="">
            
            <label>Add item: </label>
            <input type="text" name="itemName" required> <input type="submit" value="Add"><input type="hidden" name="action" value="Add">
        </form>

        <form method="post" action="">
            
            <ul>
                <c:forEach items="${List}" var="item"><li>
                <input type="radio" name="item" value="${item}">${item}
                    </li>
            </c:forEach>
            </ul>

            <input type="submit" value="Delete"> <input type="hidden" name="action" value="Delete">
        </form>
        
    </body>
</html>
