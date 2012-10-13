<%--
    Document   : login
    Created on : 09.10.2012, 18:51:17
    Author     : Andrey Svininykh
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Login"
                       pageid="login">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.WelcomeActionBean"
                      event="load"
                      class="ui-btn-left">
            Home
        </stripes:link>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <stripes:form beanclass="com.nordpos.mobile.stripes.action.LoginActionBean" focus="">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><stripes:text name="loginName"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><stripes:password name="loginPassword"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <stripes:submit name="login"/>
                    </td>
                </tr>
            </table>
        </stripes:form>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
