<%-- 
    Document   : productcategory_view
    Created on : Apr 1, 2013, 11:34:53 AM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Products"
                       pageid="products">

    <stripes:layout-component name="header">
        <stripes:link href="ProductCatalog.action"
                      class="ui-btn-left">
            <stripes:label name="label.productcategories" />
        </stripes:link>
        <h2>
            <stripes:label name="label.products" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview" data-filter="true">
            <c:forEach items="${actionBean.products}" var="product" >
                <li>
                    <c:out value="${product.name}" />
                    <span class="ui-li-count">
                        <c:out value="${product.priceSell.toString()}" />
                    </span>                        
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
