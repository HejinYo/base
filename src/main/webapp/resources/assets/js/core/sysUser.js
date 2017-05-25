$(function () {
    //var pymChild = new pym.Child();

    $(window).resize(function () {//告诉父页面更新高度
        //pymChild.sendHeight();
    });

    $('#sendHeight').click(function () {
        //var height = $(window).height();
        //pymChild.sendMessage('height', height);
        //check_answer(pymChild);
        pymChild.sendHeight();
    });
    $('#sendHeight2').click(function () {
        //var height = $(window).height();
        //pymChild.sendMessage('height', height);
        //check_answer(pymChild);
        var footer_height = $('.main-footer').outerHeight() || 0;
        var neg = $('.main-header').outerHeight() + footer_height;
        var window_height = $(window).height();
        window_height = window_height - (footer_height + neg);
        console.log(window_height);
        pymChild.sendMessage('height', 560);
    });
    //var pymChild = new pym.Child({renderCallback: drawGraphic});//带有回调函数的加载
    function drawGraphic() {//加载时的回调函数
        var hei = document.getElementsByTagName('body')[0].offsetHeight.toString();
        //pymChild.sendMessage('height', divhei);//向父页面发送信息
    }

    function check_answer(pymChild) {
        pymChild.sendHeight();
    }
});

