<%-- 
    Document   : update
    Created on : May 22, 2021, 4:00:21 PM
    Author     : Surface book 2
--%>

<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Department"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <% 
            ArrayList<Department> depts =(ArrayList<Department>)request.getAttribute("depts");
            Student student = (Student)request.getAttribute("student");
        %>
    </head>
    <body>
         <form action="update" method="POST">
             ID:<input readonly="readonly" type="text" value="<%=student.getId()%>" name="id"/> <br/>
            Name:<input type="text" value="<%=student.getName()%>" name="name"/> <br/>
            Dob:<input type="date" value="<%=student.getDob()%>" name="dob"/> <br/>
            Gender:
                   
                    <input type="radio" 
                           <%=(student.isGender())?"checked=\"checked\"":"" %>
                           name="gender" value="male"  /> Male
                   <input type="radio" name="gender" 
                          <%=(!student.isGender())?"checked=\"checked\"":"" %>
                          value="female"  /> Female
                   <br/>
            Department:
            <select name="did">
                <% for(Department d : depts){ %>
                <option 
                       <%=(student.getDept().getId() == d.getId())?"selected=\"selected\"":"" %> 
                        value="<%=d.getId()%>" ><%=d.getName()%></option>
                <%}%>
            </select>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
