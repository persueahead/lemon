<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/10
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>

    <script type="text/javascript">
      $(function(){
          $("#testJson").click(function () {
              var  url=this.href;
              var args={
                  'id':123,
                  'name':'小王'
              };
              alert(url);

              $.post(url,args,function (data) {

                  alert(data);
                  for (var i=0;i<data.length;i++){
                      var id=data[i].id;
                      var name=data[i].name;
                      alert(id+":"+name);
                  }

              });
              return false;

          });




      })


    </script>
  </head>
  <body>


  <a href="TestCotriller002/test001" id="testJson">Test Josn</a>


  </body>
</html>
