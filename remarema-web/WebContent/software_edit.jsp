<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="software_edit" class="two">
	<div class="container">

		<header>
			<h2>Softwareversion bearbeiten</h2>
		</header>

		<p>${message}</p>

		<form method="post" action="/remarema/software_edit?id=${id}">
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
					<input type="text" value="Pfad" disabled />
				</div>
				<div class="10u">
					<input type="text" name="path" value="${path}" />
				</div>
			</div>
			<div class="row">
				<div class="2u">
					<input type="text" value="Package" disabled />
				</div>
				<div class="2u">
					<input type="text" name="packageID" value="${packageID}" disabled />
				</div>
				<div class="6u">
					<input type="text" name="packageName" value="${packageName}" />
				</div>
				<div class="2u"><a href="/remarema/package_edit?id=${packageID}"><input id="inputbtn" type="text" value="View" disabled /></a></div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" value="Softwareversion updaten!" /> <input
						type="hidden" name="action" value="update" />
				</div>
			</div>
		</form>
		<br />
		
		<form method="post" action="/remarema/software_edit?id=${id}">
			<div class="row">
				<div class="12u">
					<input type="submit" value="Löschen!" /> <input type="hidden"
						name="action" value="delete" />
				</div>
			</div>
		</form>
	</div>
</section>


</body>

</html>