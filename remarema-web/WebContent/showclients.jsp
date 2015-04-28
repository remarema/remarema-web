<%@include file='template/menu.jsp'%>						  

<!-- 
	Display networks and clients
 -->
					<section id="netzwerke" class="two">
						<div class="container">
					
							<header>
								<h2>Clients</h2>
							</header>
							
							
							<p>...</p>
							
							<div class="row">
								<div class="12u" style="text-align: left;">
									<div style=""><span style="font-size:x-large"><b><u>Client 1</u></b></span></div>
									<div style="margin-left:5%;"><span style="font-size:large"><b>Network</b></span></div>
									<div style="margin-left:5%;"><span style="font-size:medium">IP</span></div>
									<div style="margin-left:5%;"><span style="font-size:medium">Softwarepackages</span></div>
									<div style="margin-left:5%;"><span style="font-size:medium">Edit Client</span></div>
								</div>
							</div>
							
							${clientList}
							
							<div class ="row">
								<div class="1u">
									<form method="get" action="/remarema/showclients">
										<input type="hidden" name="page" value="1">
										<input type="submit" value="<<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="/remarema/showclients">
										<input type="hidden" name="page" value="${pageDecrement}">
										<input type="submit" value="<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="4u">
									<form method="get" action="/remarema/showclients">
										<input type="hidden" name="page" value="0">
										<input type="submit" value="Aktuellste">
									</form>
								</div>
																
								<div class="1u">
									<form method="get" action="/remarema/showclients">
										<input type="hidden" name="page" value="${pageIncrement}">
										<input type="submit" value=">">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="/remarema/showclients">
										<input type="hidden" name="page" value="${lastPage}">
										<input type="submit" value=">>">
									</form>
								</div>
							</div>
								
						</div>
					</section>
					

	</body>
 	
</html>