<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>HejinYo | Fighting !!!</title>
    <!-- 告诉浏览器响应屏幕宽度 -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="resources/plugins/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="resources/plugins/ionicons/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE皮肤. 选择皮肤从 css/skins 文件夹，而不是下载所有的，以减少负载. -->
    <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="resources/plugins/iCheck/flat/blue.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries  HTML5 Shim和Respond.js IE8支持HTML5元素和媒体查询-->
    <!-- WARNING: Respond.js doesn't work if you view the page via file://  如果通过file：//  查看页面，Respond.js将无法正常工作-->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div class="wrapper">
    <header class="main-header">
        <!-- Logo -->
        <a href="resources/index.html" class="logo">
            <!-- 侧边栏的 mini logo 50x50 像素 -->
            <span class="logo-mini"><b>H</b>j<b>Y</b></span>
            <!-- 常规 Logo -->
            <span class="logo-lg"><b>Hejin</b>Yo</span>
        </a>
        <!-- Start Header Navbar 标题导航栏: 样式可以在header.less中找到 -->
        <nav class="navbar navbar-static-top">
            <!-- Start 侧边栏切换按钮-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span> <!-- 切换导航文字，sr-only 表示屏幕阅读器才会显示 -->
            </a>
            <!-- End 侧边栏切换按钮-->
            <!-- Start 右上角 用户菜单-->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages 消息: style 可以在dropdown.less中找到-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有 4 条消息</li>
                            <li>
                                <!-- inner menu: 包含实际数据 -->
                                <ul class="menu">
                                    <li><!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                支持团队
                                                <small><i class="fa fa-clock-o"></i> 5分钟</small>
                                            </h4>
                                            <p>为什么不买新的 awesome 主题?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看所有消息</a></li>
                        </ul>
                    </li>
                    <!-- Notifications 通知 : style 可以在dropdown.less中找到-->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">您有10个通知</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 今天有5名新成员参加
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">查看全部</a></li>
                        </ul>
                    </li>
                    <!-- Tasks 任务: style 可以在dropdown.less中找到 -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有9个任务</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li><!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                设计一些按钮
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% 完成</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">查看所有任务</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account 用户帐号: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${username}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image 用户图像 -->
                            <li class="user-header">
                                <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                                <p>
                                    HejinYo - Web开发人员
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <!-- Menu Body 菜单主体-->
                            <li class="user-body">
                                <div class="row">
                                    <div class="col-xs-4 text-center">
                                        <a href="#">粉丝</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">Sales</a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#">好友</a>
                                    </div>
                                </div>
                                <!-- /.row -->
                            </li>
                            <!-- Menu Footer 菜单页脚-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">简介</a>
                                </div>
                                <div class="pull-right">
                                    <a href="logout" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- 控制侧栏切换按钮 -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
            <!-- End 右上角 用户菜单-->
        </nav>
        <!-- End Header Navbar 标题导航栏 -->
    </header>

    <!-- Start 左侧栏. 包含徽标和侧边栏 -->
    <aside class="main-sidebar">
        <!-- sidebar 侧边栏: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel 侧边栏的用户面板-->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>HejinYo</p>
                    <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>
            <!-- search form 搜索框-->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="搜索...">
                    <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->
            <!-- sidebar menu 侧边栏菜单: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">主导航</li>
                <li class="active"><a href="javascript:void(0);" onclick="JavaScript:openPage('resources/pages/examples/iframe_profile.html');" ><i class="fa fa-user"></i> <span>我的信息</span></a></li>
                <li><a href="javascript:void(0);" onclick="JavaScript:openPage('resources/documentation/iframe_document.html');" ><i class="fa fa-book"></i> <span>帮助文档</span></a></li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-share"></i> <span>多级菜单</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
                        <li>
                            <a href="#"><i class="fa fa-circle-o"></i> 一级
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-circle-o"></i> 二级</a></li>
                                <li>
                                    <a href="#"><i class="fa fa-circle-o"></i> 二级
                                        <span class="pull-right-container">
                                            <i class="fa fa-angle-left pull-right"></i>
                                        </span>
                                    </a>
                                    <ul class="treeview-menu">
                                        <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
                                        <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
                    </ul>
                </li>
                <li class="header">标签</li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-laptop"></i> <span>测试</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a id="myLink1"><i class="fa fa-circle-o text-red"></i> <span>方法1</span></a></li>
                        <li><a id="myLink2"><i class="fa fa-circle-o text-blue"></i> <span>方法2</span></a></li>
                        <li><a id="myLink3"><i class="fa fa-circle-o text-green"></i> <span>切换3</span></a></li>
                        <li><a id="myLink4"><i class="fa fa-circle-o text-yellow"></i> <span>切换4</span></a></li>
                        <li><a id="myLink5"><i class="fa fa-circle-o text-orange"></i> <span>关闭5</span></a></li>
                    </ul>
                </li>
                <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>重要</span></a></li>


            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- End 左侧栏 -->

    <!-- Start Content Wrapper. 页面主体：包含页面内容 -->
    <div class="content-wrapper">
        <!-- Content Header (页面标题) -->
        <%--<section class="content-header">
            <h1>
                仪表板
                <small>控制面板</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">仪表板</li>
            </ol>
        </section>--%>

        <!-- 主要内容 -->
        <!-- <section class="content"> -->
        <section>
            <!-- Small boxes (Stat box) -->
            <div class="row">
                <div class="col-md-12 col-xs-12" >
                    <div id="main-content" ></div>
                </div>
            </div>
            <!-- /.row -->
        </section>
    </div>
    <!-- /.content-wrapper -->

    <!-- 内容页脚 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy; 2017-2018 <a href="http://weibo.com/234992665">HejinYo</a>.</strong> All rights
        reserved.
    </footer>
    <!-- End Content Wrapper. 页面主体：包含页面内容 -->

    <!-- Start Control Sidebar 控制侧边栏 -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs 创建选项卡 -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes 标签窗格 -->
        <div class="tab-content">
            <!-- Home tab content 主页标签内容 -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h4 class="control-sidebar-heading">近期活动</h4>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Nora 加入邮件列表</h4>
                                <p>nora@example.com</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0)">
                            <i class="menu-icon fa fa-file-code-o bg-green"></i>
                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>
                                <p>执行时间5秒</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->
                <h4 class="control-sidebar-heading">任务进度</h4>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:void(0)">
                            <h4 class="control-sidebar-subheading">
                                更新简历
                                <span class="label label-success pull-right">95%</span>
                            </h4>
                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->
            </div>
            <!-- /.tab-pane -->

            <!-- Stats tab content 面板内容  -->
            <div class="tab-pane" id="control-sidebar-stats-tab">统计标签内容</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h4 class="control-sidebar-heading">常规设置</h4>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            报告面板使用
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                        <p>
                            有关此常规设置选项的一些信息
                        </p>
                    </div>
                    <!-- /.form-group -->
                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            在帖子中显示作者姓名
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                        <p>
                            允许用户在博客帖子中显示他的名字
                        </p>
                    </div>
                    <!-- /.form-group -->
                    <h4 class="control-sidebar-heading">聊天设置</h4>
                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            在线显示我
                            <input type="checkbox" class="pull-right" checked>
                        </label>
                    </div>
                    <!-- /.form-group -->
                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            关闭通知
                            <input type="checkbox" class="pull-right">
                        </label>
                    </div>
                    <!-- /.form-group -->
                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            删除聊天记录
                            <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                        </label>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- End Control Sidebar 控制侧边栏 -->
    <!-- Add the sidebar's background. This div must be placed mmediately after the control sidebar
          添加侧边栏的背景。 这个div必须被放置 紧随控制侧栏 -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 2.2.3 -->
<script src="resources/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="resources/plugins/jQueryUI/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip 使用Bootstrap工具提示解决jQuery UI工具提示中的冲突-->
<script> $.widget.bridge('uibutton', $.ui.button); </script>
<!-- Bootstrap 3.3.6 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- jQuery Knob Chart 进度条插件-->
<script src="resources/plugins/knob/jquery.knob.js"></script>
<!-- Slimscroll 滚动条插件-->
<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- pym js from iframe插件 -->
<script src="resources/plugins/pym/pym.js"></script>
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<%--<script src="resources/dist/js/demo.js"></script>--%>
<script src="resources/dist/js/core/main.js"></script>
</body>
</html>
