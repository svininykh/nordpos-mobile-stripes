<%--
    Document   : login
    Created on : 09.10.2012, 18:51:17
    Author     : Andrey Svininykh
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
        <h1>Hello ${actionBean.loginUser.role} ${actionBean.loginUser.name}!</h1>

        <stripes:form beanclass="com.nordpos.mobile.stripes.action.LoginActionBean" focus="">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><stripes:text name="loginName"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><stripes:password name="loginPassword"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <stripes:submit name="login" value="Login"/>
                    </td>
                </tr>
            </table>
        </stripes:form>
    </body>
</html>
