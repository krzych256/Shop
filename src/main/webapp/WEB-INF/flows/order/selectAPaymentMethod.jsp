<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">

	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
    		50%
  		</div>
	</div>
	
	<h1>Wybierz sposób płatności</h1>
	<hr />
	
	<div class="row col-md-offset-3 col-md-6 col-md-offset-3">
		<form:form commandName="order" class="form-horizaontal">	
			<div class="funkyradio">
		        <div class="funkyradio-success">
		            <form:radiobutton name="radio" id="radio1" path="payment" value="Przedpłata"/>
		            <label for="radio1">Przedpłata</label>
		        </div>
		        <div class="funkyradio-success">
		            <form:radiobutton name="radio" id="radio2" path="payment" value="Pobranie" checked="checked"/>
		            <label for="radio2">Pobranie</label>
		        </div>
		        <div class="funkyradio-success">
		            <form:radiobutton name="radio" id="radio3" path="payment" value="Odroczony termin płatności"/>
		            <label for="radio3">Odroczony termin płatności</label>
		        </div>	        
		    </div>	
		    <br />
	  		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	  		<button class="btn btn-danger" name="_eventId_cancel">Anuluj</button>
	  		<a href="${flowExecutionUrl}&_eventId=backToPurchase" class="btn btn-default">Cofnij</a>
	  		<input type="submit" value="Dalej" class="btn btn-success" name="_eventId_sendDataPayment" />
	  		
	  		
		</form:form>

	 </div>

</div> 

<%@include file="/WEB-INF/views/footer.jsp" %>