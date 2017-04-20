<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">

	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br />		
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/editOrderAddress" modelAttribute="address"  method="POST">
			<form:hidden path="addressID" value="${addressID}" />		
			<fieldset>
				<legend class="">Edytuj adres dostawy</legend>    
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
		  	</fieldset>
		  	<br />
		    <input type="submit" value="Edytuj dane" class="btn btn-default btn-lg">
            <a href="<c:url value="/admin/orderPage" />" class="btn btn-default btn-lg">Anuluj</a>						
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>