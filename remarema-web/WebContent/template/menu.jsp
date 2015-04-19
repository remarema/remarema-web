<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="remarema.web.main.Util" %>
<% 
	//Creates Objects to call methods later

	Util utilitie = new Util();

	String uri = request.getRequestURI();
	String currentPage = uri.substring(uri.lastIndexOf("/")+1);

%>	

<!DOCTYPE HTML>
<!--
	Prologue by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
	
	Author: Maik Riedlsperger
	Version: 0.020
-->
<html>
	<head>
		<title>ReMaReMa</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/css/ie/html5shiv.js"></script><![endif]-->
		<link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" />
		<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/skel-layers.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/init.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css"/>
		<noscript>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/skel.css" />
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-wide.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v8.css" /><![endif]-->
		
	<!-- Datepicker Javascript -->

		<script>
			/*window.onerror = function(errorMsg) {
				$('#console').html($('#console').html()+'<br>'+errorMsg)
			}*/
			$('#datetimepicker').datetimepicker({
			dayOfWeekStart : 1,
			lang:'en',
			startDate:	'<% out.print(utilitie.getDateTime()); %>'
			});
			$('#datetimepicker').datetimepicker({value:'<% out.print(utilitie.getDateTime()); %>',step:10});
			
			$('#datetimepicker02').datetimepicker({
			dayOfWeekStart : 1,
			lang:'en',
			startDate:	'<% out.print(utilitie.getDateTime()); %>'
			});
			$('#datetimepicker02').datetimepicker({value:'<% out.print(utilitie.getDateTime()); %>',step:10});
		</script> 
	
	</head>
	<body>

		<!-- Header -->
			<div id="header" class="skel-layers-fixed">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<span class="image avatar48"><img src="<%=request.getContextPath()%>/images/dipl_logo.png" alt="" /></span>
							<h1 id="title">ReMaReMa</h1>
							<p>Wartungsoberfläche</p>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<!-- <li><form action="/remarema/search"><input type="text" name="s" placeholder="Suche..." /></form></li>  -->
								<li id="<%=utilitie.activeMenu(currentPage, "index.jsp")%>"><a href="/remarema/index"><span class="icon fa-home">Home</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "addnetwork.jsp")%>"><a href="/remarema/addnetwork" id="addnetwork"><span class="icon fa-user">Netzwerk hinzufügen</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "addclient.jsp")%>"><a href="/remarema/addclient" id="addclient"><span class="icon fa-user">Client hinzufügen</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "networks.jsp")%>"><a href="/remarema/networks" id="networks"><span class="icon fa-th">Netzwerkstatus</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "nodes.jsp")%>"><a href="/remarema/nodes" id="nodes"><span class="icon fa-th">Clientstatus</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "addsoftware.jsp")%>"><a href="/remarema/addsoftware" id="addsoftware"><span class="icon fa-user">Software hinzufügen</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "distribute.jsp")%>"><a href="/remarema/distribute" id="distribute"><span class="icon fa-th">Software verteilen</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "properties.jsp")%>"><a href="/remarema/properties" id="properties"><span class="icon fa-envelope">Einstellungen</span></a></li>
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">
<!--
 mario: dieses Logo überdeckt auf kleinen Browserfenstern das Menü und dann können 
 	Menüpunkte nicht mehr ausgewählt werden. 
 	 
						<ul class="icons">
						
							<li><a href="http://www.arz.at/" target="_blank"><span class="label"><img src="<%=request.getContextPath()%>/images/arz_logo.png"></img></span></a></li>
						</ul>
	 -->			
				</div>
			
			</div>

		<!-- Main -->
			<div id="main">