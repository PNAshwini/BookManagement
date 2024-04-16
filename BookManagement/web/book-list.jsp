<%-- 
    Document   : book-list
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
                <h2 class="display-3"><i class="fa-solid fa-book"></i> All-Books</h2>
            </div>
            <a class="btn btn-success" href="<%=request.getContextPath()%>/newBook">Add Book</a>
        </div>
        <table class="table text-center table-striped align-middle">
            <thead class="table-dark">
              <tr>
                <th>ID</th>
                <th>Book Name</th>
                <th>Author </th>
                <th>Price</th>
                <th>Description</th>
                <th>Image</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${listBook}">
              <tr>
                <td><c:out value="${book.bid}" /></td>
                <td><c:out value="${book.bname}" /></td>
                <td><c:out value="${book.bauthor}" /></td>
                <td><c:out value="${book.bprice}" /></td>
                <td><c:out value="${book.bdescription}" /></td>
                <td class="text-center ">
                    <div class="col-md-12 rounded-start ">                         
                        <img src="/EBook/images/<c:out value='${book.bimage}' />" width="20%">
                    </div>
                </td>
                <td>
                    <a class="btn btn-primary" href="editBook?bid=<c:out value='${book.bid}' />">Update Book</a>
                    <a class="btn btn-danger" href="deleteBook?bid=<c:out value='${book.bid}' />">Delete Book</a>
                </td>
              </tr>
              </c:forEach>
              
            </tbody>
          </table>
    </div>
    </body>
</html>
