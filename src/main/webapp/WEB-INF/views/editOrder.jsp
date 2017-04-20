<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">

	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br />		
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/editOrder" modelAttribute="order"  method="POST">
			<form:hidden path="orderID" value="${order.orderID}" />			
			<form:hidden path="amount" value="${order.amount}" />
			<form:hidden path="users.userID" value="${order.users.userID}" />
			<fieldset>
				<legend class="">Edytuj zamówienie</legend>
				<div class="form-group">
		            <label for="payment">Sposób płatności</label>
		            <label class="checkbox-inline ">
		            	<form:radiobutton path="payment" id="payment" value="Przedpłata" checked="checked"/>Przedpłata
		            </label>
					<label class="checkbox-inline">
		            	<form:radiobutton path="payment" id="payment" value="Pobranie" />Pobranie
		            </label>
		            <label class="checkbox-inline">
		            	<form:radiobutton path="payment" id="payment" value="Odroczony termin płatności" />Odroczony termin płatności
		            </label>
		        </div>
		       	<div class="form-group">
                	<label for="enabled">Status zamówienia</label>
                    <form:select class="form-control" path="statusOrder" >
                    	<option value="false">Nie zrealizowane</option>
  						<option value="true">Zrealizowane</option>    					    
  					</form:select>
              	</div>	
		        <div class="form-group">
		    		<label for="orderDate">Data zamówienia</label>
		    		<form:input path="orderDate" type="date" class="form-control" id="orderDate" />
		  			<form:errors path="orderDate" cssStyle="color:#ff0000" />
		  		</div>	        
		    </fieldset>
		    <br />			
			<input type="submit" value="Zapisz zmiany" class="btn btn-default btn-lg">
            <a href="<c:url value="/admin/orderPage" />" class="btn btn-default btn-lg">Anuluj</a>						
		</form:form>
		<hr />
		<a href="<c:url value="/admin/editOrderAddress/${order.shippingAddress.addressID}" />" class="btn btn-default btn-lg">Edytuj adres dostawy</a>
		<c:if test="${not empty order.business.businessID}">
			<a href="<c:url value="/admin/editOrderBusiness/${order.business.businessID}" />" class="btn btn-default btn-lg">Edytuj dane do faktury</a>
		</c:if>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>