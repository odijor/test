<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" 
        import="javax.servlet.http.HttpSession"
        import="java.util.ArrayList"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList<UserDataDTO> resultList = (ArrayList<UserDataDTO>)session.getAttribute("resultList");
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <% if(resultList != null){ %>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for(UserDataDTO i:resultList){%>
                <td>
                        <a href="ResultDetail?id=<%= i.getUserID()%>"><%= i.getName()%></a>
                </td>
                <td><%= i.getBirthday()%></td>
                <td><%= jh.exTypenum(i.getType())%></td>
                <td><%= i.getNewDate()%></td>
            </tr>
            <%}%>
        </table>
            <% }else{ %>
            <h1>該当件数は0件です</h1>
        
            <% } %>
            <form action="Search" method="POST">
            <input type="submit" name="no" value="検索画面に戻る">
            </form>
    </body>
    <%=jh.home()%>
</html>
