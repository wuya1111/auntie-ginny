<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR</title>
</head>
<body>
  <h1>Error Page</h1>
  <p>Application has encountered an error. Please contact support on ...</p>
    
    Failed URL: ${url}
    Exception:  ${exception.message}
    <pre style="">
    <c:forEach items="${exception.stackTrace}" var="ste">
        <c:choose>
          <c:when test="${ste.matches("olsendesign")}" >
            <strong>${ste}</strong>
          </c:when>
          <c:otherwise>
            ${ste}
          </c:otherwise>
        </c:choose>
    </c:forEach>
    </pre>
</body>
</html>