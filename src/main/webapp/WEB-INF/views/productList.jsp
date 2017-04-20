<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
	
	<c:forEach items="${products}" var="products">
		
		<div class="row row-auction">
			<div class="col-md-3">
				<img class="img-responsive" src="${pageContext.request.contextPath}/product/productImage?productID=${products.productID}"/>
			</div>
			<div class="col-md-6">
				<div class="row title-auction">
				<br />
					${products.productName}
				</div>
				<div class="row description-auction">
				<br />
					${products.productDescription1}
				</div>							
			</div>
			<div class="col-md-3">
				<div class="row">
				<br /><br />
					<h2 class="price">Cena: ${products.productPrice} zł</h2>
				</div>
				<div class="row">
				<br />
					<a class="btn btn-success" href="${pageContext.request.contextPath}/product/buyProduct?productID=${products.productID}">Dodaj do koszyka</a>
				</div>
			</div>		
		</div>
		
		<hr />
	</c:forEach>
	
</div>

<%@include file="/WEB-INF/views/footer.jsp"%>