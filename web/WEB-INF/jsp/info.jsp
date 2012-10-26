<%--
    Document   : info
    Created on : 24.10.2012, 11:12:08
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Information"
                       pageid="info">

    <stripes:layout-component name="header">
        <stripes:link href="/stripes/action/Application.action"
                      class="ui-btn-left">
            <stripes:label name="label.title" />
        </stripes:link>
        <h2>
            <stripes:label name="label.information" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">

        <c:if test="${actionBean.connectionStatus != true}">
            <h2>
                <stripes:label name="message.db.connection.fail" />
            </h2>
            <p>
                <stripes:label name="description.check.db.parameters" />
            </p>
        </c:if>

        <table summary="Information about servlet.">
            <tbody>
                <tr>
                    <th scope="row"><stripes:label name="label.info.java.version" /></th>
                    <td><c:out value="${actionBean.javaVersion}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.info.os" /></th>
                    <td><c:out value="${actionBean.operationSystem}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.info.server" /></th>
                    <td><c:out value="${actionBean.serverInfo}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.info.language" /></th>
                    <td><c:out value="${actionBean.language}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.info.country" /></th>
                    <td><c:out value="${actionBean.country}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.db.driver" /></th>
                    <td><c:out value="${actionBean.dataBaseDriver}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.db.url" /></th>
                    <td><c:out value="${actionBean.dataBaseURL}" /></td>
                </tr>
            </tbody>
        </table>

    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>
</stripes:layout-render>
