<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<h2>Отчёты по физическим лицам</h2>
	<table>
	<c:forEach var="person" items="${personsList}">
		<tr>
			<td>${person}</td>
		</tr>
	</c:forEach>
	</table>
<%@ include file="footer.jsp"%>