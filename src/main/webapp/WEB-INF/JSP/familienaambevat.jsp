<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Klanten" />
</head>
<body>
	<vdab:navigatie alleLinks="true" h1="Klanten"/>
	<c:url value="/klanten" var="url"/>
	<form:form action="${url}" modelAttribute="familienaamBevatForm" method="get">
		<form:label path="naambevat">Familienaam bevat:</form:label><br>
		<form:input path="naambevat" autofocus="autofocus"/><form:errors path="naambevat"/><br>
		<input type="submit" value="Zoeken">
	</form:form>
</body>
</html>