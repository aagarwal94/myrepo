<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<%
	List imagesUrl = (List) session.getAttribute("imagesUrl");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>
	<c:out value="Hello"></c:out>
	<h3>Employee Details</h3>
	<hr size="4" color="gray" />
	<form action="DownloadImage" method="post">
		 <c:forEach items="${imagesUrl}" var="images">
		 		 <input type="checkbox" name ="ImagesUrl" value ="<c:out value="${images.imageSrc}"/>" >${images.imageSrc}<br> 
		</c:forEach>
		<input type="submit" name="Download">
	</form>
</body>
</html>
