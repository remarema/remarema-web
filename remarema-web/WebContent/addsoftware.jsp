<%@include file='template/menu.jsp'%>						  

<!-- 
	Deploy and add software
 -->
					<section id="software" class="two">
						<div class="container">	
							<header>
								<h2>Software hinzufügen</h2>
							</header>
							
							<p>Short description/guide</p>
							<p>${message}</p>

							<form method="post" action="/remarema/addsoftware">
								<div class="row">
									<div class="8u"><input type="text" name="data" placeholder="Softwaredateien" /></div>
									<div class="4u">
										<input type="submit" value="Software Upload" />
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="text" name="packet" placeholder="Softwarepacket" />
									</div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Neue Software hinzufügen!" />
									</div>
								</div>
							</form>
							
							<br /><br />
							
							<h3>Derzeitig verfügbare Softwares</h3>
							
							<p>Liste</p>

						</div>
					</section>
					

	</body>
 	
</html>