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
<c:set var="totalPage" value='${ cart.getItems().size()}' />
<c:if test="${cart == null || cart.getItems().size() == 0}">
	<script>
		alert("Your cart is empty!!!!");
	</script>
</c:if>

<title>Cart</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/web/css/home.css" rel="stylesheet" type="text/css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
</head>
<body>
<jsp:include page = "header.jsp" />

<main>
    <h1 class="mb-3 text-center mt-1">Your Cart</h1>
  <div class="album py-5 bg-light">
    <div class="container">
   		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		  <c:forEach items="${cart.getItems()}" var="product" >
		        <div class="col">
		          <div class="card shadow-sm">
		            <img class="bd-placeholder-img card-img-top" src="${product.getSrc()}" role="img" alt="Product" aria-label="Thumbnail">
		            <div class="card-body">
		              <h2><c:out value="${product.getName()}"/> </h2>
		              <p class="card-text">${product.getDescription()}</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                <form action="InformationProductController" method="get">
		                  <button type="submit" class="btn btn-sm btn-outline-secondary" name="id" value="${product.getId() }">View</button>
						</form>
						<form action="AddToCartController?action=delete" method="post">
		                  <button type="submit" class="btn btn-sm btn-outline-secondary" name="id" value="${product.getId() }">Add to cart</button>
						</form>
		                </div>
		                <small class="text-muted">$${product.getPrice()}</small>
		              </div>
		            </div>
		          </div>
		        </div>
	      </c:forEach>
      	</div>
    </div>
  </div>
</main>

<jsp:include page = "footer.jsp" />
</body>
</html>