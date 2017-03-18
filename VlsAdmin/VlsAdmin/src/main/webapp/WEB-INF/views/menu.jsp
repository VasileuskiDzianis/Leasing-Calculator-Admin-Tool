<%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false" import="java.util.List,by.vls.admin.view.ToolBox"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="menu">

	<c:forEach var="toolBox" items="${menu}">
	<a class="menu" href="${toolBox.link}">${toolBox.label}</a>
	</c:forEach>

	
</p>
