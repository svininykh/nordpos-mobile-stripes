<%--
    Document   : menu
    Created on : Oct 11, 2012, 4:07:17 PM
    Author     : Andrey Svininykh
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Administration"
                       pageid="administration">

    <stripes:layout-component name="header">
        <c:if test="${actionBean.loginUser != null}">
            <h2>
                <stripes:label name="message.hello" />
                <c:out value="${actionBean.loginUser.name}" />!
            </h2>
        </c:if>

        <c:if test="${actionBean.loginUser == null}">
            <h2>
                <stripes:label name="header.administration" />
            </h2>
        </c:if>
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                      event="list"
                      class="ui-btn-right">
            <stripes:label name="button.customers" />
        </stripes:link>
    </stripes:layout-component>

    <stripes:layout-component name="content">

    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
