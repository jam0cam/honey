<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title><c:out value="${pageTitle}"/> </title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/mystyle.css">

</head>
<body>
<div id="nav-bar" class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <sec:authorize access="authenticated" var="authenticated"/>
            <a class="brand" href="/home">Honey</a>
            <div class="nav-collapse">
                <ul class="nav">
                    <c:choose>
                        <c:when test="${authenticated}">
                            <li><a href="/tt/newGame">New Game</a></li>
                        </c:when>
                    </c:choose>
                    <li><a href="/tt">Stats</a></li>
                    <li><a href="/about">About</a></li>
                </ul>
            </div>
            <div id="nav-account" class="nav-collapse pull-right">
                <ul class="nav">

                    <c:choose>
                        <c:when test="${authenticated}">
                            <li id="greeting"><a>Hi <sec:authentication property="principal.name" /> !</a></li>
                            <li><a href="/manage">Profile</a></li>
                            <li><a id="navLogoutLink" href="/logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a id="navSignupLink" href="/register">Register</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>

</div>

<div class="container">
