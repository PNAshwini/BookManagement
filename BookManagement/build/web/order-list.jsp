<%-- 
    Document   : order-list
    Created on : 02-Mar-2023, 8:01:45 PM
    Author     : tarun
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Admin-Books</title>
    </head>
    <body>
        <%@include file="includes/admin-navbar.jsp" %>
        <div class="container">
        <div class="col-md-12 m-3">
            <div class="col-md-12">
                <h2 class="display-3"><i class="fa-solid fa-cart-shopping"></i> All-Orders</h2>
            </div>
            
        </div>
        <table class="table text-center table-striped">
            <thead class="table-dark">
              <tr>
                <th>ID</th>
                <th>Book Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Customer Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="order" items="${listOrder}">
              <tr>
                <td><c:out value="${order.oid}" /></td>
                <td><c:out value="${order.bname}" /></td>
                <td><c:out value="${order.bprice}" /></td>
                <td><c:out value="${order.bquantity}" /></td>
                <td><c:out value="${order.cname}" /></td>
                <td><c:out value="${order.phone}" /></td>
                <td><c:out value="${order.email}" /></td>
                <td><c:out value="${order.address}" /></td>
                
              </tr>
              </c:forEach>
              
            </tbody>
          </table>
    </div>
    </body>
</html>
