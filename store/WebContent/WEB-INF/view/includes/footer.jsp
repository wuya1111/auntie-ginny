<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
    <c:if test="${account eq null}">
    <!--  MODAL SIGN UP CODE -->
    <div id="signUpModal" class="modal modal-fade" role="dialog" tabindex="-1">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">Get Started and Sign Up Now!</h4>
          </div>
          <div class="modal-body">
            <c:url value="/${store.storeId}/account/new" var="newAccount"></c:url>
            <form id="newAccountForm" action="${newAccount}" method="POST">
              <div class="form-group">
                <label>Enter your email address:</label>
                <input name="emailAddress" type="email" placeholder="Email" class="form-control" />
                <input name="passwordOne" type="password" placeholder="password" class="form-control" />
                <input name="passwordTwo" type="password" placeholder="password confirm" class="form-control" />
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            <button type="button" class="btn btn-primary" id="newAccountSubmit">Save</button>
          </div>
        </div>
      </div>
    </div>
    <!-- MODAL END -->
    </c:if>
    <footer>
        <p>${store.footer}</p>
        <p>&copy; ${store.copyright} ${store.title}</p>
    </footer>
  </div> <!-- ?container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- Latest compiled and minified JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${pageContext.request.contextPath}/resources/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>