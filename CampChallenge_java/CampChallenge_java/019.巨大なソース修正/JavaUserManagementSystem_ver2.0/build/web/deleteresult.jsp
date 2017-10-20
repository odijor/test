
<%@page contentType="text/html" pageEncoding="UTF-8"
        import="jums.JumsHelper"
        import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<%JumsHelper jh = JumsHelper.getInstance();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <br>
    <form action="Search" method="POST">
        <input type="submit" name="no" value="検索画面に戻る">
        </form>
    <br>
        <%=jh.home()%>
    </body>
</html>
