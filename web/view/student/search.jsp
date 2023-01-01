<%-- 
    Document   : search
    Created on : May 26, 2021, 2:39:40 PM
    Author     : Surface book 2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="search">
            ID = <input type="text" name="id"/> <br/>
            Name contains <input type="text" name="name"/> <br/>
            Gender 
            <input type="radio" name="gender" value="male"/> Male
            <input type="radio" name="gender" value="female"/> Female
            <input type="radio" checked="checked" name="gender" value="both"/> Both
            <br/>
            From <input type="date" name="from"/>
            To <input type="date" name="to"/> 
            <br/>
            Department
            <select name="did">
                <option value="-1">------------------</option>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select>
            <br/>
            <input type="submit" value="Search"/>
        </form>
        <br/>
        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Gender</th>
                <th>Dob</th>
                <th>Department</th>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.gender}</td>
                    <td>${s.dob}</td>
                    <td>${s.dept.name}</td>
                </tr> 
            </c:forEach>
        </table>

    </body>
</html>
