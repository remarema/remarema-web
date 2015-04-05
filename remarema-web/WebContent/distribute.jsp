<%@include file='template/menu.jsp'%>						  


<!-- 
	Display networks and clients
 -->
					<section id="netzwerke" class="two">
						<div class="container">
					
							<header>
								<h2>Netzwerke und Clients</h2>
							</header>
								
							<p>Guide Stuff</p>
							
							<p>${message}</p>
								
							<form method="post" action="/remarema/distribute">
							
							<div class="row">
								<div class="12u"><input type="text" placeholder="Clients/Netzwerke hinzufügen" /></div>
							</div>
							
							<p>
								Derzeitige hinzugefügte Netzwerke/Clients:
							</p>

								<div class="row">
									<div class="6u">
										<input type="text" name="typ" placeholder="Softwaretyp" />
									</div>
									<div class="6u">
										<input type="text" name="version" placeholder="Softwareversion" />
									</div>
								</div>
								<div class="row">
									<div class="8u">
										<input type="text" placeholder="Zeitpunkt der Verteilung" disabled />
									</div>
									<div class="4u">	
										<input type="text" name="distribution" value="${time}" id="datetimepicker" />
									</div>
								</div>
								<div class="row">
									<div class="8u">
										<input type="text" placeholder="Zeitpunkt der Installation" disabled />
									</div>
									<div class="4u">	
										<input type="text" name="installation" value="${time}" id="datetimepicker02" />
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" name="Software" value="Software verteilen!" />
									</div>
								</div>
								
							</form>
						</div>
						
						<p>
							Anstehende Softwareverteilungen:
						</p>
					</section>
					

	</body>
 	
</html>