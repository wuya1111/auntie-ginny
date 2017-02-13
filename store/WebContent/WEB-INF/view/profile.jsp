<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<jsp:include page="includes/header.jsp"></jsp:include>

<script>
//insert this in your jquery
//control the resizing of menu and go down the content in the correct position
    $("#navMenu").resize(function () {
        $('#godown').height($("#navMenu").height() + 10);
    });
    if ($("#navMenu").height() > $('#godown').height()) $('#godown').height($("#navMenu").height() + 10);
</script>	

<jsp:include page="includes/navbar.jsp"/>

<div class="godown-60" id="godown" style="padding-top:50px;"></div>
<div class="container">
    <div class="page-header">
        <h1>Profile Editor<small> so be careful!</small></h1>
    </div>
 
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#list">View</a></li>
    <li><a data-toggle="tab" href="#edit-account">Edit Account</a></li>
    <li><a data-toggle="tab" href="#edit-user">Edit User</a></li>
  </ul>
  <div class="tab-content">
    <div id="list" class="tab-pane fade in active">
      <h3>Account Info</h3>
      <ul>
        <li>Account Id: ${account.accountId}</li>
        <li>Email Address : ${account.emailAddress}</li>
        <c:set value="${account.role}" var="role"></c:set>
        <li>Role : ${role.roleName}</li>
      </ul>
      <h3>User Info</h3>
      <ul>
        <li>Salutation: ${user.salutation}</li>
        <li>First Name : ${user.firstName}</li>
        <li>Middle Name : ${user.middleName}</li>
        <li>Last Name : ${user.lastName}</li>
        <li>Suffix : ${user.suffix}</li>        
      </ul>
    </div> 
    <div id="edit-account" class="tab-pane fade">
      <h3>Edit Account</h3>
      <c:url value="account/update" var="accountEdit"></c:url>
	  <form:form id="editAccountForm" method="POST" modelAttribute="account" action="${accountEdit}">
	    <form:input type="hidden" value="${account.accountId}" path="accountId" />
	    <form:input type="hidden" value="${account.role}" path="role" />
	    <form:input type="hidden" value="${account.user}" path="user" />
		<div class="form-group">
			<label for="name">Email Address</label> 
			<form:input type="email" value="${account.emailAddress}" class="form-control" path="emailAddress" placeholder="Email" />
		</div>
		<div class="form-group">
			<label for="name">Password</label> 
			<form:input type="password" value="${account.password}" class="form-control" path="password" placeholder="Password" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
    <div id="edit-user" class="tab-pane fade">
      <h3>Edit User</h3>
      <c:url value="/${store.storeId}/user/update" var="updateUser"></c:url>
      <form:form id="updateUserForm" method="POST" modelAttribute="user" action="${updateUser}">
        <form:hidden value="${user.accountId}" path="accountId"/>
		<div class="form-group">
			<label for="name">Salutation</label> 
			<form:input type="text" class="form-control" path="salutation" placeholder="Mr. Ms. Phd. Dr. etc." maxlength="10" />
		</div>
		<div class="form-group">
			<label for="name">First Name</label> 
			<form:input type="text" class="form-control" path="firstName" placeholder="First Name" maxlength="40" />
		</div>
		<div class="form-group">
			<label for="name">Middle Name</label> 
			<form:input type="text" class="form-control" path="middleName" placeholder="Middle Name" maxlength="40" />
		</div>
		<div class="form-group">
			<label for="name">Last Name</label> 
			<form:input type="text" class="form-control" path="lastName" placeholder="Last Name" maxlength="40" />
		</div>
		<div class="form-group">
			<label for="name">Suffix</label> 
			<form:input type="text" class="form-control" path="suffix" placeholder="Sr. Jr. III etc." maxlength="10" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
  </div>
</div>

    <jsp:include page="includes/footer.jsp"></jsp:include>
