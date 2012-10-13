<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<stripes:layout-definition>
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1" />
            <title>${title} - <c:out value="${actionBean.application.id}" /> <c:out value="${actionBean.application.version}" /></title>
            <link rel="stylesheet" href="<c:url value='/css/jquery.mobile-1.1.1.min.css'/>" />
            <script src="<c:url value='/js/jquery.min.js'/>"></script>
            <script src="<c:url value='/js/jquery.mobile-1.2.0.min.js'/>"></script>
        </head>
        <body>
            <div data-role="page" id="${pageid}">
                <div data-theme="b" data-role="header">
                    <h2>
                        NORD POS mobile
                    </h2>
                    <stripes:layout-component name="header"/>
                </div>
                <div data-role="content" style="padding: 15px" align="center">
                    <stripes:layout-component name="content"/>
                </div>

                <div data-theme="b" data-role="footer">
                    <h2>
                        2012
                    </h2>
                    <stripes:layout-component name="footer"/>
                </div>
            </div>
        </body>
    </html>
</stripes:layout-definition>

