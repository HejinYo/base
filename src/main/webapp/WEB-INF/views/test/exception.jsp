<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>XXXX</title>
    <%-- Start: COMMON RESOURCES --%>
    <%@ include file="/resources/js/common/commonresource.jsp" %>
    <%-- End : COMMON RESOURCES --%>
</head>
<body>
<div id="dd"><span id="sss"></span></div>
<button type="submit" value="" onclick="show()">使劲点我看看！</button>
</body>
<script type="application/javascript">
    function show() {
        jQuery.ajax({
            type: "GET", contentType: "application/json",
            url: "/login",
            dataType: "json",
            success: function (data) {
                alert(data.message);
                $("#sss").html(data.message);
            }
        });
    }
</script>

</html>
