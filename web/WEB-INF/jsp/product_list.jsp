<%--
    Document   : productcategory_view
    Created on : Apr 1, 2013, 11:34:53 AM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="${actionBean.productCategory.name} - Categories"
                       pageid="products">

    <stripes:layout-component name="header">
        <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductCategoryActionBean"
                      event="list"
                      class="ui-btn-left">
            <stripes:label name="label.productcategories" />
        </stripes:link>
        <h2>
            <c:out value="${actionBean.productCategory.name}" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview" data-filter="true">
            <c:forEach items="${actionBean.products}" var="product" >
                <li>
                    <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                                  event="view">
                        <stripes:param name="productRef" value="${product.reference}" />
                        <c:out value="${product.name}" />
                        <span class="ui-li-aside">
                            <stripes:format value="${product.priceSellTax}"
                                            formatType="currency" />
                        </span>
                    </stripes:link>
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
