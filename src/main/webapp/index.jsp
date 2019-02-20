<html>
<body>
<h2>Hello World!</h2>

<form <%--action="/student/enrol"--%> method="post">

    <input type="text" name="username" id="username">

    <input type="text" name="password" id="password">

    <input type="submit" name="btn" id="btn1" onclick="checkName()">

</form>
</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function checkName() {
        var username = $("#username").val();
        alert(username);
        //获取账号后的提示信息文本
        $.ajax({
            url : "http://localhost:8080/student/changeRoom", //后台查询验证的方法
            data : {
                "username" : username
            }, //携带的参数
            type : "post",
            success : function(data) {
                alert(data.username);
                alert(data.age);
            }
        });

    }
</script>
</html>

