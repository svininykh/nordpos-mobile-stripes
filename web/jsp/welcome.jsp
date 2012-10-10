<%--
    Document   : welcome
    Created on : 10.10.2012, 22:23:29
    Author     : Andrey Svininykh
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html>
    <stripes:form action="/stripes/action/Application.action">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NORD POS mobile - Welcome - <c:out value="${actionBean.results.id}" /> - <c:out value="${actionBean.results.version}" /></title>
    </head>

    <body>
        <h1>Welcome to <c:out value="${actionBean.results.name}" />!</h1>
    </body>
    </stripes:form>
</html>
