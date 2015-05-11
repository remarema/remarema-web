<%@include file='template/menu.jsp'%>

<section id="package_edit" class="two">
	<div class="container">

		<header>
			<h2>Package bearbeiten</h2>
		</header>

		<p>${message}</p>

		<form method="post" action="/remarema/package_edit?id=${id}">
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
				<div class="12u">
					<input type="submit" value="Package updaten!" /> <input
						type="hidden" name="action" value="update" />
				</div>
			</div>
		</form>
		<br />
		<form method="post" action="/remarema/package_edit?id=${id}">
			<div class="row">
				<div class="12u">
					<input type="submit" value="Löschen!" /> <input type="hidden"
						name="action" value="delete" />
				</div>
			</div>
		</form>

		<br /> <br />
		<h3>Software hinzufügen</h3>

		<form method="post" action="/remarema/package_edit?id=${id}">
			<div class="row">
				<div class="12u">
					<input type="text" name="softwareName" placeholder="Softwarename"
						value="${softwareName}" />
				</div>
				<div class="12u">
					<input type="text" name="softwarePath" placeholder="Software Pfad"
						value="${softwarePath}" />
				</div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" value="Neue Software hinzufügen!" /> <input
						type="hidden" name="action" value="addSoftware" /> <input
						type="hidden" name="name" value="${name}" />
				</div>
			</div>
		</form>


		<br /> <br />
		<h3>Verfügbare Softwareversionen</h3>

		<table class="default">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${version}" var="item">
					<tr>
						<td>${item.softwareID}</td>
						<td>${item.softwarePath}</td>
						<td><a
							href="/remarema/package_edit?id=${item.softwareID}">Info</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>




	</div>
</section>


</body>

</html>