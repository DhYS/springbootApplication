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

<script src="http://cdn.jsdelivr.net/webjars/jquery/2.1.4/jquery.min.js"
	th:src="@{/webjars/jquery/2.1.4/jquery.min.js}"></script>
<link href="../css/style.css" th:href="@{css/style.css}"
	rel="stylesheet" media="screen" />

<title>Real State Report System</title>

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<style>
#map {
	height: 100%;
	width: 100%;
}

#scaleimg {
	height: auto;
    width: auto; 
    max-width: 550px; 
    max-height: 350px;
}
</style>

</head>
<body>


	<script>
		var address = '${report.getCurrent().getAddress()}';
		function initMap() {
			var geocoder = new google.maps.Geocoder();
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {lat : -30.397, lng : 150.644},
				zoom : 17
			});
			geocoder.geocode({'address': address}, function(results, status) {
    			if (status === google.maps.GeocoderStatus.OK) {
      				map.setCenter(results[0].geometry.location);
      				var marker = new google.maps.Marker({
        				map: map,
        				position: results[0].geometry.location
      				});
    			} else {
      				alert('Geocode was not successful for the following reason: ' + status);
    			}
  			});
  			document.getElementById('submit').addEventListener('click', function() {
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
				<h1>Real State Report</h1>
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
		<h2>Report View</h2>
		<h3>${report.getCurrent().getAddress()}</h3>
		<div class="box"><img ${report.getCurrent().getImage()} id="scaleimg"/></div>
		<div class="box">
      		<div id="map"></div>
      	</div>

		<p></p>
		<div class="CSSTableGenerator">
			<table>
				<tr>
					<td>Bed/Bath Count</td>
					<td>${report.getCurrent().getBedBathCount()}</td>
					<td>Purchase Price</td>
					<td>${report.getCurrent().getPurchasePrice()}</td>
				</tr>
				<tr>
					<td>Square Feet</td>
					<td>${report.getCurrent().getSquareFootage()}</td>
					<td>Projected CapEx</td>
					<td>${report.getCurrent().getProjectedCapEx()}</td>
				</tr>
				<tr>
					<td>Year Built</td>
					<td>${report.getCurrent().getYearBuilt()}</td>
					<td>Total Cost</td>
					<td>${report.getCurrent().getTotalCost()}</td>
				</tr>
				<tr>
					<td>Neighborhoods</td>
					<td>${report.getCurrent().getNeighborhood()}</td>
					<td>Price/SF</td>
					<td>${report.getCurrent().getPriceSF()}</td>
				</tr>
				<tr>
					<td>Neighborhood Rating</td>
					<td>${report.getCurrent().getNeighborhoodRating()}</td>
					<td>Projected Rent</td>
					<td>${report.getCurrent().getProjectedRent()}</td>
				</tr>
				<tr>
					<td>Status</td>
					<td>${report.getCurrent().getStatus()}</td>
					<td>Projected Gross Yield</td>
					<td>${report.getCurrent().getProjectedGrossYield()}</td>
				</tr>
			</table>
		</div>
		<p></p>
		<form action="ppt-view" method=post>
			<a><input type="submit" name="previous" value="Previous" /></a> <a><input
				type="submit" name="next" value="Next" /></a>
		</form>
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