<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">   
   
	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br />		
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/editProduct" modelAttribute="product"  method="POST">
			<form:hidden path="productID" value="${product.productID}" />				
			<fieldset>
				<legend class="">Edytuj produkt</legend>
					<c:if test="${not empty errorMessage }">
				    	<div class="error-message">
				    		${errorMessage}
				    	</div>
				   	</c:if>
					<div class="form-group">
						<label for="productName">Nazwa</label>
                    	<form:input class="form-control" path="productName" autofocus="" value="${product.productName}"/>
                        <form:errors path="productName" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
                    	<label for="productCategory">Kategoria</label>
                    	<form:select class="form-control" path="productCategory.productCategoryID" value="${productCategory.productCategoryID}">
  							<option value="1">Czujniki alarmowe</option>
    						<option value="2">Systemy przewodowe</option>  
    						<option value="3">Systemy bezprzewodowe</option>  
    						<option value="4">Mini alarmy</option>    
  						</form:select>
                    </div>
                    <div class="form-group">
						<label for="productPrice">Cena</label>
                    	<form:input class="form-control" path="productPrice" value="${product.productPrice}"/>
                        <form:errors path="productPrice" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
                    	<label for="productStatus">Aktywność</label>
                    	<form:select class="form-control" path="productStatus" value="${product.productStatus}">
  							<option value="true">Aktywny</option>
    						<option value="false">Nie aktywny</option>    
  						</form:select>
                    </div>                                
                    <div class="form-group">
						<label for="productDescription1">Opis skrócony</label>
						<form:textarea class="form-control" path="productDescription1" rows="3"></form:textarea>                 	
                        <form:errors path="productDescription1" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="productDescription2">Opis główny</label>
						<form:textarea class="form-control" path="productDescription2" rows="3"></form:textarea>
                    	<form:errors path="productDescription2" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="productDescription3">Opis dodatkowy</label>
						<form:textarea class="form-control" path="productDescription3" rows="3"></form:textarea>
                        <form:errors path="productDescription3" cssStyle="color:#ff0000" />
                    </div>
					
					<input type="submit" value="Edytuj produkt" class="btn btn-default btn-lg">
                    <a href="<c:url value="/admin/productPage"/>" class="btn btn-default btn-lg">Anuluj</a>				
						
				</fieldset>
			</form:form>
		</div>
	</div>


<%@include file="/WEB-INF/views/footer.jsp"%>