<%--
    Document   : info
    Created on : 24.10.2012, 11:12:08
    Author     : svininykh-av
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Information"
                       pageid="info">

    <stripes:layout-component name="header">
        <stripes:link href="/stripes/action/Application.action"
                      event="back"
                      class="ui-btn-left">
            <stripes:label name="label.title" />
        </stripes:link>
        <h2>
            <stripes:label name="label.information" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">

        <h3><c:out value="${actionBean.country}" /></h3>
        <h3><c:out value="${actionBean.language}" /></h3>
        <h3><c:out value="${actionBean.serverInfo}" /></h3>
        <h3><c:out value="${actionBean.dataBaseDriver}" /></h3>
        <h3><c:out value="${actionBean.dataBaseURL}" /></h3>

    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>
</stripes:layout-render>
