<%@tag description="navigatiemenu met filmgenres" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- test of ${item.naam} gelijk is aan ${geselecteerd} om als platte tekst voor te stellen (of juist niet) -->
<header>
	<nav>
		<ul>
			<c:forEach items="${genres}" var="genre">
			<li>
				<c:choose>
					<c:when test="${genre.id ne param.id}">
						<spring:url value="/genres/{id}" var="url"><spring:param name="id" value="${genre.id}"/></spring:url>
						<a href="${url}">${genre.naam}</a>
					</c:when>
					<c:otherwise>
						${genre.naam}
					</c:otherwise>
				</c:choose>
			</li>
			</c:forEach>
		</ul>
	</nav>
</header>
