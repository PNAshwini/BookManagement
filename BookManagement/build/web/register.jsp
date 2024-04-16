<%-- 
    Document   : user-form
    Created on : 02-Mar-2023, 7:30:30 PM
    Author     : tarun
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>New User Registration</title>
    </head>
    <body>
        <div class="container">        
        <div class="row justify-content-center pt-5">
            <div class="card col-md-6">
                <div class="card-header bg-dark text-center text-light">
                    <h3 class="display-3">
                        <i class="fa-solid fa-user-plus"> New User Registration</i>            		
                    </h3>
                </div>
                <div class="card-body">
                    
			<form action="registerUser" method="post" autocomplete="off">
                    
                    
                        <div class="mb-1">
                            <label for="name">Full Name</label>
                            <input type="text" class="form-control" name="fname" id="fname" placeholder="Enter Your Name" value="<c:out value='${user.fname}' />" required>
                        </div>
                        <div class="mb-1">
                            <label for="name">User Name</label>
                            <input type="text" class="form-control" name="uname" id="uname" placeholder="Enter Your Name" value="<c:out value='${user.uname}' />" required>
                        </div>
                        <div class="mb-1">
                            <label for="name">Password</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="Enter Your Password" value="<c:out value='${user.password}' />" required>
                        </div>
                        <div class="mb-1">
                            <label for="confirm_password">Confirm Password</label>
                            <input class="form-control" type="password" name="cpassword" id="cpassword" placeholder="Re-Enter your Password" value="<c:out value='${user.cpassword}' />" required>
                        </div>
                        <div class="text-center m-3">
                            <button type="submit" class="btn btn-dark">Submit</button>
                            <button type="reset" class="btn btn-secondary">Clear</button>
                        </div>
                    </form>
                </div>
        </div>
        </div>
    </div>
    </body>
</html>
