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
        <div data-role="collapsible" data-collapsed="false">
            <h3><stripes:label name="label.customer.general" /></h3>
            <table summary="General information about select customer.">
                <tbody>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.id" /></th>
                        <td>${actionBean.customer.id}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.searchkey" /></th>
                        <td>${actionBean.customer.searchKey}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.taxid" /></th>
                        <td>${actionBean.customer.taxId}</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div data-role="collapsible">
            <h3><stripes:label name="label.customer.contact" /></h3>
            <table summary="Contact information about select customer.">
                <tbody>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.firstname" /></th>
                        <td>${actionBean.customer.firstName}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.lastname" /></th>
                        <td>${actionBean.customer.lastName}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.address" /></th>
                        <td>${actionBean.customer.address}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.address2" /></th>
                        <td>${actionBean.customer.address2}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.postal" /></th>
                        <td>${actionBean.customer.postal}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.city" /></th>
                        <td>${actionBean.customer.city}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.region" /></th>
                        <td>${actionBean.customer.region}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.country" /></th>
                        <td>${actionBean.customer.country}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.email" /></th>
                        <td>${actionBean.customer.email}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.phone" /></th>
                        <td>${actionBean.customer.phone}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.phone2" /></th>
                        <td>${actionBean.customer.phone2}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.customer.fax" /></th>
                        <td>${actionBean.customer.fax}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
