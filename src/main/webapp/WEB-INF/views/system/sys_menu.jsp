<%--
  Created by IntelliJ IDEA.
  User: HejinYo
  Date: 2016/12/25
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Clip-Two - Responsive Admin Template</title>
    <meta charset="utf-8"/>
    <%-- Start: COMMON RESOURCES --%>
    <%@ include file="/resources/js/common/commonresource.jsp" %>
    <link href="<%=basePath%>resources/vendor/jstree/themes/default/style.css" rel="stylesheet" media="screen">
    <%-- End : COMMON RESOURCES --%>
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<body>
<div id="app">
    <div class="panel-body">
        <div id="tree_3" class="tree-demo"></div>
    </div>
</div>
<script src="<%=basePath%>resources/vendor/jstree/jstree.js"></script>
<script src="<%=basePath%>resources/js/system/sys_menu.js"></script>
<script>
    jQuery(document).ready(function () {
        UITreeview.init();
    });
</script>
</body>
</html>