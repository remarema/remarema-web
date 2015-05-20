<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>
<script src="//code.jquery.com/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery.datetimepicker.css"/>
<script src="<%=request.getContextPath()%>/js/jquery.datetimepicker.js"></script>

<!-- Datepicker Javascript -->

		<script>
		jQuery(function () {
			jQuery('#datetimepicker').datetimepicker()
		});
		jQuery(function () {
			jQuery('#datetimepicker02').datetimepicker()
		});
		</script> 
		
<script type="text/javascript">
function updateSoftwareVersionList() {
	$.ajax({
		type: "GET",
		url: "VersionsByPackageIdServlet?PackageId=" + $("#softwarePackageList").val(),
		async: true,
		error: function(Request, Message, ThrownError)
		{
			alert("JsonRequest.Error: " + Message + ", " + ThrownError);
		},
		success: function(Data)
		{
			var Success = false;
			var JsonData = null;
			try
			{
				JsonData = $.parseJSON(Data);
				Success = true;
			}
			catch(e)
			{
				Success = false;
			}
			if (Success)
			{
				var VersionSelect = $("#softwareVersionList");
				VersionSelect.empty();
				VersionSelect.append($("<option>").attr("value", "").html("Bitte auswählen!"));
				for (var i = 0; i < JsonData.length; i++)
				{
					var a = $("<option>");
					a.attr("value", JsonData[i].Id);
					a.html(JsonData[i].Version);
					a.appendTo(VersionSelect);
				}
			}
			else
			{
				alert("JsonRequest.JsonParseError: " + Data);
			}
		}
	});
}
</script>

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
								href="/remarema/distribute_edit?networkid=${item.networkID}&id=${id}&action=add">Auswählen</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>

		<header>
			<h4>Derzeit hinzugef&uuml;gte Netzwerke:</h4>
		</header>

		<table class="default">
			${addedNetworksList}

			<tbody>
				<c:forEach items="${addedNetworks}" var="item">
					<tr>
						<td>${item.networkID}</td>
						<td>${item.networkName}</td>
						<td><a
							href="/remarema/distribute_edit?networkid=${item.networkID}&id=${id}&action=delete">Entfernen</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="/remarema/update_distribute?id=${id}" method="post">
			<c:forEach items="${addedNetworks}" var="item">
				<input type="hidden" name="addedNetworks[]" value="${item.networkID}" />
			</c:forEach>
			
			<div class="row">
				<div class="4u">
					<input type="text" placeholder="Softwarepackage" disabled />
				</div>
				<div class="8u">
					<select id="softwarePackageList" name="package"
						onchange="updateSoftwareVersionList()">
						<option value="${packageID}">${packageName}</option> 
						${options}
					</select>
					
				</div>


			</div>
			<div class="row">
				<div class="4u">
					<input type="text" placeholder="Softwareversion" disabled />
				</div>
				<div class="8u">
					<select id="softwareVersionList" name="version">
						<option value= "${softwareID}">${software}</option>

					</select>
				</div>
			</div>
			<div class="row">
				<div class="8u">
					<input type="text" placeholder="Zeitpunkt der Verteilung" disabled />
				</div>
				<div class="4u">
					<input type="text" name="distribution" value="${deploy}"
						id="datetimepicker" />
				</div>
			</div>
			<div class="row">
				<div class="8u">
					<input type="text" placeholder="Zeitpunkt der Installation"
						disabled />
				</div>
				<div class="4u">
					<input type="text" name="installation" value="${installation}"
						id="datetimepicker02" />
				</div>
			</div>
			<div class="row">
				<div class="12u">
					<input type="submit" name="Software" value="Update!" />
				</div>
			</div>
		</form>
		
		<br />
		
		<form action="/remarema/distribute_edit?id=${id}" method="post">
			<div class="row">
				<div class="12u">
					<input type="submit" name="L&ouml;schen" value="L&ouml;schen" />
					<input type="hidden" name="delete" value="true" />
				</div>
			</div>
		</form>
	</div>
</section>


</body>

</html>