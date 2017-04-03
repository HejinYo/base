<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <!-- start: META -->
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1"/><![endif]-->
    <meta charset="utf-8"/>
    <meta http-equiv="keywords" content="HejinYo">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <link rel="icon" href="<%=basePath%>resources/images/common/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="<%=basePath%>resources/images/common/favicon.ico" type="image/x-icon"/>
    <!-- end: META -->
    <!-- start: GOOGLE FONTS -->
    <link rel="stylesheet" href="<%=basePath%>resources/css/common/google-fonts.css" type="text/css"/>
    <!-- end: GOOGLE FONTS -->
    <!-- start: MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/bootstrap/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/fontawesome/css/font-awesome.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/themify-icons/themify-icons.min.css" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/animate.css/animate.min.css" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/perfect-scrollbar/perfect-scrollbar.min.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/switchery/switchery.min.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="<%=basePath%>/resources/vendor/toastr/toastr.css" media="screen">
    <link rel="stylesheet" href="<%=basePath%>resources/vendor/poshytip/src/tip-blue/tip-blue.css" type="text/css"/>
    <%--<link rel="stylesheet" href="<%=basePath%>resources/vendor/jquery-ui/jquery-ui.css" >--%>
    <!-- end: MAIN CSS -->
    <!-- start: CLIP-TWO CSS -->
    <link rel="stylesheet" href="<%=basePath%>resources/css/system/styles.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/css/system/plugins.css"/>
    <link rel="stylesheet" href="<%=basePath%>resources/css/system/themes/theme-1.css" id="skin_color"/>
    <!-- end: CLIP-TWO CSS -->

    <!-- start: MAIN JAVASCRIPTS -->
    <script type="text/javascript" src="<%=basePath%>resources/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/modernizr/modernizr.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/jquery-cookie/jquery.cookie.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/switchery/switchery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/toastr/toastr.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/poshytip/src/jquery.poshytip.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/vendor/jquery/jquery.json.js"></script>
    <script type="text/javascript" src="<%=basePath%>resources/js/common/jquery-utils.js"></script>
    <!-- end: MAIN JAVASCRIPTS -->

</head>
</html>
