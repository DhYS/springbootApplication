<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<link
	href="http://cdn.jsdelivr.net/webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	th:href="@{/webjars/bootstrap/3.3.4/css/bootstrap.min.css}"
	rel="stylesheet" media="screen" />

<title>Real State Report System</title>

<script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"
	th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
<link href="../css/style.css" th:href="@{css/style.css}"
	rel="stylesheet" media="screen" />

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>

<style>
#map {
	height: 100%;
	width: 50%;
	padding-left: 100px;
	float: left;
}

#scaleimg {
	height: auto;
	width: 50%;
	max-height: 350px;
	float: left;
}

input[id='submit'] {
	border-radius: 5px;
	border-color: #333;
	font-size: 18px;
	color: #000000;
	height: 38px;
	width: 212px
}

<!--
CSS styles for standard search box with placeholder text-->#tfnewsearch
	{
	float: right;
	padding: 20px;
}

.tftextinput2 {
	margin: 0;
	width: 50%;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	color: #666;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
	color: #666;
}

.tfbutton2 {
	margin: 0;
	padding: 5px 9px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 18px;
	font-weight: bold;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: #ffffff;
	border: solid 0px #0076a3;
	border-right: 0px;
	background: #0095cd;
	background: -webkit-gradient(linear, left top, left bottom, from(#00adee),
		to(#0078a5));
	background: -moz-linear-gradient(top, #00adee, #0078a5);
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.tfbutton2:hover {
	text-decoration: none;
	background: #007ead;
	background: -webkit-gradient(linear, left top, left bottom, from(#0095cc),
		to(#00678e));
	background: -moz-linear-gradient(top, #0095cc, #00678e);
}
/* Fixes submit button height problem in Firefox */
.tfbutton2::-moz-focus-inner {
	border: 0;
}

.tfclear {
	clear: both;
}
</style>
</head>

<body>
	<script>
		var address = '${report.getAddress()}';
		function initMap() {
			var geocoder = new google.maps.Geocoder();
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : -30.397,
					lng : 150.644
				},
				zoom : 17
			});
			geocoder
					.geocode(
							{
								'address' : address
							},
							function(results, status) {
								if (status === google.maps.GeocoderStatus.OK) {
									map.setCenter(results[0].geometry.location);
									var marker = new google.maps.Marker({
										map : map,
										position : results[0].geometry.location
									});
								} else {
									alert('Geocode was not successful for the following reason: '
											+ status);
								}
							});
			document.getElementById('submit').addEventListener('click',
					function() {
						geocodeAddress(geocoder, map);
					});
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?signed_in=false&callback=initMap"
		async defer>
		
	</script>

	<div id="header">
		<div class="clearfix">
			<div class="logo">
				<h1>PPT Report</h1>
			</div>
			<ul class="navigation">
				<li><a href="home">Home</a></li>
				<li class="active"><a href="ppt-view">PPT View</a></li>
				<li><a href="search">Search</a></li>
				<li><a href="about">About</a></li>
			</ul>
		</div>
	</div>

	<div class="main" align="center">

		<div id="tfheader">
			<form id="tfnewsearch" method="get" action="ppt-view">
				<input type="text" id="tfq" class="tftextinput2" name="input" size="21"
					maxlength="120" value="Address Search"
					onfocus="if(this.value=='Address Search') {this.value=''};">
				<input type="submit" value="Search" class="tfbutton2">
			</form>
			<div class="tfclear"></div>
		</div>
		<script>${alertMessage}</script>
		<p>Found ${reportNumber} result(s), showing No.${reportIndex}</p>

		<h3>${report.getAddress()}</h3>
		<div class="box">
			<img src="${report.getImage()}" id="scaleimg" />
			<div id="map"></div>
		</div>

		<p></p>
		<div class="CSSTableGenerator">
			<table>
				<tr>
					<td>Bed/Bath Count</td>
					<td>${report.getBedBathCount()}</td>
					<td>Purchase Price</td>
					<td>${report.getPurchasePrice()}</td>
				</tr>
				<tr>
					<td>Square Feet</td>
					<td>${report.getSquareFootage()}</td>
					<td>Projected CapEx</td>
					<td>${report.getProjectedCapEx()}</td>
				</tr>
				<tr>
					<td>Year Built</td>
					<td>${report.getYearBuilt()}</td>
					<td>Total Cost</td>
					<td>${report.getTotalCost()}</td>
				</tr>
				<tr>
					<td>Neighborhoods</td>
					<td>${report.getNeighborhood()}</td>
					<td>Price/SF</td>
					<td>${report.getPriceSF()}</td>
				</tr>
				<tr>
					<td>Neighborhood Rating</td>
					<td>${report.getNeighborhoodRating()}</td>
					<td>Projected Rent</td>
					<td>${report.getProjectedRent()}</td>
				</tr>
				<tr>
					<td>Status</td>
					<td>${report.getStatus()}</td>
					<td>Projected Gross Yield</td>
					<td>${report.getProjectedGrossYield()}</td>
				</tr>
			</table>
		</div>
		<p></p>
		<div>
		<form action="ppt-view" method=post>
			<a><input type="submit" name="previous" value="Previous" id="submit" /></a>
			<a>
				<input type="text" name="page number" size="5" value="${reportIndex}"
					onfocus="if(this.value=='${reportIndex}') {this.value=''};">
				<input type="submit" name="page" value="Go to" id="submit" maxlength="5">
			</a>
			<a><input type="submit" name="next" value="Next" id="submit" /></a>
		</form>
		</div>
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