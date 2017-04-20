<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">

	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br />		
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/editOrderBusiness" modelAttribute="business"  method="POST">
			<form:hidden path="businessID" value="${businessID}" />	
			<fieldset>
				<legend class="">Edytuj dane do faktury</legend>               		
		        	<div class="form-group">
			    		<label for="name">Nazwa firmy</label>
			    		<form:input path="businessName" type="text" class="form-control" id="name" />
			  			<form:errors path="businessName" cssStyle="color:#ff0000" />
			  		</div>
					<div class="form-group">
			    		<label for="streetName">Ulica</label>
			    		<form:input path="businessStreetName" type="text" class="form-control" id="streetName" />
			  			<form:errors path="businessStreetName" cssStyle="color:#ff0000" />
			  		</div>
			  		<div class="form-group">
			    		<label for="zipCode">Kod pocztowy</label>
			    		<form:input path="businessZipCode" type="text" class="form-control" id="zipCode" />
			  			<form:errors path="businessZipCode" cssStyle="color:#ff0000" />
			  		</div>
			  		<div class="form-group">
			    		<label for="city">Miasto</label>
			    		<form:input path="businessCity" type="text" class="form-control" id="city" />
			  			<form:errors path="businessCity" cssStyle="color:#ff0000" />
			  		</div>
			  		<div class="form-group">
			    		<label for="country">Kraj</label>
			    		<form:input path="businessCountry" type="text" class="form-control" id="country" />
			  			<form:errors path="businessCountry" cssStyle="color:#ff0000" />
			  		</div>
			  		<div class="form-group">
			    		<label for="nip">NIP</label>
			    		<form:input path="businessNIP" type="text" class="form-control" id="nip" />
			  			<form:errors path="businessNIP" cssStyle="color:#ff0000" />
			  		</div>		        
		        </fieldset>
		  	<br />
		    <input type="submit" value="Edytuj dane" class="btn btn-default btn-lg">
            <a href="<c:url value="/admin/orderPage" />" class="btn btn-default btn-lg">Anuluj</a>						
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>