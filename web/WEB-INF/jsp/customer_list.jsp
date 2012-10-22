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
        <h2>
            <stripes:label name="button.customers" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview">
            <c:forEach items="${actionBean.customers}" var="customer" >
                <li><c:out value="${customer.name}" />
                    <ul data-role="listview">
                        <li><c:out value="${customer.id}" /></li>
                        <li><c:out value="${customer.searchKey}" /></li>
                        <li><c:out value="${customer.taxId}" /></li>
                    </ul>
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
