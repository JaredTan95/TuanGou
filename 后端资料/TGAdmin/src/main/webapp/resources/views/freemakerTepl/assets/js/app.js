$(function() {
    // 读取body data-type 判断是哪个页面然后执行相应页面方法，方法在下面。
   /* var dataType = $('body').attr('data-type');
    console.log(dataType);
    for (key in pageData) {
        if (key == dataType) {
            pageData[key]();
        }
    }*/
    //     // 判断用户是否已有自己选择的模板风格
    //    if(storageLoad('SelcetColor')){
    //      $('body').attr('class',storageLoad('SelcetColor').Color)
    //    }else{
    //        storageSave(saveSelectColor);
    //        $('body').attr('class','theme-black')
    //    }

    autoLeftNav();
    $(window).resize(function() {
        autoLeftNav();
        console.log($(window).width())
    });

    //    if(storageLoad('SelcetColor')){

    //     }else{
    //       storageSave(saveSelectColor);
    //     }
});




$('.tpl-skiner-content-bar').find('span').on('click', function() {
    $('body').attr('class', $(this).attr('data-color'))
    saveSelectColor.Color = $(this).attr('data-color');
    // 保存选择项
    storageSave(saveSelectColor);

});




// 侧边菜单开关
function autoLeftNav() {
    $('.tpl-header-switch-button').on('click', function() {
        if ($('.left-sidebar').is('.active')) {
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').removeClass('active');
            }
            $('.left-sidebar').removeClass('active');
        } else {

            $('.left-sidebar').addClass('active');
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').addClass('active');
            }
        }
    });

    if ($(window).width() < 1024) {
        $('.left-sidebar').addClass('active');
    } else {
        $('.left-sidebar').removeClass('active');
    }
}

//TODO:后台管理函数方法通过全局函数调用
//全局函数
jQuery.TGAdmin={
    login:function () {
        var name=$('#user-name').val();
        var passwd=$('#user-password').val();
        if(name==""||passwd==""){
            if(name==""){
                $('#user-name').attr("placeholder","账号不能为空");
            }
            $('#user-password').attr("placeholder","密码不能为空");
        }else {
            $.ajax({
                type: "POST",
                url: "/sso/login",
                dataType: "json",
                data:{username:name,password:passwd},
                statusCode:{
                    200:function (data) {
                        location.href="/";
                        /* console.log(data);*/
                    },
                    500:function () {
                        alert("请重新尝试!");
                    },
                    404:function () {
                        alert("账户或密码不正确");
                    }
                }
            });
        }
    },
    getCatepory:function () {
        
    }
};

$('#loginBtn').on('click',function () {
    $.AMUI.progress.start();
    $.TGAdmin.login();
    $.AMUI.progress.done();
});

/*$("#proCate").page({
    pages:10,
    first: "首页", //设置false则不显示，默认为false
    last: "尾页", //设置false则不显示，默认为false
    prev: '<', //若不显示，设置false即可，默认为上一页
    next: '>', //若不显示，设置false即可，默认为下一页
    groups: 3 //连续显示分页数
});
$("#proCate").on('jump.page.amui', function() {
    console.log('点击分页按钮时会触发jump.page.amui事件');
});*/

var proCatePages=0;
$("#proCate").page({
    pages:proCatePages,
    groups:5,
    jump:function(context){
        $("#tips3").html("共"+context.option.pages+"页，当前第"+context.option.curr+"页");
    }
});

