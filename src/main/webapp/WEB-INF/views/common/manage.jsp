<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Change Password" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<form:form class="form-signin" action="/manage" method="post" commandName="command">
    <h3 class="form-signin-heading">Change Password</h3>
    <form:errors path="*" element="div" cssClass="alert alert-error"/>

    <form:input path="email" type="text" id="email" class="input-block-level" placeholder="Email address" readonly="true"/>
    <form:input path="password" type="password" id="password" class="input-block-level" placeholder="Password" />
    <button class="btn btn-medium btn-primary" type="submit">Change</button> <a href="/home" class="btn btn-medium btn-primary">Cancel</a><br>
</form:form>
<jsp:include page="includes/footer.jsp"/>