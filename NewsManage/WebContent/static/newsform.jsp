<%--
  Created by IntelliJ IDEA.
  User: ChaW
  Date: 2019/3/28
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
    <link rel="stylesheet" type="text/css" href="css/skin_/form.css" />
    <link href="umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/global.js"></script>
    <script type="text/javascript" src="js/jquery.select.js"></script>
    <script type="text/javascript" src="js/WdatePicker.js"></script>
    <script type="text/javascript">
        window.UMEDITOR_HOME_URL = 'umeditor/';  // 请换成绝对路径
    </script>
    <script type="text/javascript" src="js/umeditor.config.js"></script>
    <script type="text/javascript" src="js/editor_api.js"></script>
    <script type="text/javascript" src="umeditor/lang/zh-cn/zh-cn.js"></script>
    <title>基础信息</title>
</head>

<body>
<div id="container">
    <div id="hd">
    </div>
    <div id="bd">
        <div id="main">
            <h2 class="subfild">
                <span>基本信息</span>
            </h2>

            <div class="subfild-content base-info">
                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>文章标题</label>
                    <div class="kv-item-content">
                        <input name="title" id="title" type="text" placeholder="文章标题" />
                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>

                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>文章作者</label>
                    <div class="kv-item-content">
                        <input name="author" id="author" type="text" placeholder="文章作者" />
                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>

                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>文章摘要</label>
                    <div class="kv-item-content">
                        <input name="summary" id="summary" type="text" placeholder="文章摘要" />
                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>
                <div class="kv-item ue-clear time">
                    <label><span class="impInfo">*</span>发布时间</label>
                    <div class="kv-item-content">
                        <input name="date" id="date" type="text" placeholder="选择时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
                        <i class="time-icon"></i>
                    </div>
                    <span class="kv-item-tip error">这是一个错误信息</span>
                </div>

                <div class="kv-item ue-clear">
                    <label>所在栏目</label>
                    <div class="kv-item-content">
                        <select name="select" id="select">
                            <option value="1">国内</option>
                            <option value="2">国际</option>
                            <option value="3">军事</option>
                            <option value="4">体育</option>
                            <option value="5">娱乐</option>
                            <option value="6">社会</option>
                            <option value="7">财经</option>
                            <option value="8">科技</option>
                            <option value="9">健康</option>
                            <option value="10">汽车</option>
                            <option value="11">教育</option>
                            <option value="12">房产</option>
                            <option value="13">家居</option>
                            <option value="14">旅游</option>
                            <option value="15">文化</option>
                            <option value="16">其它</option>
                            <option value="17">另类</option>
                        </select>
                    </div>
                    <span class="kv-item-tip success">成功信息</span>
                </div>

                <div class="kv-item ue-clear">
                    <label>是否审核</label>
                    <div class="kv-item-content">
                    	<span class="choose">
                            <span class="checkboxouter">
                                <input type="radio" name="need" />
                                <span class="radio"></span>
                            </span>
                            <span class="text">是</span>
                        </span>
                        <span class="choose">
                            <span class="checkboxouter">
                                <input type="radio" name="need" />
                                <span class="radio"></span>
                            </span>
                            <span class="text">否</span>
                        </span>

                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>


                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>缩略图</label>
                    <div class="kv-item-content file">
                        <span class="text"></span>
                        <input type="file" />
                        <input type="button" class="button normal long2" value="浏览.." />
                    </div>
                    <span class="kv-item-tip">标题字数限制在35个字符</span>
                </div>
            </div>

            <h2 class="subfild">
                <span>备注资料</span>
            </h2>

            <div class="subfild-content remarkes-info">
                <div class="kv-item ue-clear">
                    <label><span class="impInfo">*</span>文章内容</label>
                    <div class="kv-item-content">
                        <textarea name="text" placeholder="文章内容" id="ncontent" style="width:800px;height:240px;"></textarea>
                    </div>
                </div>
            </div>

            <div class="buttons">
                <input class="button" type="button" value="确认添加" onclick="add()"/>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    function add() {
		
        var title = $("#title").val().trim();
        var date = $("#date").val().trim();
        var tid = $("#select").val().trim();
        var content = $("#ncontent").val();
        var author = $("#author").val().trim();
        var summary = $("#summary").val().trim();

        if (date == null || date == "" || date == "undefined" || content == null || content == "" || content == "undefined"){
        	return false;
        }

        $.ajax({
            url:'../NewsServlet?opr=add',
            method:'get',
            data:{title:title,date:date,tid:tid,content:content,author:author,summary:summary},
            success:function (data) {
                if (data == "ok"){
                    alert("添加成功！");
                    $("#title").val("");
                    $("#date").val("");
                    $("#content").val("");
                    $("#author").val("");
                    $("#summary").val("");
                }else if (data == "error"){
                    alert("添加失败！")
                }
            }
        });
    }
</script>
<script type="text/javascript">
    $('select').select();
    showRemind('input[type=text],textarea','color5');
    UM.getEditor('content');
</script>
</html>
