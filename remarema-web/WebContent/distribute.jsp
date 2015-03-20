<%@include file='template/menu.jsp'%>
<%@ page import="remarema.web.main.Main" %>
<%@ page import="remarema.web.main.Util" %>
<%@ page import="remarema.web.display.Setting" %>
<%@ page import="remarema.web.display.Test" %>
<%@ page import="remarema.web.display.Version" %>
<%@ page import="remarema.web.display.Node" %>
<%@ page import="remarema.web.display.Deploy" %>
<% 
	//Creates Objects to call methods later

	Util util = new Util();

%>								  


<!-- 
	Display networks and clients
 -->
					<section id="netzwerke" class="two">
						<div class="container">
					
							<header>
								<h2>Netzwerke und Clients</h2>
							</header>
							
							
							<p>Guide Stuff</p>
								
							<form method="post" action="#">
							
							<div class="row">
								<div class="12u"><input type="text" placeholder="Clients/Netzwerke hinzufügen" /></div>
							</div>
							
							<p>
								Derzeitige hinzugefügte Netzwerke/Clients.
							</p>

								<div class="row">
									<div class="6u">
										<input type="text" placeholder="Softwaretyp" />
									</div>
									<div class="6u">
										<input type="text" placeholder="Softwareversion" />
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
						
						<p>
							Anstehende Softwareverteilungen:
						</p>
					</section>
					

	</body>
 	
</html>