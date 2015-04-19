<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="node_status" class="two">
	<div class="container">
		<header>
			<h2>Nodes</h2>
		</header>

		<table class="default">
			<thead>
				<tr>
					<th>Name</th>
					<th>IP</th>
					<th>Netzwerk</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${nodes}" var="item">
					<tr>
						<td>${item.nodeName}</td>
						<td>${item.nodeIP}</td>
						<td>${item.nodeNetworkID}
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>


</body>

</html>