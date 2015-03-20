<%@include file='template/menu.jsp'%>
<%@ page import="remarema.web.main.Util" %>
<%@ page import="remarema.web.beans.NetworkList" %>

<% 
	//Creates Objects to call methods later

	Util util = new Util();
	NetworkList nl = new NetworkList();
	String currentPageNumber = request.getParameter("page");
	int pageNumber = 0;
	
	try{							//If there is a page number -> parse it
		pageNumber = Integer.parseInt(currentPageNumber);
	}
	catch(NumberFormatException e){	//If there's none: Don't parse it and start the if below
		pageNumber = 0;
	}
	
	nl.setPage(pageNumber);

%>								  


<!-- 
	Display networks and clients
 -->
					<section id="netzwerke" class="two">
						<div class="container">
					
							<header>
								<h2>Netzwerke</h2>
							</header>
							
							
							<p>...</p>
							
							<div class="row">
								<div class="12u" style="text-align: left;">
									<div style=""><input type="checkbox" name="verteilen" value="true"><span style="font-size:x-large"><b><u>N1</u></b></span></div>
									<div style="margin-left:5%;"><input type="checkbox" name="verteilen" value="true"><span style="font-size:large"><b>C1</b></span></div>
									<div style="margin-left:10%;"><span style="font-size:medium">IP</span></div>
									<div style="margin-left:10%;"><span style="font-size:medium">Softwarepackage 1</span></div>
									<div style="margin-left:10%;"><span style="font-size:medium">Softwarepackage 2</span></div>
									<div style="margin-left:10%;"><input type="checkbox" name="loeschen" value="true"><span style="font-size:medium">Löschen?</span></div>
								</div>
							</div>
							
							<% 
								out.println(nl.NetworkList(pageNumber)); 
							%>
							<div class ="row">
								<div class="1u">
									<form method="get" action="shownetworks.jsp">
										<input type="hidden" name="page" value="1">
										<input type="submit" value="<<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="shownetworks.jsp">
										<input type="hidden" name="page" value="<% out.print(nl.getPageDecrement()); %>">
										<input type="submit" value="<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="4u">
									<form method="get" action="shownetworks.jsp">
										<input type="hidden" name="page" value="0">
										<input type="submit" value="Aktuellste">
									</form>
								</div>
																
								<div class="1u">
									<form method="get" action="shownetworks.jsp">
										<input type="hidden" name="page" value="<% out.print(nl.getPageIncrement()); %>">
										<input type="submit" value=">">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="shownetworks.jsp">
										<input type="hidden" name="page" value="<% out.print(nl.getLastPage()); %>">
										<input type="submit" value=">>">
									</form>
								</div>
							</div>
								
						</div>
					</section>
					

	</body>
 	
</html>