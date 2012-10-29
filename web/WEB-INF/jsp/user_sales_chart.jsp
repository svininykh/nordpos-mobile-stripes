<%--
    Document   : user_sales_chart
    Created on : 29.10.2012, 11:18:22
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%@page import="com.nordpos.mobile.stripes.chart.JqPlotSample" %>
<stripes:layout-render name="/WEB-INF/jsp/common/layout_chart.jsp"
                       title="Sales - Users"
                       pageid="usersales">

    <stripes:layout-component name="header">
        <h2>
            <stripes:label name="label.users.chart" />
        </h2>
    </stripes:layout-component>

    <stripes:layout-component name="content">
        <script class="code" type="text/javascript">

            $(document).ready(function () {
            <%=JqPlotSample.barChart(getServletContext(), "barChart")%>
            <%=JqPlotSample.pieChart(getServletContext(), "pieChart")%>
                });

        </script>
        <div>
            <div id="pieChart" style="margin-top:0px; margin-left:0px; width:300px; height:200px;"></div>
            <div id="barChart" style="margin-top:0px; margin-left:0px; width:300px; height:200px;"></div>
        </div>
    </stripes:layout-component>

    <stripes:layout-component name="footer">

    </stripes:layout-component>

</stripes:layout-render>
