<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Bevestigen" />
</head>
<body>
	<vdab:navigatie alleLinks="true" h1="Bevestigen"/>
	<p>${aantalFilms} film(s) voor ${klant.naam}</p>
	<c:url value="/klanten/${klant.id}/rapport" var="url"/>
	<form:form action="${url}" method="get">
		<input type="submit" value="Bevestigen">
	</form:form>
</body>
</html>