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
			<div class="2u">
					<input type="text" value="Name" disabled />
				</div>
				<div class="10u">
					<input type="text" name="name" value="${softwareName}" />
				</div>
				<div class="12u">
					<input type="file" name="newSoftware" value="Durchsuchen" />
				</div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" value="Neue Software hinzufügen!" />
				</div>
			</div>
		</form>

		<br /> <br />
		<h3>Verfügbare Softwareversionen</h3>

		<form method="post" action="/remarema/distribute">
			<div class="row">
				<div class="10u">
					<input type="text" name="softwareID" value="${softwareNames}" />
				</div>
				<div class="2u">
					<input type="submit" value="Wählen" />
				</div>
			</div>
		</form>



	</div>
</section>


</body>

</html>