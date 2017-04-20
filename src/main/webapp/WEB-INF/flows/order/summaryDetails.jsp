<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	
	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="99" aria-valuemin="0" aria-valuemax="100" style="width: 99%;">
    		99%
  		</div>
	</div>
	
	<div class="panel panel-primary">
    	<div class="panel-heading">Forma płatności</div>
      	<div class="panel-body">
      		${order.payment}:
      		${order.cart.amountTotal} zł
      	</div>
    </div>	
	<div class="panel panel-primary">
      	<div class="panel-heading">Dowód zakupu</div>
      	<div class="panel-body">
			<c:if test="${order.business == null}">Paragon</c:if> 
			<c:if test="${order.business != null}">Faktura <br /><br />
				<table class="table table-bordered">
					<tr>
						<th>Nazwa firmy</th>
						<th>${order.business.businessName}</th>
					</tr>
					<tr>
						<th>Adres</th>
						<th>${order.business.businessStreetName}</th>
					</tr>
					<tr>
						<th>Kod pocztowy</th>
						<th>${order.business.businessZipCode}</th>
					</tr>
					<tr>
						<th>Miejscowość</th>
						<th>${order.business.businessCity}</th>
					</tr>
					<tr>
						<th>Kraj</th>
						<th>${order.business.businessCountry}</th>
					</tr>
					<tr>
						<th>NIP</th>
						<th>${order.business.businessNIP}</th>
					</tr>		
				</table>
			</c:if>
		</div>
    </div>
	<div class="panel panel-primary">
    	<div class="panel-heading">Dane do wysyłki</div>
      	<div class="panel-body">
      		<table class="table table-bordered">			
				<tr>
					<th>Imię i nazwisko</th>
					<th>${order.shippingAddress.addressName}</th>
				</tr>
				<tr>
					<th>Adres</th>
					<th>${order.shippingAddress.addressStreetName}</th>
				</tr>
				<tr>
					<th>Kod pocztowy</th>
					<th>${order.shippingAddress.addressZipCode}</th>
				</tr>
				<tr>
					<th>Miejscowość</th>
					<th>${order.shippingAddress.addressCity}</th>
				</tr>
				<tr>
					<th>Kraj</th>
					<th>${order.shippingAddress.addressCountry}</th>
				</tr>
				<tr>
					<th>Numer kontaktowy</th>
					<th>${order.shippingAddress.addressPhone}</th>
				</tr>		
		</table>
      	</div>
    </div>		
	<div class="panel panel-primary">
    	<div class="panel-heading">Zawartość koszyka</div>
      	<div class="panel-body">
	      	<table class="table table-hover">
	        	<thead>
			        <tr>
			        	<th>Produkt</th>
			            <th>Ilość</th>
			            <th>Cena</th>
			        </tr>
			  	</thead>
			    <tbody>
		        	<c:forEach var="cartItem" items="${order.cart.cartItem}" >
			        	<tr>
			            	<td><em>${cartItem.productInfo.productName}</em></td>
			                <td>${cartItem.quantity}</td>
			                <td>${cartItem.productInfo.productPrice}</td>
			            </tr>
			        </c:forEach>
			        </tbody>
	        </table>
      	</div>
    </div>	
    
	<a href="${flowExecutionUrl}&_eventId=cancel" class="btn btn-danger">Anuluj</a>	
	<a href="${flowExecutionUrl}&_eventId=acceptOrder" class="btn btn-success">Akceptuj</a>
	
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>