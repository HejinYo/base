var pymParent = null;//创建的iframe对象

$(function(){
    "use strict";//启用严格模式，变量未定义或重名会报错等
    initMain($.AdminLTE);//初始化主頁配置
    pymParent = new pym.Parent('main-content', 'resources/pages/examples/iframe_profile.html', {});//加载初始页内容
    gotoTop();//返回頂部

    //var pymParent = new pym.Parent('example-1', 'resources/documentation/test2.html', {});

    $('#myLink1').click(function(){
        pymParent.sendMessage('navigate', "200");
    });
    $('#myLink2').click(function(){
        pymParent.sendMessage('navigate2', "400");
    });
    $('#myLink3').click(function(){
        pymParent = new pym.Parent('main-content', 'resources/documentation/iframe_document.html', {});
    });
    $('#myLink5').click(function(){
        pymParent.remove();
    });

    /*pymParent.onMessage('navigate3', onNavigateMessage);//接受子页面消息
    function onNavigateMessage(url) {
        alert(url);
    }*/
});

/**
 * 打开iframe页面
 * @param url
 */
function openPage(url){
    pymParent = new pym.Parent('main-content', url, {});
}

//返回顶部
function gotoTop(){
    var slideToTop = $("<div />");
      slideToTop.html('<i class="fa fa-chevron-up"></i>');
      slideToTop.css({
        position: 'fixed',
        bottom: '20px',
        right: '25px',
        width: '40px',
        height: '40px',
        color: '#eee',
        'font-size': '',
        'line-height': '40px',
        'text-align': 'center',
        'background-color': '#222d32',
        cursor: 'pointer',
        'border-radius': '5px',
        'z-index': '99999',
        opacity: '.7',
        'display': 'none'
      });
      slideToTop.on('mouseenter', function () {
        $(this).css('opacity', '1');
      });
      slideToTop.on('mouseout', function () {
        $(this).css('opacity', '.7');
      });
      $('.wrapper').append(slideToTop);
      $(window).scroll(function () {
        if ($(window).scrollTop() >= 150) {
          if (!$(slideToTop).is(':visible')) {
            $(slideToTop).fadeIn(500);
          }
        } else {
          $(slideToTop).fadeOut(500);
        }
      });
      $(slideToTop).click(function () {
        $("body").animate({
          scrollTop: 0
        }, 500);
      });
      $(".sidebar-menu li:not(.treeview) a").click(function () {
        var $this = $(this);
        var target = $this.attr("href");
        if (typeof target === 'string') {
          $("body").animate({
            scrollTop: ($(target).offset().top) + "px"
          }, 500);
        }
      });
}

/**
 * 初始化主页控制侧边栏设置
 * @param AdminLTE
 */
