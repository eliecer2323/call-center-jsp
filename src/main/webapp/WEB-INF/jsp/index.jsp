<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	System.out.print(request);
	System.out.print(response);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Call Center</title>
<script>
	function getCalls(idCall) {
		if (idCall != '') {
			fetch('/getCalls?idCall=' + idCall).then(function(response) {
				return response.json();
			}).then(function(myJson) {
				var reporte = document.getElementById('reporte');
				reporte.innerHTML = myJson.mensaje;
				setTimeout(function() {
					getCalls(idCall);
				}, 1000);
			});
		}
	}
</script>
</head>
<body onload="getCalls('${idCall}')">
	<form method="post" action="dispatch">
		<input type="submit" value="Lanzar llamada">
		<c:if test="${idCall!=null}">
			<br />
			<br />
			<span id="reporte">${idCall}</span>
		</c:if>
	</form>
</body>
</html>