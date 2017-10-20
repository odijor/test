<%@page import="jums.JumsHelper" 
        import="java.util.ArrayList"
        import="javax.servlet.http.HttpSession"
        import="jums.UserDataBeans"
        import="jums.UserDataDTO"%>

<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)request.getAttribute("updatedata");
    ArrayList<String> chkList = udb.chkproperties();
    UserDataDTO udd = (UserDataDTO)session.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS更新結果画面</title>
    </head>
    <body>
        <% if(chkList.size()==0){ %>
        <h1>変更結果</h1><br>
        名前:<%= udb.getName()%><br>
        生年月日:<%= udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日"%><br>
        種別:<%= jh.exTypenum(udb.getType())%><br>
        電話番号:<%= udb.getTell()%><br>
        自己紹介:<%= udb.getComment()%><br>
        以上の内容で登録しました。<br>
        <br>
        <% }else{ %>
        <h1>入力が不完全です</h1>
        <%=jh.chkinput(chkList) %>
        <% } %>
        <form action="ResultDetail" method="POST">
            <input type="hidden" name="id" value="<%= udd.getUserID() %>">
            <input type="submit" name="no" value="詳細画面に戻る">
        </form><br>
        
    
    <%=jh.home()%>
    </body>
</html>
