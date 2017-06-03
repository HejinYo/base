jQuery(document).ready(function () {
    Main.init();
    loadSubMenu();
});

/**
 * 打开新的iframe
 * @param url
 */
function openPage(url) {
    $('#main-iframe').attr('src', url);
}

/**
 * 加载菜单
 * @param position
 */
function loadSubMenu() {
    jQuery.ajax({
        type: "get", contentType: "application/json",
        url: "/userMenu",
        dataType: "json",
        success: function (data) {
            if (data.status === 0) {
                processMenu(data.data);
            } else {
                console.log("菜单加载失败");
            }
        }
    });
}

/**
 * 处理菜单数据，遍历数据进行dom操作
 * @param data
 */
function processMenu(data) {
    $.each(data, function (index, item) {
        if (item.pid === 0) {//一级菜单
            var subMenu = '<li id="menuId_' + item.mid + '">';
            if (item.murl === '*') {
                subMenu += '<a href="javascript:;">';
            } else {
                subMenu += '<a onclick="openPage(\'' + item.murl + '\');">';
            }
            subMenu += '<div class="item-content"><div class="item-media">';
            subMenu += '<i class="' + item.micon + '"></i></div>';
            subMenu += '<div class="item-inner"><span class="title">' + item.mname + ' </span>';
            subMenu += '</div></div></a>';
            subMenu += '</li>';
            $('.main-navigation-menu').append(subMenu);
        } else {//子菜单没有特殊样式
            var childrenMenu = '<li id="menuId_' + item.mid + '">';
            if (item.murl === '*') {
                childrenMenu += '<a href="javascript:;">';
            } else {
                childrenMenu += '<a onclick="openPage(\'' + item.murl + '\');">';
            }
            //childrenMenu += '<i class="' + item.micon + '"></i></div>';
            childrenMenu += '<span class="title">' + item.mname + '</span>';
            childrenMenu += '</a>';
            childrenMenu += '</li>';
            var parentMenu = $('#menuId_' + item.pid);
            if (parentMenu.children('ul').length === 0) {
                parentMenu.append('<ul class="sub-menu"></ul>');
                parentMenu.children('a').find('span[class=title]').after('<i class="icon-arrow"></i>');
            }
            parentMenu.children('ul').append(childrenMenu);
        }
    });
}