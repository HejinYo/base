/**
 * Created by HejinYo on 2016/12/25.
 */
var UITreeview = function () {
    "use strict";
    //function to initiate jquery.dynatree
    var runTreeView = function () {
        //Default Tree

        var json = '';
        jQuery.ajax({
                type: "GET", contentType: "application/json",
                url: "/sysMenu/menuTree",
                dataType: "json",
                success: function (data) {
                    createPermitTree(data);
                }
            }
        );
        function createPermitTree(datastr) {
            //datastr = eval("" + datastr + "");
            $('#tree_3').jstree({
                "core": {
                    "themes": {"responsive": false},
                    "check_callback": true,
                    'data': datastr
                },
                "types": {
                    "default": {"icon": "fa fa-folder text-primary fa-lg"},
                    "file": {"icon": "fa fa-file text-primary fa-lg"}
                },
                "state": {"key": "demo2"},
                "plugins": ["dnd", "types"]
            });
        }

       /* var data = '[{"id":"1","parent":"#","text":"Parent Node"},' +
            '{"id":"2","parent":"1","text":"Initially selected","state": {"selected": true}},' +
            '{"id":"3","parent":"1","text":"Custom Icon","icon": "fa fa-warning text-primary"},' +
            '{"id":"4","parent":"1","text":"Initially open","icon": "fa fa-folder text-primary", "state": {"opened": true}},' +
            '{"id":"5","parent":"4","text":"Another node","icon": "fa fa-file text-primary"}]';
        $("#tree_3").jstree(
            {
                "core": {
                    "themes": {"responsive": false},
                    "check_callback": true,
                    'data': {
                        "url": "/sysMenu/menuTree",
                        "dataType": "json" // needed only if you do not supply JSON headers
                    }
                },
                "types": {
                    "default": {"icon": "fa fa-folder text-primary fa-lg"},
                    "file": {"icon": "fa fa-file text-primary fa-lg"}
                },
                "state": {"key": "demo2"},
                "plugins": ["dnd", "types"]
            }
        );*/

    };
    return {
        //main function to initiate template pages
        init: function () {
            runTreeView();
        }
    };
}();