<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="netzwerk_status" class="two">
	<div class="container">
		<header>
			<h2>Netzwerke</h2>
		</header>

		<table class="default">
			<thead>
				<tr>
					<th>Name</th>
					<th>Parent</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${networks}" var="item">
					<tr>
						<td>${item.networkName}</td>
						<td>${item.networkParentID}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>


</body>

</html>