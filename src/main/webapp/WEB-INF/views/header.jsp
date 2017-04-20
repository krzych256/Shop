<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sklep internetowy</title>
	
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
	<script src="<c:url value="/resources/js/jquery-1.11.3.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
<div class="containerMain">
	<div class="container-fluid naglowek">
		<div class="row margin-top-bottom-5px">
			<div class="col-xs-3 col-sm-2 col-md-2 col-lg-1 pull-right text-center">
				<a href="<spring:url value="contact"/>">
					<span class="glyphicon glyphicon-earphone" aria-hidden="true"></span> Kontakt
				</a>
			</div>
			<div class="col-xs-4 col-sm-3 col-md-3 col-lg-1 pull-right text-center">
				<a href="<spring:url value="/informationCenter"/>">
					Centrum informacji
				</a>
			</div>
			<div class="col-xs-4 col-sm-3 col-md-3 col-lg-1 pull-right text-center">				 
				<c:if test="${pageContext.request.userPrincipal.name == null}">Witaj, <a href="<c:url value="/login" />">zaloguj się</a> </c:if>
				<c:if test="${pageContext.request.userPrincipal.name != null}"><a href="<c:url value="/j_spring_security_logout" />">Wyloguj się</a> </c:if>
			</div>				
		</div>
		<div class="row margin-top-bottom-5px">
			<div class="col-md-2">
				<a href="<spring:url value="/" />">
					<img class="img-responsive center-block" src="<c:url value="/resources/images/logoSI.png" />" >
				</a>
			</div>
			<div class="col-md-8" style="margin-top:1%;" >			
				<form class="form" action="${pageContext.request.contextPath}/search">
					<div class="col-md-10 col-xs-12 col-sm-10 col-lg-10">					
						<input type="text" class="form-control input-lg" name="searchText" placeholder="Wpisz nazwę" />
					</div>
					<div class="col-md-2 col-xs-12">
						<button type="submit" class="btn btn-primary center-block btn-lg">Szukaj w sklepie</button>
					</div>					
				</form>
			</div>
			<div class="col-md-2" style="margin-top:1%;">
				<div class="pshoppingcart col-md-offset-3 col-md-4 col-md-offset-4 
										  col-xs-offset-4 col-xs-4 col-ss-offset-4">
					<a href="<spring:url value="/product/shoppingCart" />">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
					</a>
				</div>						
			</div>
		</div>		
		<div class="row margin-top-bottom-5px">
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
			  <div class="btn-group btn-group-lg " role="group">			  
			  	<a type="button" class="btn btn-color" href="<spring:url value="/product/productCategory?productCategoryID=1" />">Czujniki alarmowe</a>
			  </div>
			  <div class="btn-group btn-group-lg" role="group">
			  	<a type="button" class="btn btn-color" href="<spring:url value="/product/productCategory?productCategoryID=2" />">Systemy przewodowe</a>
			  </div>
			  <div class="btn-group btn-group-lg" role="group">
			  	<a type="button" class="btn btn-color" href="<spring:url value="/product/productCategory?productCategoryID=3" />">Systemy bezprzewodowe</a>			    
			  </div>
			  <div class="btn-group btn-group-lg" role="group">
			  	<a type="button" class="btn btn-color" href="<spring:url value="/product/productCategory?productCategoryID=4" />">Monitoring</a>
			  </div>
			  <div class="btn-group btn-group-lg" role="group">
			  	<a type="button" class="btn btn-color" href="<spring:url value="/product/productCategory?productCategoryID=5" />">Mini alarmy</a>
			  </div>
			</div>		
		</div>	
	</div>
		