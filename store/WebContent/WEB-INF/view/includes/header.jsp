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
    <meta name="author" content="Peter E. Olsen III peteolsen@gmail.com">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
    <!-- script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/vendor/jquery.min.js"><\/script>')</script -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/resources/css/carousel.css" rel="stylesheet">
	<title>${store.title}</title>
	<script>
	  $(document).ready(function() {
	    $(".dropdown-toggle").dropdown();
	  });
	  
	  $(function () {
		  $('[data-toggle="popover"]').popover()
	  });
	  
	  $(function() {
		     $('.signUpModal').on('show.bs.modal', function () {
		    	 // Add other code that runs when modal appears
		     });
	  });
	  
	  $(document).ready(function() {
		  var form = document.getElementById("newAccountForm");
	      document.getElementById("newAccountSubmit").addEventListener("click", function () {
	          form.submit(); 
	      });  
	  });
	  
	  <c:if test="${errors}" >
	  $(document).ready(function() {
		  $('#myModal').modal('show'); 
		  alert("Errors Exist :( " + "${errors}" );
      });
	  </c:if>
	  
	</script>
  </head>
  <body>