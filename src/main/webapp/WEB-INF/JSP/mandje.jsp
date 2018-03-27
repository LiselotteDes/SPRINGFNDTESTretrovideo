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

	${mandje.films}
</body>
</html>