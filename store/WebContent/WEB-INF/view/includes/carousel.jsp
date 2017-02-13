<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
     <!-- Carousel ================================================== -->
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
                  <img class="first-slide" src="${pageContext.request.contextPath}/resources/images/${copySection.copyImage}" alt="${coptSection.coptImageAltText}">
                  <div class="container">
                      <div class="carousel-caption"> 
                          ${copySection.copyBody}                
                          <c:url value="${copySection.copyLink}" var="copyLink"></c:url>
                          <p><a class="btn btn-lg btn-primary" href="${copySection.copyLink}" role="button">${copySection.copyLinkText}</a></p>
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