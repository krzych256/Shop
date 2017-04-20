<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">

<c:if test="${empty cartInfo or empty cartInfo.cartItem}">
   <h2>Koszyk jest pusty.</h2>
   <a href="${pageContext.request.contextPath}/product/productList">Pokaż dostępne produkty.</a>
</c:if>

<c:if test="${not empty cartInfo and not empty cartInfo.cartItem}">
<div class="row">
	<h1>Koszyk</h1>
	<hr />
	<br />
	<form:form method="POST" modelAttribute="cartInfo" action="${pageContext.request.contextPath}/product/shoppingCart">
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Zdjęcie</th>
					<th>Nazwa produktu</th>
					<th>Usuń</th>
					<th>Cena</th>
					<th>Ilość</th>
					<th>Wartość</th>
				</tr>
			</thead>
			<c:forEach items="${cartInfo.cartItem}" var="cartItem" varStatus="varStatus">				
				<tr>
					<td>
						<img class="img-responsive" src="${pageContext.request.contextPath}/product/productImage?productID=${cartItem.productInfo.productID}" width="100"/>
					</td>
					<td>
						${cartItem.productInfo.productName}
						
						<!--<form:hidden path="cartItem[${varStatus.index}].productInfo.productID" value="${cartItem.productInfo.productID}"/>-->
						<form:hidden path="cartItem[${varStatus.index}].productInfo.productID" />
						<form:hidden path="cartItem[${varStatus.index}].productInfo" value="${cartItem.productInfo}"/>
                    </td>
                    <td>
                    	<a href="${pageContext.request.contextPath}/product/removeProduct?productID=${cartItem.productInfo.productID}"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a>
					</td>
					<td>
						${cartItem.productInfo.productPrice} zł						
					</td>
					<td>
						<form:input path="cartItem[${varStatus.index}].quantity" />
					</td>
					<td>
						${cartItem.amount} zł
					</td>
				</tr>
			</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>Wartość całkowita:</td>
					<td>${cartInfo.amountTotal} zł</td>
					
		</table>
		<!-- <input class="btn btn-default btn-lg" type="submit" value="Przelicz koszyk" /> -->
		<a class="btn btn-success btn-lg" href="${pageContext.request.contextPath}/reservation">Do kasy</a>
		<a class="btn btn-default btn-lg" href="${pageContext.request.contextPath}/product/productList">Kontynuuj zakupy</a>
		 		
	</form:form>
	</div>
</c:if>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>