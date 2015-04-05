<%@include file='template/menu.jsp'%>						  
<%@ page import="remarema.web.display.Setting" %>		
					<section id="einstellungen" class="two">
						<div class="container">

							<header>
								<h2>Einstellungen</h2>
							</header>

							<p>Short description/guide</p>
							<p>${message}</p>
							
							<form method="post" action="/remarema/properties">
								<div class="row">
									<div class="4u"><input type="text" value="Lebenszeit (in Tagen)" disabled /></div>
									<div class="8u"><input type="text" name="lebenszeit" placeholder="${lifetime}" /></div>
								</div>
								<div class="row">
									<div class="12u">
										<input type="submit" value="Einstellungen updaten!" />
									</div>
								</div>
							</form>

						</div>
					</section>


	</body>
 	
</html>