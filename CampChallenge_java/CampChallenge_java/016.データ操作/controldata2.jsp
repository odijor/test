<%-- 
    Document   : controldata2
    Created on : 2017/09/26, 16:00:05
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
        <form action="http://localhost:8080/SanpleA/controldata2.jsp" method="post"><label>
                名前:<input type="text" name="name"></label><input type="submit" value="送信"></form>
            <br>
            <form action="http://localhost:8080/SanpleA/controldata2.jsp" method="post"><label>
                性別:<input type="radio" name="sex" value="male">男性
                <input type="radio" name="sex" value="female">女性</label><input type="submit" value="送信"></form>
            <br>
            <form action="http://localhost:8080/SanpleA/controldata2.jsp" method="post"><label>
                    趣味:<textarea name="hobby" cols="30" row="3"></textarea></label><input type="submit" value="送信"></form>
            
            <a href="http://www.htmq.com/html/indexm.shtml" target="_blank">サンプルはこちら</a>
        
    </body>
</html>

<%
    out.println(request.getParameter("name"));
    out.println(request.getParameter("sex"));
    out.println(request.getParameter("hobby"));
    

%>