<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	
	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
    		25%
  		</div>
	</div>
	
	<h1>Podaj dane do faktury</h1>
	<hr />

	<form:form commandName="business" class="form-horizaontal" action="${flowExecutionUrl}">
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
  		
  		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
  		<button class="btn btn-danger" name="_eventId_cancel">Anuluj</button>  		
  		<a href="${flowExecutionUrl}&_eventId=backToPurchase" class="btn btn-default">Cofnij</a>
  		<input type="submit" value="Dalej" class="btn btn-success" name="_eventId_sendData" />
  		
	</form:form>

</div>
	
<%@include file="/WEB-INF/views/footer.jsp" %>