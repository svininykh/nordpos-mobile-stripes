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
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <h1>Hello <c:out value="${actionBean.loginUser.name}" />!</h1>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
