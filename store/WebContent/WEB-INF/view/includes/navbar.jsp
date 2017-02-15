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
              <a class="navbar-brand" href='<c:url value="/${store.storeId}/main" ></c:url>'>${store.title}</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/${store.storeId}/main" />">Home</a></li>
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
                        <li><a href="<c:url value="/${store.storeId}/profile" />"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
                        <li><a href="<c:url value="/${store.storeId}/account/${account.accountId}/shoppingCart" />"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a></li>
                        <li><a href="<c:url value="/${store.storeId}/account/${account.accountId}/calendar" />"><span class="glyphicon glyphicon-calendar"></span> Calendar</a></li>
                        <li><a href="<c:url value="/${store.storeId}/account/${account.accountId}/addressBook" />"><span class="glyphicon glyphicon-book"></span> Address Book</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="<c:url value="/${store.storeId}/logout" />"><span class="glyphicon glyphicon-remove"></span> Logout</a></li>
                        <c:set var="role" value="${account.role}"></c:set>
                        <c:if test="${role.roleName == 'ADMIN'}">
                            <li role="separator" class="divider"></li>
                            <li><a href="<c:url value="/admin/main"/>"><span class="glyphicon glyphicon-dashboard"></span> Admin</a></li>
                        </c:if>
                      </ul>
                    </li>
                  </ul>
                </c:when>
                <c:otherwise>
                  <c:url value="/${store.storeId}/login" var="loginUrl"></c:url>
                    <form method="POST" action="${loginUrl}" modelAttribute="account" class="navbar-form navbar-right">
                    <div class="form-group">
                      <input name="emailAddress" type="email" placeholder="Email" class="form-control"/>
                    </div>
                    <div class="form-group">
                      <input name="password" type="password" placeholder="Password" class="form-control">
                    </div>
                    <input type="submit" class="btn btn-default" value="Sign In"></input>
                    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#signUpModal">Sign Up!</button>
                  </form>              
                </c:otherwise>
              </c:choose>
            </div>
          </div>
        </nav>
      </div><!-- /.container -->
    </div><!-- /.navbar-wrapper -->
    
  <div>
    <!--  MODAL SIGN UP BEGIN -->
    <div id="signUpModal" class="modal modal-fade" role="dialog" tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">Sign Up Now!</h4>
          </div>
          <div class="modal-body">
            <form:form action="account/new" method="POST">
              <div class="form-group">
                <input name="emailAddress" type="email" placeholder="Email" class="form-control" />
              </div>
            </form:form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary">Save</button>
          </div>
        </div>
      </div>
    </div>
    <!-- MODAL END -->
  </div>