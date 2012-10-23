<%--
    Document   : customer_list
    Created on : 14.10.2012, 20:47:14
    Author     : svininykh-av
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Customers"
                       pageid="customers">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.LoginActionBean"
                      class="ui-btn-left">
            <stripes:label name="header.administration" />
        </stripes:link>
        <h2>
            <stripes:label name="button.customers" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview">
            <c:forEach items="${actionBean.customers}" var="customer" >
                <li>
                    <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                                  event="view">
                        <stripes:param name="customerId" value="${customer.id}" />
                        <c:out value="${customer.name}" />
                    </stripes:link>
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
