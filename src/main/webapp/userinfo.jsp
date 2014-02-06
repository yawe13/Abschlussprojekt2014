<%-- 
    Document   : index
    Created on : 20-Jan-2013, 22:16:54
    Author     : anton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Information</title>
    </head>
    <body>
        <h1>User Information</h1>
        <form action="./UserServlet" method="POST">
            <table>
                <tr>
                    <td>User ID</td>
                    <td><input type="text" name="userId" value="${user.userId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${user.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${user.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${user.yearLevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>                
                </tr>            
            </table>
        </form>        
        <br>
        <table border="1">
            <th>User ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
            <c:forEach items="${allUsers}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.yearLevel}</td>
                </tr>
            </c:forEach>
        </table>  
    </body>
</html>
