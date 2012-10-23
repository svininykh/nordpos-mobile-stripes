<%--
    Document   : customer_view
    Created on : 23.10.2012, 12:50:09
    Author     : svininykh-av
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="${actionBean.customer.name} - Customers"
                       pageid="customer">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.CustomerListActionBean"
                      class="ui-btn-left">
            <stripes:label name="label.customers" />
        </stripes:link>
        <h2>
            ${actionBean.customer.name}
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <table summary="Information about select customer.">
            <tbody>
                <tr>
                    <th scope="row">ID:</th>
                    <td>${actionBean.customer.id}</td>
                </tr>
                <tr>
                    <th scope="row">Key:</th>

                    <td>${actionBean.customer.searchKey}</td>
                </tr>
                <tr>
                    <th scope="row">Tax ID:</th>
                    <td>${actionBean.customer.taxId}</td>
                </tr>
            </tbody>
        </table>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
