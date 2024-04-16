<%-- 
    Document   : order
    Created on : 03-Mar-2023, 7:14:24 PM
    Author     : tarun
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="includes/header.jsp" %>
        <title>Book Order Page</title>
    </head>
    <body>
        <%@include file="includes/user-navbar.jsp" %>
        <div class="container">
        <div class="col-md-12 text-center mb-4">
            <h3>Fill this form to confirm your order.</h3>
        </div>
        <form action="buyBook" method="post">
            <div class="row justify-content-center">
                <div class="col-md-1 rounded-start border border-end-0 border-dark p-2">
                    <img src="/EBook/images/<c:out value='${book.bimage}' />" alt="" width="100%">
                </div>
                <div class="col-md-5 rounded-end border border-start-0 border-dark">
                    <div class="ms-3">
                        <p class="fw-bold"><c:out value='${book.bname}' /></p>
                        <p class="fw-bold">₹. <c:out value='${book.bprice}' />/-</p>
                    </div>
                    <div class="m-3 form-group">
                        <label for="quantity" class="form-label">Quantity</label>
                        <input type="number" name="bquantity" value="1" class="form-control" required>
                    </div>
                </div>
            </div>
        
            <div class="mt-2">
                <div class="row justify-content-center">
                    <div class="col-md-6 rounded border border-dark p-4">
                        <input type="hidden" name="bname" value="<c:out value='${book.bname}' />" id="custname">
                        <input type="hidden" name="bprice" value="<c:out value='${book.bprice}' />" id="custname">
                        <div class="mb-1">
                            <label for="name">Full Name</label>
                            <input type="text" class="form-control" name="cname" id="custname" placeholder="Enter Your Name" required>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-1">
                                    <label for="phone">Phone Number</label>
                                    <input type="tel" class="form-control" name="phone" id="phone" placeholder="Enter Your Phone Number" required>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="mb-1">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" id="email" placeholder="Enter Your Email" required>
                                </div>
                            </div>
                        </div>
                        <div class="mb-1">
                            <label for="address">Address</label>
                            <textarea name="address" class="form-control" id="address" rows="4"></textarea>
                        </div>
                        <button type="submit" class="btn btn-secondary mt-3">Confirm Order</button>
                    </div>
                </div>
            </div>
        </form>
        
    </div>
    </body>
</html>
