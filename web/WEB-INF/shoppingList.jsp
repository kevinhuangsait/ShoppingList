<%-- 
    Document   : shoppingList
    Created on : Oct 25, 2020, 4:45:59 PM
    Author     : 831719
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username} <a href="ShoppingList?action=logout"/>Logout</a>
        
        <h2>List</h2>
        <form action=" " method="post">
            Add Item: <input type="text" name="item">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>
        
        <form action=" " method="post">
                <c:forEach items="${itemList}" var="itemList">
                    <li><input type="radio" name="items" value="${itemList}">${itemList}</li>
                </c:forEach>
                
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
            
        </form>
    </body>
</html>
