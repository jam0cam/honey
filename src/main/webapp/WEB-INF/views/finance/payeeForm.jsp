<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Payee Form" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

    <form:form class="form-payee" action="/finance/payee/save"  method="post" commandName="command" >
        <h3 class="form-signin-heading text-center">Payee</h3>
        <form:errors path="*" element="div" cssClass="alert alert-error"/>
        <form:input path="name" type="text" class="input-block-level"  placeholder="Name"/>
        <form:input path="accountNumber" type="text" class="input-block-level" placeholder="Account #"/>
        <form:input path="phone" type="text" class="input-block-level" placeholder="Phone"/>
        <form:input path="url" type="text" class="input-block-level" placeholder="URL"/>
        <form:textarea path="notes" rows="3" class="input-block-level"  placeholder="Notes"/>
        <form:hidden path="id" />
        <form:checkbox path="notifyOn"/> Notify me on the <form:input path="notifyDay" type="text" class="input-mini" maxlength="2"/> day of each month.
        <br>

        <button class="btn btn-medium btn-primary" type="submit">Save</button>
        <a href="/finance/payee" class="btn btn-medium btn-primary">Cancel</a><br>
    </form:form>
<jsp:include page="./includes/footer.jsp"/>