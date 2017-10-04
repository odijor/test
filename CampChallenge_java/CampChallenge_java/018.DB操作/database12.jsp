<%-- 
    Document   : database12
    Created on : 2017/10/03, 14:56:49
    Author     : sige
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>database12</title>
    </head>
    <body>
        <form action="http://localhost:8080/database/database14" method="post">
            検索:<input type="text" name="select" ><input type="submit" value="送信"></form>        
        <form action="http://localhost:8080/database/database14" method="post">
            追加:ID:<input type="text" name="insertID">
            name:<input type="text" name="insertN">
            tel:<input type="text" name="insertT">
            age:<input type="text" name="insertA">
            birthday:<input type="text" name="insertB"><input type="submit" value="送信"></form>
        <form action="http://localhost:8080/database/database14" method="post">
            削除:<input type="text" name="deleteID"><input type="submit" value="送信"></form>
        <form action="http://localhost:8080/database/database14" method="post">
            更新:ID:<input type="text" name="updateID">
            value:<input type="text" name="update"><input type="submit" value="送信"></form>
        <form action="http://localhost:8080/database/database14" method="post">
            複合検索:名前:<input type="text" name="searchN">
            年齢:<input type="text" name="searchA">
            誕生日:<input type="text" name="searchB">
            <input type="submit" value="送信"></form>
    </body>
</html>
