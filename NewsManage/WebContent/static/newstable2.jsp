<%--
  Created by IntelliJ IDEA.
  User: ChaW
  Date: 2019/4/4
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            margin: 0.625rem;
        }
        table{
            margin-top: 30px;
        }
    </style>
</head>
<%--<script src="static/js/jquery.js"></script>--%>
<script>
    var indexpage = 1;
    var total = 1;
    var num = 0;

    function load(page) {
        indexpage = page;
        if ((page)<1) {
            alert("已经是第一页了！");
            indexpage = 1;
            return false;
        }
        $.ajax({
            url:'../NewsServlet?opr=load',
            method:'get',
            data:{page:page},
            success:function (data) {
                var obj = eval('(' + data + ')');//json对象
                var count = obj.count;//数据总条数
                var list = obj.data;//数据集合
                var totalpage = Math.ceil(count/10);
                total = totalpage;
                if (page>totalpage){
                    alert("已经是最后一页了！");
                    indexpage = totalpage;
                    return false;
                }

                $("tbody").children().remove();
                for (var i = 0;i < list.length;i++){
                    $("tbody").append("<tr><td>"+list[i].nid+"</td><td>"+list[i].ntopic+"</td><td>"+list[i].ntitle+"</td><td>"+list[i].nauthor+"</td><td>"+list[i].ncreatedate+"</td><td><a href='javascript:void(0)' onclick='dele("+list[i].nid+")'>删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='../NewsServlet?opr=toupdate&nid="+list[i].nid+"' onclick='update("+list[i].nid+")'>编辑</a>");
                }

                //插入上下页
                // var lip = "<li><a href=\"javascript:void(0)\" aria-label=\"Previous\" onclick=\'load("+(indexpage-1)+")\'><span aria-hidden=\"true\">&laquo;</span></a></li>";
                // var lin = "<li id=\"flag\"><a href=\"javascript:void(0)\" aria-label=\"Next\"><span aria-hidden=\"true\" onclick=\'load("+(indexpage+1)+")\'>&raquo;</span></a></li>";
                //
                // $(".pagination").append(lip);
                // $(".pagination").append(lin);
                //

                if (num == 0){
                    //插入页码
                    for (var j = 0;j < total;j++){
                        $("#flag").before("<li><a id='"+(j+1)+"' href='javascript:void(0)' onclick='load("+(j+1)+")'>"+(j+1)+"</a></li>");
                    }
                    num ++;
                }
                // $(".pagination").children().remove();


            }
        });
        // var id = ""+indexpage;
        // $(".pagination").children("li").eq(0).children("a").css({"background":"#aaaaaa"})
        // $("#1").css({"background":"#eeeeee"});
        // $("#"+indexpage).parents("li").siblings().children("a").css({"background":"#ffffff"});
    }

    function chgpage(obj) {
        if (obj == 0){
            indexpage = indexpage - 1;
            load(indexpage);
        }
        if (obj == 1){
            indexpage = indexpage + 1;
            load(indexpage);
        }
    }
    load(indexpage);

    function dele(obj) {
        var tr = $(this).parent().parent();
        var flag = confirm("确定删除吗？");
        if (flag == false){
            return;
        }
        $.ajax({
           url:'../NewsServlet?opr=del',
           data:{nid:obj},
           method:'get',
           success:function (data) {
               if (data=='success'){
                   alert("删除成功！");
                   tr.remove();
                   window.location.reload();
               } else {
                   alert("删除失败！");
               }
           }
        });
    }
</script>
<body>
<%--<button type="button" class="btn btn-primary">提交按钮</button>--%>
<%--<button type="button" class="btn btn-success">成功按钮</button>--%>
<table class="table table-striped table-bordered table-hover  table-condensed">
    <thead>
        <th>ID</th>
        <th>主题</th>
        <th>标题</th>
        <th>作者</th>
        <th>创建时间</th>
        <th>操作</th>
    </thead>
    <tbody>
    <%--<tr>--%>
        <%--<td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/gareen.png"/></td>--%>
        <%--<td>盖伦</td>--%>
        <%--<td>616</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/teemo.png"/></td>--%>
        <%--<td>提莫</td>--%>
        <%--<td>383</td>--%>
    <%--</tr>--%>
    <%--<tr>--%>
        <%--<td><img width="20px" src="http://how2j.cn/study/bootstrap/lol/akali.png"/></td>--%>
        <%--<td>阿卡丽</td>--%>
        <%--<td>448</td>--%>
    <%--</tr>--%>
    </tbody>
</table>

<nav>
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous" onclick="chgpage(0)">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <%--<li><a href="#">1</a></li>--%>
        <%--<li><a href="#">2</a></li>--%>
        <%--<li><a href="#">3</a></li>--%>
        <%--<li><a href="#">4</a></li>--%>
        <%--<li><a href="#">5</a></li>--%>
        <li id="flag">
            <a href="#" aria-label="Next" onclick="chgpage(1)">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
