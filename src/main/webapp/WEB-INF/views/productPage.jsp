<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	<div class="row">	
		<h1>Zarządzanie produktami</h1>
		<hr />
		<br />
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Zdjęcie</th>
			        <th>Nazwa</th>
			        <th>Kategoria</th>
			        <th>Cena</th>
			        <th>Aktywność</th>
			        <th></th>
			   	</tr>
			</thead>
			<tbody>
			<c:forEach items="${product}" var="product" >
				<tr>
			    	<td><img src="${pageContext.request.contextPath}/product/productImage?productID=${product.productID}" width="100"/></td>
			        <td>${product.productName}</td>
			        <td>${product.productCategory.productCategoryName}</td>
			        <td>${product.productPrice} zł</td>
			        <td>
			        	<c:if test="${product.productStatus == false}">Nie aktywny</c:if>
			        	<c:if test="${product.productStatus == true}">Aktywny</c:if>
			        </td>			       			        
			        <td>
						<a href="<spring:url value="/admin/editProduct/${product.productID}"/>" class="btn btn-default pull-right">Edytuj</a>
						<a href="<spring:url value="/admin/deleteProduct/${product.productID}"/>" class="btn btn-default pull-right">Usuń</a>
					</td>
			  	</tr>
			</c:forEach>
			</tbody>
		</table>
		<a href="<spring:url value="/admin/addProduct" />" class="btn btn-default">Dodaj produkt</a>
		<a href="<spring:url value="/admin" />" class="btn btn-default">Wróć</a>
	</div>
</div>