<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
	<title>Register</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/web/css/login.css" rel="stylesheet" type="text/css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	
</head>
<body class="text-center">
    <main class="form-signin">
        <form action="<%= response.encodeUrl(request.getContextPath()+"/login?action=docreate") %>" method="post" >
            <img class="mb-4" src="https://old-freec2-production.s3.amazonaws.com/carrierwave/images/image_upload/317725/medium_funixfulllogooriginal.png" alt="" width="72" height="57">
            <h1 class="h3 mb-3 fw-normal">Please sign up</h1>

            <div class="form-floating">
            <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="username" required>
            <label for="floatingInput">Email address</label>
            </div>
            <div class="form-floating">
            <input type="text" class="form-control" placeholder="User Name" name="userName" required>
            <label for="floatingPassword">User name</label>
            </div>
            <div class="form-floating">
            <input type="text" class="form-control" placeholder="User Address" name="address" required>
            <label for="floatingPassword">User Address</label>
            </div>
            <div class="form-floating">
            <input type="tel" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" class="form-control" placeholder="Phone Number" name="phone"  required>
            <label for="floatingPassword">Phone Number</label>
            </div>
            <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
            <label for="floatingPassword">Password</label>
            </div>
            
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" id="inlineCheckbox1" value="1" name="role" required>
			  <label class="form-check-label" for="inlineCheckbox1">Admin</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" id="inlineCheckbox2" value="2" name="role" required>
			  <label class="form-check-label" for="inlineCheckbox2">Seller</label>
			</div>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" id="inlineCheckbox3" value="3" name="role" required>
			  <label class="form-check-label" for="inlineCheckbox3">Buyer</label>
			</div>          
            
			<c:if test="${ requestScope['message'] != null}">
				<p class="alert alert-danger">${ requestScope['message']}</p>
			</c:if>
			
            <div class="checkbox mb-3">
            <label>
                <input type="checkbox" value="remember-me" name="cookies" checked> Remember me
            </label>
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Sign up</button>
              <!-- Register buttons -->
			  <div class="text-center">
			    <p>Already have an account? <a href="<%= response.encodeUrl(request.getContextPath()+"/login") %>">Login</a></p>
			    <p>or sign up with:</p>
			    <button type="button" class="btn btn-link btn-floating mx-1">
			      <i class="fab fa-facebook-f"></i>
			    </button>
			
			    <button type="button" class="btn btn-link btn-floating mx-1">
			      <i class="fab fa-google"></i>
			    </button>
			
			    <button type="button" class="btn btn-link btn-floating mx-1">
			      <i class="fab fa-twitter"></i>
			    </button>
			
			    <button type="button" class="btn btn-link btn-floating mx-1">
			      <i class="fab fa-github"></i>
			    </button>
			  </div>
            <p class="mt-5 mb-3 text-muted">&copy; Huy's Project</p>
        </form>
    </main>
</body>
</html>