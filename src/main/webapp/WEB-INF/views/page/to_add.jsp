<%@page import="com.hejinyo.common.utils.PageParam"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>代理IP提取系统</title>
<link rel="stylesheet" type="text/css" href="/resources/css/ip/index.min.css">
</head>
<body>

	<!-- head -->
	<div id="page-header" class="wrap header">
		<header id="masthead" class="site-header" data-role="banner">
			<div class="hgroup">
				<h1 class="site-title">
					<a class="home-link" href="${basePath }" title="添加代理IP" rel="home"d>添加代理IP</a>
				</h1>
				<h2 class="site-description" id="site-description">最便宜、最稳定、实时更新、API接口、实用软件</h2>
			</div>
			<div class="clear"></div>
		</header>
	</div>

	<!-- menu -->
	<div id="primary-nav">
		<div class="wrap nav">
			<nav id="site-navigation" class="main-navigation" data-role="navigation">
				<h3 class="menu-toggle">Menu</h3>
				<a class="assistive-text" href="#content" title="Skip to content">Skip to content</a>
				<ul class="nav-menu">
					<li id="menu_index" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item">
						<a href="${basePath }">首页</a>
					</li>
					<li id="menu_api" class="menu-item menu-item-type-taxonomy menu-item-object-custom ">
						<a href="${basePath }fetch.html">API接口</a>
					</li>
					<li id="menu_help" class="menu-item menu-item-type-taxonomy menu-item-object-custom">
						<a href="${basePath }help.html">帮助中心</a>
					</li>
				</ul>
			</nav>
		</div>
	</div>

<!-- body -->
<div class="wrap fullwidth">
	<div id="content" style="width: auto;">
	<div id="post-2" class="post-2 page type-page status-publish hentry">
		<div class="clear"></div>
		<div class="entry entry-content">
            <form id="fetchForm" class="largeinput" accept-charset="UTF-8" method="POST" target="_blank" action="${basePath }add.html">
                <div class="control-group">
                    <label class="control-label" for="ip">IP</label>
                    <div class="controls">
                        <input id="ip" type="text" name="ip" class="span4 required" value="100" placeholder="填入数字,一次做多提取10000个">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="port">端口</label>
                    <div class="controls">
                        <input id="port" type="text" name="port" class="span4 required" value="" placeholder="国家，比如中国">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="isp"> IP运营商</label>
                    <div class="controls">
                        <select id="isp" name="isp">
                            <option value="">不限</option>
                            <option value="电信">电信</option>
                            <option value="联通">联通</option>
                            <option value="移动">移动</option>
                            <option value="网通">网通</option>
                        </select>
                    </div>
                </div>
                <div class="submit" style="margin-top: 22px; ">
                    <span class="smallbutton">
                        <a id="postcontent" href="javascript:fetchForm.submit();">提取IP</a>
                    </span>
                </div>
            </form>
            <label class="control-label"> ${result}</label>
            <c:if test="${validated !=null }">
                <c:forEach items="${validated}" var="error">
                    <label class="control-label"> ${error.defaultMessage}</label>
                </c:forEach>
            </c:if>
        </div>
		</div>
	</div>
</div>
</body>
</html>