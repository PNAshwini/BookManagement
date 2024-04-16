<%-- 
    Document   : login
    Created on : 03-Mar-2023, 9:18:55 PM
    Author     : tarun
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>User login</title>
        <style>
        a{
            text-decoration: none;
        }
        .log{
            background-image:url("/EBook/images/back2.avif");
        }
    </style>
    </head>
    <body>
        
        <div class="container pt-5">
            <div class="row justify-content-center pt-5 ">
                <c:if test="${error != null}">
                    <div class="col-md-12 text-center">
                        <p class="text-danger">User Not Found</p>
                    </div>                    
                </c:if>
                <div class="col-md-6  rounded border border-secondary log">
                    <h3 class="display-6 text-center">Login</h3>
                    <form action="loginCheck" method="post" class="">
                        <div class="m-3 form-group">
                            <label for="uname" class="form-label">User Name:</label>
                            <input type="text" name="uname" placeholder="Enter Your User Name" class="form-control" required>
                        </div>
                        <div class="m-3 form-group">
                            <label for="password" class="form-label">Password:</label>
                            <input type="password" name="password" placeholder="Enter Your Password" class="form-control" required>
                        </div>
                        <div class="text-center pb-3">
                            <button type="submit" class="btn btn-primary">Login</button>
                            <button type="reset" class="btn btn-secondary">Clear</button>
                        </div>
                        <a href="<%=request.getContextPath()%>/register" class="text-dark"> <i class="fa-solid fa-user-plus"></i> New User</a>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
