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
        <h1>Product Editor<small> so be careful!</small></h1>
    </div>
 
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#list">View</a></li>
    <li><a data-toggle="tab" href="#edit">Edit</a></li>
    <li><a data-toggle="tab" href="#new">New Product</a></li>
  </ul>
  <div class="tab-content">
    <div id="list" class="tab-pane fade in active">
      <h3>List</h3>
      <ul>
        <li>Id: ${product.productId}</li>
        <li>Name: ${product.name}</li>
        <li>Store Name: ${product.store.name}</li>
      </ul>
      <div class="form-group">
		<h3>Product Listing</h3>
		<table class="table">
	        <tbody>
	            <tr><th>Id</th><th>Name</th><th>-</th><th>Actions</th></tr>
	            <c:forEach items="${products}" var="product">
	            <tr>
	                <td>${product.productId}</td>
	                <td>${product.name}</td>
	                <td>-</td>
	                <td>
	                    <c:set value="${product.store}" var="pStore" />
	                    <a href="<c:url value="/admin/store/${store.storeId}/product/${product.productId}/list" />">edit</a> /
	                    <a href="<c:url value="/admin/store/${store.storeId}/product/${product.productId}/delete" />" >delete</a>
	                </td>
	            </tr>
	            </c:forEach>
	        </tbody>	
	    </table>
	  </div>
    </div>
    <div id="edit" class="tab-pane fade">
      <h3>Edit Product</h3>
      <c:url value="admin/store/${store.storeId}/product/${product.productId}/update" var="updateProductFoo"></c:url>
      <c:url value="../${product.productId}/update" var="updateProduct"></c:url>
	  <form:form method="POST" modelAttribute="product" action="${updateProduct}">
	    <form:input type="hidden" path="productId" />Foo
	    <!--  form:input type="hidden" path="store" value="${product.store.storeId}"/  -->
		<div class="form-group">
			<label for="name">Product Name</label> 
			<form:input type="text" value="${product.name}" class="form-control" path="name" placeholder="The Name of the new Product" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
    
    <div id="new" class="tab-pane fade">
      <h3>New Product</h3>
      <c:url value="../new" var="newProduct" />
      <form:form id="newStoreCopyForm" method="POST" modelAttribute="product" action="${newProduct}">
		<div class="form-group">
			<label for="name">Product Name</label> 
			<form:input type="text" class="form-control" path="name" placeholder="" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
  </div>
</div>

    <jsp:include page="includes/footer.jsp"></jsp:include>
