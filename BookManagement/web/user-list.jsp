<%-- 
    Document   : user-list
    Created on : 02-Mar-2023, 7:10:20 PM
    Author     : tarun
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Admin-Users</title>
    </head>
    <body>
        <%@include file="includes/admin-navbar.jsp" %>
        <div class="container">
        <div class="col-md-12 m-3">
            <div class="col-md-12">
                <h2 class="display-3"><i class="fa-solid fa-users"></i> All-Users</h2>
            </div>
            <a class="btn btn-success" href="<%=request.getContextPath()%>/new">Add Users</a>
        </div>
        <table class="table text-center table-striped">
            <thead class="table-dark">
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Full Name</th>
                <th scope="col">User Name</th>
                <th scope="col">Password</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${listUser}">
              <tr>
                <th scope="row"><c:out value="${user.id}" /></th>
                <td><c:out value="${user.fname}" /></td>
                <td><c:out value="${user.uname}" /></td>
                <td><c:out value="${user.password}" /></td>
                <td>
                    <a class="btn btn-primary" href="edit?id=<c:out value='${user.id}' />">Update User</a>
                    <a class="btn btn-danger" href="delete?id=<c:out value='${user.id}' />">Delete User</a>
                </td>
              </tr>
              </c:forEach>
              
            </tbody>
          </table>
    </div>
    </body>
</html>
