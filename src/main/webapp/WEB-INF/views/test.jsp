<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Account" scope="request"/>
<jsp:include page="common/includes/header.jsp"/>

    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>


<div id="chartContainer" style="min-width: 400px; height: 400px; margin: 0 auto"></div>
<div id="chartContainer2" style="min-width: 400px; height: 400px; margin: 0 auto"></div>

<a href="#" onclick="createChart('chartContainer', '/finance/test/data')">Create chart</a>
<a href="#" onclick="createChart('chartContainer2' , '/finance/test/data2')">Create chart</a>

<script src="/js/highcharts.js"></script>
<script src="/js/modules/exporting.js"></script>
<script src="/js/myJs.js"></script>


</body>
</html>

