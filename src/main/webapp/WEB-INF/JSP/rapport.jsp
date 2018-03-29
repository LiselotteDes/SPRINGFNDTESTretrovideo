<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Rapport" />
</head>
<body>
	<vdab:navigatie alleLinks="false" h1="Rapport"/>
	<c:choose>
		<c:when test="${empty mislukteReservaties}">
			<p>De reservatie is OK.</p>
		</c:when>
		<c:otherwise>
			<p>Volgende reservaties zijn niet gelukt:</p>
			<ul>
			<c:forEach items="${mislukteReservaties}" var="reservatie">
				<li>${reservatie.titel }</li>
			</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>
	
</body>
</html>