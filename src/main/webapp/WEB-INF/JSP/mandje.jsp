<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri="http://www.springframework.org/tags"%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!DOCTYPE html>
<html lang="nl">
<head>
	<vdab:head title="Mandje" />
</head>
<body>
	<vdab:navigatie alleLinks="true" h1="Mandje"/>
<%-- 	<c:url></c:url> --%>
<%-- 	<form:form action="${url}" modelAttribute="mandjeForm" method="post"> --%>
<!-- 		<table> -->
<!-- 			<thead> -->
<!-- 				<tr> -->
<!-- 					<th>Film</th> -->
<!-- 					<th>Prijs</th> -->
<!-- 					<th><input type="submit" value="Verwijderen"></th> -->
<!-- 				</tr> -->
<!-- 			</thead> -->
<!-- 		</table> -->
<%-- 	</form:form> --%>

	<c:if test="${not empty filmsInMandje}">
		<c:url value="/mandje/verwijderen" var="url"/>
		<form:form action="${url}" method="post" modelAttribute="mandjeForm">
		<table>
			<tr>
				<th>Film</th>
				<th>Prijs</th>
				<th><input type='submit' value='Verwijderen'></th>
			</tr>
			<c:forEach items="${filmsInMandje}" var="film">
				<tr>
					<td>${film.titel}</td>
					<td>&euro; <spring:eval expression="film.prijs" /></td>
					<td><input type="checkbox" name="verwijderids" value="${film.id}"></td>
				</tr>
			</c:forEach>
			<tr>
				<td>Totaal:</td>
				<td>&euro; ${totaal}</td>
			</tr>
		</table>
		</form:form>
	</c:if>
</body>
</html>