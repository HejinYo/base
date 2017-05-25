jQuery(document).ready(function () {
    Main.init();

});

function openPage(url) {
    $('#main-iframe').attr('src', url);
}

/**
 * 显示菜单
 * @type {{load: showSubMenu.load, levelMenu_2: showSubMenu.levelMenu_2, levelMenu_3: showSubMenu.levelMenu_3}}
 */
var showSubMenu = {
    load: function (level1, level2, level3) {
        var subMenu = '';
        $.each(level1, function (i, l1) {
            var menu_2 = '';
            var arrow = '';
            subMenu += '<li id="menuId_' + l1.mid + '">';
            if (l1.murl == '*') {
                subMenu += '<a href="javascript:void(0)">';
                if (!utils.isEmpty(level2)) {
                    arrow = '<i class="icon-arrow"></i>';
                    menu_2 = showSubMenu.levelMenu_2(l1.mid, level2, level3);
                }
            } else {
                subMenu += '<a onclick="tabs.addPanel(\'' + l1.mname + '\',\'' + l1.murl + '\',\'tabs_' + l1.mid + '\');">';
            }
            subMenu += '<div class="item-content"><div class="item-media">';
            subMenu += '<i class="' + l1.micon + '"></i></div>';
            subMenu += '<div class="item-inner"><span class="title">' + l1.mname + ' </span>';
            subMenu += arrow;
            subMenu += '</div></div></a>';
            subMenu += menu_2;
            subMenu += '</li>';
        });
        return subMenu;
    },
    //二级菜单
    levelMenu_2: function (mid, level2, level3) {
        var menu_2 = '<ul class="sub-menu">';
        $.each(level2, function (j, l2) {
            var menu_3 = '';
            var arrow = '';
            if (l2.pid == mid) {
                menu_2 += '<li id="menuId_' + l2.mid + '">';
                if (l2.murl == '*') {
                    menu_2 += '<a href="javascript:void(0)">';
                    if (!utils.isEmpty(level3)) {
                        arrow = '<i class="icon-arrow"></i>';
                        menu_3 = showSubMenu.levelMenu_3(l2.mid, level3);
                    }
                } else {
                    menu_2 += '<a onclick="tabs.addPanel(\'' + l2.mname + '\',\'' + l2.murl + '\',\'tabs_' + l2.mid + '\');">';
                }
                menu_2 += '<span class="title">' + l2.mname + '</span>';
                menu_2 += arrow;
                menu_2 += '</a>';
                menu_2 += menu_3;
                menu_2 += '</li>';
            }
        });
        menu_2 += '</ul>';
        return menu_2;
    },
    //三级菜单
    levelMenu_3: function (mid, level3) {
        var menu_3 = '<ul class="sub-menu">';
        $.each(level3, function (k, l3) {
            if (l3.pid == mid) {
                menu_3 += '<li><a onclick="tabs.addPanel(\'' + l3.mname + '\',\'' + l3.murl + '\',\'tabs_' + l3.mid + '\');">';
                menu_3 += '<span class="title">' + l3.mname + '</span></a></li>';
            }
        });
        menu_3 += '</ul>';
        return menu_3;
    }
};

/**
 * 加载菜单
 * @param position
 */
function loadSubMenu(position) {
    jQuery.ajax({
        type: "get", contentType: "application/json",
        url: "/sysMenu/mutilMenu",
        dataType: "json",
        success: function (data) {
            if (data.status == 1) {
                $(position).empty();
                var submenu = showSubMenu.load(data.data.menu1, data.data.menu2, data.data.menu3);
                $(position).html(submenu);
            } else {
                console.log("菜单加载失败");
            }
        }
    });
}