<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>Product Info</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.101.0">
    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="${pageContext.request.contextPath}/web/css/home.css" rel="stylesheet" type="text/css">
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<c:set var="products" scope = "session" value='${requestScope["product"]}' />
	
</head>
<body>
	<jsp:include page = "header.jsp" />

<section style="background-color: #eee;">
  <div class="container py-5">
    <div class="row justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-6">
        <div class="card text-black">
          <i class="fab fa-apple fa-lg pt-3 pb-1 px-3"></i>
          <img src="${product.getSrc()}"
            class="card-img-top" alt="Product" />
          <div class="card-body">
            <div class="text-center">
              <h5 class="card-title">${product.getName()}</h5>
              <p class="text-uppercase text-muted mb-4">${product.getBrand() } ${product.getType() }</p>
            </div>
            <div>
              <div class="d-flex justify-content-around">
                <span>Price</span><span>$${product.getPrice()}</span>
              </div><br>
              <div class="d-flex justify-content-between">
                <p class="about">${product.getDescription()}</p>
              </div>
              <div class="cart mt-4 align-items-center"> <button class="btn btn-danger text-uppercase mr-2 px-4">Add to cart</button> <i class="fa fa-heart text-muted"></i> <i class="fa fa-share-alt text-muted"></i> </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

	<jsp:include page = "footer.jsp" />
</body>
</html>