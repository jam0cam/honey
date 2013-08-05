<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Ping Pong Series" scope="request"/>
<jsp:include page="includes/header.jsp"/>

<br>
<div id="mixChart" style="height: 400px; margin: 0 auto;"></div>
<br>
<br>
<div id="pie" style="height: 400px; margin: 0 auto;"></div>

<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery-1.10.1.min.js"></script>
<script src="/js/highcharts.js"></script>
<script src="/js/modules/exporting.js"></script>
<script src="/js/myJs.js"></script>

<script>
    //+200 is a x coordinate off the screen so the user cannot see it
    createChart('mixChart', '/finance/stats/monthlyExpense', +200);
    createPie('pie', '/finance/stats/expenseByPayee');
</script>

</body>
</html>