<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/mystyle.css">
    <link rel="stylesheet" href="/css/account.css">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

    <form:form class="form-signin" action="/test"  method="post" commandName="command" >

        <table class="table">

            <c:forEach var="item" items="${command.rowDatas}">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.month1}</td>
                    <td>${item.month2}</td>
                    <td>${item.month3}</td>
                </tr>
            </c:forEach>
        </table>
    </form:form>


</div> <!-- /container -->

</body>
</html>
