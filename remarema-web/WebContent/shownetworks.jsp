<%@include file='template/menu.jsp'%>								  


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
									<div style=""><span style="font-size:x-large"><b><u>Network</u></b></span></div>
									<div style="margin-left:5%;"><span style="font-size:large"><b>Parent</b></span></div>
									<div style="margin-left:5%;"><span style="font-size:medium">Edit Network</span></div>
								</div>
							</div>
							
							${networkList}
							
							<div class ="row">
								<div class="1u">
									<form method="get" action="/remarema/shownetworks">
										<input type="hidden" name="page" value="1">
										<input type="submit" value="<<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="/remarema/shownetworks">
										<input type="hidden" name="page" value="${pageDecrement}">
										<input type="submit" value="<">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="4u">
									<form method="get" action="/remarema/shownetworks">
										<input type="hidden" name="page" value="0">
										<input type="submit" value="Aktuellste">
									</form>
								</div>
																
								<div class="1u">
									<form method="get" action="/remarema/shownetworks">
										<input type="hidden" name="page" value="${pageIncrement}">
										<input type="submit" value=">">
									</form>
								</div>
								
								<div class="1u"></div>
								
								<div class="1u">
									<form method="get" action="/remarema/shownetworks">
										<input type="hidden" name="page" value="${lastPage}">
										<input type="submit" value=">>">
									</form>
								</div>
							</div>
								
						</div>
					</section>
					

	</body>
 	
</html>