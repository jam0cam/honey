<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Ping Pong Series" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<form:form class="form-signin" commandName="command" action="/tt/save"  method="post">

    <h3 class="form-signin-heading text-center">New Game</h3>
    <br>
    <div class="text-center">
        <form:errors path="*" element="div" cssClass="alert alert-error "/>
            ${command.player1.name}
        <form:input path="player1Score" type="text" class="input-micro" maxlength="1"/>
        <form:hidden path="player1.id" />
        <form:hidden path="player1.name" />
        <b>VS</b>
        <form:input path="player2Score" type="text" class="input-micro" maxlength="1"/>
        <form:hidden path="player2.id" />
        <form:hidden path="player2.name" />
        <form:hidden path="date"/>
        <%--<form:input path="newGame.player2Score" type="text" class="input-micro" maxlength="1"/>--%>
            ${command.player2.name}
        <br><br>
        <button class="btn btn-medium btn-primary" type="submit">Save</button>
    </div>

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

    document.forms[0].date.value=displayfirst+"/"+displaysecond+"/"+displaythird
</script>
<jsp:include page="includes/footer.jsp"/>