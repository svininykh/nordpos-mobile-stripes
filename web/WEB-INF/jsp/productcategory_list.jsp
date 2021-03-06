<%--
    Document   : productcategory_list
    Created on : Apr 1, 2013, 10:38:41 AM
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"
                       title="Products"
                       pageid="products">

    <stripes:layout-component name="header">
        <stripes:link href="Login.action"
                      class="ui-btn-left">
            <stripes:label name="label.administration" />
        </stripes:link>
        <h2>
            <stripes:label name="label.productcategories" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <ul data-role="listview" data-filter="true">
            <c:forEach items="${actionBean.productCategories}" var="productcategory" >
                <li>
                    <stripes:link beanclass="com.nordpos.mobile.stripes.action.ProductActionBean"
                                  event="list">
                        <stripes:param name="productCategoryId" value="${productcategory.id}" />

                        <img src="${pageContext.servletContext.contextPath}/ProductCategory.action?eventName=display&categoryId=${productcategory.id}"
                             alt="${productcategory.name}"
                             class="ui-li-thumb" />

                        <c:out value="${productcategory.name}" />
                        <span class="ui-li-count">
                            <c:out value="${productcategory.countProducts}" />
                        </span>
                    </stripes:link>
                </li>
            </c:forEach>
        </ul>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
