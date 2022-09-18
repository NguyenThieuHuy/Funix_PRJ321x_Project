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
<c:set var="products" scope = "session" value='${requestScope["products"]}' />
<c:set var="totalPage" scope = "session" value='${requestScope["totalPage"]}' />
<c:set var="page" scope = "session" value='${requestScope["page"]}' />

</head>
<body>
<main>
<c:if test="${products == null || products.size() == 0}">
	<script>
		alert("There is no product to be shown!!!");
	</script>
</c:if>
  <div class="album py-5 bg-light">
    <div class="container">
   		<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
		  <c:forEach items="${products}" var="product" >
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
						<c:if test="${sessionScope['user'] == null }">
							<c:set var="disabled" scope = "session" value="disabled"/>
						</c:if>
						<form action="AddToCartController?action=add" method="post">
		                  <button type="submit" class="btn btn-sm btn-outline-secondary" name="id" value="${product.getId() }" ${disabled}>Add to cart</button>
						</form>
		                </div>
		                <small class="text-muted">$${product.getPrice()}</small>
		              </div>
		            </div>
		          </div>
		        </div>
	      </c:forEach>
      	</div>
      <nav aria-label="Page navigation">
        <ul class="pagination">
        <c:if test="${page > 1}">
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}?page=${page-1}">Previous</a></li>
        </c:if>
        <c:forEach  var = "i" begin = "1" end = "${totalPage/9 + 1}">
        <c:choose>
	        <c:when test = "${i == page}">
	            <c:set var="active" value="active" />
	        </c:when>
	        <c:otherwise> <c:set var="active" value="" /></c:otherwise>
	     </c:choose>
          <li class="page-item"><a class="page-link ${active}" href="${pageContext.request.contextPath}?page=${i}">${i}</a></li>
        </c:forEach>
        <c:if test="${page < totalPage/9}">
          <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}?page=${page+1}">Next</a></li>
        </c:if>
        </ul>
      </nav>
    </div>
  </div>
</main>

</body>
</html>