<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
    <!-- Marketing messaging and featurettes ================================================== -->
    <!-- Wrap the rest of the page in another container to center all the content. -->
    <div class="container marketing">
      <!-- Three columns of text below the carousel -->
      <div class="row">
        <c:forEach items="${store.storePostCopy}" var="post">
        <div class="col-lg-4">
          <img class="img-circle" src="${pageContext.request.contextPath}/resources/images/${post.copyImage}" alt="${post.copyImageAltText}" width="140" height="140">
          ${post.copyBody}
          <p><a class="btn btn-default" href="${post.copyLink}" role="button">${post.copyLinkText}</a></p>
        </div><!-- /.col-lg-4 -->
        </c:forEach>
      </div><!-- /.row -->
    </div>