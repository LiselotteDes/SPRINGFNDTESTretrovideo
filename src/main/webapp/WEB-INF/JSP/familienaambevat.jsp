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
		<form:input path="naambevat" required="required" autofocus="autofocus"/><form:errors path="naambevat" cssClass="fout"/><br>
		<input type="submit" value="Zoeken"><br>
		<form:errors cssClass="fout"/>
	</form:form>
	<c:if test="${not empty klanten}">
		<table>
			<tr>
				<th>Naam</th>
				<th>Straat - Huisnummer</th>
				<th>Postcode</th>
				<th>Gemeente</th>
			</tr>
			<c:forEach items="${klanten }" var="klant">
				<spring:url var="url" value="/klanten/{id}"><spring:param name="id" value="${klant.id}"/></spring:url>
				<tr>
					<td>
						<a href="${url}"><c:out value="${klant.naam}"/></a>
					</td>
					<td>${klant.straatNummer}</td>
					<td>${klant.postcode}</td>
					<td>${klant.gemeente}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>