<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>班级详情</title>

    <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">

    <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

    <script>
        $(function() {
            $( "#datepicker" ).datepicker({
                changeMonth: true,
                changeYear: true,
                showButtonPanel: true,
                dateFormat: "yy-mm-dd",
                defaultDate:new Date()

            });
        });
    </script>
    <script>
        function query_date() {
            //加入未选择日期的异常处理
            window.location="/clDD/${resultDaily.deptId}/"+document.getElementById("datepicker").value;
        }

    </script>


</head>
<body>

<p>日期：<input type="text" id="datepicker">


    <input type="button" id="update" value="查询" onclick="query_date()" /></p>
<div class="container">
    <h2>班级详情</h2>
    <hr/>
    <h3>${resultDaily.ctTime}</h3>
    <hr/>

    <hr>

    <table class="table table-bordered table-striped">
        <tr>
            <th>班次</th>
            <td>${resultDaily.deptName}</td>
        </tr>
        <tr>
            <th>人数</th>
            <td>${resultDaily.peoCT}</td>
        </tr>
        <tr>
            <th>上午到课率</th>
            <td>${resultDaily.ctMorning}</td>
        </tr>
        <tr>
            <th>下午到课率</th>
            <td>${resultDaily.ctAfternoon}</td>
        </tr>
        <tr>
            <th>早餐就餐率</th>
            <td>${resultDaily.ctBFast}</td>
        </tr>
        <tr>
            <th>中餐就餐率</th>
            <td>${resultDaily.ctLunch}</td>
        </tr>
        <tr>
            <th>晚餐就餐率</th>
            <td>${resultDaily.ctDinner}</td>
        </tr>
        <tr>
            <th>上午未到课学员</th>
            <td>${resultDaily.peoMorning}</td>
        </tr>
        <tr>
            <th>下午未到课学员</th>
            <td>${resultDaily.peoAfternoon}</td>
        </tr>
        <tr>
            <th>早餐未就餐学员</th>
            <td>${resultDaily.peoBFast}</td>
        </tr>
        <tr>
            <th>中餐未就餐学员</th>
            <td>${resultDaily.peoLunch}</td>
        </tr>
        <tr>
            <th>晚餐未就餐学员</th>
            <td>${resultDaily.peoDinner}</td>
        </tr>


    </table>


</div>

</body>
</html>