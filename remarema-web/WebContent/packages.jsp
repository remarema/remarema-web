<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="netzwerk_status" class="two">
	<div class="container">
		<header>
			<h2>Softwarepackages</h2>
		</header>
		<p>${message}</p>

		<h3>Package hinzufügen</h3>

		<form method="post" action="/remarema/packages">
			<div class="row">
				<div class="12u">
					<input type="text" name="name" placeholder="Package Name" />
				</div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" value="Package anlegen!" /> <input
						type="hidden" name="action" value="insert" />
				</div>
			</div>
		</form>

		<br /> <br />


		<table class="default">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${packages}" var="item">
					<tr>
						<td>${item.softwarepackageID}</td>
						<td>${item.softwarepackageName}</td>
						<td><a
							href="/remarema/package_edit?id=${item.softwarepackageID}">Info</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
</section>


</body>

</html>