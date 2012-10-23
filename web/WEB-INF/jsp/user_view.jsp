<%--
    Document   : user_view
    Created on : 23.10.2012, 19:43:03
    Author     : svininykh-av
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="${actionBean.user.name} - Users"
                       pageid="user">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.UserListActionBean"
                      class="ui-btn-left">
            <stripes:label name="label.users" />
        </stripes:link>
        <h2>
            ${actionBean.user.name}
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <table summary="Information about select user.">
            <tbody>
                <tr>
                    <th scope="row">ID:</th>
                    <td>${actionBean.user.id}</td>
                </tr>
            </tbody>
        </table>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
