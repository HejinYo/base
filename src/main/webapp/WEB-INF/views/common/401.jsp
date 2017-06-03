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
<!-- start: 404 -->
<div class="error-full-page">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 page-error">
                <div class="error-number text-azure">
                    401
                </div>
                <div class="error-details col-sm-6 col-sm-offset-3">
                    <h3>${message}</h3>
                    <p>
                        Unfortunately the page you were looking for could not be found.
                        <br>
                        It may be temporarily unavailable, moved or no longer exist.
                        <br>
                        Check the URL you entered for any mistakes and try again.
                        <br>
                        <a href="index.html" class="btn btn-red btn-return">
                            Return home
                        </a>
                        <br>
                        Still no luck?
                        <br>
                        Search for whatever is missing, or take a look around the rest of our site.
                    </p>
                    <form action="#">
                        <div class="input-group">
                            <input type="text" placeholder="keyword..." size="16" class="form-control">
                            <span class="input-group-btn">
										<button class="btn btn-azure">
											Search
										</button> </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<!-- end: BODY -->
</html>