<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/header.jsp"%>

<div class="container">
	<div class="row col-md-offset-3 col-md-6 col-md-offset-3"><br>	
		<form:form class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post" commandName="users">
			<fieldset>
				<legend class="">Zarejestruj się</legend>
					<div class="form-group">
						<label for="userName">Imię</label>
                    	<form:input class="form-control" path="userName" autofocus=""/>
                        <form:errors path="userName" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userSurname">Nazwisko</label>
                    	<form:input class="form-control" path="userSurname"/>
                        <form:errors path="userSurname" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userEmail">E-mail</label>
                    	<form:input class="form-control" path="userEmail"/>
                        <form:errors path="userEmail" cssStyle="color:#ff0000" />
                        <c:if test="${not empty emailMsg}" >
							<div class="emailMsg" style="color:#ff0000">${emailMsg}</div>
						</c:if>
                    </div>
                    <div class="form-group">
						<label for="userPhone">Numer telefonu</label>
                    	<form:input class="form-control" path="userPhone"/>
                        <form:errors path="userPhone" cssStyle="color:#ff0000" />
                    </div>
                    <div class="form-group">
						<label for="userPassword">Hasło</label>
                    	<form:input class="form-control" path="userPassword" type="password"/>
                        <form:errors path="userPassword" cssStyle="color:#ff0000" />
                    </div>
					<br>
					<input type="submit" value="Zarejestruj" class="btn btn-default btn-lg">
                    <a href="<c:url value="/" />" class="btn btn-default btn-lg">Anuluj</a>				
						
				</fieldset>
			</form:form>
		</div>
	</div>


<%@include file="/WEB-INF/views/footer.jsp"%>