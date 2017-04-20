<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br>		
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/editUser" method="post" commandName="users">
		<form:hidden path="userID" value="${users.userID}" />
		<form:hidden path="userEmail" value="${users.userEmail}" />		
			<fieldset>
				<legend class="">Edytuj użytkownika</legend>
					<div class="form-group">
						<label for="userName">Imię</label>
                    	<form:input class="form-control" path="userName" autofocus="" value="${users.userName}"/>
                        <form:errors path="userName" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userSurname">Nazwisko</label>
                    	<form:input class="form-control" path="userSurname" value="${users.userSurname}"/>
                        <form:errors path="userSurname" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userEmail">E-mail</label>
                    	<input class="form-control" value="${users.userEmail}" type="text" disabled="disabled"/>
                        <form:errors path="userEmail" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
                    	<label for="enabled">Aktywność</label>
                    	<form:select class="form-control" path="enabled" >
  							<option value="true">Aktywny</option>
    						<option value="false">Nie aktywny</option>    
  						</form:select>
                    </div>                            
                    <div class="form-group">
						<label for="userPhone">Numer telefonu</label>
                    	<form:input class="form-control" path="userPhone" value="${users.userPhone}"/>
                        <form:errors path="userPhone" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userPassword">Wpisz nowe hasło</label>
                    	<form:input class="form-control" path="userPassword" type="password" value=""/>
                        <form:errors path="userPassword" cssStyle="color:#ff0000" />
                    </div>
					
					<input type="submit" value="Zmień dane" class="btn btn-default btn-lg">
                    <a href="<c:url value="/admin/userPage" />" class="btn btn-default btn-lg">Anuluj</a>				
						
				</fieldset>
			</form:form>
		</div>
	</div>


<%@include file="/WEB-INF/views/footer.jsp"%>