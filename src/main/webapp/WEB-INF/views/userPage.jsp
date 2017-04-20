<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	<div class="row">	
		<h1>Zarządzanie użytkownikami</h1>
		<hr />
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Imię</th>
			        <th>Nazwisko</th>
			        <th>E-mail</th>
			        <th>Numer telefonu</th>
			        <th>Aktywność</th>
			        <th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${userList}" var="userList" >
				<tr>
			    	<td>${userList.userName}</td>
			        <td>${userList.userSurname}</td>
			        <td>${userList.userEmail}</td>
			        <td>${userList.userPhone}</td>
			        <td>
			        	<c:if test="${userList.enabled == false}">Nie aktywny</c:if>
			        	<c:if test="${userList.enabled == true}">Aktywny</c:if>
			        </td>
			        <td>
						<a href="<spring:url value="/admin/editUser/${userList.userID}"/>" class="btn btn-default pull-right">Edytuj</a>
						<a href="<spring:url value="/admin/deleteUser/${userList.userID}"/>" class="btn btn-default pull-right">Usuń</a>
					</td>
			  	</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="<spring:url value="/admin/addUser" />" class="btn btn-default">Dodaj użytkownika</a>
		<a href="<spring:url value="/admin" />" class="btn btn-default">Wróć</a>
	</div>	
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>