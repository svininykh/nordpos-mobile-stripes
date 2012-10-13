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
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>NORD POS mobile - Welcome - <c:out value="${actionBean.application.id}" /> - <c:out value="${actionBean.application.version}" /></title>

        <link rel="stylesheet" href="<c:url value='/css/jquery.mobile-1.1.1.min.css'/>" />
        <script src="<c:url value='/js/jquery.min.js'/>"></script>
        <script src="<c:url value='/js/jquery.mobile-1.2.0.min.js'/>"></script>
    </head>

    <body>
        <div data-role="page" id="first">
            <div data-theme="b" data-role="header">
               <a data-role="button" data-transition="fade" href="<c:url value='/jsp/login.jsp'/>" data-icon="arrow-r" data-iconpos="right" class="ui-btn-right">
                    <stripes:label name="button.login"/>
                </a>
                <h2>
                    NORD POS mobile
                </h2>
            </div>
            <div data-role="content" style="padding: 15px" align="center">
                <h1><stripes:label name="message.welcome" /> <c:out value="${actionBean.application.name}" />!</h1>
            </div>

            <div data-theme="b" data-role="footer">
                <h2>
                    2012
                </h2>
            </div>
        </div>
    </body>
</html>
