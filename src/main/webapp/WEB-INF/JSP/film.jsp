<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="${film.titel}" />
</head>
<body>
	<vdab:navigatie alleLinks="false" h1="${film.titel}"/>
	<img src="/images/${film.id}.jpg" alt="${film.titel}">
	<dl>
		<dt>Prijs</dt>
		<dd>
			&euro; <spring:eval expression="film.prijs" />
		</dd>
		<dt>Voorraad</dt>
		<dd>${film.voorraad}</dd>
		<dt>Gereserveerd</dt>
		<dd>${film.gereserveerd}</dd>
		<dt>Beschikbaar</dt>
		<dd>${film.beschikbaar}</dd>
	</dl>
	<c:if test="${film.beschikbaar gt 0}">
		<c:url value="/mandje" var="url"/>
		<form:form method='post' modelAttribute="mandjeForm" action='${url}' id="inmandjeForm">
			<form:hidden path="filmid" />
			<input type='submit' value='In mandje' id="inmandjeKnop">
		</form:form>
	</c:if>
	<script>
		document.getElementById("inmandjeForm").onsubmit = function() {
			document.getElementById("inmandjeKnop").disabled = true;
		}
	</script>
</body>
</html>