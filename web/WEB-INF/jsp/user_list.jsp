<%--
    Document   : user_list
    Created on : 23.10.2012, 19:35:07
    Author     : svininykh-av
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
        <ul data-role="listview">
            <c:forEach items="${actionBean.users}" var="user" >
                <li>
                    <stripes:link beanclass="com.nordpos.mobile.stripes.action.UserListActionBean"
                                  event="view">
                        <stripes:param name="userId" value="${user.id}" />
                        <c:out value="${user.name}" />
                    </stripes:link>
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>

