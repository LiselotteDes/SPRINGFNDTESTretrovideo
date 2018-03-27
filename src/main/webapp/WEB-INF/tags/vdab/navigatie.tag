<%@ tag description="navigatie-menu" pageEncoding="UTF-8"%>
<%@attribute name="alleLinks" required="true" type="Boolean"%>
<%@attribute name="h1" required="true" type="java.lang.String"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<header>
	<nav>
		<ul>
			<li><a href="<c:url value='/'/>">Reserveren</a></li>
			<c:if test="${alleLinks}">
				<li><a href="<c:url value='/mandje'/>">Mandje</a></li>
				<li><a href="<c:url value='/klanten'/>">Klant</a></li>
			</c:if>
		</ul>
	</nav>
	<h1>${h1}</h1>
	<c:if test="${not empty genres}">
		<nav>
			<ul>
				<c:forEach items="${genres}" var="item">
					<li><c:choose>
							<c:when test="${genre.id ne item.id}">
								<spring:url value="/genres/{id}" var="url">
									<spring:param name="id" value="${item.id}" />
								</spring:url>
								<a href="${url}">${item.naam}</a>
							</c:when>
							<c:otherwise>
						${item.naam}
					</c:otherwise>
						</c:choose></li>
				</c:forEach>
			</ul>
		</nav>
	</c:if>
</header>