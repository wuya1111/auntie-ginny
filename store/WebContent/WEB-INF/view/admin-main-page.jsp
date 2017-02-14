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
        <h1>Administration Menu<small> so be careful!</small></h1>
    </div>
 
    <h2>Links</h2>
    <ul>
        <li><a href="<c:url value="/admin/main" />">Stores</a>
	        <ul>
	          <c:forEach items="${stores}" var="store">
	              <li><a href="<c:url value="store/${store.storeId}/list" />">${store.name}</a></li>
	          </c:forEach>
	        </ul>
        </li>
        <li><a href="profile">Active Users</a>
	        <ul>
	          <c:forEach items="${users}" var="user">
	              <c:set value="${user.account}" var="account" />
	              <c:if test="${account.active}">
	                <li><a href="<c:url value="/admin/user/${account.accountId}/list" />">${user.firstName} ${user.lastName} &lt;${account.emailAddress}&gt;</a></li>
	              </c:if>
	          </c:forEach>
	        </ul>
        </li>
        <li><a href="account">Accounts</a>
            <ul>
	          <c:forEach items="${accounts}" var="account">
	              <c:set value="${account.user}" var="user" />
	              <li><a href="<c:url value="/admin/user/${account.accountId}/list" />">${user.firstName} ${user.lastName} &lt;${account.emailAddress}&gt; ${account.role.roleName}</a></li>
	          </c:forEach>
	        </ul>
        </li>
        <li><a href="account">Products</a>
            <ul>
	          <c:forEach items="${products}" var="product">
	              <c:set value="${product.store}" var="pStore" />
	              <li><a href="<c:url value="/admin/store/${pStore.storeId}/product/${product.productId}/list" />">${product.name}</a></li>
	          </c:forEach>
	        </ul>
        </li>
    </ul>
    <hr/>
    <jsp:include page="includes/footer.jsp"></jsp:include>
