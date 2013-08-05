<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Home" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<form:form class="form-signin">

        <h3 class="text-center">Apps</h3><br>
        <a  href="/finance">
            <img src="/img/finance2_80.jpg" data-toggle="tooltip" title="Finance App"/>
        </a>

        <a  href="/coupon">
            <img src="/img/coupon_71.jpg" data-toggle="tooltip" title="Coupon App"/>
        </a>

        <a  href="/tt">
            <img src="/img/tt_73.png" data-toggle="tooltip" title="Ping Pong Series"/>
        </a>
</form:form>
<jsp:include page="includes/footer.jsp"/>

