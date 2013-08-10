<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:set var="pageTitle" value="List of Lectures and Announcements" scope="request"/>
<jsp:include page="includes/header.jsp"/>
<link rel="stylesheet" href="/css/taichi.css">
<form:form class="form-taichi" commandName="command">
    <h3 class="text-center">List of Lectures and Announcements</h3>
    <hr>
    <br><br>

    <p>
    <ul>
        <li>(1) A Historical Account of Tai Chi
            <ul>
                <li> (A)
                    <ul>
                        <li>(a) I-Ching</li>
                        <li>(b) The Chi Program</li>
                    </ul>
                </li>
                <li> (B)
                    <ul>
                        <li>(a) The Original vs the Modified Forms.</li>
                        <li>(b) Internal vs External Styles</li>
                        <li>(c) Tai Chi & Yoga</li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
    </p>
    <br>

    <p>
    <ul>
        <li>(2) Abdominal Breathing</li>
        <ul>
            <li>(a) Correct Breathing Techniques</li>
            <li>(b) Minimum Time Duration For Movements</li>
            <li>(c) Important Affected Meridian Points</li>
        </ul>
    </ul>
    </p>
    <br>

    <p>
    <ul>
        <li>(3) <a href="/taichi/health">Tai Chi Health Benefits: A Systematic Account</a></li>
    </ul>
    </p>
    <br>
    <p>
    <ul>
        <li>(4) Creation of the Original Tai Chi Style</li>
        <ul>
            <li>(a) S. F. Chang's Itinerary</li>
            <li>(b) Tai Chi's Dichotomy: Shiu-Lim Temple vs Mu Dong Mt.</li>
        </ul>
    </ul>
    </p>
    <br>
    <p>
    <ul>
        <li>(5) Chi & The Meridians</li>
        <ul>
            <li>(A)
                <ul>
                    <li>(a) The 5 Elements</li>
                    <li>(b) The Meridian Charts</li>
                    <li>(c) The Meridian Point Distribution & Connections </li>
                </ul>
            </li>
            <li>(B)
                <ul>
                    <li>(a) Acupunture: Some Historical Aspects & The Extraneous Meridian Points</li>
                    <li>(b) Dan Tien (丹田): The Accumulation & Storage of Chi </li>
                    <li>(c) Chi Flow & The Time Duration vs Total Meridian Points</li>
                    <li>(d) Tattoo & Body Piercings, etc.</li>
                </ul>
            </li>
        </ul>
    </ul>
    </p>

    <br>
    <p>
    <ul>
        <li>(6) Tai Chi Principles</li>
        <ul>
            <li>(A) <a href="/taichi/nineAspects">Physical Aspects of Tai Chi Postures</a></li>
            <li>(B) <a href="/taichi/eightPrinciples">Principles Governing Forms & Movements</a></li>
        </ul>
    </ul>
    </p>

    <br>
    <p>
    <ul>
        <li>(7) Diet & Nutrition</li>
        <ul>
            <li>(a) Refueling</li>
            <li>(b) Blood Types</li>
        </ul>
    </ul>
    </p>
    <br>

    <p>
    <ul>
        <li>(8) Meditation: Techniques and Chakras</li>
    </ul>
    </p>
    <br>
    <p>
    <ul>
        <li>(9) Misc. Programs, IQ Program, etc.</li>
    </ul>
    </p>
</form:form>


<jsp:include page="includes/footer.jsp"/>
