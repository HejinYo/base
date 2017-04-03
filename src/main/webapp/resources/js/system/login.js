var codeStatus = false;
$(function () {
    //禁止回退
    //window.history.forward(1);
    //输入内容限制
    confineInput();
    //刷新验证码
    refreshCheckImg();
    //初始化提示信息
    var Poshytip = $("#owl-login");
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
        $('#verifi').val('').focus();//清空已经输入的验证码
        codeStatus = false;
        $('#verifi').next('span').removeClass("glyphicon-ok captcha-success glyphicon-remove captcha-failure");
        $('button').attr('disabled', 'disabled');
        $('#checkImg').attr('src', '/codeimg');
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
        showTimeout: 100
    });
}
//输入密码猫头鹰反映
function owlAction(Poshytip) {
    $('#login #password').focus(function () {
        Poshytip.addClass('password');
        Poshytip.poshytip('update', '我不看你密码！').poshytip('show');
    }).blur(function () {
        Poshytip.removeClass('password');
        Poshytip.poshytip('hide');
    });
}
//异步判断验证码
function validateCode() {
    $("#verifi").on("keyup", function () {
        var cap = $("#verifi").val();
        if (utils.len(cap) == 4) {
            jQuery.ajax({
                type: "POST", contentType: "application/json",
                url: "/verifyCode?code=" + $("#verifi").val() + "&random=" + Math.random(),
                dataType: "json",
                success: function (data) {
                    //console.log(data.flag);//打印code返回结果
                    if (0 == data.status) {
                        $('#verifi').next('span').removeClass("glyphicon-remove captcha-failure").addClass("glyphicon-ok captcha-success");
                        codeStatus = true;
                        var use = $('#username').val();
                        var pwd = $('#password').val();
                        if (utils.len(use) > 0 && utils.len(pwd) > 0) {
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
        if (utils.len(use) > 0 && utils.len(pwd) > 0) {
            if (codeStatus) {
                $('button').removeAttr('disabled');
            }
        } else {
            $('button').attr('disabled', 'disabled');
        }
    })
}

function doLogin() {
    $('.form-actions button').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        $('#loginpw').val(utils.code(username,password));
        var json = $.toJSON($("#form").serializeObject());
        jQuery.ajax({
            type: "POST", contentType: "application/json",
            url: "/login",
            dataType: "json",
            data:json,
            success: function (data) {
                if(data.status==0){
                    top.location.href = "/home";
                    alert(data.message);
                }else{
                    alert(data.message);
                }
            }
        });
    })
}