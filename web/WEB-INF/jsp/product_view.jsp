<%--
    Document   : product_view
    Created on : Apr 1, 2013, 5:19:50 PM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="${actionBean.product.name} - ${actionBean.productCategory.name}"
                       pageid="product">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                      event="list"
                      class="ui-btn-left">
            <stripes:param name="productCategoryId" value="${actionBean.product.category}" />
            <c:out value="${actionBean.productCategory.name}" />
        </stripes:link>

        <h2>
            <c:out value="${actionBean.product.name}" />
        </h2>

        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                      event="ticket"
                      class="ui-btn-right">
            <stripes:param name="productRef" value="${actionBean.product.reference}" />
            <stripes:label name="label.sell" />
        </stripes:link>

    </stripes:layout-component>

    <stripes:layout-component name="content">
        <table summary="Information about select product.">
            <tbody>
                <tr>
                    <td rowspan="3">
                        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                                      event="image">
                            <stripes:param name="productRef" value="${actionBean.product.reference}" />
                            <img src="${pageContext.servletContext.contextPath}/Product.action?eventName=display&productRef=${actionBean.product.reference}"
                                 alt="${actionBean.product.name}" />
                        </stripes:link>
                    </td>
                    <th scope="row"><stripes:label name="label.product.reference" /></th>
                    <td><c:out value="${actionBean.product.reference}" /></td>
                </tr>
                <tr>
                    <th scope="row"><stripes:label name="label.product.code" /></th>
                    <td><c:out value="${actionBean.product.code}" /></td>
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
