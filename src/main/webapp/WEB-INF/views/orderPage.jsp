<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	<div class="row">
		<h1>Zarządzanie zamówieniami</h1>
		<hr />
		<br />
		<table class="table table-hover">
	    	<thead>
				<tr>
			    	<th>Data zakupu</th>
			        <th>Sposób płatności</th>
			        <th>E-mail kupującego</th>
			        <th>Dowód zakupu</th>
			        <th>Status zamówienia</th>
			        <th></th>
			  	</tr>
			</thead>
			<tbody>
				<c:forEach items="${orders}" var="orders" >
			    	<tr>
			        	<td>${orders.orderDate}</td>
			        	<td>${orders.payment}</td>
			        	<td>${orders.users.userEmail}</td>
						<td>
			        		<c:if test="${orders.business == null}">Paragon</c:if>
			        		<c:if test="${orders.business != null}">Faktura</c:if>
			        	</td>
			        	<td>
			        		<c:if test="${orders.statusOrder == true}">Zrealizowane</c:if>
			        		<c:if test="${orders.statusOrder != true}">Nie zrealizowane</c:if>
			        	</td>
		        		<td>
							<a href="<spring:url value="/admin/detailOrder/${orders.orderID}"/>" class="btn btn-default pull-right">Szczegóły</a>
							<a href="<spring:url value="/admin/editOrder/${orders.orderID}"/>" class="btn btn-default pull-right">Edytuj</a>							
						</td>
		        	</tr>
		        </c:forEach>
			</tbody>
		</table>
		<a href="<spring:url value="/admin" />" class="btn btn-default">Wróć</a>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>