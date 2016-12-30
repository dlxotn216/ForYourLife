<%--
  Created by IntelliJ IDEA.
  User: Neonexsoft
  Date: 2016-11-28
  Time: 오전 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
	<title><tiles:getAsString name="title" /></title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="/resources/css/common.css">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="row">
	<div class="col-md-12">
		<tiles:insertAttribute name="header"/>
	</div>
	<div class="col-md-12 header-offset" style="display:block; padding-top:50px;">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Library</a></li>
			<li class="active">Data</li>
		</ol>
	</div>

	<div class="clearfix"></div>

	<div class="col-md-12">
		<tiles:insertAttribute name="body" ignore="false" />
	</div>

	<div class="clearfix"></div>

	<div class="col-md-12">
		<tiles:insertAttribute name="footer" />
	</div>
</div>

<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/1.5.13/clipboard.min.js"></script>
<!--<script src="https://cdn.jsdelivr.net/lodash/4.17.2/lodash.js"></script>-->

<script src="/resources/js/test.js"></script>
<script type="text/javascript">
	(function () {
	    console.log("INIT");
	})();
</script>

<script type="text/javascript" src="/resources/js/admin/movie/detail.js"></script>
<script type="text/javascript" src="/resources/js/admin/movie/list.js"></script>
<script type="text/javascript" src="/resources/js/admin/fb/detail.js"></script>
<!-- Hotjar Tracking Code for http://ec2-54-238-153-241.ap-northeast-1.compute.a -->
<script>
	(function(h,o,t,j,a,r){
		if( console.log ){
			console.log(arguments);
		}
		h.hj=h.hj||function(){(h.hj.q=h.hj.q||[]).push(arguments)};
		h._hjSettings={hjid:353286,hjsv:5};
		a=o.getElementsByTagName('head')[0];
		r=o.createElement('script');r.async=1;
		r.src=t+h._hjSettings.hjid+j+h._hjSettings.hjsv;
		a.appendChild(r);
	})(window,document,'//static.hotjar.com/c/hotjar-','.js?sv=');
</script>
</body>
</html>
