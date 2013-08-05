<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Ping Pong Series" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<h3 class="text-center">Games Played</h3>
<br>
<div id="gamesColumn" style="height: 400px; margin: 0 auto;"></div>
<hr>
<h3 class="text-center">Series Played</h3>
<br>
<div id="seriesColumn" style="height: 400px; margin: 0 auto;"></div>

<form:form class="form-signin" commandName="command">

    <c:choose>
        <c:when test="${not empty command.games}">
            <h3 class="text-center">Detail Breakdown</h3>
            <br>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th>${command.playerOne}</th>
                    <th>${command.playerTwo}</th>
                </tr>
                </thead>
                <tr>
                    <td>Series Win</td>
                    <td>${command.player1SeriesWin}</td>
                    <td>${command.player2SeriesWin}</td>
                </tr>
                <tr>
                    <td>Total Win</td>
                    <td>${command.player1TotalWin}</td>
                    <td>${command.player2TotalWin}</td>
                </tr>
            </table>
            <hr>

            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>${command.playerOne}</th>
                    <th>${command.playerTwo}</th>
                    <th>Winner</th>
                </tr>
                </thead>
                <c:forEach var="item" items="${command.games}">
                    <tr>
                        <td>${item.dateString}</td>
                        <td>${item.player1Score}</td>
                        <td>${item.player2Score}</td>
                        <td>${item.winner}</td>
                    </tr>
                </c:forEach>
            </table>

        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</form:form>


</div>

<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/highcharts.js"></script>
<script src="/js/modules/exporting.js"></script>
<script src="/js/myJs.js"></script>

<script>
    createChart('gamesColumn', '/tt/monthly/game', -300);
    createChart('seriesColumn', '/tt/monthly/series', -300);
</script>

</body>
</html>