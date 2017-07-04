<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DownloadPage</title>

<script type="text/javascript">
	<!--
	function Redirect() {
		window.location = "<%=request.getAttribute("videoUrl")%>";
	}
//-->
</script>

</head>
<body>
	<br> Download is Complete !!! Have a nice day
	<br>
	<form>
		<input type="button" value="Redirect Me" onclick="Redirect();" />
	</form>

</body>
</html>