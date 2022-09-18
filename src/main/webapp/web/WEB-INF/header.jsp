<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<% 
	String name = (String) session.getAttribute("user");
	String status = "Logout";
	String button = "danger";
	if(name == null){
		name = "Guest";
		status = "Login";
		button = "primary";
	}
	%>
</head>
<body>
<header>
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">About</h4>
          <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
          	
			<form action="SearchController" method="get">
			<div class="input-group">
  			  <input type="search" class="form-control rounded " name="search" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
			  <button type="submit" class="btn btn-primary">
			    <i class="fas fa-search"></i>
			  </button>
  			</div>
			</form>
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
        
          <h4 class="text-white">Welcome!<%= name %> </h4>

          <ul class="list-unstyled">
            <li><a href="ListController" class="text-white text-decoration-none">Products</a></li>
            <c:if test="${sessionScope['user'] != null }">
            	<li><a href="AddToCartController" class="text-white text-decoration-none">Cart</a></li>
            </c:if>
            <li><a href="#" class="text-white text-decoration-none">About</a></li>

            <li>
            <form action="login" method="get">
    			<button class="btn btn-<%= button %> text-white" type="submit"><%= status %></button>
    		</form>
    		</li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="#" class="navbar-brand d-flex align-items-center">
        <strong>FUNIX</strong>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>

</body>
</html>