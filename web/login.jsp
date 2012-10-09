<%--
    Document   : login
    Created on : 09.10.2012, 18:51:17
    Author     : svininykh-av
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>

<%@taglib prefix="stripes" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NORD POS mobile - Login</title>
    </head>
    <body>
        <h1>Hello User!</h1>

        <stripes:form action="/stripes/action/Application.action">
            <table cellpadding="0" cellspacing="0" border="0" width="100%" class="dataTbl">

                <c:forEach items="${actionBean.results}" var="row" >
                    <tr>
                        <td><c:out value="${row.name}" /></td>
                        <td><c:out value="${row.version}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </stripes:form>
    </body>
</html>
