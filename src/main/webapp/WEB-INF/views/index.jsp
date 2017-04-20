<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/header.jsp" %>

<div class="container">
	<div id="myCarousel" class="carousel slide" data-ride="carousel">  
	  <ol class="carousel-indicators">
	    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	    <li data-target="#myCarousel" data-slide-to="1"></li>
	    <li data-target="#myCarousel" data-slide-to="2"></li>
	  </ol>
	
	  <div class="carousel-inner" role="listbox">
	    <div class="item active">
	      <img src="<c:url value="/resources/images/baner1.png" />" alt="Szeroka oferta">
	    </div>
	
	    <div class="item">
	      <img src="<c:url value="/resources/images/baner2.png" />" alt="System rabatowy">
	    </div>
	
	    <div class="item">
	      <img src="<c:url value="/resources/images/baner3.png" />" alt="Błyskawiczna wysyłka">
	    </div>
	  </div>
	  
	  <a class="left carousel-control opacityZero" href="#myCarousel" role="button" data-slide="prev">
	    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="right carousel-control opacityZero" href="#myCarousel" role="button" data-slide="next">
	    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
	
	<div class="row">
		<div class="col-md-4">
			<img class="img-responsive" src="<c:url value="/resources/images/detector.jpg" />" alt="Czujnik alarmowy">
		</div>
		<div class="col-md-8">
			<br /><br />
			<h2>Czujniki alarmowe</h2>
			<br />
			<p>Maauris et eros vel velit posuere tempus nec auctor risus. Quisque mollis turpis non tristique aliquam. Aliquam convallis arcu purus, nec rhoncus lorem cursus sed. Ut quis lobortis odio, eget aliquet nulla. Fusce vitae velit eu neque tincidunt euismod eu id orci. Donec sed sem sed enim iaculis tempus. Vestibulum consequat neque ut varius iaculis. Mauris faucibus tellus suscipit magna ultricies dignissim posuere id sem. </p>
		</div>
	</div>
	<hr />
	<div class="row">		
		<div class="col-md-8">
			<br /><br />
			<h2>Systemy przewodowe</h2>
			<br />
			<p>Donec at nulla non mauris suscipit rhoncus a vitae sem. Nunc egestas rhoncus neque vel sodales. Nunc sagittis turpis nunc, efficitur tempus arcu euismod nec. Fusce rhoncus ante ac sollicitudin mollis. Fusce ornare hendrerit ligula ut blandit. Integer eu faucibus felis. Phasellus ac elementum nisi. Nulla facilisi. Aenean sed venenatis metus. Nam iaculis nunc vel lorem egestas, in mollis sapien posuere. Nulla sed ante tincidunt, finibus erat hendrerit, vulputate turpis.</p>
		</div>
		<div class="col-md-4">
			<img class="img-responsive" src="<c:url value="/resources/images/wire.png" />" alt="Systemy przewodowe">
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-4">
			<img class="img-responsive" src="<c:url value="/resources/images/wirless.jpg" />" alt="Systemy bezprzewodowe">
		</div>
		<div class="col-md-8">
			<br /><br />
			<h2>Systemy bezprzewodowe</h2>
			<br />
			<p>Curabitur feugiat ullamcorper orci, mattis eleifend mauris pulvinar non. Duis venenatis, lacus vitae dapibus commodo, urna tortor maximus arcu, non aliquam lacus velit ut velit. Nunc pulvinar orci lacinia, congue turpis nec, malesuada dui. Donec ut imperdiet nisi. Etiam imperdiet nunc a egestas semper. Morbi eu felis dignissim, dignissim turpis eu, accumsan elit. Phasellus ut nunc mattis, tristique justo id, fermentum turpis. Duis sed facilisis orci.</p>
		</div>
	</div>
	<hr />
	<div class="row">		
		<div class="col-md-8">
			<br /><br />
			<h2>Monitoring</h2>
			<br />
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean dapibus a turpis vitae placerat. Integer id ullamcorper ante, eu cursus ligula. Donec sollicitudin tempus nulla, et ullamcorper ipsum efficitur eu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Integer et tellus mollis, viverra urna non, euismod ligula. Suspendisse potenti. Donec varius risus a mi ultricies facilisis.</p>
		</div>
		<div class="col-md-4">
			<img class="img-responsive" src="<c:url value="/resources/images/camera.jpg" />" alt="Monitoring">
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-md-4">
			<img class="img-responsive img-circle" src="<c:url value="/resources/images/mini.jpg" />" alt="Mini alarmy">
		</div>
		<div class="col-md-8">
			<br /><br />
			<h2>Mini alarmy</h2>
			<br />
			<p>Vestibulum quis leo id erat blandit posuere. Donec vel quam eleifend, ultrices augue a, egestas ex. Morbi malesuada justo metus, consequat blandit sapien vulputate sed. Donec tempus a lacus vitae varius. Donec et pulvinar nunc. Ut aliquet ipsum aliquet fringilla luctus. Morbi consectetur pulvinar neque, sed tempor magna varius sed. Integer finibus feugiat dolor. Donec tempus facilisis porttitor. Pellentesque mattis dolor non elit euismod, ac dignissim lacus laoreet. Aliquam erat volutpat. Proin vitae feugiat tortor. Morbi vitae mauris nec urna pretium ultrices at nec ante.</p>
		</div>
	</div>
	<br />	
</div>

<%@include file="/WEB-INF/views/footer.jsp" %>