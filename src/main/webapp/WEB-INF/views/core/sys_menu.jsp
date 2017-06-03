<%--
  Created by IntelliJ IDEA.
  User: HejinYo
  Date: 2016/12/25
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<head>
    <base href="<%=basePath%>"/>
    <title>Clip-Two - Responsive Admin Template</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="resources/vendor/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/assets/css/styles.css">
    <link rel="stylesheet" href="resources/vendor/jstree/themes/default/style.css"  media="screen">
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<body>
<div id="app">
    <div class="panel-body">
        <div id="tree_3" class="tree-demo"></div>
    </div>
</div>
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/jstree/jstree.js"></script>
<script src="resources/assets/js/core/sys_menu.js"></script>
<script>
    jQuery(document).ready(function () {
        UITreeview.init();
    });
</script>
</body>
</html>