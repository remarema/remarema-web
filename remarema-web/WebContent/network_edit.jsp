<%@include file='template/menu.jsp'%>						  
	
					<section id="netzwerk_edit" class="two">
						<div class="container">

							<header>
								<h2>Netzwerk bearbeiten</h2>
							</header>
							
							<p>${message}</p>

						<form method="post" action="/remarema/network_edit?network=${id}">
							<div class="row">
								<div class="2u"><input type="text" value="Name" disabled /></div>
								<div class="2u"><input type="text" name="id" value="${id}" disabled /></div>
								<div class="8u"><input type="text" name="name" value="${name}" /></div>
							</div>
							<div class="row">
								<div class="2u"><input type="text" value="Parent" disabled /></div>
								<div class="2u"><input type="text" name="parentID" value="${parentID}" /></div>
								<div class="6u"><input type="text" name="parentName" value="${parentName}" /></div>
								<div class="2u"><a href="/remarema/network_edit?id=${parentID}"><input id="inputbtn" type="text" value="View" disabled /></a></div>
							</div>
							<div class="row">
									<div class="12u">
										<input type="submit" value="Netzwerk updaten!" />
										<input type="hidden" name="action" value="update"/>
									</div>
							</div>
						</form>
						
						<br /> <br />
							<h3>Clients im Netzwerk</h3>

							<form method="post" action="">
								<div class="row">
									<div class="10u"><input type="text" name="parentID" value="${nodeNames}" /></div>
									<div class="2u"><a href="/remarema/node_edit?id=${nodeIDs}"><input id="inputbtn" type="text" value="View" disabled /></a></div>
								</div>
							</form>
							
						<br /> <br />
							<h3>Netzwerk löschen</h3>

							<form method="post" action="/remarema/network_edit.jsp?network=${id}">
								<div class="row">
									<div class="12u">
										<input type="submit" value="Löschen!" />
										<input type="hidden" name="action" value="delete"/>
									</div>
								</div>
							</form>

						</div>
					</section>


	</body>
 	
</html>