<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	
	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="min-width: 2em;">
    		0%
  		</div>
	</div>
	
	<h1>Wybierz dowód zakupu:</h1>
	<hr />
	<br />
	
	<div class="row col-md-offset-3 col-md-4 col-md-offset-3">
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		
		<button class="btn btn-lg btn-danger" name="_eventId_cancel">Anuluj</button>
		<a href="${flowExecutionUrl}&_eventId=choiceOfReceipt" class="btn btn-lg btn-default">Paragon</a>
		<a href="${flowExecutionUrl}&_eventId=choiceOfInvoice" class="btn btn-lg btn-default">Faktura</a>		
	</div>
	
</div> 

<%@include file="/WEB-INF/views/footer.jsp" %>