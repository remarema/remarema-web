<%@include file='template/menu.jsp'%>						  

<!-- 
	Add networks and clients
 -->
					<section id="hinzufuegen" class="two">
						<div class="container">

							<header>
								<h2>Netzwerk hinzufügen</h2>
							</header>

							
							<p>Short description/guide</p>
							<p>${message}</p>
							
							<form method="post" action="/remarema/addnetwork">
								<div class="row">
									<div class="12u"><input type="text" name="name" placeholder="Netzwerkname" /></div>
								</div>
								<div class="row">
									<div class="12u"><input type="text" name="parent" placeholder="Parent" /></div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Neues Netzwerk erstellen!" />
									</div>
								</div>
							</form>
							

						</div>
					</section>

	</body>
 	
</html>