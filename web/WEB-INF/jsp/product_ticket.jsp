<%--
    Document   : ticket_view
    Created on : Apr 2, 2013, 11:37:19 AM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Sell - ${actionBean.product.name}"
                       pageid="ticket">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                      event="view"
                      class="ui-btn-left">
            <stripes:param name="productRef" value="${actionBean.product.reference}" />
            <c:out value="${actionBean.product.name}" />
        </stripes:link>

        <h2>
            <stripes:label name="label.sell" />
        </h2>

        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                      event="ticket"
                      class="ui-btn-right">
            <stripes:param name="productRef" value="${actionBean.product.reference}" />
            <stripes:format value="${actionBean.product.priceSellTax}"
                            formatType="currency" />
        </stripes:link>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <table summary="Information about sell product.">
            <tbody>
                <tr>
                    <th scope="row"><stripes:label name="label.product.category.name" /></th>
                    <td><c:out value="${actionBean.productCategory.name}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.name" /></th>
                    <td><c:out value="${actionBean.product.name}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.pricesell" /></th>
                    <td>
                        <stripes:format value="${actionBean.product.priceSell}"
                                        formatType="currency" />
                    </td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.tax.name" /></th>
                    <td><c:out value="${actionBean.productTaxCategory.name}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.tax.rate" /></th>
                    <td>
                        <stripes:format value="${actionBean.product.taxRate}"
                                        formatType="percentage" />
                    </td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.tax.amount" /></th>
                    <td>
                        <stripes:format value="${actionBean.product.taxAmount}"
                                        formatType="currency" />
                    </td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.priceselltax" /></th>
                    <td>
                        <stripes:format value="${actionBean.product.priceSellTax}"
                                        formatType="currency" />
                    </td>
                </tr>
            </tbody>
        </table>

    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>