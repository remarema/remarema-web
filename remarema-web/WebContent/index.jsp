<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="remarema.web.Main" %>
<%@ page import="remarema.web.Web" %>
<%@ page import="remarema.web.Util" %>

<!DOCTYPE HTML>
<!--
	Prologue by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title>ReMaReMa</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<link rel="shortcut icon" href="favicon.ico" />
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollzer.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="js/jquery.datetimepicker.js"></script>
		<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
		</noscript>
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body>

		<!-- Header -->
			<div id="header" class="skel-layers-fixed">

				<div class="top">

					<!-- Logo -->
						<div id="logo">
							<span class="image avatar48"><img src="images/dipl_logo.png" alt="" /></span>
							<h1 id="title">ReMaReMa</h1>
							<p>Wartungsoberfläche</p>
						</div>

					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="#top" id="top-link" class="skel-layers-ignoreHref"><span class="icon fa-home">Intro</span></a></li>
								<li><a href="#netzwerke" id="netzwerke-link" class="skel-layers-ignoreHref"><span class="icon fa-th">Netzwerke und Clients</span></a></li>
								<li><a href="#hinzufuegen" id="hinzufuegen-link" class="skel-layers-ignoreHref"><span class="icon fa-user">Netzwerk/Client hinzufügen</span></a></li>
								<li><a href="#einstellungen" id="einstellungen-link" class="skel-layers-ignoreHref"><span class="icon fa-envelope">Einstellungen</span></a></li>
							</ul>
						</nav>
						
				</div>
				
				<div class="bottom">

						<ul class="icons">
							<li><a href="http://www.arz.at/" target="_blank"><span class="label"><img src="images/arz_logo.png"></img></span></a></li>
						</ul>
				
				</div>
			
			</div>

		<!-- Main -->
			<div id="main">

				<!-- Intro -->
					<section id="top" class="one dark cover">
						<div class="container">

							<header>
								<%
							      Main main = new Main();
								  Web web = new Web();
								  Util util = new Util();
							      out.println("<h1>" + main.test() + "</h1>");				//Some Testings
							    %>
							</header>

						</div>
					</section>
					
				<!-- Portfolio -->
					<section id="netzwerke" class="two">
						<div class="container">
					
							<header>
								<h2>Netzwerke und Clients</h2>
							</header>
							
							<p>Meow.</p>
								
							<form method="post" action="#">
							
							<!-- Still have to think about some good displaying method for 2k clients. -->
							
							<div class="row">
								<div class="3u">
									<input type="text" placeholder="Name" disabled />
								</div>
								<div class="3u">
									<input type="text" placeholder="Netzwerk" disabled />
								</div>
								<div class="2u">
									<input type="text" placeholder="Version" disabled />
								</div>
								<div class="2u">
									<input type="text" placeholder="Verteilen" disabled />
								</div>
								<div class="2u">
									<input type="text" placeholder="Löschen" disabled />
								</div>
							</div>

									<% out.print(web.clientList(main.getClients())); %>
						
						
								<div class="row">
									<div class="12u">
										<input type="submit" name="Clients" value="Clients Updaten!" />
									</div>
								</div>
								
							<br><br>	
						
							<header>
								<h3>Software verteilen</h3>
							</header>
							
								<div class="row">
									<div class="8u">
										<input type="text" placeholder="Softwareversion" disabled />
									</div>
									<div class="4u">
										<select name="softwareversionen">
											<% out.println(web.versionList(main.getVersions())); %>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="8u">
										<input type="text" placeholder="Zeitpunkt der Verteilung" disabled />
									</div>
									<div class="4u">	
										<input type="text" name="zeitpunktVerteilung" value="<% out.print(util.getDateTime()); %>" id="datetimepicker" />
									</div>
								</div>
								<div class="row">
									<div class="8u">
										<input type="text" placeholder="Zeitpunkt der Installation" disabled />
									</div>
									<div class="4u">	
										<input type="text" name="zeitpunktInstallation" value="<% out.print(util.getDateTime()); %>" id="datetimepicker02" />
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" name="Software" value="Software verteilen!" />
									</div>
								</div>
							</form>

						</div>
					</section>

				<!-- Hinzufügen -->
					<section id="hinzufuegen" class="three">
						<div class="container">

							<header>
								<h2>Netzwerk/Client hinzufügen</h2>
							</header>

							
							<p>Miez.</p>
							
							<form method="post" action="#">
								<div class="row">
									<div class="12u"><input type="text" placeholder="Neues Netzwerk" /></div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Neues Netzwerk erstellen!" />
									</div>
								</div>
							</form>
							
							<br><br>
							
							<form method="post" action="#">
								<div class="row">
									<div class="12u"><input type="text" name="clientName" placeholder="Client Name" /></div>		
								</div>
								<div class="row">
									<div class="12u"><input type="text" name="clientCredential" placeholder="Client Credential" /></div>		
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Neuen Client erstellen!" />
									</div>
								</div>
							</form>

						</div>
					</section>
			
				<!-- Einstellungen -->
					<section id="einstellungen" class="four">
						<div class="container">

							<header>
								<h2>Einstellungen</h2>
							</header>

							<p>Nyan.</p>
							
							<form method="post" action="#">
								<div class="row">
									<div class="4u"><input type="text" value="Lebenszeit (in Tagen)" disabled /></div>
									<div class="8u"><input type="text" name="lebenszeit" placeholder="<% out.println(main.getLifetime()); %>" /></div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Einstellungen updaten!" />
									</div>
								</div>
							</form>

						</div>
					</section>
			
			</div>

		<!-- Footer -->
			<div id="footer">
				
				<!-- Copyright -->
					<ul class="copyright">
						<li>&copy; Maik Riedlsperger, Rebecca van Langelaan, Regina Werlberger</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				
			</div>

	</body>
	
	<script>
		/*window.onerror = function(errorMsg) {
			$('#console').html($('#console').html()+'<br>'+errorMsg)
		}*/
		$('#datetimepicker').datetimepicker({
		dayOfWeekStart : 1,
		lang:'en',
		startDate:	'<% out.print(util.getDateTime()); %>'
		});
		$('#datetimepicker').datetimepicker({value:'<% out.print(util.getDateTime()); %>',step:10});
		
		$('#datetimepicker02').datetimepicker({
		dayOfWeekStart : 1,
		lang:'en',
		startDate:	'<% out.print(util.getDateTime()); %>'
		});
		$('#datetimepicker02').datetimepicker({value:'<% out.print(util.getDateTime()); %>',step:10});
	</script>
</html>