<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">

	<div class="progress">
  		<div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
    		100%
  		</div>
	</div>
	
	<h1>Dziękujemy za złożenie zamówienia.</h1>
	<hr />
	<br />
	<h2>Zapraszamy do dalszych <a href="${pageContext.request.contextPath}/product/productList">zakupów.</a></h2>
	
</div> 

<%@include file="/WEB-INF/views/footer.jsp" %>