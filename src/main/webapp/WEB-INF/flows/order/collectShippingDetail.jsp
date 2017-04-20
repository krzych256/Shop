<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	
	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style="width: 75%;">
    		75%
  		</div>
	</div>
	
	<h1>Podaj adres dostawy</h1>
	<hr />
	<form:form commandName="shippingAddress" class="form-horizaontal">
		<div class="form-group">
    		<label for="name">Odbiorca</label>
    		<form:input path="addressName" type="text" class="form-control" id="name" />
    		<form:errors path="addressName" cssStyle="color:#ff0000" />
  		</div>
		<div class="form-group">
    		<label for="streetName">Ulica</label>
    		<form:input path="addressStreetName" type="text" class="form-control" id="streetName" />
    		<form:errors path="addressStreetName" cssStyle="color:#ff0000" />
  		</div>
  		<div class="form-group">
    		<label for="zipCode">Kod pocztowy</label>
    		<form:input path="addressZipCode" type="text" class="form-control" id="zipCode" />
    		<form:errors path="addressZipCode" cssStyle="color:#ff0000" />
  		</div>
  		<div class="form-group">
    		<label for="city">Miasto</label>
    		<form:input path="addressCity" type="text" class="form-control" id="city" />
    		<form:errors path="addressCity" cssStyle="color:#ff0000" />
  		</div>
  		<div class="form-group">
    		<label for="country">Kraj</label>
    		<form:input path="addressCountry" type="text" class="form-control" id="country" />
    		<form:errors path="addressCountry" cssStyle="color:#ff0000" />
  		</div>
  		<div class="form-group">
    		<label for="phone">Numer telefonu</label>
    		<form:input path="addressPhone" type="text" class="form-control" id="phone" />
    		<form:errors path="addressPhone" cssStyle="color:#ff0000" />
  		</div>
  		
  		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
  		<button class="btn btn-danger" name="_eventId_cancel">Anuluj</button>  		
  		<a href="${flowExecutionUrl}&_eventId=backToPaymant" class="btn btn-default">Cofnij</a>
  		<input type="submit" value="Dalej" class="btn btn-success" name="_eventId_sendDataShipping" />  		
	</form:form>
	<!-- 
	<form:form commandName="order" class="form-horizaontal">
		<div class="form-group">
    		<label for="name">Odbiorca</label>
    		<form:input path="shippingAddress.addressName" type="text" class="form-control" id="name" />
  		</div>
		<div class="form-group">
    		<label for="streetName">Ulica</label>
    		<form:input path="shippingAddress.addressStreetName" type="text" class="form-control" id="streetName" />
  		</div>
  		<div class="form-group">
    		<label for="zipCode">Kod pocztowy</label>
    		<form:input path="shippingAddress.addressZipCode" type="text" class="form-control" id="zipCode" />
  		</div>
  		<div class="form-group">
    		<label for="city">Miasto</label>
    		<form:input path="shippingAddress.addressCity" type="text" class="form-control" id="city" />
  		</div>
  		<div class="form-group">
    		<label for="country">Kraj</label>
    		<form:input path="shippingAddress.addressCountry" type="text" class="form-control" id="country" />
  		</div>
  		<div class="form-group">
    		<label for="phone">Numer telefonu</label>
    		<form:input path="shippingAddress.addressPhone" type="text" class="form-control" id="phone" />
  		</div>
  		
  		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
  		<input type="submit" value="Dalej" class="btn btn-default" name="_eventId_sendDataShipping" />
  		<a href="${flowExecutionUrl}&_eventId=backToPaymant" class="btn btn-default">Cofnij</a>
  		<button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
	</form:form>
	-->
</div> 

<%@include file="/WEB-INF/views/footer.jsp" %>