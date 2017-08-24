<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>我的校园卡</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <h2>我的校园卡</h2>
    <hr/>

    <h3>我的钱包</h3>

    <!-- 如果用户列表为空 -->
    <c:if test="${empty pbBalanceEntityList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true">没有相关信息。</span>
        </div>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty pbBalanceEntityList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>big钱包</th>
                <th>little钱包</th>
                <th>补贴</th>

            </tr>

            <c:forEach items="${pbBalanceEntityList}" var="balanceE">
                <tr>
                    <td>${balanceE.bigBag}</td>
                    <td>${balanceE.littleBag}</td>
                    <td>${balanceE.subsidy}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>

    <h3>资金变动情况</h3>
    <c:if test="${empty pbBalanceEntityList}">
        <div class="alert alert-warning" role="alert">
            <span class="glyphicon glyphicon-info-sign" aria-hidden="true">没有相关信息</span>
        </div>
    </c:if>

    <!-- 如果用户列表非空 -->
    <c:if test="${!empty pbIcanteenEntityList}">
        <table class="table table-bordered table-striped">
            <tr>
                <th>时间</th>
                <th>金额</th>
                <th>余额</th>

            </tr>

            <c:forEach items="${pbIcanteenEntityList}" var="pbIcanteenEntity">
                <tr>
                    <td>${pbIcanteenEntity.dealDate}</td>
                    <td>${pbIcanteenEntity.dealMoney}</td>
                    <td>${pbIcanteenEntity.balance}</td>

                </tr>
            </c:forEach>
        </table>
    </c:if>




</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>