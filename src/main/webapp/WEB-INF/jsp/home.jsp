<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	th:href="@{/webjars/bootstrap/3.3.4/css/bootstrap.min.css}"
	rel="stylesheet" media="screen" />

<script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"
	th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
<link href="../../css/style.css" th:href="@{css/style.css}"
	rel="stylesheet" media="screen" />

<title>Real State Report System</title>
</head>
<body>

	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1>Real State Report</h1>
			</div>
			<ul class="navigation">
				<li class="active"><a href="home">Home</a></li>
				<li><a href="ppt-view">PPT View</a></li>
				<li><a href="search">Search</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
	</div>

	<div class="main" align="center">
		<li>
			<h2>This is a web based application for real state report</h2>
			<p>Use the navigation buttom above</p>
			<p>"PPT view" will show completed list of report based on search results, default is all results</p>
			<p>"Search" will provide a filter for specific reports</p>
			<a href="about"><button type="button" class="button2">More About</button></a>
		</li>
	</div>

	<div id="footer">
		<div class="clearfix"></div>
		<div id="footnote">
			<div class="clearfix">
				<div class="connect">
					<a href="https://www.facebook.com/ying.liyu.7/" class="facebook"></a>
					<a href="https://www.pinterest.com/lying1/" class="pinterest"></a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>