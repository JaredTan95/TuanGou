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

$('.sidebar-nav .sidebar-nav-link a').on('click', function () {
    $('.sidebar-nav .sidebar-nav-link a').removeClass('active');
    $(this).addClass('active').siblings();
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
                    200:function () {
                        location.href="/";
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
    showCateLists:function (getData) {
        $.AMUI.progress.start();
        $('#tbody4Cate').html("");
        for(var i=0;i<getData.length;i++){
            var str="<tr class='even gradeC'><td>"+getData[i].cateTitle+"</td><td> <div class='tpl-table-black-operation'>" +
                "<a href='javascript:;' data-cateId='"+getData[i].cateId+"'><i class='am-icon-pencil'></i> 编辑 </a> " +
                "<a href='javascript:;' data-cateId='"+getData[i].cateId+"' class='tpl-table-black-operation-del'>" +
                "<i class='am-icon-trash'></i> 删除 </a> </div> </td> </tr>";
            $('#tbody4Cate').append(str);
        }
        $.AMUI.progress.done();
    },
    showOrderInfos:function (getData) {
        $.AMUI.progress.start();
        $('#tbody4order').html("");
        for(var i=0;i<getData.length;i++){
            var str="";
            if(i%2==0){
                str="<tr class='gradeX'><td>"+getData[i].OrderID+"</td><td data-proId='"+getData[i].productId+"'>"+getData[i].productName+"</td><td>"+getData[i].userAccount+"</td> " +
                    "<td>"+$.TGAdmin.convertDate(getData[i].OrderDate)+"</td> <td><a>"+getData[i].OrderNum+"</a></td> " +
                    "<td>"+$.TGAdmin.covertOrderStatus(getData[i].OrderStatus)+"</td> <td><div class='tpl-table-black-operation'> " +
                    "<a href='javascript:;' data-orderId='"+getData[i].OrderID+"'> <i class='am-icon-pencil'></i> 编辑 </a> " +
                    "<a href='javascript:;' data-orderId='"+getData[i].OrderID+"' class='tpl-table-black-operation-del'><i class='am-icon-trash'></i> 删除 </a> " +
                    "</div></td> </tr>";
            } else {
                str="<tr class='even gradeC'><td>"+getData[i].OrderID+"</td><td>"+getData[i].productName+"</td><td>"+getData[i].userAccount+"</td> " +
                    "<td>"+$.TGAdmin.convertDate(getData[i].OrderDate)+"</td> <td><a>"+getData[i].OrderNum+"</a></td> " +
                    "<td>"+$.TGAdmin.covertOrderStatus(getData[i].OrderStatus)+"</td> <td><div class='tpl-table-black-operation'> " +
                    "<a href='javascript:;' data-orderId='"+getData[i].OrderID+"'> <i class='am-icon-pencil'></i> 编辑 </a> " +
                    "<a href='javascript:;' data-orderId='"+getData[i].OrderID+"' class='tpl-table-black-operation-del'><i class='am-icon-trash'></i> 删除 </a> " +
                    "</div></td></tr>";
            }
            $('#tbody4order').append(str);
        }
        $.AMUI.progress.done();
    },
    showProductInfo:function (getData) {
        $.AMUI.progress.start();
        $('#tbody4product').html("");
        for(var i=0;i<getData.length;i++){
            var str="";
            if(i%2==0){
                str="<tr class='gradeX'><td>"+getData[i].productName+"</td><td>"+getData[i].productionDscp+"</td><td>"+getData[i].startPrice+"</td>" +
                    "<td>"+getData[i].salePrice+"</td><td>"+getData[i].sellCount+"</td><td><a>预览图</a></td>" +
                    " <td>"+getData[i].productStatus+"</td> <td> <div class='tpl-table-black-operation'> <a href='javascript:;'> " +
                    "<i data-proId='"+getData[i].productId+"' class='am-icon-pencil'></i> 编辑 </a> " +
                    "<a href='javascript:;' class='tpl-table-black-operation-del'> <i data-proId='"+getData[i].productId+"' class='am-icon-trash'></i> 删除 </a> " +
                    "</div> </td> </tr>";
            } else {
                str="<tr class='even gradeC'><td>"+getData[i].productName+"</td><td>"+getData[i].productionDscp+"</td><td>"+getData[i].startPrice+"</td>" +
                    "<td>"+getData[i].salePrice+"</td><td>"+getData[i].sellCount+"</td>" +
                    "<td><a>预览图</a></td><td>"+getData[i].productStatus+"</td><td>" +
                    "<div class='tpl-table-black-operation'><a href='javascript:;'>" +
                    "<i data-proId='"+getData[i].productId+"' class='am-icon-pencil'></i> 编辑</a>" +
                    "<a href='javascript:;' class='tpl-table-black-operation-del'><i data-proId='"+getData[i].productId+"' class='am-icon-trash'></i> 删除</a>" +
                    "</div></td></tr>";
            }
            $('#tbody4product').append(str);
        }
        $.AMUI.progress.done();
    },
    showCateSelect:function (data) {
        $.AMUI.progress.start();
        for(var i=0;i<data.length;i++){
            var str="<option value='"+data[i].cateId+"'>"+data[i].cateTitle+"</option>";
            $('#procateSelect').append(str);
        }
        $.AMUI.progress.done();
    },
    showSellerLists:function (getData) {
        $.AMUI.progress.start();
        $('#tbody4selles').html("");
        for(var i=0;i<getData.length;i++){
            var str="";
            if(i%2==0){
                str="<tr class='gradeX'> <td>"+getData[i].sellerId+"</td> <td>"+getData[i].sellerAccount+"</td><td>"+$.TGAdmin.cutString(getData[i].sellerDscp)+"</td>" +
                    "<td>"+getData[i].sellerLevel+"</td><td>"+getData[i].sellerRegDate+"</td> <td>"+getData[i].sellerPhoneNum+"</td> " +
                    "<td>"+getData[i].sellerStatus+"</td><td><div class='tpl-table-black-operation'> <a href='javascript:;'> <i data-sellerId='"+getData[i].sellerId+"' class='am-icon-pencil'></i> 编辑 </a> " +
                    "<a href='javascript:;' class='tpl-table-black-operation-del'> <i data-sellerId='"+getData[i].sellerId+"' class='am-icon-trash'></i> 删除 </a>" +
                    "</div></td></tr>";
            } else {
                str="<tr class='even gradeX'><td>"+getData[i].sellerId+"</td> <td>"+getData[i].sellerAccount+"</td><td>"+$.TGAdmin.cutString(getData[i].sellerDscp)+"</td>" +
                    "<td>"+getData[i].sellerLevel+"</td><td>"+getData[i].sellerRegDate+"</td> <td>"+getData[i].sellerPhoneNum+"</td> " +
                    "<td>"+getData[i].sellerStatus+"</td><td><div class='tpl-table-black-operation'> <a href='javascript:;'> <i data-sellerId='"+getData[i].sellerId+"' class='am-icon-pencil'></i> 编辑 </a> " +
                    "<a href='javascript:;' class='tpl-table-black-operation-del'> <i data-sellerId='"+getData[i].sellerId+"' class='am-icon-trash'></i> 删除 </a>" +
                    "</div></td></tr>";
            }
            $('#tbody4selles').append(str);
        }
        $.AMUI.progress.done();
    },
    cutString:function (str) {
        var MAX=30;
        if(str.length<=MAX){
            return str;
        }else {
            return str.substring(0,MAX)+"......";
        }
    },
    covertOrderStatus:function (statu) {
        switch(statu){
            case 1:return "新订单";
            case 2:return "已取消";
            case 3:return "已付款";
            case 4:return "待发货";
            case 5:return "已发货";
            case 6:return "交易成功";
        }
    },
    convertDate:function (time) {
        return new Date(parseInt(time)).toLocaleDateString();
    }
};

$('#loginBtn').on('click',function () {
    $.AMUI.progress.start();
    $.TGAdmin.login();
    $.AMUI.progress.done();
});



