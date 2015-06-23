<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<section id="software_edit" class="two">
	<div class="container">

		<header>
			<h2>Softwareversion bearbeiten</h2>
		</header>

		<p><font color="#770000">${message}</font></p>

		<form method="post" action="/remarema/software_edit?id=${id}">
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
				<div class="4u">
					<input type="text" value="Pfad" disabled />
				</div>
				<div class="8u">
					<input type="text" name="path" value="${path}" />
				</div>
			</div>
			<div class="row">
				<div class="4u">
					<input type="text" value="Package" disabled />
				</div>
				<div class="8u">
					<input type="text" name="packageName" value="${packageName}" />
				</div>
			</div>
			<div class="row">
				<div class="1u"></div>
				<div class="5u">
					<input type="submit" value="Software updaten!" /> <input
						type="hidden" name="action" value="update" />
						</form>
				</div>		
		
			<div class="1u">
				<form method="post" action="/remarema/software_edit?id=${id}">
				<input type="submit" value="Software löschen!" /> <input type="hidden"
					name="action" value="delete" />
					</form>
			</div>
			<div class="5u"></div>
	</div>
</section>


</body>

</html>