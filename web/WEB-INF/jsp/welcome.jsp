<%--
    Document   : welcome
    Created on : 10.10.2012, 22:23:29
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Welcome"
                       pageid="welcome">

    <stripes:layout-component name="header">
        <h2>
            <stripes:label name="message.welcome" />
            <c:out value="${actionBean.application.name}" />
            <c:out value="${actionBean.application.version}" />!
        </h2>
        <stripes:link href="/stripes/action/Application.action"
                      event="info"
                      class="ui-btn-right">
            <stripes:label name="label.information" />
        </stripes:link>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <img src="<c:url value='/image/logo.png' />" alt="Company logo">
        <stripes:form beanclass="com.nordpos.mobile.stripes.action.LoginActionBean" focus="">
            <table summary="Enter user name and password.">
                <tbody>
                    <tr>
                        <th scope="row"><stripes:label name="label.login.name" /></th>
                        <td><stripes:text name="loginName"/></td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.login.password" /></th>
                        <td><stripes:password name="loginPassword"/></td>
                    </tr>
                </tbody>
                <tfoot>
                    <tr>
                        <th scope="row" colspan="2">
                            <stripes:submit name="login" />
                        </th>
                    </tr>
                </tfoot>
            </table>
        </stripes:form>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>
</stripes:layout-render>