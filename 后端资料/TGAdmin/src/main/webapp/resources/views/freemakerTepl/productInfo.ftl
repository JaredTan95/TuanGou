<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>团购网后台管理系统</title>
        <meta name="description" content="这是一个 index 页面">
        <meta name="keywords" content="index">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
        <link rel="icon" type="image/png" href="/resources/views/freemakerTepl/assets/i/favicon.png">
        <link rel="apple-touch-icon-precomposed" href="/resources/views/freemakerTepl/assets/i/app-icon72x72@2x.png">
        <meta name="apple-mobile-web-app-title" content="Amaze UI" />
        <script src="/resources/views/freemakerTepl/assets/js/echarts.min.js"></script>
        <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/amazeui.min.css" />
        <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/amazeui.datatables.min.css" />
        <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/app.css">
        <script src="/resources/views/freemakerTepl/assets/js/jquery.min.js"></script>
    </head>
    <body>


    <div class="row">

        <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
            <div class="widget am-cf">
                <div class="widget-head am-cf">
                    <div class="widget-function am-fr">
                        <a href="javascript:;" class="am-icon-cog"></a>
                    </div>
                </div>
                <h1 class="am-form-icon" style="margin-top: -30px;margin-left: 20px;">商品信息</h1>
                <div class="widget-body  widget-body-lg am-fr">
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                        <div class="am-form-group">
                            <div class="am-btn-toolbar">
                                <div class="am-btn-group am-btn-group-xs">
                                    <button type="button" class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span> 新增</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-secondary"><span class="am-icon-save"></span> 保存</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-warning"><span class="am-icon-archive"></span> 审核</button>
                                    <button type="button" class="am-btn am-btn-default am-btn-danger"><span class="am-icon-trash-o"></span> 删除</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6 am-u-lg-3">
                        <div class="am-form-group tpl-table-list-select">
                            <select data-am-selected="{btnSize: 'sm'}">
                                <option value="option1">所有类别</option>
                                <option value="option2">IT业界</option>
                                <option value="option3">数码产品</option>
                                <option value="option3">笔记本电脑</option>
                                <option value="option3">平板电脑</option>
                                <option value="option3">只能手机</option>
                                <option value="option3">超极本</option>
                            </select>
                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                        <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                            <input type="text" class="am-form-field ">
                            <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button"></button>
          </span>
                        </div>
                    </div>
                    <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                        <thead>
                        <tr>
                            <th>商品名称</th>
                            <th>商品描述</th>
                            <th>商品原价</th>
                            <th>商品现价</th>
                            <th>卖出数量</th>
                            <th><a>商品预览图</a></th>
                            <th>商品状态</th>
                            <th>商品操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr class="gradeX">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr class="even gradeC">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr class="gradeX">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr class="even gradeC">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <tr class="even gradeC">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>

                        <tr class="even gradeC">
                            <td>surface pro4</td>
                            <td>微软出品笔记本</td>
                            <td>4999</td>
                            <td>4555</td>
                            <td>20</td>
                            <td><a>预览图</a></td>
                            <td>在售</td>
                            <td>
                                <div class="tpl-table-black-operation">
                                    <a href="javascript:;">
                                        <i class="am-icon-pencil"></i> 编辑
                                    </a>
                                    <a href="javascript:;" class="tpl-table-black-operation-del">
                                        <i class="am-icon-trash"></i> 删除
                                    </a>
                                </div>
                            </td>
                        </tr>
                        <!-- more data -->
                        </tbody>
                    </table>

                </div>
            </div>
        </div>




    </div>
    <script src="/resources/views/freemakerTepl/assets/js/amazeui.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/amazeui.datatables.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/dataTables.responsive.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/app.js"></script>
    </body>
</html>