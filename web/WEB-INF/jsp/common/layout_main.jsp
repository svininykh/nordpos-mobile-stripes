<%--
    Document   : layout_main
    Created on : 26.10.2012, 20:39:00
    Author     : Andrey Svininykh (svininykh@gmail.com)
    Copyright  : Nord Trading Ltd.
    License    : Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0.html)
--%>

<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<stripes:layout-definition>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <title>${title} - NORD POS mobile</title>
            <link rel="stylesheet" href="<c:url value='/css/jquery.mobile-1.2.0.min.css'/>" />
            <link rel="icon" type="image/png" href="<c:url value='/icon.png' />" />
            <script src="<c:url value='/js/jquery-1.8.2.min.js'/>"></script>
            <script src="<c:url value='/js/jquery.mobile-1.2.0.min.js'/>"></script>
            <style type="text/css">
                table { width:100%; }
                table caption { text-align:left;  }
                table thead th { text-align:left; border-bottom-width:1px; border-top-width:1px; }
                table th, td { text-align:left; padding:6px;}
            </style>
        </head>
        <body>
            <div data-role="page" id="${pageid}">
                <div data-theme="b" data-role="header">
                    <stripes:layout-component name="header"/>
                </div>
                <div data-role="content" style="padding: 15px" align="center">
                    <stripes:layout-component name="content"/>
                </div>

                <div data-theme="b" data-role="footer">
                    <h2>
                        2013
                    </h2>
                    <stripes:layout-component name="footer"/>
                </div>
            </div>
        </body>
    </html>
</stripes:layout-definition>

