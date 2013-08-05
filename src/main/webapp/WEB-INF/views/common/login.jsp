<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Login" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<form:form class="form-signin" action="/login" method="post" commandName="command">
    <h3 class="form-signin-heading">Sign in</h3>
    <c:if test="${command.error != null}">
        <div class="alert alert-error">
            ${command.error}
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            You have been logged out.
        </div>
    </c:if>
    <form:input path="email" type="text" id="email" class="input-block-level" placeholder="Email address" />
    <form:input path="password" type="password" id="password" class="input-block-level" placeholder="Password" />
    <p class="text-center">v1.5</p>
    <button class="btn btn-medium btn-primary" type="submit">Sign in</button>
</form:form>
<jsp:include page="includes/footer.jsp"/>