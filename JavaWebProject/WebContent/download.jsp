<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DownloadPage</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css" media="screen">
<link rel="stylesheet" type="text/css"
	href="assets/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/style.css"
	media="screen">
<link rel="stylesheet" type="text/css" href="assets/css/responsive.css"
	media="screen">

<script type="text/javascript">
	<!--
	function Redirect() {
		window.location = "<%=request.getAttribute("videoUrl")%>";
	}
//-->
</script>

</head>
<body>
	<div id="header"></div>
	
 	<div class="fix main_content_area">
		<div class="fix wrapper main_content">
			<div class="inner_page">

				<p>To start the download click the link below !!!</p>
				<form>
					<input type="button" value="Download video" onclick="Redirect();" />
				</form>
			</div>
		</div>
	</div>
	
	<div id="footer"></div>

	<script>
		$("#header").load("pages/header.html");
		$("#footer").load("pages/footer.html");
	</script>

</body>
</html>