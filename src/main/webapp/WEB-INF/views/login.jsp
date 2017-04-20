<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	<div class="row">
    	<div class="col-md-offset-3 col-md-6 col-md-offset-3"><br>
        	<form name="loginForm" class="form-horizontal" action="<c:url value="/j_spring_security_check" /> " method="post">
                          <fieldset>
                          	<legend class="">Zaloguj się</legend>                            
	                            <c:if test="${not empty msg}" >
									<div class="msg" style="font-size: 24px;color: green">${msg}</div>
								</c:if>
								<c:if test="${not empty error}">
									<div class="error" style="font-size: 24px;color: #ff0000">${error}</div>
								</c:if>
                            <div class="form-group">
                              <label for="email">E-mail</label>
                              <div class="controls">
                                <input type="email" id="email" name="userEmail" placeholder="" class="form-control input-lg">
                              </div>
                            </div>
                            <div class="form-group">
                              <label for="password">Hasło</label>
                              <div class="controls">
                                <input type="password" id="password" name="userPassword" placeholder="" class="form-control input-lg">
                              </div>
                            </div>
                            <div class="form-group">
                                <div class="controls">
                                <input type="submit" value="Zaloguj" class="btn btn-default btn-lg"><br><br>
                                Jeśli jeszcze nie masz konta, <a href="<c:url value="/register" />">zarejestruj się.</a>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                              </div>
                            </div>
                          </fieldset>
                        </form>
                </div>
        </div>
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>