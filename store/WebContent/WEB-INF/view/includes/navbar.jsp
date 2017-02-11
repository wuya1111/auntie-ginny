<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
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
                <li><a href="#support">Support</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class=""></span><span class="caret"></span></a>
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
                  <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Welcome ${user.firstName} ${user.lastName}</a></li>
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-home"></span><span class="caret"></span></a>
                      <ul class="dropdown-menu">
                        <li><a href="profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        <li><a href="shoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a></li>
                        <li><a href="calendar"><span class="glyphicon glyphicon-calendar"></span> Calendar</a></li>
                        <li><a href="addressBook"><span class="glyphicon glyphicon-book"></span> Address Book</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="logout"><span class="glyphicon glyphicon-remove"></span> Logout</a></li>
                        <c:set var="role" value="${account.role}"></c:set>
                        <c:if test="${role.roleName == 'ADMIN'}">
                            <li role="separator" class="divider"></li>
                            <li><a href="admin"><span class="glyphicon glyphicon-dashboard"></span> Admin</a></li>
                        </c:if>
                      </ul>
                    </li>
                  </ul>
                </c:when>
                <c:otherwise>
          	      <form method="POST" action="/store/login" modelAttribute="account" class="navbar-form navbar-right">
	                <div class="form-group">
	                  <input name="emailAddress" type="email" placeholder="Email" class="form-control"/>
	                </div>
	                <div class="form-group">
	                  <input name="password" type="password" placeholder="Password" class="form-control">
	                </div>
	                <input type="submit" class="btn btn-success" value="Sign In"></input>
	              </form>              
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </nav>
      </div><!-- /.container -->
    </div><!-- /.navbar-wrapper -->