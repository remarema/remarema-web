<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/test.js"></script>

<!-- 
	Display networks and clients
 -->
<section id="netzwerke" class="two">
	<div class="container">

		<header>
			<h2>Software verteilen</h2>
		</header>


		<p>${message}</p>

		<form method="post">
			<div class="row">
				<div class="9u">
					<input type="text" name="s" placeholder="Netzwerk suchen..." />
				</div>
				<div class="3u">
					<input type="submit" value="Suche" /> <input type="hidden"
						name="searchNetwork" value="true">
				</div>
			</div>
		</form>

		<br />

		<form action="">

			<table class="default">
				${search}
				<tbody>
					<c:forEach items="${networks}" var="item">
						<tr>
							<td>${item.networkID}</td>
							<td>${item.networkName}</td>
							<td><a
								href="/remarema/distribute?id=${item.networkID}&action=add">Auswählen</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>

		<header>
			<h3>Derzeit hinzugef&uuml;gte Netzwerke:</h3>
		</header>

		<table class="default">
			${addedNetworksList}

			<tbody>
				<c:forEach items="${addedNetworks}" var="item">
					<tr>
						<td>${item.networkID}</td>
						<td>${item.networkName}</td>
						<td><a
							href="/remarema/distribute?id=${item.networkID}&action=delete">Entfernen</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="">

			<div class="row">
				<div class="4u">
					<input type="text" placeholder="Softwarepackage" disabled />
				</div>
				<div class="8u">
					<select id="softwareVersionList" name="package" onchange="updateSoftwareVersionList()">
						<option value="">Bitte auswählen!</option> 
						${options}
					</select>
				</div>


			</div>
			<div class="row">
				<div class="4u">
					<input type="text" placeholder="Softwareversion" disabled />
				</div>
				<div class="6u">
					<input type="text" name="version" placeholder="Softwareversion" />
				</div>
				<div class="1u">
					<input type="button" name="softwareversion" value="auswählen!"
						onClick="myFunction()" />
				</div>
			</div>
			<div class="row">
				<div class="8u">
					<input type="text" placeholder="Zeitpunkt der Verteilung" disabled />
				</div>
				<div class="4u">
					<input type="text" name="distribution" value="${time}"
						id="datetimepicker" />
				</div>
			</div>
			<div class="row">
				<div class="8u">
					<input type="text" placeholder="Zeitpunkt der Installation"
						disabled />
				</div>
				<div class="4u">
					<input type="text" name="installation" value="${time}"
						id="datetimepicker02" />
				</div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" name="Software" value="Software verteilen!" />
				</div>
			</div>

		</form>
	</div>

	<p>Anstehende Softwareverteilungen:</p>
</section>


</body>

</html>