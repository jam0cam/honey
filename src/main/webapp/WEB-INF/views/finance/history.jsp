<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="History" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

<form:form class="form-account" commandName="command" >
    <h3 class="form-signin-heading text-center">Billing History</h3>
    <br><br>

    <form:errors path="*" element="div" cssClass="alert alert-error"/>
    <c:forEach var="item" items="${command}">
        <h4 class="form-signin-heading">${item.name}</h4>
        <table class="table table-striped table-bordered">
            <c:forEach var="row" items="${item.rowdata}">
                <tr>
                    <td style="width:150px;">
                        ${row.month1}
                        <c:choose>
                            <c:when test="${not empty row.month2}">
                                <img src="/img/notepad_20.jpg"  data-toggle="tooltip" title="${row.month2}"/>
                            </c:when>
                        </c:choose>
                    </td>
                    <td style="width:100px;">${row.name}</td>
                    <td style="width:100px;">
                        <a href="/finance/entry/edit/id/${row.id}?returnTo=history" data-toggle="tooltip" title="Edit">
                            <img src="/img/edit_30.jpg" />
                        </a>
                        <a href="/finance/history/remove/id/${row.id}" data-toggle="tooltip" title="Delete">
                            <img src="/img/delete_30.jpg" />
                        </a>

                    </td>
                </tr>
            </c:forEach>
        </table>

    </c:forEach>

        <span class="help-block toppadding">
        </span>
</form:form>

<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/bootstrap-tooltip.js"></script>
<script type="text/javascript">
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
</script>

<jsp:include page="./includes/footer.jsp"/>