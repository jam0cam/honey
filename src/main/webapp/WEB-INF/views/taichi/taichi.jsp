<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Tai Chi" scope="request"/>
<jsp:include page="includes/header.jsp"/>
<form:form class="form-taichi" commandName="command">

    <ul>
        <li><a href="/taichi/nineAspects">The Nine Key Physical Aspects on Tai Chi Posture</a></li>
        <li><a href="/taichi/eightPrinciples">The Eight Form & Movement Principles</a></li>
    </ul>
</form:form>


<jsp:include page="includes/footer.jsp"/>
