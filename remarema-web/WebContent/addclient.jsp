<%@include file='template/menu.jsp'%>						  

<!-- 
	Add networks and clients
 -->
					<section id="hinzufuegen" class="two">
						<div class="container">

							<header>
								<h2>Client hinzufügen</h2>
							</header>

							
							<p>Short description/guide</p>
						
							
							<form method="post" action="#">
								<div class="row">
									<div class="12u"><input type="text" name="clientName" placeholder="Client Name" /></div>		
								</div>
								<div class="row">
									<div class="12u"><input type="text" name="clientIP" placeholder="Client IP" /></div>		
								</div>
								<div class="row">
									<div class="12u"><input type="text" name="clientNetwork" placeholder="Netzwerk wählen" /></div>		
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Neuen Client erstellen!" />
									</div>
								</div>
							</form>

						</div>
					</section>

	</body>
 	
</html>