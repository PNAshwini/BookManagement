<%-- 
    Document   : index
    Created on : 01-Mar-2023, 10:57:10 PM
    Author     : tarun
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
    
    <title>Index</title>
    
    </head>
    <body>
    <%@include file="includes/user-navbar.jsp" %>
    <div class="container">
        <div class="row">
            <c:forEach var="book" items="${listBook}">
            <div class="col-md-3">
                <div class="img-thumbnail  border-dark">
                    <img alt="pic1" src="/EBook/images/<c:out value='${book.bimage}' />" class="rounded-top px-5 pt-2" alt="pic1" width="100%">
                    <p class="text-center fw-bold mb-1"><c:out value="${book.bname}" /></p>
                    <p class="px-3 mb-1"><span class="fw-bold">Author: </span><c:out value="${book.bauthor}" /> </p>
                    <p class="px-3 fw-bold mb-1">₹. <c:out value="${book.bprice}" /> </p>
                    <p class="text-justify m-2">
                        <c:out value="${book.bdescription}" />
                    </p>
                    <div class="text-center">
                        <a class="btn btn-danger mb-2" href="orderBook?bid=<c:out value='${book.bid}' />">Buy Now!</a>
                    </div>
                </div>
            </div>
            </c:forEach>

        </div>
    </div>
    </body>
</html>
