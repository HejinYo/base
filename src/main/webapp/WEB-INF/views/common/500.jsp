<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- Template Name: Clip-Two - Responsive Admin Template build with Twitter Bootstrap 3.x | Author: ClipTheme -->
<!--[if IE 8]><html class="ie8" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html lang="en">
	<!--<![endif]-->
	<!-- start: HEAD -->
	<!-- start: HEAD -->
    <head>
        <title>Clip-Two - Responsive Admin Template</title>
        <!-- start: META -->
        <!--[if IE]>
        <meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1"/><![endif]-->
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta content="" name="description"/>
        <meta content="" name="author"/>
        <!-- end: META -->
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
    </head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body>
		<!-- start: 500 -->
		<div class="error-full-page" >
			<div class="container">
				<div class="row">
					<div class="col-sm-12 page-error">
						<div class="error-number text-red">
							500
						</div>
						<div class="error-details col-sm-6 col-sm-offset-3">
							<h3>系统错误：${message}</h3>
							<p>
								Something's wrong!
								<br>
								It looks as though we've broken something on our system.
								<br>
								Don't panic, we are fixing it! Please come back in a while.
							</p>
                            <a>
                                <h3 id="showInfo">${msg}</h3>
                            </a>
						</div>

                        <div id="info" style="margin-top: 170px;display:none;">
                            <p style="padding-left: 15%;text-align:left;">${info}</p>
                        </div>
					</div>
				</div>
			</div>
		</div>
		<!-- end: 500 -->
	</body>
    <script type="application/javascript">
        $(function () {
            $("#showInfo").click(function () {
                var info  = $("#info").css("display");
                if(info == "none"){
                    $("#info").css("display","");
                }else{
                    $("#info").css("display","none");
                }
            })
        });
    </script>
	<!-- end: BODY -->
</html>

