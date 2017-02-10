<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
    <!-- START THE FEATURETTES -->
    <div class="container marketing">
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
              <div class="col-md-5">
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
    </div>
    <!-- /END THE FEATURETTES --> 