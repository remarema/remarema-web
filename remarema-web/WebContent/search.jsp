<%@include file='template/menu.jsp'%>						  
<%@ page import="remarema.web.beans.Search" %>
<% 
	//Creates Objects to call methods later
	
	Search search = new Search();
	search.setSearch(request.getParameter("s"));
%>		
					<section id="einstellungen" class="two">
						<div class="container">

							<header>
								<h2>Die Suche nach <i><% out.println(search.getSearch()); %></i> ergab folgende Ergebnisse:</h2>
							</header>

							<p><a href="network_status.jsp?network=11">Netzwerk 01</a><br />
							<a href="node_status.jsp?node=42">Client 007</a></p>
							


						</div>
					</section>


	</body>
 	
</html>