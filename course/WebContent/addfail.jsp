<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <!--禁止缩放，适合设备尺寸-->
        <meta name="viewport" content="width=device-width, 
                                       initial-scle=1.0,
                                       maximum-scale=1.0,
                                       user-scalable=no">
        <link href="css/bootstrap.min.css" rel="stylesheet">
       
    </head>
  
    <body>
        <div style="padding:100px 200px 10px;">
            <font color="green" size="4"> 
                添加失败...,<br>
                无法进行该操作，<br> <br>
                3秒后自动跳转。当前还剩<span id="num">3</span>秒。<br> <br> 
                如果没有跳转,请按 <a href="relation_apply">这里</a>!!!<br> 
            </font>
        </div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            function jump(count) {
                window.setTimeout(function(){
                    count--;
                    if(count > 0) {
                        $('#num').text(count);
                        jump(count);
                    } else {
                        location.href="relation_apply";
                    }
                }, 1000);
            }
            jump(3);
        });
    </script>
</html>
