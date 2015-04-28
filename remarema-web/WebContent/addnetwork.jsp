<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<!-- 
	Add networks and clients
 -->
<section id="hinzufuegen" class="two">
	<div class="container">

		<header>
			<h2>Netzwerk hinzufügen</h2>
		</header>

		<c:if test="${not form.valid}">
			<c:forEach items="${form.messages}" var="msg">
				<label for="${msg.id}" class="error">${msg.message}</label>
			</c:forEach>
		</c:if>

		<p>Short description/guide</p>
		<p>${message}</p>

		<form method="post" action="/remarema/addnetwork">
			<div class="row">
				<div class="12u">
					<input id="name" type="text" name="name" value="Root" />
				</div>
			</div>

			<div class="row">
				<div class="12u">
					<input type="submit" value="Root-Netzwerk erstellen!" />
				</div>
			</div>
		</form>


	</div>
</section>

</body>

</html>