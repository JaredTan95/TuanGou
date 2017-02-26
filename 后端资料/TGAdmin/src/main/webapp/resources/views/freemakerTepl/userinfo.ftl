<html>
    <head>
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


    <div class="container-fluid am-cf">
        <div class="row">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 部件首页 <small>Amaze UI</small></div>
                <p class="page-header-description">Amaze UI 含近 20 个 CSS 组件、20 余 JS 组件，更有多个包含不同主题的 Web 组件。</p>
            </div>
            <div class="am-u-lg-3 tpl-index-settings-button">
                <button type="button" class="page-header-button"><span class="am-icon-paint-brush"></span> 设置</button>
            </div>
        </div>

    </div>

    <div class="row-content am-cf">
        <div class="row  am-cf">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">月度财务收支计划</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body am-fr">
                        <div class="am-fl">
                            <div class="widget-fluctuation-period-text">
                                ￥61746.45
                                <button class="widget-fluctuation-tpl-btn">
                                    <i class="am-icon-calendar"></i>
                                    更多月份
                                </button>
                            </div>
                        </div>
                        <div class="am-fr am-cf">
                            <div class="widget-fluctuation-description-amount text-success" am-cf>
                                +￥30420.56

                            </div>
                            <div class="widget-fluctuation-description-text am-text-right">
                                8月份收入
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                <div class="widget widget-primary am-cf">
                    <div class="widget-statistic-header">
                        本季度利润
                    </div>
                    <div class="widget-statistic-body">
                        <div class="widget-statistic-value">
                            ￥27,294
                        </div>
                        <div class="widget-statistic-description">
                            本季度比去年多收入 <strong>2593元</strong> 人民币
                        </div>
                        <span class="widget-statistic-icon am-icon-credit-card-alt"></span>
                    </div>
                </div>
            </div>
            <div class="am-u-sm-12 am-u-md-6 am-u-lg-4">
                <div class="widget widget-purple am-cf">
                    <div class="widget-statistic-header">
                        本季度利润
                    </div>
                    <div class="widget-statistic-body">
                        <div class="widget-statistic-value">
                            ￥27,294
                        </div>
                        <div class="widget-statistic-description">
                            本季度比去年多收入 <strong>2593元</strong> 人民币
                        </div>
                        <span class="widget-statistic-icon am-icon-support"></span>
                    </div>
                </div>
            </div>
        </div>

        <div class="row am-cf">
            <div class="am-u-sm-12 am-u-md-8">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">月度财务收支计划</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="tpl-echarts">

                    </div>
                </div>
            </div>

            <div class="am-u-sm-12 am-u-md-4">
                <div class="widget am-cf">
                    <div class="widget-head am-cf">
                        <div class="widget-title am-fl">专用服务器负载</div>
                        <div class="widget-function am-fr">
                            <a href="javascript:;" class="am-icon-cog"></a>
                        </div>
                    </div>
                    <div class="widget-body widget-body-md am-fr">

                        <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                        <div class="am-progress">
                            <div class="am-progress-bar" style="width: 15%"></div>
                        </div>
                        <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                        <div class="am-progress">
                            <div class="am-progress-bar  am-progress-bar-warning" style="width: 75%"></div>
                        </div>
                        <div class="am-progress-title">CPU Load <span class="am-fr am-progress-title-more">28% / 100%</span></div>
                        <div class="am-progress">
                            <div class="am-progress-bar am-progress-bar-danger" style="width: 35%"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="row am-cf">
            <div class="am-u-sm-12 am-u-md-12 am-u-lg-4 widget-margin-bottom-lg ">
                <div class="tpl-user-card am-text-center widget-body-lg">
                    <div class="tpl-user-card-title">
                        禁言小张
                    </div>
                    <div class="achievement-subheading">
                        月度最佳员工
                    </div>
                    <img class="achievement-image" src="/resources/views/freemakerTepl/assets/img/user07.png" alt="">
                    <div class="achievement-description">
                        禁言小张在
                        <strong>30天内</strong> 禁言了
                        <strong>200多</strong>人。
                    </div>
                </div>
            </div>

            <div class="am-u-sm-12 am-u-md-12 am-u-lg-8 widget-margin-bottom-lg">

                <div class="widget am-cf widget-body-lg">

                    <div class="widget-body  am-fr">
                        <div class="am-scrollable-horizontal ">
                            <table width="100%" class="am-table am-table-compact am-text-nowrap tpl-table-black " id="example-r">
                                <thead>
                                <tr>
                                    <th>文章标题</th>
                                    <th>作者</th>
                                    <th>时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="gradeX">
                                    <td>新加坡大数据初创公司 Latize 获 150 万美元风险融资</td>
                                    <td>张鹏飞</td>
                                    <td>2016-09-26</td>
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
                                    <td>自拍的“政治角色”：观众背对希拉里自拍合影表示“支持”</td>
                                    <td>天纵之人</td>
                                    <td>2016-09-26</td>
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
                                    <td>关于创新管理，我想和你当面聊聊。</td>
                                    <td>王宽师</td>
                                    <td>2016-09-26</td>
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
                                    <td>究竟是趋势带动投资，还是投资引领趋势？</td>
                                    <td>着迷</td>
                                    <td>2016-09-26</td>
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
                                    <td>Docker领域再添一员，网易云发布“蜂巢”，加入云计算之争</td>
                                    <td>醉里挑灯看键</td>
                                    <td>2016-09-26</td>
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
        </div>
    </div>
    </div>
    <script src="/resources/views/freemakerTepl/assets/js/amazeui.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/amazeui.datatables.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/dataTables.responsive.min.js"></script>
    <script src="/resources/views/freemakerTepl/assets/js/app.js"></script>
    </body>
</html>