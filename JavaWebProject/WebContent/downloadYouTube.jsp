<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page
	import="com.github.axet.vget.vhs.*,com.github.axet.vget.*,com.github.axet.vget.info.*"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

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
	$(document)
			.ready(
					function() {
						$("input[type='button']")
								.click(
										function() {
											var radios = document
													.getElementsByName('downloadUrl');
											for (var i = 0, length = radios.length; i < length; i++) {
												if (radios[i].checked) {
													var str = "video."
															+ (document
																	.getElementById(i).innerHTML);
													$("#target").attr(
															"download", str);
													$("#target").attr("href",
															radios[i].value);
													break;
												}
											}
										});
					});
</script>

</head>
<body>
	<div id="header"></div>
	<div class="fix main_content_area">
		<div class="fix wrapper main_content">
			<div class="inner_page">
				<h1>To start the download click the link below !!!</h1>
				<br /> <img src="${thumbnail}" alt="Thumbnail"
					style="width: 304px; height: 228px;"> <br /> <br /> <br />

				<h2 id='video'>${videoName}</h2>
				<br />
				<table>
					<c:forEach items="${videosUrl}" var="videoUrl" varStatus="loop">
						<td><input type="radio" name="downloadUrl"
							value="${videoUrl.url}">${videoUrl.stream.c} Quality:
							${videoUrl.stream.vq} bitrate: ${videoUrl.stream.aq}</td>
						<td id="${loop.index}" value="${videoUrl.stream.c}"
							style="color: buttonface; visibility: hidden;">${videoUrl.stream}</td>
						</tr>
					</c:forEach>
				</table>
				 <br /> <a id="target" href="radioValue" download="videoName">
					<input type="button" value="Download Video">
				</a>
			</div>
		 	<h4 style="margin-left: 130px;">In case your video is downloading just as a file, change its extension after it downloads on your system</h4>
		</div>
	</div>
	<div id="footer"></div>

	<script>
		$("#header").load("pages/header.html");
		$("#footer").load("pages/footer.html");
	</script>

</body>
</html>