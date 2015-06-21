<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>


<section id="netzwerk_edit" class="two">
	<div class="container">

		<header>
			<h2>Netzwerk bearbeiten</h2>
		</header>

		<p><font color="#770000">${message}</font></p>

		<form method="post" action="/remarema/network_edit?id=${id}">
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
					<input type="text" value="Parent" disabled />
				</div>
				<div class="2u">
					<input type="text" name="parentID" value="${parentID}" disabled />
				</div>
				<div class="6u">
					<input type="text" name="parentName" value="${parentName}" />
				</div>
				<div class="2u">
					<a href="/remarema/network_edit?id=${parentID}"><input type="button" value="View" /></a>
				</div>
			</div>
			<div class="row">
				<div class="1u"></div>
				<div class="5u">
					<input type="submit" value="Netzwerk updaten!" /> <input
						type="hidden" name="action" value="update" />
		</form>
	</div>
	<form method="post" action="/remarema/network_edit?id=${id}">
		<div class="5u">
			<input type="submit" value="Netzwerk löschen!" /> <input
				type="hidden" name="action" value="delete" />
		</div>
	</form>
	<div class="1u"></div>
	</div>


	<br /> <br />
	<h3>Untergeordnetes Netzwerk hinzufügen</h3>

	<form method="post" action="/remarema/network_edit?id=${id}">
		<div class="row">
			<div class="12u">
				<input type="text" name="childName" placeholder="Netzwerkname" />
			</div>
		</div>
		<div class="row">
			<div class="12u">
				<input type="submit" value="Netzwerk anlegen!" /> <input
					type="hidden" name="action" value="insertChild" /> <input
					type="hidden" name="name" value="${name}" /> <input type="hidden"
					name="parentID" value="${parentID}" /> <input type="hidden"
					name="parentName" value="${parentName}" />
			</div>
		</div>
	</form>

	<br /> <br />
	<h3>Client hinzufügen</h3>

	<form method="post" action="/remarema/network_edit?id=${id}">
		<div class="row">
			<div class="12u">
				<input type="text" name="nodeName" placeholder="Clientname" />
			</div>
			<div class="12u">
				<input type="text" name="nodeIP" placeholder="Client IP" />
			</div>
		</div>
		<div class="row">
			<div class="12u">
				<input type="submit" value="Client anlegen!" /> <input
					type="hidden" name="action" value="insertNode" /> <input
					type="hidden" name="name" value="${name}" /> <input type="hidden"
					name="parentID" value="${parentID}" /> <input type="hidden"
					name="parentName" value="${parentName}" />
			</div>
		</div>
	</form>

	<br /> <br />
	<h3>Clients im Netzwerk</h3>

	<table class="default">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>IP</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${nodeList}" var="item">
					<tr>
						<td>${item.nodeID}</td>
						<td>${item.nodeName}</td>
						<td>${item.nodeIP}</td>
						<td><a href="/remarema/node_edit?id=${item.nodeID}">Info</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</section>


</body>

</html>