<%@include file='template/menu.jsp'%>

<section id="node_edit" class="two">
	<div class="container">

		<header>
			<h2>Client bearbeiten</h2>
		</header>

		<p><font color="#770000">${message}</font></p>

		<form method="post" action="/remarema/node_edit?id=${id}">
			<div class="row">
				<div class="2u">
					<input type="text" value="Name" disabled />
				</div>
				<div class="2u">
					<input type="text" name="id" value="${id}" disabled />
				</div>
				<div class="8u">
					<input type="text" name="name" value="${name}" />
				</div>
			</div>
			<div class="row">
				<div class="2u">
					<input type="text" value="IP" disabled />
				</div>
				<div class="10u">
					<input type="text" name="ip" value="${ip}" />
				</div>
			</div>
			<div class="row">
				<div class="2u">
					<input type="text" value="Network" disabled />
				</div>
				<div class="2u">
					<input type="text" name="networkID" value="${networkID}" disabled />
				</div>
				<div class="6u">
					<input type="text" name="networkName" value="${networkName}" />
				</div>
				<div class="2u">
					<a href="/remarema/network_edit?id=${networkID}"><input type="button" value="View" /></a>
				</div>
			</div>
			<div class="row">
				<div class="1u"></div>
				<div class="5u">
					<input type="submit" value="Client updaten!" /> <input
						type="hidden" name="action" value="update" />
		</form>
	</div>
	<form method="post" action="/remarema/node_edit?id=${id}">
		<div class="1u">
			<input type="submit" value="Client löschen!" /> <input type="hidden"
				name="action" value="delete" />
		</div>
	</form>
	<div class="5u"></div>
	</div>

</section>


</body>

</html>