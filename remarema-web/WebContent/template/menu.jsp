<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="remarema.web.util.Util" %>
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

		<noscript>
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/skel.css" />
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
			<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-wide.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v8.css" /><![endif]-->
	
	</head>
	<body>

		<!-- Header -->
			<div id="header" class="skel-layers-fixed">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<span class="image avatar48"><a href="/remarema/home"><img src="<%=request.getContextPath()%>/images/bw_small2.png" width="240px" alt="" /></a></span>
							<h1 id="title"></h1>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li id="<%=utilitie.activeMenu(currentPage, "home.jsp")%>"><a href="/remarema/home"><span class="icon fa-home">Home</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "networks.jsp")%>"><a href="/remarema/networks" id="networks"><span class="icon fa-desktop">Netzwerkverwaltung</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "nodes.jsp")%>"><a href="/remarema/nodes" id="nodes"><span class="icon fa-user">Clientverwaltung</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "packages.jsp")%>"><a href="/remarema/packages" id="packages"><span class="icon fa-upload">Softwareverwaltung</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "distribute.jsp")%>"><a href="/remarema/distribute" id="distribute"><span class="icon fa-share-square">Software verteilen</span></a></li>
								<li id="<%=utilitie.activeMenu(currentPage, "index.jsp")%>"><a href="/remarema/index?action=logout" id="logout"><span class="icon fa-sign-out">Logout</span></a></li>
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">
				</div>
			
			</div>

		<!-- Main -->
			<div id="main">