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
        <c:choose>
            <c:when test="${actionBean.loginUser != null}">
                <h2>
                    <stripes:label name="message.hello" />
                    <c:out value="${actionBean.loginUser.name}" />!
                </h2>
            </c:when>
            <c:otherwise>
                <h2>
                    <stripes:label name="label.administration" />
                </h2>
            </c:otherwise>
        </c:choose>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview">
            <li>
                <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                              event="list">
                    <stripes:label name="label.customers" />
                </stripes:link>
            </li>
            <li>
                <stripes:link beanclass="com.nordpos.mobile.stripes.action.UserListActionBean"
                              event="list">
                    <stripes:label name="label.users" />
                </stripes:link>
            </li>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
