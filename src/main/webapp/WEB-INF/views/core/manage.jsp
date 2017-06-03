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
	<!-- start: HEAD -->
	<head>
        <base href="<%=basePath%>"/>
		<title>HejinYo - Fighting!!!</title>
		<!-- start: META -->
		<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta content="" name="description" />
		<meta content="" name="author" />
		<!-- end: META -->
		<!-- start: GOOGLE FONTS -->
		<link href="resources/assets/fonts/google-fonts.css" rel="stylesheet" type="text/css" />
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
		<link rel="stylesheet" href="resources/assets/css/themes/theme-1.css" id="skin_color" />
		<!-- end: CLIP-TWO CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
	<body>
		<div id="app">
			<!-- sidebar -->
			<div class="sidebar app-aside" id="sidebar">
				<div class="sidebar-container perfect-scrollbar">
					<nav>
						<!-- start: SEARCH FORM -->
						<div class="search-form">
							<a class="s-open" href="#">
								<i class="ti-search"></i>
							</a>
							<form class="navbar-form" role="search">
								<a class="s-remove" href="#" target=".navbar-form">
									<i class="ti-close"></i>
								</a>
								<div class="form-group">
									<input type="text" class="form-control" placeholder="搜索...">
									<button class="btn search-button" type="submit">
										<i class="ti-search"></i>
									</button>
								</div>
							</form>
						</div>
						<!-- end: SEARCH FORM -->
						<!-- start: MAIN NAVIGATION MENU -->
						<div class="navbar-title">
							<span>菜单</span>
						</div>
                        <ul class="main-navigation-menu"></ul>
						<!-- end: MAIN NAVIGATION MENU -->
						<!-- start: CORE FEATURES -->
						<div class="navbar-title">
							<span>常用</span>
						</div>
						<ul class="folders">
							<li>
								<a href="javascript:;">
									<div class="item-content">
										<div class="item-media">
											<span class="fa-stack"> <i class="fa fa-square fa-stack-2x"></i> <i class="fa fa-terminal fa-stack-1x fa-inverse"></i> </span>
										</div>
										<div class="item-inner">
											<span class="title"> 日历 </span>
										</div>
									</div>
								</a>
							</li>
							<li>
								<a href="javascript:;">
									<div class="item-content">
										<div class="item-media">
											<span class="fa-stack"> <i class="fa fa-square fa-stack-2x"></i> <i class="fa fa-folder-open-o fa-stack-1x fa-inverse"></i> </span>
										</div>
										<div class="item-inner">
											<span class="title"> 信息 </span>
										</div>
									</div>
								</a>
							</li>
						</ul>
						<!-- end: CORE FEATURES -->
						<!-- start: DOCUMENTATION BUTTON -->
						<div class="wrapper">
							<a href="javascript:;" onclick="JavaScript:openPage('resources/documentation.html')" class="button-o">
								<i class="ti-help"></i>
								<span>文档</span>
							</a>
						</div>
						<!-- end: DOCUMENTATION BUTTON -->
					</nav>
				</div>
			</div>
			<!-- / sidebar -->
			<div class="app-content">
				<!-- start: TOP NAVBAR -->
				<header class="navbar navbar-default navbar-static-top">
					<!-- start: NAVBAR HEADER -->
					<div class="navbar-header">
						<a href="#" class="sidebar-mobile-toggler pull-left hidden-md hidden-lg" class="btn btn-navbar sidebar-toggle" data-toggle-class="app-slide-off" data-toggle-target="#app" data-toggle-click-outside="#sidebar">
							<i class="ti-align-justify"></i>
						</a>
						<a class="navbar-brand" href="javascript:;">
							<img src="resources/assets/images/core/logo.png" alt="Clip-Two"/>
						</a>
						<a href="#" class="sidebar-toggler pull-right visible-md visible-lg" data-toggle-class="app-sidebar-closed" data-toggle-target="#app">
							<i class="ti-align-justify"></i>
						</a>
						<a class="pull-right menu-toggler visible-xs-block" id="menu-toggler" data-toggle="collapse" href=".navbar-collapse">
							<span class="sr-only">切换导航</span>
							<i class="ti-view-grid"></i>
						</a>
					</div>
					<!-- end: NAVBAR HEADER -->
					<!-- start: NAVBAR COLLAPSE -->
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-right">
							<!-- start: MESSAGES DROPDOWN -->
							<li class="dropdown">
								<a href class="dropdown-toggle" data-toggle="dropdown">
									<span class="dot-badge partition-red"></span> <i class="ti-comment"></i> <span>信息</span>
								</a>
								<ul class="dropdown-menu dropdown-light dropdown-messages dropdown-large">
									<li>
										<span class="dropdown-header"> 未读消息</span>
									</li>
									<li>
										<div class="drop-down-wrapper ps-container">
											<ul>
												<li class="unread">
													<a href="javascript:;" class="unread">
														<div class="clearfix">
															<div class="thread-image">
																<img src="resources/assets/images/core/avatar-2.jpg" alt="">
															</div>
															<div class="thread-content">
																<span class="author">Nicole Bell</span>
																<span class="preview">Duis mollis, est non commodo luctus, nisi erat porttitor ligula...</span>
																<span class="time"> Just Now</span>
															</div>
														</div>
													</a>
												</li>
											</ul>
										</div>
									</li>
									<li class="view-all">
										<a href="#">
											查看所有
										</a>
									</li>
								</ul>
							</li>
							<!-- end: MESSAGES DROPDOWN -->
							<!-- start: ACTIVITIES DROPDOWN -->
							<li class="dropdown">
								<a href class="dropdown-toggle" data-toggle="dropdown">
									<i class="ti-check-box"></i> <span>动态</span>
								</a>
								<ul class="dropdown-menu dropdown-light dropdown-messages dropdown-large">
									<li>
										<span class="dropdown-header"> 你有新的通知</span>
									</li>
									<li>
										<div class="drop-down-wrapper ps-container">
											<div class="list-group no-margin">
												<a class="media list-group-item" href="">
													<img class="img-circle" alt="..." src="resources/assets/images/core/avatar-1.jpg">
													<span class="media-body block no-margin"> Use awesome animate.css <small class="block text-grey">10 分钟前</small> </span>
												</a>
												<a class="media list-group-item" href="">
													<span class="media-body block no-margin"> 1.0 initial released <small class="block text-grey">1 小时前</small> </span>
												</a>
											</div>
										</div>
									</li>
									<li class="view-all">
										<a href="#">
											查看所有
										</a>
									</li>
								</ul>
							</li>
							<!-- end: ACTIVITIES DROPDOWN -->
							<!-- start: LANGUAGE SWITCHER -->
							<li class="dropdown">
								<a href class="dropdown-toggle" data-toggle="dropdown">
									<i class="ti-world"></i> 语言
								</a>
								<ul role="menu" class="dropdown-menu dropdown-light fadeInUpShort">
									<li>
										<a href="#" class="menu-toggler">
											Deutsch
										</a>
									</li>
									<li>
										<a href="#" class="menu-toggler">
											English
										</a>
									</li>
									<li>
										<a href="#" class="menu-toggler">
											Italiano
										</a>
									</li>
								</ul>
							</li>
							<!-- start: LANGUAGE SWITCHER -->
							<!-- start: USER OPTIONS DROPDOWN -->
							<li class="dropdown current-user">
								<a href class="dropdown-toggle" data-toggle="dropdown">
									<img src="resources/assets/images/core/avatar-1.jpg" alt="Peter"> <span class="username">${username} <i class="ti-angle-down"></i></span>
								</a>
								<ul class="dropdown-menu dropdown-dark">
									<li>
										<a href="pages_user_profile.html">
											我的资料
										</a>
									</li>
									<li>
										<a href="pages_calendar.html">
											我的日历
										</a>
									</li>
									<li>
										<a hef="pages_messages.html">
											我的消息 (3)
										</a>
									</li>
									<li>
										<a href="login_lockscreen.html">
											锁屏
										</a>
									</li>
									<li>
										<a href="logout">
											退出
										</a>
									</li>
								</ul>
							</li>
							<!-- end: USER OPTIONS DROPDOWN -->
						</ul>
						<!-- start: MENU TOGGLER FOR MOBILE DEVICES -->
						<div class="close-handle visible-xs-block menu-toggler" data-toggle="collapse" href=".navbar-collapse">
							<div class="arrow-left"></div>
							<div class="arrow-right"></div>
						</div>
						<!-- end: MENU TOGGLER FOR MOBILE DEVICES -->
					</div>
					<a class="dropdown-off-sidebar" data-toggle-class="app-offsidebar-open" data-toggle-target="#app" data-toggle-click-outside="#off-sidebar">
						&nbsp;
					</a>
					<!-- end: NAVBAR COLLAPSE -->
				</header>
				<!-- end: TOP NAVBAR -->
				<div class="main-content" >
					<div id="container">
						<!-- start: DASHBOARD TITLE -->
                        <iframe id="main-iframe" src="" border="0" frameBorder="no" scrolling="auto" width="100%" style="display: block"></iframe>
						<!-- end: DASHBOARD TITLE -->
					</div>
				</div>
			</div>
			<!-- start: FOOTER -->
			<footer>
				<div class="footer-inner">
					<div class="pull-left">
						&copy; <span class="current-year"></span><span class="text-bold text-uppercase">HejinYo</span>. <span>All rights reserved</span>
					</div>
					<div class="pull-right">
						<span class="go-top"><i class="ti-angle-up"></i></span>
					</div>
				</div>
			</footer>
			<!-- end: FOOTER -->
			<!-- start: OFF-SIDEBAR -->
			<div id="off-sidebar" class="sidebar">
				<div class="sidebar-wrapper">
					<ul class="nav nav-tabs nav-justified">
						<li class="active">
							<a href="#off-users" aria-controls="off-users" role="tab" data-toggle="tab">
								<i class="ti-comments"></i>
							</a>
						</li>
						<li>
							<a href="#off-favorites" aria-controls="off-favorites" role="tab" data-toggle="tab">
								<i class="ti-heart"></i>
							</a>
						</li>
						<li>
							<a href="#off-settings" aria-controls="off-settings" role="tab" data-toggle="tab">
								<i class="ti-settings"></i>
							</a>
						</li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="off-users">
							<div id="users" toggleable active-class="chat-open">
								<div class="users-list">
									<div class="sidebar-content perfect-scrollbar">
										<h5 class="sidebar-title">在线</h5>
										<ul class="media-list">
											<li class="media">
												<a data-toggle-class="chat-open" data-toggle-target="#users" href="#">
													<i class="fa fa-circle status-online"></i>
													<img alt="..." src="resources/assets/images/core/avatar-2.jpg" class="media-object">
													<div class="media-body">
														<h4 class="media-heading">Nicole Bell</h4>
														<span> Content Designer </span>
													</div>
												</a>
											</li>
											<li class="media">
												<a data-toggle-class="chat-open" data-toggle-target="#users" href="#">
													<div class="user-label">
														<span class="label label-success">3</span>
													</div>
													<i class="fa fa-circle status-online"></i>
													<img alt="..." src="resources/assets/images/core/avatar-3.jpg" class="media-object">
													<div class="media-body">
														<h4 class="media-heading">Steven Thompson</h4>
														<span> Visual Designer </span>
													</div>
												</a>
											</li>
										</ul>
										<h5 class="sidebar-title">离线</h5>
										<ul class="media-list">
											<li class="media">
												<a data-toggle-class="chat-open" data-toggle-target="#users" href="#">
													<img alt="..." src="resources/assets/images/core/avatar-6.jpg" class="media-object">
													<div class="media-body">
														<h4 class="media-heading">Nicole Bell</h4>
														<span> Content Designer </span>
													</div>
												</a>
											</li>
											<li class="media">
												<a data-toggle-class="chat-open" data-toggle-target="#users" href="#">
													<div class="user-label">
														<span class="label label-success">3</span>
													</div>
													<img alt="..." src="resources/assets/images/core/avatar-7.jpg" class="media-object">
													<div class="media-body">
														<h4 class="media-heading">Steven Thompson</h4>
														<span> Visual Designer </span>
													</div>
												</a>
											</li>
										</ul>
									</div>
								</div>
								<div class="user-chat">
									<div class="chat-content">
										<div class="sidebar-content perfect-scrollbar">
											<a class="sidebar-back pull-left" href="#" data-toggle-class="chat-open" data-toggle-target="#users"><i class="ti-angle-left"></i> <span>Back</span></a>
											<ol class="discussion">
												<li class="messages-date">
													Sunday, Feb 9, 12:58
												</li>
												<li class="self">
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															Hi, Nicole
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															How are you?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															Hi, i am good
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="self">
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															Glad to see you ;)
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="messages-date">
													Sunday, Feb 9, 13:10
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															What do you think about my new Dashboard?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="messages-date">
													Sunday, Feb 9, 15:28
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															Alo...
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															Are you there?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="self">
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															Hi, i am here
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															Your Dashboard is great
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="messages-date">
													Friday, Feb 7, 23:39
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															How does the binding and digesting work in AngularJS?, Peter?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="self">
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															oh that's your question?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															little reduntant, no?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															literally we get the question daily
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															I know. I, however, am not a nerd, and want to know
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="self">
													<div class="message">
														<div class="message-name">
															Peter Clark
														</div>
														<div class="message-text">
															for this type of question, wouldn't it be better to try Google?
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-1.jpg" alt="">
														</div>
													</div>
												</li>
												<li class="other">
													<div class="message">
														<div class="message-name">
															Nicole Bell
														</div>
														<div class="message-text">
															Lucky for us :)
														</div>
														<div class="message-avatar">
															<img src="resources/assets/images/core/avatar-2.jpg" alt="">
														</div>
													</div>
												</li>
											</ol>
										</div>
									</div>
									<div class="message-bar">
										<div class="message-inner">
											<a class="link icon-only" href="#"><i class="fa fa-camera"></i></a>
											<div class="message-area">
												<textarea placeholder="Message"></textarea>
											</div>
											<a class="link" href="#">
												Send
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="off-favorites">
							<div class="users-list">
								<div class="sidebar-content perfect-scrollbar">
									<h5 class="sidebar-title">收藏</h5>
									<ul class="media-list">
										<li class="media">
											<a href="#">
												<img alt="..." src="resources/assets/images/core/avatar-7.jpg" class="media-object">
												<div class="media-body">
													<h4 class="media-heading">Nicole Bell</h4>
													<span> Content Designer </span>
												</div>
											</a>
										</li>
										<li class="media">
											<a href="#">
												<div class="user-label">
													<span class="label label-success">3</span>
												</div>
												<img alt="..." src="resources/assets/images/core/avatar-6.jpg" class="media-object">
												<div class="media-body">
													<h4 class="media-heading">Steven Thompson</h4>
													<span> Visual Designer </span>
												</div>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane" id="off-settings">
							<div class="sidebar-content perfect-scrollbar">
								<h5 class="sidebar-title">常规设置</h5>
								<ul class="media-list">
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" checked />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">启用通知</span>
										</div>
									</li>
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">显示E-mail</span>
										</div>
									</li>
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" checked />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">显示离线用户</span>
										</div>
									</li>
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" checked />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">E-mail提示</span>
										</div>
									</li>
									<li class="media">
										<div class="padding-10">
											<div class="display-table-cell">
												<input type="checkbox" class="js-switch" />
											</div>
											<span class="display-table-cell vertical-align-middle padding-left-10">消息提示</span>
										</div>
									</li>
								</ul>
								<div class="save-options">
									<button class="btn btn-success">
										<i class="icon-settings"></i><span>保存更改</span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end: OFF-SIDEBAR -->
			<!-- start: SETTINGS -->
			<div class="settings panel panel-default hidden-xs hidden-sm" id="settings">
				<button ct-toggle="toggle" data-toggle-class="active" data-toggle-target="#settings" class="btn btn-default">
					<i class="fa fa-spin fa-gear"></i>
				</button>
				<div class="panel-heading">
					样式设置
				</div>
				<div class="panel-body">
					<!-- start: FIXED HEADER -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">固定导航</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-header" />
						</span>
					</div>
					<!-- end: FIXED HEADER -->
					<!-- start: FIXED SIDEBAR -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">固定菜单</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-sidebar" />
						</span>
					</div>
					<!-- end: FIXED SIDEBAR -->
					<!-- start: CLOSED SIDEBAR -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">关闭菜单</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="closed-sidebar" />
						</span>
					</div>
					<!-- end: CLOSED SIDEBAR -->
					<!-- start: FIXED FOOTER -->
					<div class="setting-box clearfix">
						<span class="setting-title pull-left">固定页脚</span>
						<span class="setting-switch pull-right">
							<input type="checkbox" class="js-switch" id="fixed-footer" />
						</span>
					</div>
					<!-- end: FIXED FOOTER -->
					<!-- start: THEME SWITCHER -->
					<div class="colors-row setting-box">
						<div class="color-theme theme-1">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-1">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-2">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-2">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<div class="colors-row setting-box">
						<div class="color-theme theme-3">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-3">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-4">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-4">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<div class="colors-row setting-box">
						<div class="color-theme theme-5">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-5">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
						<div class="color-theme theme-6">
							<div class="color-layout">
								<label>
									<input type="radio" name="setting-theme" value="theme-6">
									<span class="ti-check"></span>
									<span class="split header"> <span class="color th-header"></span> <span class="color th-collapse"></span> </span>
									<span class="split"> <span class="color th-sidebar"><i class="element"></i></span> <span class="color th-body"></span> </span>
								</label>
							</div>
						</div>
					</div>
					<!-- end: THEME SWITCHER -->
				</div>
			</div>
			<!-- end: SETTINGS -->
		</div>
		<!-- start: MAIN JAVASCRIPTS -->
		<script src="resources/vendor/jquery/jquery.min.js"></script>
		<script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>
		<script src="resources/vendor/modernizr/modernizr.js"></script>
		<script src="resources/vendor/jquery-cookie/jquery.cookie.js"></script>
		<script src="resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
		<script src="resources/vendor/switchery/switchery.min.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="resources/vendor/Chart.js/Chart.min.js"></script>
		<script src="resources/vendor/jquery.sparkline/jquery.sparkline.min.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<!-- start: CLIP-TWO JAVASCRIPTS -->
		<script src="resources/assets/js/core/app-main.js"></script>
		<!-- start: JavaScript Event Handlers for this page -->
		<script src="resources/assets/js/core/manage.js"></script>
		<!-- end: JavaScript Event Handlers for this page -->
		<!-- end: CLIP-TWO JAVASCRIPTS -->
	</body>
</html>
