<%--
    Document   : menu
    Created on : Oct 11, 2012, 4:07:17 PM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Administration"
                       pageid="administration">

    <stripes:layout-component name="header">
        <stripes:link href="/stripes/action/Application.action"
                      class="ui-btn-left">
            <stripes:label name="label.title" />
        </stripes:link>
        <c:choose>
            <c:when test="${actionBean.loginUser.id != null}">
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
                <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductCatalogActionBean"
                              event="list">
                    <stripes:label name="label.productcategories" />
                    <p>
                        <stripes:label name="description.productcategories" />
                    </p>
                </stripes:link>
                <span class="ui-li-count">${actionBean.countProductCategories}</span>
            </li>     
            <li>
                <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                              event="list">
                    <stripes:label name="label.customers" />
                    <p>
                        <stripes:label name="description.customers" />
                    </p>
                </stripes:link>
                <span class="ui-li-count">${actionBean.countCustomers}</span>
            </li>
            <li>
                <stripes:link beanclass="com.nordpos.mobile.stripes.action.UserListActionBean"
                              event="list">
                    <stripes:label name="label.users" />
                    <p>
                        <stripes:label name="description.users" />
                    </p>
                </stripes:link>
                <span class="ui-li-count">${actionBean.countUsers}</span>
            </li>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
