<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Feedback" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<form:form class="form-signin" action="/about" method="post" commandName="command">
    <h3 class="form-signin-heading">Feedback</h3>

    This is a website created by Jia Tse. Please leave any comments/questions/feedback below.<br><br>

    <form:errors path="*" element="div" cssClass="alert alert-error"/>

    <form:input path="email" type="text" id="email" class="input-block-level" placeholder="Email" />
    <form:textarea path="comments" rows="3" class="input-block-level"  placeholder="Comments"/>
    <button class="btn btn-medium btn-primary" type="submit">Submit</button>
</form:form>
<jsp:include page="includes/footer.jsp"/>