<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans data=(UserDataBeans)session.getAttribute("DATA");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <h1>登録結果</h1><br>
        名前:<%= data.getName()%><br>
        生年月日:<%= data.getYear()+"年"+data.getMonth()+"月"+data.getDay()+"日"%><br>
        種別:<%= data.getType()%><br>
        電話番号:<%= data.getTell()%><br>
        自己紹介:<%= data.getComment()%><br>
        以上の内容で登録しました。<br>
    </body>
    <%=JumsHelper.getInstance().home()%>
</html>
