<%-- 
    Document   : database23
    Created on : 2017/10/05, 10:23:23
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
        在庫管理システムへようこそ
            <form action="http://localhost:8080/database/database24" method="post">
            一覧
            <input type="submit" value="送信">
            </form>
            <form action="http://localhost:8080/database/database2main" method="post">
        検索:ID:<input type="text" name="selectID">
            名前:<input type="text" name="selectItemName">
            単価:<input type="text" name="selectCost">
            在庫:<input type="text" name="selectStock">
            <input type="submit" value="送信"></form>
        
        <form action="http://localhost:8080/database/database2main" method="post">
        商品登録:ID:<input type="text" name="insertID">
            名前:<input type="text" name="insertItemName">
            単価:<input type="text" name="insertCost">
            在庫:<input type="text" name="insertStock">
            <input type="submit" value="送信"></form>
        
        
        <a href="http://localhost:8080/database/database21.jsp">ログオフ</a>    
        
    </body>
</html>
