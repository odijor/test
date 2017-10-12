<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%@page import="jums.UserDataBeans"%>
<%
    HttpSession hs = request.getSession();
    UserDataBeans data=(UserDataBeans)session.getAttribute("DATA");
    
    //生年月日をint型に変換
    int year = -1;
    int month = -1;
    int day = -1;
    if(!(data.getYear().equals("")))year = Integer.parseInt(data.getYear());
    if(!(data.getMonth().equals("")))month = Integer.parseInt(data.getMonth());
    if(!(data.getDay().equals("")))day =Integer.parseInt(data.getDay());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%=data.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"<%if(i == year)out.print("selected");%>> <%=i%> </option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"<%if(i == month)out.print("selected");%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"<%if(i == day)out.print("selected");%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" 
               <%if(data.getType().equals("") || data.getType().equals("1"))out.print("checked=\"checked\"");%>>エンジニア<br>
        <input type="radio" name="type" value="2"<%if(data.getType().equals("2"))out.print("checked=\"checked\"");%>>営業<br>
        <input type="radio" name="type" value="3"<%if(data.getType().equals("3"))out.print("checked=\"checked\"");%>>その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%= data.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= data.getComment()%></textarea><br><br>
        
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
