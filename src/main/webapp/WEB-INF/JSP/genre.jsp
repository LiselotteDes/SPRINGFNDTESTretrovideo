<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags" %>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form' %>
<%@taglib prefix='vdab' uri='http://vdab.be/tags' %>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="${genre.naam}"/>
</head>
<body>
	<vdab:reserverenlink/>
	<h1>Reserveren</h1>
	<vdab:genres/>
	<c:if test="${not empty films}">
		<c:forEach var="film" items="${films}">
			<img src="/images/${film.id}.jpg" alt="${film.titel}" 
			title="${film.titel}: reservatie ${film.gereserveerd lt film.voorraad ? 'mogelijk' : 'niet mogelijk'} ">
		</c:forEach>
	</c:if>
</body>
</html>