<%--
    Document   : user_list
    Created on : 23.10.2012, 19:35:07
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Users"
                       pageid="users">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.LoginActionBean"
                      class="ui-btn-left">
            <stripes:label name="label.administration" />
        </stripes:link>
        <h2>
            <stripes:label name="label.users" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview"
            data-filter="true"
            data-filter-placeholder="Search user...">
            <c:forEach items="${actionBean.roles}" var="role" >
                <li data-role="list-divider">
                    <c:out value="${role.name}" />
                </li>
                <c:forEach items="${actionBean.users}" var="user" >
                    <c:if test="${user.role.equals(role.id)}">
                        <li>
                            <c:out value="${user.name}" />
                        </li>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>

