<%@page import="javax.servlet.http.HttpSession"
        import="jums.JumsHelper" 
        import="jums.UserDataBeans"
        import="jums.UserDataDTO"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <h1>更新後のデータを記入してください</h1>
    <form action="UpdateResult" method="POST">
        名前:
        <input type="text" name="name" value="<%= udb.getName()%>">
        <br><br>

        生年月日:　
        <select name="year">
            <option value="">----</option>
            <% for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>" <% if(i == udb.getYear()){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <% for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>" <% if(i == udb.getMonth()){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <% for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>" <% if(i == udb.getDay()){out.print("selected = \"selected\"");}%>><%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
            <% for(int i = 1; i<=3; i++){ %>
            <input type="radio" name="type" value="<%=i%>"<%if(i == udb.getType()){out.print("checked = \"checked\"");}%>><%=jh.exTypenum(i)%><br>
            <% } %>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%=udb.getTell()%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%=udb.getComment()%>
        </textarea><br><br>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="hidden" name="id" value="<%=udd.getUserID()%>">
        <input type="submit" name="btnSubmit" value="更新を実行">
    </form>
        <br>
        <form action="ResultDetail" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="submit" name="no" value="詳細画面に戻る">
        </form><br>
        <%=jh.home()%>
    </body>
</html>
