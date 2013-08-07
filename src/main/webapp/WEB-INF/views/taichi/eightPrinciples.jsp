<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="pageTitle" value="The Eight Form & Movement Principles" scope="request"/>
<jsp:include page="includes/header.jsp"/>
<form:form class="form-taichi" commandName="command">
    <h3 class="text-center">The Eight Form & Movement Principles</h3>
    <h3 class="text-center">(太極拳姿勢及動作之八大要點)</h3>
    <hr>
    <br><br>

    <p>
        (A) Form (Posture) (姿勢):<br>
    <ol>
        <li> (中) Concentration - the ability to be centered, focused, and in control</li>
        <li> (正) Precision - The ability to be correct and precis</li>
        <li> (安) Calmness - The ability to be relaxed and composed while being focused</li>
        <li> (舒) Ease - The ability to integrate various movements with comfort and ease</li>
    </ol>
    </p>
<br>
    <p>
        (B) Movement (Transformation) (動作):<br>
    <ol>
        <li>(輕) Effortlessness - the ability to be nimble and lightfooted</li>
        <li>(靈) Sensitivity - the ability to react to one's immediate surroundings with dexterity and utmost readiness</li>
        <li>(圓) Completeness - the ability to thoroughly follow the movements of a form to its unbroken conclusion</li>
        <li>(活) Continuity - the ability to link and connect sequences without pause or interruption</li>
    </ol>
    </p>

</form:form>


<jsp:include page="includes/footer.jsp"/>
