<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>layui</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <style>
      #content{
        width: 100%;
        margin: 0px;
      }
      .layui-table-cell{
        text-align: center;
      }
    </style>
  </head>
<body>

  <div id="content">
    <%--<div class="demoTable">--%>
      <%--搜索ID：--%>
      <%--<div class="layui-inline">--%>
        <%--<input class="layui-input" name="id" id="demoReload" autocomplete="off">--%>
      <%--</div>--%>
      <%--<button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>--%>
    <%--</div>--%>

    <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
  </div>

  <script>
      layui.use('table', function(){
    
          var table = layui.table;

          //方法级渲染
          table.render({
              elem: '#LAY_table_user'
              ,url: '../NewsServlet?opr=load'
              ,limit:10
              ,limits:[5,10,20]
              ,cols: [[
                  {checkbox: true, fixed: true}
                  ,{field:'nid', title: '新闻ID', width:100, sort: true, fixed: true}
                  ,{field:'ntid', title: '主题ID', width:120}
                  ,{field:'ntitle', title: '新闻标题', width:400, sort: true}
                  ,{field:'nauthor', title: '新闻作者', width:100}
                  ,{field:'ncreatedate', title: '创建日期'}
                  ,{field:'ntopic', title:'新闻主题', width:100}
              ]]
              ,id: 'testReload'
              ,page: true
          });
          

          var $ = layui.$, active = {//提交数据
              reload: function(){
                  var demoReload = $('#demoReload');

                  //执行重载
                  table.reload('testReload', {
                      page: {
                          curr: 1 //重新从第 1 页开始
                      }
                      ,where: {
                          key: {
                              id: demoReload.val()
                          }
                      }
                  });
              }
          };

          $('.demoTable .layui-btn').on('click', function(){
              var type = $(this).data('type');
              active[type] ? active[type].call(this) : '';
          });
      });
  </script>

</body>
</html>