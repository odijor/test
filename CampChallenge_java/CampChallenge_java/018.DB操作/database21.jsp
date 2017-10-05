<%-- 
    Document   : database
    Created on : 2017/10/04, 17:53:26
    Author     : sige
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ログイン画面です。パスワード認証を行います。デバッグ用ID 名前:test1 pass:a<br>
        <form action="http://localhost:8080/database/database22" method="post">
            名前:<input type="text" name="name" >パスワード:<input type="password" name="pass" >
            <input type="submit" value="送信"></form> 
    </body>
</html>
