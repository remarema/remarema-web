<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="netzwerk_status" class="two">
	<div class="container">
		<header>
			<h2>Netzwerke</h2>
		</header>
		<p><font color="#770000">${message}</font></p>
		
<form method = "post">
		<div class="row">
			<div class="9u">
				<input type="text" name="s" placeholder="Suche..." />
			</div>
			<div class="3u">
				<input type="submit" value="Suche" />
				<input type="hidden" name="action" value="suche">
			</div>
			</div>
		</form>
		
		<br />


		<table class="default">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Parent ID</th>
					<th>Parent Name</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${networks}" var="item">
					<tr>
						<td>${item.networkID}</td>
						<td>${item.networkName}</td>
						<td>${item.networkParentID}</td>
						<td>${item.networkParentName}</td>
						<td><a href="/remarema/network_edit?id=${item.networkID}">Info</a></td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<p></p>
		<form method="get" action="/remarema/addnetwork">
			<div class="row">
				<div class="12u">
					${root}
				</div>
			</div>
		</form>
		
		${buttons}
	</div>
</section>


</body>

</html>