<%@include file='template/menu.jsp'%>						  
	
					<section id="node_edit" class="two">
						<div class="container">

							<header>
								<h2>Node bearbeiten</h2>
							</header>
							
							<p>${message}</p>

						<form method="post" action="/remarema/node_edit?id=${id}">
							<div class="row">
								<div class="2u"><input type="text" value="Name" disabled /></div>
								<div class="2u"><input type="text" name="id" value="${id}" disabled /></div>
								<div class="8u"><input type="text" name="name" value="${name}" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="IP" disabled /></div>
								<div class="10u"><input type="text" name="ip" value="${ip}" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Network" disabled /></div>
								<div class="2u"><input type="text" name="networkID" value="${networkID}" disabled/></div>
								<div class="6u"><input type="text" name="networkName" value="${networkName}" /></div>
								<div class="2u"><a href="/remarema/network_edit?id=${networkID}"><input id="inputbtn" type="text" value="View" disabled /></a></div>
							</div>
							<div class="row">
									<div class="12u">
										<input type="submit" value="Node updaten!" />
									</div>
							</div>
						</form>
						
						<br /> <br />
							<h3>Node löschen</h3>
							<form method="post" action="/remarema/node_edit?id=${id}&delete=true">
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