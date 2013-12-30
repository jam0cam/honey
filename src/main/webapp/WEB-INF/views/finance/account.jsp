<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Account" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

<form:form class="form-account" commandName="command" >
    <h3 class="form-signin-heading text-center">Recent Entries</h3>
    <br>
    <table class="table table-striped">

        <c:forEach var="item" items="${command.rowTitles}">
            <tr>
                <td>${item.name}</td>
                <td>${item.month1}</td>
                <td>${item.month2}</td>
                <td>${item.month3}</td>
                <td>${item.month4}</td>
            </tr>
        </c:forEach>
        <c:forEach var="item" items="${command.rowDatas}">
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
                </td>

                <td><a href="/finance/entry/edit/id/${item.entryId1}" data-toggle="tooltip" title="${item.toolTip1}">${item.month1}</a></td>
                <td><a href="/finance/entry/edit/id/${item.entryId2}" data-toggle="tooltip" title="${item.toolTip2}">${item.month2}</a></td>
                <td><a href="/finance/entry/edit/id/${item.entryId3}" data-toggle="tooltip" title="${item.toolTip3}">${item.month3}</a></td>
                <td><a href="/finance/entry/edit/id/${item.entryId4}" data-toggle="tooltip" title="${item.toolTip4}">${item.month4}</a></td>
            </tr>
        </c:forEach>
    </table>
    <br><br>
    <c:if test="${command.hasPayees}">
        <a href="/finance/entry" class="btn btn-medium btn-primary">Add Entry</a><br>
    </c:if>

</form:form>

<jsp:include page="./includes/footer.jsp"/>