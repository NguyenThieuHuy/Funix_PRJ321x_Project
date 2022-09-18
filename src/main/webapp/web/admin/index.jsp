<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <meta name="description" content="">
 <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
 <meta name="generator" content="Hugo 0.84.0">
 <title>Dashboard</title>
 <!-- Bootstrap core CSS -->
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
 <link href="${pageContext.request.contextPath}/web/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<sql:setDataSource var="ds" dataSource="jdbc/ShoppingDB" />
	
	<sql:query dataSource="${ds}" sql="select * from Account" var="results"/>
	
	<c:forEach var = "account" items="${results.rows}">
		<p>${account.user_name}</p>
	</c:forEach>
	
	<jsp:include page = "header.jsp" />
	<jsp:include page = "body.jsp" />
	<jsp:include page = "footer.jsp" />
</body>
</html>