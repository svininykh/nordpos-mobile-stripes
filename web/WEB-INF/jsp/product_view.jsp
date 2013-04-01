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
                       pageid="customer">

    <stripes:layout-component name="header">
        <stripes:link href="ProductCatalog.action"
                      class="ui-btn-left">
            <stripes:label name="label.products" />
        </stripes:link>
        <h2>
            ${actionBean.product.name}
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <div data-role="collapsible" data-collapsed="false">
            <h3><stripes:label name="label.product.general" /></h3>
            <table summary="General information about select product.">
                <tbody>
                    <tr>
                        <th scope="row"><stripes:label name="label.product.reference" /></th>
                        <td>${actionBean.product.reference}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.product.code" /></th>
                        <td>${actionBean.product.code}</td>
                    </tr>
                </tbody>
            </table>
        </div>
                    
        <div data-role="collapsible" data-collapsed="false">
            <h3><stripes:label name="label.product.prices" /></h3>
            <table summary="Prices of select product.">
                <tbody>
                    <tr>
                        <th scope="row"><stripes:label name="label.product.pricebuy" /></th>
                        <td>${actionBean.product.priceBuy}</td>
                    </tr>
                    <tr>
                        <th scope="row"><stripes:label name="label.product.pricesell" /></th>
                        <td>${actionBean.product.priceSell}</td>
                    </tr>
                </tbody>
            </table>
        </div>                    

    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
