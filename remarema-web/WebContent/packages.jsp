<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="netzwerk_status" class="two">
	<div class="container">
		<header>
			<h2>Softwarepackages</h2>
		</header>
		<p><font color="#770000">${message}</font></p>


		<form method="post" action="/remarema/packages">
			<div class="row">
				<div class="9u">
					<input type="text" name="name" placeholder="Geben Sie den Namen für ein neues Package ein" />
				</div>
				<div class="3u">
					<input type="submit" style="padding: 0.15em 1.25em 0.15em 1.25em;" value="Package anlegen!" /> <input
						type="hidden" name="action" value="insert" />
				</div>
			</div>
		</form>

		<br />


	<h3>Bereits existierende Packages</h3>
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