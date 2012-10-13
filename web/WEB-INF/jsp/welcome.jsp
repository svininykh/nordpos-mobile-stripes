<%--
    Document   : welcome
    Created on : 10.10.2012, 22:23:29
    Author     : Andrey Svininykh
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Welcome"
                       pageid="welcome">

    <stripes:layout-component name="header">
        <a data-role="button" data-transition="fade" href="<c:url value='/WEB-INF/jsp/login.jsp'/>" data-icon="arrow-r" data-iconpos="right" class="ui-btn-right">
            <stripes:label name="button.login"/>
        </a>
    </stripes:layout-component>
    <stripes:layout-component name="content">
        <h1><stripes:label name="message.welcome" /> <c:out value="${actionBean.application.name}" />!</h1>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>
</stripes:layout-render>