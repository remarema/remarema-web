<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="node_status" class="two">
	<div class="container">
		<header>
			<h2>Nodes</h2>
		</header>
		<p>${message}</p>

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
						<td><a href="/remarema/node_edit?id=${item.nodeID}">bearbeiten</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>

</body>

</html>