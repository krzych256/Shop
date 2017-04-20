<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container"> 
	<div class="row">
		<div class="panel panel-primary">
	    	<div class="panel-heading">Podsumowanie</div>
	      	<div class="panel-body">
	      		<table class="table table-bordered">					
					<tr>
						<th>Wartość zamówienia:</th>
						<th>${orders.amount} zł</th>
					</tr>
				</table>	      		
	      	</div>
	    </div>	
	</div>
	
	<div class="row">
		<div class="panel panel-primary">
	    	<div class="panel-heading">Szczegóły</div>
	      	<div class="panel-body">
	      		<table class="table table-bordered">
					<tr>
						<th>Data zamówienia:</th>	
						<th>${orders.orderDate}</th>
					</tr>
					<tr>
						<th>Sposób płatności:</th>
						<th>${orders.payment}</th>
					</tr>	
					<tr>
						<th>Dowód zakupu</th>
						<th>
							<c:if test="${orders.business == null}">Paragon</c:if>
					    	<c:if test="${orders.business != null}">Faktura</c:if>
					    </th>
					</tr>
					<tr>
						<th>Klient:</th>
						<th>${orders.users.userName} ${orders.users.userSurname}</th>
					</tr>
					<tr>
						<th>Adres e-mail:</th>
						<th>${orders.users.userEmail}</th>
					</tr>
					<tr>
						<th>Telefon</th>
						<th>${orders.users.userPhone}</th>
					</tr>	
				</table>	
	      	</div>
	    </div>
	</div>
	<c:if test="${not empty orders.business }">
		<div class="row col-md-6">
	</c:if>
	<c:if test="${empty orders.business }">
		<div class="row">
	</c:if>
		<div class="panel panel-primary">
	    	<div class="panel-heading">Dane do wysyłki</div>
	      	<div class="panel-body">
	      		<table class="table table-bordered">					
					<tr>
						<th>Imię i nazwisko</th>
						<th>${orders.shippingAddress.addressName}</th>
					</tr>
					<tr>
						<th>Adres</th>
						<th>${orders.shippingAddress.addressStreetName}</th>
					</tr>
					<tr>
						<th>Kod pocztowy</th>
						<th>${orders.shippingAddress.addressZipCode}</th>
					</tr>
					<tr>
						<th>Miejscowość</th>
						<th>${orders.shippingAddress.addressCity}</th>
					</tr>
					<tr>
						<th>Kraj</th>
						<th>${orders.shippingAddress.addressCountry}</th>
					</tr>
					<tr>
						<th>Numer kontaktowy</th>
						<th>${orders.shippingAddress.addressPhone}</th>
					</tr>		
				</table>	
	      	</div>
	    </div>
	</div>
	<c:if test="${not empty orders.business }">
		<div class="row col-md-6">
			<div class="panel panel-primary">
		    	<div class="panel-heading">Dane do faktury</div>
		      	<div class="panel-body">
		      		<table class="table table-bordered">					
						<tr>
							<th>Nazwa firmy</th>
							<th>${orders.business.businessName}</th>
						</tr>
						<tr>
							<th>Adres</th>
							<th>${orders.business.businessStreetName}</th>
						</tr>
						<tr>
							<th>Kod pocztowy</th>
							<th>${orders.business.businessZipCode}</th>
						</tr>
						<tr>
							<th>Miejscowość</th>
							<th>${orders.business.businessCity}</th>
						</tr>
						<tr>
							<th>Kraj</th>
							<th>${orders.business.businessCountry}</th>
						</tr>
						<tr>
							<th>NIP</th>
							<th>${orders.business.businessNIP}</th>
						</tr>		
					</table>	
		      	</div>
		    </div>
		</div>	
	</c:if>
	
	<div class="row">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Zdjęcie</th>
			        <th>Nazwa</th>
			        <th>Ilość</th>
			        <th>Cena</th>
			        <th>Suma</th>
			   	</tr>
			</thead>
			<tbody>
			<c:forEach items="${orderDetail}" var="orderDetail" >
				<tr>
			    	<td><img src="${pageContext.request.contextPath}/product/productImage?productID=${orderDetail.product.productID}" width="100"/></td>
			        <td>${orderDetail.product.productName}</td>
			        <td>${orderDetail.quantity}</td>
			        <td>${orderDetail.price} zł</td>			        
			        <td>${orderDetail.amount} zł</td>
			  	</tr>
			</c:forEach>
				<tr>
					<th></th>
			        <th></th>
			        <th></th>
			        <th>Suma zamówienia</th>
			        <th>${orders.amount}</th>
				</tr>
			</tbody>
		</table>	
	</div>	
	<a href="<c:url value="/admin/orderPage" />" class="btn btn-default btn-lg">Wróć</a>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>