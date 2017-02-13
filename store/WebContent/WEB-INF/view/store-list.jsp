<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<jsp:include page="includes/header.jsp"></jsp:include>
    <jsp:include page="includes/navbar.jsp"/>
    <div class="container" style="padding-top:150px;">
        <ul>
          <c:forEach items="${stores}" var="store">
            <li><a href="<c:url value="${store.storeId}/main" />"/>${store.name}</a></li>
          </c:forEach>
        </ul>
    </div>
<jsp:include page="includes/footer.jsp"></jsp:include>