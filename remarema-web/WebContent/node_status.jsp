<%@include file='template/menu.jsp'%>						  
<%@ page import="remarema.web.beans.NodeStatus" %>
<%
	//Creates Objects to call methods later
	
	NodeStatus status = new NodeStatus();
	status.setNodeID(Integer.parseInt(request.getParameter("node")));
	String delete = "false";
	
	
	if(request.getParameter("id") != null){
		//Call Rebecca and update stuff
	}
	
	if(request.getParameter("delete") != null){
		//Delete the node
	}

%>		
					<section id="node_status" class="two">
						<div class="container">

							<header>
								<h2>Nodestatus</h2>
							</header>

						<form method="post" action="node_status.jsp?node=<% out.print(status.getNodeID()); %>">
							<div class="row">
								<div class="2u"><input type="text" value="ID" disabled /></div>
								<div class="10u"><input type="text" name="id" value="<% out.println(status.getNodeID()); %>" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Name" disabled /></div>
								<div class="10u"><input type="text" name="name" value="<% out.println(status.getNodeName()); %>" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="IP" disabled /></div>
								<div class="10u"><input type="text" name="ip" value="<% out.println(status.getNodeIP()); %>" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Network" disabled /></div>
								<div class="2u"><input type="text" name="networkID" value="<% out.println(status.getNetworkID()); %>" /></div>
								<div class="6u"><input type="text" name="networkName" value="<% out.println(status.getNetworkName()); %>" /></div>
								<div class="2u"><a href="network_status.jsp?network=<% out.print(status.getNetworkID()); %>"><input id="inputbtn" type="text" value="View" disabled /></a></div>
							</div>
							<div class="row">
									<div class="12u">
										<input type="submit" value="Node updaten!" />
									</div>
							</div>
						</form>
						
						<br /> <br />
							<h3>Node löschen</h3>

							<form method="post" action="node_status.jsp?node=<% out.print(status.getNetworkID()); %>&delete=true">
								<div class="row">
									<div class="12u">
										<input type="submit" value="Löschen!" />
									</div>
								</div>
							</form>
							


						</div>
					</section>


	</body>
 	
</html>