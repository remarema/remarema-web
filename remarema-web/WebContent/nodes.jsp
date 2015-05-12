<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="node_status" class="two">
	<div class="container">
		<header>
			<h2>Clients</h2>
		</header>
		<p>${message}</p>

		<form method= "post">
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
					<th>Name</th>
					<th>IP</th>
					<th>Netzwerk-Name</th>
					<th>Softwareversion</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${nodes}" var="item">
					<tr>
						<td>${item.nodeName}</td>
						<td>${item.nodeIP}</td>
						<td>${item.nodeNetworkName}</td>
						<td>${item.softwareversion}</td>
						<td><a href="/remarema/node_edit?id=${item.nodeID}">Info</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		${buttons}
	</div>
</section>

</body>

</html>