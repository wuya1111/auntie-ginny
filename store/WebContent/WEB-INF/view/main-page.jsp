<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="Aunty Ginny's Card Shop">
    <meta name="author" content="Peter E. Olsen III <peteolsen@gmail.com>">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet">
	<title>${store.title}</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  </head>
  <body>
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="/store/main">${store.title}</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="#">Separated link</a></li>
                    <li><a href="#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
          <c:choose>
          <c:when test="${account.active}">
	        <div class="account_info" style="color:white;">
                <strong>Hello <c:out value="${user.firstName}" /></strong>
            </div>  
          </c:when>
          <c:otherwise>
          	  <form method="POST" action="/store/login" modelAttribute="account" class="navbar-form navbar-right">
	            <div class="form-group">
	              <input name="emailAddress" type="email" placeholder="Email" class="form-control"/>
	            </div>
	            <div class="form-group">
	              <input name="password" type="password" placeholder="Password" class="form-control">
	            </div>
	            <input type="submit" class="btn btn-success">Sign in</input>
	          </form>              
          </c:otherwise>
        </c:choose>
              
            </div>
          </div>
        </nav>
      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <c:forEach items="${store.storeCarouselCopy}" begin="0" end="${store.storeCarouselCopy.size() - 1}" varStatus="i">
            <c:choose>
                <c:when test="${i.index == 0}">
                    <li data-target="#myCarousel" data-slide-to="<c:out value="${i.index}"/>" class="active"></li>
                </c:when>
                <c:otherwise>
                    <li data-target="#myCarousel" data-slide-to="<c:out value="${i.index}"/>" class="foobar"></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
      </ol>
      
      <div class="carousel-inner" role="listbox">
               
          <jsp:useBean id="today" class="java.util.Date" />
		  <fmt:setLocale value="en_US" />
		  
		  <!-- START Generated Items --> 
           
              <c:forEach items="${store.storeCarouselCopy}" var="copySection" varStatus="j">
    	      <fmt:parseDate var="startDate" value="${copySection.startDate}" pattern="YYYY-MM-dd HH:mm:ss" />
			  <!-- c:if test="${today.time gt startDate.time}" -->
			  <c:choose>
			      <c:when test="${j.index == 0}">
		              <div class="item active">
		          </c:when>
		          <c:otherwise>
		              <div class="item">
		          </c:otherwise>
			  </c:choose>
                  <img class="first-slide" src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
                  <div class="container">
                      <div class="carousel-caption"> 
                          ${copySection.copyBody}                
                          <p><a class="btn btn-lg btn-primary" href="${copySection.copyLink}" role="button">View details &raquo;</a></p>
                      </div>
                  </div>
              </div>
	          <!-- /c:if -->
          </c:forEach>
          
          <!-- END Generated Items --> 
          
      </div><!-- /carousel-inner -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /#myCarousel -->




    <!-- Marketing messaging and featurettes
    ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <c:forEach items="${store.storePostCopy}" var="post">
        <div class="col-lg-4">
          <img class="img-circle" src="${featurette.copyImage}" alt="${featurette.copyImageAltText}" width="140" height="140">
          ${post.copyBody}
          <p><a class="btn btn-default" href="${post.copyLink}" role="button">${post.copyLinkText}</a></p>
        </div><!-- /.col-lg-4 -->
        </c:forEach>
      </div><!-- /.row -->
        
      <!-- START THE FEATURETTES -->

	  <c:forEach items="${store.storeFeaturetteCopy}" var="feature" varStatus="i">
        <hr class="featurette-divider">
        <div class="row featurette">
        
          <c:choose>
            <c:when test="${i.index % 2 == 0}">
              <div class="col-md-7">
            </c:when>
            <c:otherwise>
              <div class="col-md-7 col-md-push-5">
            </c:otherwise>
          </c:choose>
        
        ${feature.copyBody}
        </div>
          
          <c:choose>
            <c:when test="${i.index % 2 == 0}">
              <div class="col-md-7">
            </c:when>
            <c:otherwise>
              <div class="col-md-5 col-md-pull-7">
            </c:otherwise>
          </c:choose>
            <img class="featurette-image img-responsive center-block" data-src="${pageContext.request.contextPath}/resources/images/${feature.copyImage}" alt="${feature.copyImageAltText}">
        </div><!-- /.col-md# -->
        </div><!-- /.row featurette -->
      </c:forEach>
      <hr class="featurette-divider">
      <!-- /END THE FEATURETTES -->
      
      <footer>
        <p>${store.footer}</p>
        <p>&copy; ${store.copyright} ${store.title}</p>
      </footer>
    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"><\/script>')</script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>