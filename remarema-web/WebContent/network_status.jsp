<%@include file='template/menu.jsp'%>						  
<%@ page import="remarema.web.beans.NetworkStatus" %>
<%@ page import="java.util.ArrayList" %>
<%
	//Creates Objects to call methods later
	
	NetworkStatus status = new NetworkStatus();
	status.setNetworkID(Integer.parseInt(request.getParameter("network")));
	
	
	
	
	ArrayList<Integer> debug = new ArrayList<Integer>();
	debug.add(10);
	status.setNodeIDs(debug);
	
	ArrayList<String> debug02 = new ArrayList<String>();
	debug02.add("Großartiger Client");
	status.setNodeNames(debug02);
	
	
	
	
	if(request.getParameter("noderm") != null){
		//Call Rebecca and delete stuff
	}
	if(request.getParameter("id") != null){
		//Call Rebecca and update stuff
	}
	if(request.getParameter("delete") != null){
		//Delete the network
	}
%>		
					<section id="netzwerk_status" class="two">
						<div class="container">

							<header>
								<h2>Netzwerkstatus</h2>
							</header>

						<form method="post" action="network_status.jsp?network=<% out.print(status.getNetworkID()); %>">
							<div class="row">
								<div class="2u"><input type="text" value="ID" disabled /></div>
								<div class="10u"><input type="text" name="id" value="<% out.println(status.getNetworkID()); %>" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Name" disabled /></div>
								<div class="10u"><input type="text" name="name" value="<% out.println(status.getNetworkName()); %>" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Parent" disabled /></div>
								<div class="2u"><input type="text" name="parentID" value="<% out.println(status.getNetworkParentID()); %>" /></div>
								<div class="6u"><input type="text" name="parentName" value="<% out.println(status.getNetworkParentName()); %>" /></div>
								<div class="2u"><a href="network_status.jsp?network=<% out.print(status.getNetworkParentID()); %>"><input id="inputbtn" type="text" value="View" disabled /></a></div>
							</div>
							<div class="row">
									<div class="12u">
										<input type="submit" value="Netzwerk updaten!" />
									</div>
							</div>
						</form>
						
						<br /> <br />
							<h3>Clients im Netzwerk</h3>

							<form method="post" action="#">
								<div class="row">
									<div class="8u"><input type="text" name="parentID" value="<% out.println(status.getNodeNames().get(0)); %>" /></div>
									<div class="2u"><a href="network_status.jsp?noderm=<% out.print(status.getNodeIDs().get(0)); %>&network=<% out.print(status.getNetworkID()); %>"><input id="inputbtn" type="text" value="Delete" disabled /></a></div>
									<div class="2u"><a href="node_status.jsp?node=<% out.print(status.getNodeIDs().get(0)); %>"><input id="inputbtn" type="text" value="View" disabled /></a></div>
								</div>
							</form>
							
						<br /> <br />
							<h3>Netzwerk löschen</h3>

							<form method="post" action="network_status.jsp?network=<% out.print(status.getNetworkID()); %>&delete=true">
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