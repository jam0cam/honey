<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="View Payees" scope="request"/>
<jsp:include page="includes/header.jsp"/>

    <form:form class="form-signin" action="/register"  method="post" commandName="command" >
        <h3 class="form-signin-heading">Register</h3>
        <form:errors path="*" element="div" cssClass="alert alert-error"/>
        <form:input path="name" type="text" class="input-block-level"  placeholder="Name"/>
        <form:input path="email" type="text" class="input-block-level" placeholder="Email address"/>
        <form:input path="password" type="password" class="input-block-level" placeholder="Password"/>
        <button class="btn btn-medium btn-primary" type="submit">Register</button> <a href="/" class="btn btn-medium btn-primary">Cancel</a><br>
    </form:form>

<jsp:include page="includes/footer.jsp"/>