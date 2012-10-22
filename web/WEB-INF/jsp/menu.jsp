<%--
    Document   : menu
    Created on : Oct 11, 2012, 4:07:17 PM
    Author     : Andrey Svininykh
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Login"
                       pageid="login">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                      event="list"
                      class="ui-btn-right">
            <stripes:label name="button.customers" />
        </stripes:link>
    </stripes:layout-component>

    <c:if test="${actionBean.loginUser != null}">
        <stripes:layout-component name="content">
            <h1>
                <stripes:label name="message.hello" />
                <c:out value="${actionBean.loginUser.name}" />!
            </h1>
        </stripes:layout-component>
    </c:if>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
