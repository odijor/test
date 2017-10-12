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
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if(!data.getName().equals("") && !data.getYear().equals("") && !data.getMonth().equals("") &&
                !data.getDay().equals("") && !data.getTell().equals("") && !data.getComment().equals("  ")){ %>
        <h1>登録確認</h1>
        名前:<%= data.getName()%><br>
        生年月日:<%= data.getYear()+"年"+data.getMonth()+"月"+data.getDay()+"日"%><br>
        種別:<%= data.getType()%><br>
        電話番号:<%= data.getTell()%><br>
        自己紹介:<%= data.getComment()%><br>
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
    <% }else{ %>
    <h1>入力が不完全です<br>
        下記の入力をお願いします<br>
        <% 
        if(data.getName().equals("")){out.println("名前");}
        if(data.getYear().equals("")){out.println("生まれ年");}
        if(data.getMonth().equals("")){out.println("生まれ月");}
        if(data.getDay().equals("")){out.println("生まれ日");}
        if(data.getTell().equals("")){out.println("電話番号");}
        if(data.getComment().equals("")){out.println("自己紹介");}
            %>
    </h1>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
