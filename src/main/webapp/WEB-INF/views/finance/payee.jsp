<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Payees" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

    <form:form class="display-payee" commandName="command">
        <h3 class="form-signin-heading text-center">Payees</h3>
        <br><br>

        <table class="table table-striped">
            <thead>
            <tr>
                <th>Name</th>
                <th>Acc #</th>
                <th>Phone</th>
                <th>On/Off</th>
                <th><a href="#" data-toggle="tooltip" title="Day of the month to be notified">Day</a></th>
            </tr>
            </thead>
            <c:forEach var="item" items="${command}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${not empty item.url}">
                                <a href="${item.url}" target="_blank">${item.name}</a>
                            </c:when>
                            <c:otherwise>
                                ${item.name}
                            </c:otherwise>
                        </c:choose>
                            <c:choose>
                                <c:when test="${not empty item.notes}">
                                    <img src="/img/notepad_20.jpg"  data-toggle="tooltip" title="${item.notes}" />
                                </c:when>
                            </c:choose>
                    </td>
                    <td>${item.accountNumber}</td>
                    <td>${item.phone}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.notifyOn}">
                                <img src="/img/alarmOn_40.jpg"  />
                            </c:when>
                            <c:otherwise>
                                <img src="/img/alarmOff_40.jpg" />
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${item.notifyDay}</td>
                    <td>
                        <a href="/finance/payee/update/id/${item.id}" data-toggle="tooltip" title="Edit">
                            <img src="/img/edit_30.jpg" />
                        </a>
                        <a href="/finance/payee/remove/id/${item.id}" data-toggle="tooltip" title="Delete">
                            <img src="/img/delete_30.jpg" />
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/finance/payee/add" class="btn btn-medium btn-primary">Add Payee</a><br>
        <span class="help-block toppadding">
        </span>
    </form:form>
<script src="/js/bootstrap-tooltip.js"></script>
<script type="text/javascript">
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
</script>

<jsp:include page="./includes/footer.jsp"/>