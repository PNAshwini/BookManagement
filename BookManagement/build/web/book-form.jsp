<%-- 
    Document   : book-form
    Created on : 02-Mar-2023, 8:15:31 PM
    Author     : tarun
--%>

<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>New Book</title>
    </head>
    <body>
        <%@include file="includes/admin-navbar.jsp" %>
        <div class="container">        
        <div class="row justify-content-center pt-5">
            <div class="card col-md-6">
                <div class="card-header bg-dark text-center text-light">
                    <h3 class="display-3">
                        <c:if test="${book != null}">
            			<i class="fa-solid fa-user-plus"> Edit Book</i>
            		</c:if>
			<c:if test="${book == null}">
            			<i class="fa-solid fa-user-plus"> Add New Book</i>
            		</c:if>
                    </h3>
                </div>
                <div class="card-body">
                    <c:if test="${book != null}">
                        <form action="updateBook" method="post" autocomplete="off">
                    </c:if>
                    <c:if test="${book == null}">
                        <form action="insertBook" method="post" autocomplete="off">
                    </c:if>
                    <c:if test="${book != null}">
                        <input type="hidden" name="bid" value="<c:out value='${book.bid}' />" />
                        <label>Current Book image</label>
                        <div class="col-md-3 rounded-start p-2">                         
                            <img src="/EBook/images/<c:out value='${book.bimage}' />" class="form-control" height="50%">
                        </div>
                    </c:if>
                        <div class="mb-1">
                            <label>Book Name</label>
                            <input type="text" value="<c:out value='${book.bname}' />" class="form-control" name="bname" required="required">
                        </div>
                        <div class="mb-1">
                            <label>Book Author</label>
                            <input type="text" value="<c:out value='${book.bauthor}' />" class="form-control" name="bauthor" required="required">
                        </div>
                        <div class="mb-1">
                            <label>Book Price</label> 
                            <input type="text" value="<c:out value='${book.bprice}' />" class="form-control" name="bprice" required="required">
                        </div>
                        <div class="mb-1">
                            <label>Book Description</label> 
                            <textarea class="form-control" name="bdescription" required="required"><c:out value='${book.bdescription}' /></textarea>
                        </div>                        
                        <div class="mb-1">
                            <label>Book image</label> 
                            <input type="file" class="form-control" name="bimage" required="required">
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
