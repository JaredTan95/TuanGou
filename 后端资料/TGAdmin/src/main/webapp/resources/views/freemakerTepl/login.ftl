<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>团购网后台管理系统-用户登录</title>
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="/resources/views/freemakerTepl/assets/img/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="/resources/views/freemakerTepl/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/amazeui.datatables.min.css"/>
    <link rel="stylesheet" href="/resources/views/freemakerTepl/assets/css/app.css">
    <script src="/resources/views/freemakerTepl/assets/js/jquery.min.js"></script>
</head>

<body data-type="login">
<script src="/resources/views/freemakerTepl/assets/js/theme.js"></script>
<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <p style="color: white;font-size: 22px;text-align: center">团购网后台管理系统</p>
            <form class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input"  id="user-name" data-am-popover="{content: '账户不能为空', trigger: 'focus'}" name="username" placeholder="请输入账号" minlength="5" required>
                </div>
                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="user-password" data-am-popover="{content: '密码不能为空', trigger: 'focus'}" name="password"
                           placeholder="请输入密码" minlength="5" required>
                </div>
                <div class="am-form-group tpl-login-remember-me">
                  <#--  <input id="remember-me" type="checkbox">
                    <label for="remember-me">
                        记住密码
                    </label>-->
                </div>
                <div class="am-form-group">
                    <button type="button"
                            class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" id="loginBtn">登录
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="/resources/views/freemakerTepl/assets/js/amazeui.min.js"></script>
<script src="/resources/views/freemakerTepl/assets/js/app.js"></script>
</body>
</html>