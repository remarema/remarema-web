<html>
<head>
<title>ReMaReMa - Login</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="<%=request.getContextPath()%>/css/ie/html5shiv.js"></script><![endif]-->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/favicon.ico" />
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
<script src="<%=request.getContextPath()%>/js/skel-layers.min.js"></script>
<script src="<%=request.getContextPath()%>/js/init.js"></script>
<noscript>
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/skel.css" />
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/style.css" />
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/style-wide.css" />
</noscript>
<!--[if lte IE 9]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="<%=request.getContextPath()%>/css/ie/v8.css" /><![endif]-->
</head>
<body>
	<section id="top" class="two">
		<div class="container">

			<header>
				<center>
					<h2>Herzlich Willkommen auf ReMaReMa!</h2>
				</center>
			</header>

			<p><center>${message}</center>
			</header>
			</p>


				<form method="post" action="/remarema/index">
					<div class="row">
						<div class="2u"></div>
						<div class="8u">
							<input type="text" name="username" placeholder="Username" />
						</div>
						<div class="2u"></div>
					</div>
					<div class="row">
						<div class="2u"></div>
						<div class="8u">
							<input type="password" name="password" placeholder="Passwort" />
						</div>
						<div class="2u"></div>
					</div>
					<div class="row">
						<div class="2u"></div>
						<div class="8u">
							<center>
								<input type="submit" value="Einloggen!" /> <input type="hidden"
									name="action" value="login" />
							</center>
						</div>
						<div class="2u"></div>
					</div>
				</form>
		</div>
	</section>




</body>

</html>