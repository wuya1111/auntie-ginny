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
        <h1>Store Editor<small> so be careful!</small></h1>
    </div>
 
<div class="container">
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#list">View</a></li>
    <li><a data-toggle="tab" href="#edit">Edit</a></li>
    <li><a data-toggle="tab" href="#new-copy">New Store Copy</a></li>
    <li><a data-toggle="tab" href="#new-prod">New Product</a></li>
  </ul>
  <div class="tab-content">
    <div id="list" class="tab-pane fade in active">
      <h3>LIST</h3>
      <ul>
        <li>Id: ${store.storeId}</li>
        <li>Name: ${store.name}</li>
        <li>Title: ${store.title}</li>
        <li>Header Text: <pre>${store.header}</pre></li>
        <li>Footer Text: <pre>${store.footer}</pre></li>
        <li>Copyright: <pre>${store.copyright}</pre></li>
      </ul>
    </div>
    <div id="edit" class="tab-pane fade">
      <h3>EDIT</h3>
	  <form:form method="POST" modelAttribute="store" action="admin/store/update">
	    <form:hidden path="storeId" />
		<div class="form-group">
			<label for="name">Store Name</label> 
			<form:input type="text" class="form-control" path="name" placeholder="Email" />
		</div>
		<div class="form-group">
			<label for="name">Store Title</label> 
			<form:input type="text" class="form-control" path="title" placeholder="Email" />
		</div>
		<div class="form-group">
			<label for="name">Store Header</label> 
			<form:input type="text" class="form-control" path="header" placeholder="Email" />
		</div>
		<div class="form-group">
			<label for="name">Store Copyright</label> 
			<form:input type="text" class="form-control" path="copyright" placeholder="Email" />
		</div>
		<div class="form-group">
			<label for="name">Store Footer</label> 
			<form:input type="text" class="form-control" path="footer" placeholder="Email" />
		</div>		
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
    <div id="new-copy" class="tab-pane fade">
      <h3>New Store Copy</h3>
      <form:form id="newStoreCopyForm" method="POST" modelAttribute="storeCopy" action="admin/storecopy/new">
        <!--  form:hidden value="${store.storeId}" path="store"/ -->
		<div class="form-group">
			<label for="name">Store Copy Name</label> 
			<form:input type="text" class="form-control" path="copyName" placeholder="" />
		</div>
		<div class="form-group">
			<label for="copyBody">Store Copy Body</label> 
			<form:textarea type="text" class="form-control" path="copyBody" placeholder="" ></form:textarea>
		</div>
		<div class="form-group">
			<label for="copyType">Store Copy Type</label> 
			<form:select type="text" class="form-control" path="copyType" placeholder="">
			    <form:option value="carousel">Carousel</form:option>
			    <form:option value="featurette">Featurette</form:option>
			    <form:option value="posting">Posting</form:option>
			</form:select>
		</div>
		<div class="form-group">
			<label for="startDate">Store Copy Start Date</label> 
			<form:input type="date" class="form-control" path="startDate" placeholder="yyyy-mm-dd hh:mm:ss" />
		</div>
		<div class="form-group">
			<label for="endDate">Store Copy End Date</label> 
			<form:input type="date" class="form-control" path="endDate" placeholder="yyyy-mm-dd hh:mm:ss" />
		</div>
		<div class="form-group">
			<label for="copyLink">Store Copy Link</label> 
			<form:input type="text" class="form-control" path="copyLink" placeholder="" />
		</div>
		<div class="form-group">
			<label for="copyLinkText">Store Copy Link Text</label> 
			<form:input type="text" class="form-control" path="copyLinkText" placeholder="" />
		</div>
		<div class="form-group">
			<label for="file">Store Copy Image</label> 
			<form:input type="file" class="form-control" path="footer" placeholder="" />
		</div>
		<div class="form-group">
			<label for="name">Store Copy Image Alt Text</label> 
			<form:input type="text" class="form-control" path="copyImageAltText" placeholder="" />
		</div>		
		<button type="submit" class="btn btn-default">Submit</button>
	  </form:form>
    </div>
    <div id="new-prod" class="tab-pane fade">
      <h3>New Product</h3>
      <p></p>
    </div>
  </div>
</div>
 
 
    <div class="form-group">
		<h3>Store Products</h3>
		<table class="table">
	        <tbody>
	            <tr><th>Id</th><th>Name</th><th>-</th><th>Actions</th></tr>
	            <c:forEach items="${store.products}" var="product">
	            <tr>
	                <td>${product.productId}</td>
	                <td>${prooduct.name}</td>
	                <td>-</td>
	                <td>
	                    <a href="<c:url value="/product/edit/${product.productId}" />">edit</a> /
	                    <a href="<c:url value="/product/delete/${product.productId}" />" >delete</a>
	                </td>
	            </tr>
	            </c:forEach>
	        </tbody>	
	    </table>
	</div>

    <div class="form-group">
		<h3>Store Copy</h3>
		<table class="table">
	        <tbody>
	            <tr><th>Id</th><th>Name</th><th>-</th><th>Actions</th></tr>
	            <c:forEach items="${store.storeCopy}" var="copy">
	            <tr>
	                <td>${copy.storeCopyId}</td>
	                <td>${copy.copyName}</td>
	                <td>${copy.copyType}</td>
	                <td>
	                    <a href="<c:url value="/admin/storecopy/edit/${copy.storeCopyId}" />">edit</a> /
	                    <a href="<c:url value="/admin/storecopy/delete/${copy.storeCopyId}" />">delete</a>
	                </td>
	            </tr>
	            </c:forEach>
	        </tbody>	
	    </table>
	</div>



    <jsp:include page="includes/footer.jsp"></jsp:include>
