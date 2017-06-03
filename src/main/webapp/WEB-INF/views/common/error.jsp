<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <base href="<%=basePath%>"/>
    <!-- start: HEAD -->
    <link href="resources/assets/fonts/google-fonts.css" rel="stylesheet" type="text/css"/>
    <!-- end: GOOGLE FONTS -->
    <!-- start: MAIN CSS -->
    <link rel="stylesheet" href="resources/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/vendor/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/vendor/themify-icons/themify-icons.min.css">
    <link href="resources/vendor/animate.css/animate.min.css" rel="stylesheet" media="screen">
    <link href="resources/vendor/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen">
    <link href="resources/vendor/switchery/switchery.min.css" rel="stylesheet" media="screen">
    <!-- end: MAIN CSS -->
    <!-- start: CLIP-TWO CSS -->
    <link rel="stylesheet" href="resources/assets/css/styles.css">
    <link rel="stylesheet" href="resources/assets/css/plugins.css">
    <link rel="stylesheet" href="resources/assets/css/themes/theme-1.css" id="skin_color"/>
    <!-- end: HEAD -->
</head>
<!-- start: BODY -->
<body>
<!-- start: 500 -->
<div class="error-full-page">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 page-error">
                <div class="error-number text-red">
                    Error
                </div>
                <div class="error-details col-sm-6 col-sm-offset-3">
                    <h3>${message}</h3>
                    <p>
                        Something's wrong!
                        <br>
                        It looks as though we've broken something on our system.
                        <br>
                        Don't panic, we are fixing it! Please come back in a while.
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end: 500 -->
</body>
<!-- end: BODY -->
</html>

