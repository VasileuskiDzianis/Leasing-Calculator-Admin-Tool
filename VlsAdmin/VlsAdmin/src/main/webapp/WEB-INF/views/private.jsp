<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<h2>Отчёты по физическим лицам</h2>
	
	<form action="private" method="POST">
	<table>
		<tr>
			<th>Отобразить клиентов с доходом не менее</th>
			<td><input type="text" name="income"
					pattern="^[ 0-9]+$" required maxlength="10" size="6" /> BYN</td>
		</tr>
		<tr>
			<th><input type="submit" value="Показать" /></th>
		</tr>
	</table>
</form>
	
	<table>
	<tr>
	<td>Фамилия</td>
	<td>Имя</td>
	<td>Отчество</td>
	<td>Пол</td>
	<td>Дата рождения</td>
	<td>Контактный номер</td>
	<td>Адрес</td>
	<td>Работодатель</td>
	<td>Должность</td>
	<td>Доход</td>
	
	</tr>
	<c:forEach var="person" items="${personsList}">
		<tr>
			<td>${person.lastName}</td>
			<td>${person.firstName}</td>
			<td>${person.patronymicName}</td>
			<td>${person.gender}</td>
			<td>${person.birthDate}</td>
			<td>${person.phoneNumber}</td>
			<td>${person.address}</td>
			<td>${person.employer}</td>
			<td>${person.position}</td>
			<td>${person.monthlyIncome}</td>
		</tr>
	</c:forEach>
	
	</table>
<%@ include file="footer.jsp"%>