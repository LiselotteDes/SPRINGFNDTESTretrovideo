<%@ tag description="navigatie-menu" pageEncoding="UTF-8"%>
<%@attribute name="aantal" required="true" type="Integer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<nav>
		<ul>
			<li><a href="<c:url value='/'/>">Reserveren</a></li>
			<li><a href="<c:url value='/mandje'/>">Mandje</a></li>
			<li><a href="<c:url value='/klanten'/>">Klant</a></li>
		</ul>
	</nav>
</header>