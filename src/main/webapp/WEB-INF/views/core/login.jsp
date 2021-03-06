<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta content="" name="description"/>
    <meta content="" name="author"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="此代码内容为超萌的猫头鹰登录界面"/>
    <link rel="icon" href="resources/assets/images/core/favicon.ico" type="image/x-icon"/>
    <link rel="shortcut icon" href="resources/assets/images/core/favicon.ico" type="image/x-icon"/>
    <title>用户登录</title>
    <link rel="stylesheet" href="resources/vendor/bootstrap/css/bootstrap.min.css" type="text/css"/>
    <link rel="stylesheet" href="resources/vendor/fontawesome/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="resources/vendor/toastr/toastr.min.css" media="screen">
    <link rel="stylesheet" href="resources/vendor/poshytip/src/tip-blue/tip-blue.css" type="text/css"/>
    <link rel="stylesheet" href="resources/assets/css/core/login.css"/>
</head>
<body>
<!-- begin -->
<div id="login">
    <div class="wrapper">
        <div class="login">
            <form id="form" action="" method="post" class="container offset1 loginform">
                <div id="owl-login">
                    <div id="hand" class="hand"></div>
                    <div class="hand hand-r"></div>
                    <div class="arms">
                        <div class="arm"></div>
                        <div class="arm arm-r"></div>
                    </div>
                </div>
                <div class="pad">
                    <div class="control-group">
                        <div class="controls">
                            <i for="username" class="control-label fa fa-user"></i>
                            <input id="username" maxlength="16" type="text" name="username" placeholder="用户名" tabindex="1" autofocus="autofocus" class="form-control input-medium">
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <i for="password" class="control-label fa fa-lock"></i>
                            <input id="password" maxlength="16" type="password" placeholder="密码" tabindex="2" class="form-control input-medium">
                            <input id="loginpw" name="loginpw" type="hidden">
                            <a class="forgot" href="login_forgot.html" tabindex="-2">
                                忘记密码
                            </a>
                        </div>
                    </div>
                    <div style="position: relative">
                        <div class="control-group">
                            <div class="controls" style="margin-right: 130px;">
                                <i for="verifi" class="control-label fa fa-key"></i>
                                <input id="verifi" maxlength="4" type="text" name="verifyCode" placeholder="验证码" tabindex="3" class="form-control input-medium">
                                <span for="verifi" class="glyphicon form-control-feedback"></span>
                            </div>
                        </div>
                        <a class="refresh" title="点击刷新" style="cursor:pointer">
                            <img id="checkImg" src="verifyImg">
                        </a>
                    </div>
                    <div>
                        <div class="checkbox clip-check check-primary">
                            <input type="hidden" id="rememberMe" name="rememberMe" value="false">
                            <input type="checkbox" id="remember" value="false">
                            <label for="remember">
                                保持登录状态
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <a href="#" class="btn pull-left btn-left btn-link text-muted">还没有账户? 注册</a>
                    <button type="button" disabled="disabled" class="btn btn-primary">登录</button>
                </div>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="resources/vendor/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/vendor/toastr/toastr.min.js"></script>
    <script type="text/javascript" src="resources/vendor/poshytip/src/jquery.poshytip.min.js"></script>
    <script type="text/javascript" src="resources/vendor/jquery/jquery.json.js"></script>
    <script type="text/javascript" src="resources/vendor/jquery/jquery.base64.js"></script>
    <script type="text/javascript" src="resources/assets/common/jquery-utils.js"></script>
    <script type="text/javascript" src="resources/assets/js/core/login.js"></script>
</div>
<!-- end -->
</body>
</html>