<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">

	<h1>Panel administracyjny</h1>
	<hr />
	<br />
	<div class="btn-group btn-group-justified" role="group" aria-label="...">
	  <div class="btn-group" role="group">
	  	<a href="<c:url value="/admin/userPage" />">
	   		<button type="button" class="btn btn-lg btn-default">Zarządzanie użytkownikami</button>
	  	</a>
	  </div>	  
	  <div class="btn-group" role="group">
	  	<a href="<c:url value="/admin/productPage" />">
	    	<button type="button" class="btn btn-lg btn-default">Zarządzanie produktami</button>
	  	</a>
	  </div>	  
	  <div class="btn-group" role="group">
	  	<a href="<c:url value="/admin/orderPage" />">
	    	<button type="button" class="btn btn-lg btn-default">Zarządzanie zamówieniami</button>
	    </a>
	  </div>	  
	</div>
		
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>