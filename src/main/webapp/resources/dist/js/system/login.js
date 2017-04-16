var codeStatus = false;
var Poshytip = $("#owl-login");
var usernameLen = 4;
var passwordLen = 6;
var codeLen = 4;
$(function () {
    //禁止回退
    //window.history.forward(1);
    //输入内容限制
    confineInput();
    //刷新验证码
    refreshCheckImg();
    //初始化提示信息
    initPoshytip(Poshytip, 'center', 'top');
    //输入密码猫头鹰动画响应
    owlAction(Poshytip);
    //验证码验证
    validateCode();
    //buttom是否可用
    buttomUsable();
    //登录动作
    doLogin();
});

//输入内容限制
function confineInput() {
    $('input').keypress(function (e) {
        if (!String.fromCharCode(e.keyCode).match(/^\w+$/)) {
            return false;
        }
    });
}
//刷新验证码
function refreshCheckImg() {
    $(".refresh").click(function () {
        codeStatus = false;
        $('#verifi').val('');//清空已经输入的验证码
        $('#verifi').next('span').removeClass("glyphicon-ok captcha-success glyphicon-remove captcha-failure");
        $('button').attr('disabled', 'disabled');
        $('#checkImg').attr('src', '/verifyImg');
    });
}
//初始化提示信息
function initPoshytip(Poshytip, alignX, alignY) {
    Poshytip.poshytip({
        className: 'tip-blue',
        showOn: 'none',
        alignTo: 'target',
        alignX: alignX,
        alignY: alignY,
        offsetX: 0,
        showTimeout: 100,
        hideTimeout: 1000
    });
}
//输入密码猫头鹰反映
function owlAction(Poshytip) {
    $('#login #password').focus(function () {
        Poshytip.addClass('password');
        Poshytip.poshytip('update', '我不看你密码！').poshytip('show').poshytip('hideDelayed', 2000);
    }).blur(function () {
        Poshytip.removeClass('password');
        Poshytip.poshytip('hide');
    });
}
//异步判断验证码
function validateCode() {
    $("#verifi").on("keyup", function () {
        var cap = $("#verifi").val();
        var json = $.toJSON($("#verifi").serializeObject());
        if (utils.len(cap) >= 4) {
            jQuery.ajax({
                type: "POST", contentType: "application/json",
                url: "/verifyImgCheck?&random=" + Math.random(),
                dataType: "json",
                data: json,
                success: function (data) {
                    //console.log(data.flag);//打印code返回结果
                    if (0 == data.status) {
                        codeStatus = true;
                        var use = $('#username').val();
                        var pwd = $('#password').val();
                        $('#verifi').next('span').removeClass("glyphicon-remove captcha-failure").addClass("glyphicon-ok captcha-success");
                        if (utils.len(use) >= 4 && utils.len(pwd) >= 6) {
                            $('button').removeAttr('disabled');
                        } else {
                            $('button').attr('disabled', 'disabled');
                        }
                    } else {
                        codeStatus = false;
                        $('#verifi').next('span').removeClass("glyphicon-ok captcha-success").addClass("glyphicon-remove captcha-failure");
                        $('button').attr('disabled', 'disabled');
                    }
                }
            });
        } else if (utils.len(cap) == 0) {
            codeStatus = false;
            $('#verifi').next('span').removeClass("glyphicon-remove captcha-failure glyphicon-ok captcha-success");
            $('button').attr('disabled', 'disabled');
        } else {
            codeStatus = false;
            $('#verifi').next('span').removeClass("glyphicon-ok captcha-success").addClass("glyphicon-remove captcha-failure");
            $('button').attr('disabled', 'disabled');
        }
    });
}

//验证通过提交按钮可用
function buttomUsable() {
    $('#username,#password,#verifi').keyup(function () {
        var use = $('#username').val();
        var pwd = $('#password').val();
        if (utils.len(use) >= 4 && utils.len(pwd) >= 6 && codeStatus) {
            $('button').removeAttr('disabled');
        } else {
            $('button').attr('disabled', 'disabled');
        }
    })
}

/**
 * 校验用户名和密码输入是否合法
 * @returns {number}
 */
function checkInput() {
    var use = utils.len($('#username').val());
    var pwd = utils.len($('#password').val());
    if (use < usernameLen) {
        return "用户名输入格式错误！";
    } else if (pwd < passwordLen) {
        return "密码输入格式错误！";
    } else if (codeStatus) {
        return "验证码错误！";
    }
    return 0;
}

function doLogin() {
    $('.form-actions button').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        if ($('#remember').is(':checked')) {
            $('#rememberMe').val('true');
        }
        if (utils.len(username) >= 4 && utils.len(password) >= 6 && codeStatus) {
            $('#loginpw').val(utils.code(password));
            var json = $.toJSON($("#form").serializeObject());
            jQuery.ajax({
                type: "POST", contentType: "application/json",
                url: "/login",
                dataType: "json",
                data: json,
                success: function (data) {
                    if (data.status == 0) {
                        top.location.href = data.data;
                    } else {
                        var code = data.data;
                        if (code == 1) {//验证码错误
                            $('#verifi').next('span').focus().removeClass("glyphicon-ok captcha-success").addClass("glyphicon-remove captcha-failure");
                        } else if (code == 2) {
                            $('#username').focus();
                        } else if (code == 3) {
                            $('#password').focus();
                        }
                        $(".refresh").click();
                        Poshytip.poshytip('update', data.message).poshytip('show').poshytip('hideDelayed', 2000);
                    }
                }
            });
        } else {
            var check = checkInput();
            $('button').attr('disabled', 'disabled');
            Poshytip.poshytip('update', check).poshytip('show').poshytip('hideDelayed', 2000);
        }
    })
}