function initMain(AdminLTE){
    /**
    * 列出所有可用的皮肤
    *
    * @type Array
    */
    var my_skins = [
        "skin-blue",
        "skin-black",
        "skin-red",
        "skin-yellow",
        "skin-purple",
        "skin-green",
        "skin-blue-light",
        "skin-black-light",
        "skin-red-light",
        "skin-yellow-light",
        "skin-purple-light",
        "skin-green-light"
      ];
    //创建新选项卡
    var tab_pane = $("<div />", {
        "id": "control-sidebar-theme-demo-options-tab",
        "class": "tab-pane active"
    });

    //创建选项卡按钮
    var tab_button = $("<li />", {"class": "active"})
        .html("<a href='#control-sidebar-theme-demo-options-tab' data-toggle='tab'>"
        + "<i class='fa fa-wrench'></i>"
        + "</a>");

    //将选项卡按钮添加到右侧边栏选项卡
    $("[href='#control-sidebar-settings-tab']").parent().after(tab_button);
    //Create the menu 创建菜单
    var demo_settings = $("<div />");

    //Layout options 布局选项
      demo_settings.append(
          "<h4 class='control-sidebar-heading'>"
          + "布局选项"
          + "</h4>"
            //Fixed layout 固定布局
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-layout='fixed' class='pull-right'/> "
          + "固定布局"
          + "</label>"
          //+ "<p>激活固定布局。 您不能一起使用固定和盒装的布局</p>"
          + "</div>"
            //Boxed layout 盒子布局
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-layout='layout-boxed'class='pull-right'/> "
          + "盒子布局"
          + "</label>"
          //+ "<p>激活盒子布局</p>"
          + "</div>"
            //Sidebar Toggle 侧栏切换
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-layout='sidebar-collapse' class='pull-right'/> "
          + "切换左边栏"
          + "</label>"
          //+ "<p>切换左边栏的状态（打开或折叠）</p>"
          + "</div>"
            //Sidebar mini expand on hover toggle 侧栏小型展开悬停切换
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-enable='expandOnHover' class='pull-right'/> "
          + "左边栏悬停"
          + "</label>"
         // + "<p>让侧边栏迷你扩展悬停</p>"
          + "</div>"
            //Control Sidebar Toggle 控制侧栏切换
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-controlsidebar='control-sidebar-open' class='pull-right'/> "
          + "固定右边栏"
          + "</label>"
          //+ "<p>在内容滑动之间切换并推送内容效果</p>"
          + "</div>"
            //Control Sidebar Skin Toggle 控制边栏皮肤切换
          + "<div class='form-group'>"
          + "<label class='control-sidebar-subheading'>"
          + "<input type='checkbox' data-sidebarskin='toggle' class='pull-right'/> "
          + "右边栏皮肤"
          + "</label>"
         // + "<p>在右侧边栏的黑暗和浅色皮肤之间切换</p>"
          + "</div>"
      );

    var skins_list = $("<ul />", {"class": 'list-unstyled clearfix'});

    //Dark sidebar skins 黑色边栏皮肤
      var skin_blue =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-blue' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px; background: #367fa9;'></span><span class='bg-light-blue' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222d32;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Blue</p>");
      skins_list.append(skin_blue);
      var skin_black =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-black' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div style='box-shadow: 0 0 2px rgba(0,0,0,0.1)' class='clearfix'><span style='display:block; width: 20%; float: left; height: 7px; background: #fefefe;'></span><span style='display:block; width: 80%; float: left; height: 7px; background: #fefefe;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Black</p>");
      //skins_list.append(skin_black);
      var skin_purple =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-purple' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-purple-active'></span><span class='bg-purple' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222d32;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Purple</p>");
      skins_list.append(skin_purple);
      var skin_green =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-green' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-green-active'></span><span class='bg-green' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222d32;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Green</p>");
      skins_list.append(skin_green);
      var skin_red =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-red' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-red-active'></span><span class='bg-red' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222d32;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Red</p>");
      //skins_list.append(skin_red);
      var skin_yellow =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-yellow' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-yellow-active'></span><span class='bg-yellow' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #222d32;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin'>Yellow</p>");
      //skins_list.append(skin_yellow);

    //Light sidebar skins 白色边栏皮肤
      var skin_blue_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-blue-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px; background: #367fa9;'></span><span class='bg-light-blue' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px'>BlueLight</p>");
      skins_list.append(skin_blue_light);
      var skin_black_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-black-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div style='box-shadow: 0 0 2px rgba(0,0,0,0.1)' class='clearfix'><span style='display:block; width: 20%; float: left; height: 7px; background: #fefefe;'></span><span style='display:block; width: 80%; float: left; height: 7px; background: #fefefe;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px'>BlackLight</p>");
      skins_list.append(skin_black_light);
      var skin_purple_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-purple-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-purple-active'></span><span class='bg-purple' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px'>PurpleLight</p>");
      skins_list.append(skin_purple_light);
      var skin_green_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-green-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-green-active'></span><span class='bg-green' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px'>GreenLight</p>");
      skins_list.append(skin_green_light);
      var skin_red_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-red-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-red-active'></span><span class='bg-red' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px'>RedLight</p>");
      skins_list.append(skin_red_light);
      var skin_yellow_light =
          $("<li />", {style: "float:left; width: 33.33333%; padding: 5px;"})
              .append("<a href='javascript:void(0);' data-skin='skin-yellow-light' style='display: block; box-shadow: 0 0 3px rgba(0,0,0,0.4)' class='clearfix full-opacity-hover'>"
              + "<div><span style='display:block; width: 20%; float: left; height: 7px;' class='bg-yellow-active'></span><span class='bg-yellow' style='display:block; width: 80%; float: left; height: 7px;'></span></div>"
              + "<div><span style='display:block; width: 20%; float: left; height: 20px; background: #f9fafc;'></span><span style='display:block; width: 80%; float: left; height: 20px; background: #f4f5f7;'></span></div>"
              + "</a>"
              + "<p class='text-center no-margin' style='font-size: 12px;'>YellowLight</p>");
      skins_list.append(skin_yellow_light);

      demo_settings.append("<h4 class='control-sidebar-heading'>皮肤</h4>");
      demo_settings.append(skins_list);

      tab_pane.append(demo_settings);
      $("#control-sidebar-settings-tab").after(tab_pane);

      setup();
    /**
       * Toggles layout classes 切换布局类
       *
       * @param String cls the layout class to toggle  将要打开的布局类
       * @returns void
       */
      function change_layout(cls) {
        $("body").toggleClass(cls);
        AdminLTE.layout.fixSidebar();
        AdminLTE.controlSidebar._fix($(".control-sidebar-bg"));
        AdminLTE.controlSidebar._fix($(".control-sidebar"));
        //Fix the problem with right sidebar and layout boxed 解决右侧边栏和布局框的问题
        if ($('body').hasClass('fixed') && cls == 'fixed') {
          AdminLTE.pushMenu.expandOnHover();
          AdminLTE.layout.activate();
        }else if((!$('body').hasClass('layout-boxed')  && !$('body').hasClass('fixed'))) { //解决右侧栏固定后取消定位问题
            $(".control-sidebar-open").css('position','absolute');
        }

      }

      /**
       * 用新皮肤代替旧皮肤
       * @param String cls新皮肤类
       * @returns Boolean false以防止链接默认动作
       */
      function change_skin(cls) {
        $.each(my_skins, function (i) {
          $("body").removeClass(my_skins[i]);
        });

        $("body").addClass(cls);
        store('skin', cls);
        return false;
      }

      /**
       * 在浏览器中存储新的设置
       *
       * @param String name 设置名称
       * @param String val Value of the setting 设置值
       * @returns void
       */
      function store(name, val) {
        if (typeof (Storage) !== "undefined") {
          localStorage.setItem(name, val);
        } else {
          window.alert('Please use a modern browser to properly view this template!');
        }
      }

      /**
       * 获得预先存储的设置
       *
       * @param String name Name of of the setting
       * @returns String The value of the setting | null
       */
      function get(name) {
        if (typeof (Storage) !== "undefined") {
          return localStorage.getItem(name);
        } else {
          window.alert('Please use a modern browser to properly view this template!');
        }
      }

      /**
       * 检索默认设置并将其应用于模板
       *
       * @returns void
       */
      function setup() {
        var tmp = get('skin');
        if (tmp && $.inArray(tmp, my_skins)){
            change_skin(tmp);
        }

        //添加更改皮肤侦听器
        $("[data-skin]").on('click', function (e) {
          if($(this).hasClass('knob')){
              return;
          }
          e.preventDefault();
          change_skin($(this).data('skin'));
        });

        //添加布局管理器
        $("[data-layout]").on('click', function () {
          change_layout($(this).data('layout'));
        });

        $("[data-controlsidebar]").on('click', function () {
          change_layout($(this).data('controlsidebar'));
          var slide = !AdminLTE.options.controlSidebarOptions.slide;
          AdminLTE.options.controlSidebarOptions.slide = slide;
          if (!slide)
            $('.control-sidebar').removeClass('control-sidebar-open');
        });

        $("[data-sidebarskin='toggle']").on('click', function () {
          var sidebar = $(".control-sidebar");
          if (sidebar.hasClass("control-sidebar-dark")) {
            sidebar.removeClass("control-sidebar-dark")
            sidebar.addClass("control-sidebar-light")
          } else {
            sidebar.removeClass("control-sidebar-light")
            sidebar.addClass("control-sidebar-dark")
          }
        });

        $("[data-enable='expandOnHover']").on('click', function () {
          $(this).attr('disabled', true);
          AdminLTE.pushMenu.expandOnHover();
          if (!$('body').hasClass('sidebar-collapse'))
            $("[data-layout='sidebar-collapse']").click();
        });

        // 重置选项
        if ($('body').hasClass('fixed')) {
          $("[data-layout='fixed']").attr('checked', 'checked');
        }
        if ($('body').hasClass('layout-boxed')) {
          $("[data-layout='layout-boxed']").attr('checked', 'checked');
        }
        if ($('body').hasClass('sidebar-collapse')) {
          $("[data-layout='sidebar-collapse']").attr('checked', 'checked');
        }

      }
}