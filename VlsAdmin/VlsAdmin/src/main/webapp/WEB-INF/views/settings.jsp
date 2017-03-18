<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<%@ include file="header.jsp"%>
<%@ include file="menu.jsp"%>

<h2>Настройка базовой ставки</h2>
<form action="settings/savebaserate" method="POST">
	<table>
		<tr>
			<th>Валюта</th>
			<td>Ставка</td>
		</tr>
		<c:forEach var="baseRate" items="${baseRateList}">
			<tr>
				<th>${baseRate.currency}</th>
				<td><input type="text" name="${baseRate.currency}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${baseRate.rate}" size="6" /></td>
			</tr>
		</c:forEach>
		<tr>
			<th><input type="submit" value="Сохранить" /></th>
		</tr>
	</table>
</form>

<h2>Настройка маржи по типам предметов лизинга</h2>
<form action="settings/saveobjtypemargin" method="POST">
	<table>
		<tr>
			<th>Тип предмета</th>
			<td>Маржа</td>
		</tr>
		<c:forEach var="objTypeMargin" items="${objTypeMarginList}">
			<tr>
				<th>${objTypeMargin.objType}</th>
				<td><input type="text" name="${objTypeMargin.objType}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${objTypeMargin.objTypeMargin}" size="6" /></td>
			</tr>
		</c:forEach>
		<tr>
			<th><input type="submit" value="Сохранить" /></th>
		</tr>
	</table>
</form>
<h2>Настройка маржи по возрасту предметов</h2>
<form action="settings/agemargin" method="POST">
	<table>
		<tr>
			<th>Тип\Возраст</th>
			<c:forEach var="ageMarginTruck" items="${ageMarginTruckList}">
				<th>${ageMarginTruck.age}</th>
			</c:forEach>
		</tr>

		<tr>
			<th>Car</th>
			<c:forEach var="ageMarginCar" items="${ageMarginCarList}">
				<td><input type="text" name="carage_${ageMarginCar.age}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${ageMarginCar.marginCar}" size="5" /></td>
			</c:forEach>
		</tr>

		<tr>
			<th>Lorry</th>
			<c:forEach var="ageMarginLorry" items="${ageMarginLorryList}">
				<td><input type="text" name="lorryage_${ageMarginLorry.age}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${ageMarginLorry.marginLorry}" size="5" /></td>
			</c:forEach>
		</tr>

		<tr>
			<th>Truck</th>
			<c:forEach var="ageMarginTruck" items="${ageMarginTruckList}">
				<td><input type="text" name="truckage_${ageMarginTruck.age}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${ageMarginTruck.marginTruck}" size="5" /></td>
			</c:forEach>
		</tr>




		<tr>
			<th>Building machines</th>
			<c:forEach var="ageMarginBuildmach" items="${ageMarginBuildmachList}">
				<td><input type="text"
					name="buildmachage_${ageMarginBuildmach.age}" pattern="\d{1,}.\d{1,}"
					required maxlength="10"
					value="${ageMarginBuildmach.marginBuildmach}" size="5" /></td>
			</c:forEach>
		</tr>

		<tr>
			<th>Farming machineries</th>
			<c:forEach var="ageMarginFarmmach" items="${ageMarginFarmmachList}">
				<td><input type="text" name="farmmachage_${ageMarginFarmmach.age}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${ageMarginFarmmach.marginFarmmach}" size="5" /></td>
			</c:forEach>
		</tr>

		<tr>
			<th>Equipment</th>
			<c:forEach var="ageMarginEquip" items="${ageMarginEquipList}">
				<td><input type="text" name="equipage_${ageMarginEquip.age}"
					pattern="\d{1,}.\d{1,}" required maxlength="10"
					value="${ageMarginEquip.marginEquip}" size="5" /></td>
			</c:forEach>
		</tr>

		<tr>
			<th>Realestate</th>
			<c:forEach var="ageMarginRealestate" items="${ageMarginRealestateList}">
				<td><input type="text"
					name="realestateage_${ageMarginRealestate.age}" pattern="\d{1,}.\d{1,}"
					required maxlength="10"
					value="${ageMarginRealestate.marginRealest}" size="5" /></td>
			</c:forEach>
		</tr>



		<tr>
			<th><input type="submit" value="Сохранить" /></th>
		</tr>
	</table>
</form>


<%@ include file="footer.jsp"%>