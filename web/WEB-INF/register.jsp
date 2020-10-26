<%-- 
    Document   : register
    Created on : Oct 25, 2020, 4:45:59 PM
    Author     : 831719
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}</p>
        <a href="<c:url value='ShoppingList?action=logout'/>">Logout</a>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            Add Item: <input type="text" name="item">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>
        
        <form action="ShoppingList" method="post">
            <c:if test="${shoppingList != null}">
                <c:forEach var="itemList" items="${shopList}">
                    <li> <input type="radio" name="listedItem" value="${itemList}">${itemList} </li>
                </c:forEach>
            </c:if>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
            
        </form>
    </body>
</html>
