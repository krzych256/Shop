<%@page contentType="text/html;charset=UTF-8" language="java"%>
<% response.setCharacterEncoding("UTF-8"); request.setCharacterEncoding("UTF-8"); %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">

   <c:if test="${not empty errorMessage }">
     <div class="error-message">
         ${errorMessage}
     </div>
   </c:if>

	<div class="row col-md-offset-3 col-md-6 col-md-offset-3">		
		<form:form class="form-horizontal" modelAttribute="product"  method="POST" enctype="multipart/form-data">
			<!-- action="${pageContext.request.contextPath}/admin/addProduct"  commandName="product" enctype="multipart/form-data"-->
			<fieldset>
				<legend class="">Dodaj produkt</legend>					
					<div class="form-group">
						<label for="productName">Nazwa</label>
                    	<form:input class="form-control" path="productName" autofocus=""/>
                        <form:errors path="productName" cssStyle="color:#ff0000" />
                    </div>
                    
                    <div class="form-group">
						<label for="productCategory">Kategoria</label>
						<form:select class="form-control" path="productCategory.productCategoryID">
  							<option value="1">Czujniki alarmowe</option>
    						<option value="2">Systemy przewodowe</option>  
    						<option value="3">Systemy bezprzewodowe</option>  
    						<option value="4">Mini alarmy</option>    
  						</form:select>
                        <form:errors path="productCategory" cssStyle="color:#ff0000" />
                    </div>
                     
                    <div class="form-group">
						<label for="productPrice">Cena</label>
                    	<form:input class="form-control" path="productPrice"/>
                        <form:errors path="productPrice" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="productStatus">Aktywność</label>
						<form:select class="form-control" path="productStatus">
  							<option value="true">Aktywny</option>
    						<option value="false">Nie aktywny</option>   
  						</form:select>
                        <form:errors path="productStatus" cssStyle="color:#ff0000" />
                    </div>                        
                    <div class="form-group">
						<label for="fileData">Zdjęcie</label>
						<form:input type="file" path="fileData"/>
                        <form:errors path="fileData" cssStyle="color:#ff0000" />
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
					
					<input type="submit" value="Dodaj produkt" class="btn btn-default btn-lg">
                    <a href="<c:url value="/admin/productPage" />" class="btn btn-default btn-lg">Anuluj</a>				
						
				</fieldset>
			</form:form>
		</div>
	</div>


<%@include file="/WEB-INF/views/footer.jsp"%>