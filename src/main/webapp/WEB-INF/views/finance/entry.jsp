<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Entry" scope="request"/>
<jsp:include page="./includes/header.jsp"/>


<form:form id="myform" class="form-signin" action="/finance/entry"  method="post" commandName="command" >
    <h3 class="form-signin-heading text-center">Entry</h3>
    <form:errors path="*" element="div" cssClass="alert alert-error"/>
    <form:hidden path="returnTo" />
    <form:select path="selectedPayeeId" items="${command.payees}" multiple="false" cssClass="input-medium" />
    <form:hidden path="id" />
    <form:input path="amount" type="text" class="input-medium" placeholder="Amount"/><div class="help-inline control-group info"><span class="help-inline control-group">xx.xx</span></div>
    <form:input path="date" type="text" class="input-medium" placeholder="Date"/><div class="help-inline control-group info"><span class="help-inline control-group">mm/dd/yyyy</span></div>
    <form:textarea path="notes" type="text" class="input-block-level" placeholder="Notes" rows="3"/>
    <button class="btn btn-medium btn-primary" type="submit">Save</button>
</form:form>

<script>
    /*Current date in form credit:
     JavaScript Kit (www.javascriptkit.com)
     Over 200+ free scripts here!
     */

    var mydate=new Date()
    var theyear=mydate.getYear()
    if (theyear < 1000)
        theyear+=1900
    var theday=mydate.getDay()
    var themonth=mydate.getMonth()+1
    if (themonth<10)
        themonth="0"+themonth
    var theday=mydate.getDate()
    if (theday<10)
        theday="0"+theday

    //////EDIT below three variable to customize the format of the date/////

    var displayfirst=themonth
    var displaysecond=theday
    var displaythird=theyear

    ////////////////////////////////////

    if (document.forms[0].date.value.length == 0) {
        document.forms[0].date.value=displayfirst+"/"+displaysecond+"/"+displaythird
    }

</script>
<jsp:include page="./includes/footer.jsp"/>

