/**
 * JQuery AJAX 异常统一处理
 */
toastr.options = {
    "closeButton": true,
    "positionClass": "toast-top-left",
    "showDuration": "1000",
    "hideDuration": "1000",
    "timeOut": "0",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut",
    "preventDuplicates": true//禁止重复的提示
};


$(document).ready(function () {
    //捕获异常信息，显示到前台
    $(document).ajaxError(function (event, request, settings, exception) {
        var httpStatus = request.status;//返回状态
        var data = request.responseText;//返回的异常信息
        var msg = JSON.parse(data);//String转Json对象
        if (404 == httpStatus) {
            toastr.warning('请检查后重试！', msg.message);
        } else if (504 == httpStatus) {
            toastr.warning('请稍后重试！', '请求超时');
        } else {
            toastr.error(msg.message, '系统错误');
        }
    });
});

/**
 * 将表单中的数据返回成json对象
 * @returns {{}}
 */
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};
var utils = {
    len: function (str) {//计算输入字符长度 若为汉字之类的字符则占两个
        var l = 0;
        var a = str.split("");
        for (var i = 0; i < a.length; i++) {
            if (a[i].charCodeAt(0) < 299) {
                l++;
            } else {
                l += 2;
            }
        }
        return l;
    },
    isEmpty: function (p) { //判断变量是否为空
        if (p == '' || p == null || p == undefined) {
            return 1;
        }
        return 0;
    },
    reverse: function (str) {//反转字符串
        if (str.length == 0) {
            return null;
        }
        var i = str.length;
        var dstr = "";
        while (--i >= 0) {
            dstr += str.charAt(i);
        }
        return dstr;
    },
    code: function (str) {//字符串处理
        if (str.length == 0) {
            return null;
        }
        var dstr = $.base64.btoa(str);
        return dstr;
    }
};