<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='template/menu.jsp'%>

<!-- 
	Introduction
 -->
<section id="top" class="two">
	<div class="container">

		<header>
			<img src="<%=request.getContextPath()%>/images/dipl_logo_big.png"
				alt="" width="80%" /> <br /> <br />
		</header>
		
		<table class="default">
			<thead>
				<tr>
					<th>Rechte</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${rights}" var="item">
					<tr>
						<td>${item}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<table class="default">
			<thead>
				<tr>
					<th>Statistiken</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stats}" var="item">
					<tr>
						<td>${item}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<footer>
			<i>&copy; Rebecca van Langelaan, Maik Riedlsperger, Regina
				Werlberger, Mario Rodler</i>
		</footer>

	</div>
</section>


</body>

</html>