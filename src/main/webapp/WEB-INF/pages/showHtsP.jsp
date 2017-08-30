<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>详情</title>

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
    <h3>当日详情：</h3>
    <hr/>



        <table class="table table-bordered table-striped">
            <tr>
                <th>班级名称</th>
            </tr>
            <tr>
                <td>${dxRecord.deptName}</td>
            </tr>
            <tr>
                <th>统计时间</th>
            </tr>
            <tr>
                <td>${dxRecord.ctTime}</td>
            </tr>
            <tr>
                <th>班级人数</th>
            </tr>
            <tr>
                <td>${dxRecord.peoCt}</td>
            </tr>
            <tr>
                <th>上午到课率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctMorning}</td>
            </tr>
            <tr>
                <th>下午到课率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctAfternoon}</td>
            </tr>
            <tr>
                <th>早餐就餐率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctBFast}</td>
            </tr>
            <tr>
                <th>中餐就餐率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctLunch}</td>
            </tr>
            <tr>
                <th>晚餐就餐率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctDinner}</td>
            </tr>
            <tr>
                <th>宿舍打卡率</th>
            </tr>
            <tr>
                <td>${dxRecord.ctNight}</td>
            </tr>
            <tr>
                <th>上午未到</th>
            </tr>
            <tr>
                  <td>${dxRecord.peoMorning}</td>
            </tr>
            <tr>
                <th>下午未到</th>
            </tr>
            <tr>
                <td>${dxRecord.peoAfternoon}</td>
            </tr>
            <tr>
                <th>未就早餐</th>
            </tr>
            <tr>
                <td>${dxRecord.peoBFast}</td>
            </tr>
            <tr>
                <th>未就中餐</th>
            </tr>
            <tr>
                <td>${dxRecord.peoLunch}</td>
            </tr>
            <tr>
                <th>未就晚餐</th>
            </tr>
            <tr>
                <td>${dxRecord.peoDinner}</td>
            </tr>
            <tr>
                <th>晚上未打卡</th>
            </tr>
            <tr>
                <td>${dxRecord.peoNight}</td>
            </tr>

        </table>






</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
